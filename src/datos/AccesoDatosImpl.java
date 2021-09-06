
package datos;

import dominio.MdEmpleado;
import excepciones.*;
import java.io.*;
import java.util.*;

public class AccesoDatosImpl implements AccesoDatos {
    
    @Override
    public boolean existe(String nombre_Archivo) throws AccesoDatosEx {
        File archivo = new File(nombre_Archivo);
        return archivo.exists();
    }
    

    @Override
    public List<MdEmpleado> listar(String nombre_Archivo) throws LecturaDatosEx {
        List<MdEmpleado> empleados = new ArrayList();
        try {
            BufferedReader entrada = null;
            File archivo = new File(nombre_Archivo);
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                String[] empDatos = linea.split("\\|");
                MdEmpleado empleado = new MdEmpleado(empDatos[0], Double.valueOf(empDatos[1]), 
                                    Double.valueOf(empDatos[2]), Double.valueOf(empDatos[3]));
                empleados.add(empleado);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return empleados;
    }
    
 
    @Override
    public void escribir(MdEmpleado empleado, String nombre_Archivo, boolean anexar) throws EscrituraDatosEx {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombre_Archivo);
            salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(empleado.toString());
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }
    

    @Override
    public String buscar(String nombre_Archivo, Double buscar) throws LecturaDatosEx {
        BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombre_Archivo);
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i=1;
            linea = entrada.readLine();
            while (linea != null){
                String empDatos[] = linea.split("\\|");
                for(String dato : empDatos){
                    if(buscar != null && String.valueOf(buscar).equals(dato)){
                        resultado = linea + " encontrada en la posicion " + i;
                        break;
                    }
                }
                linea = entrada.readLine();
                i++;
            } 
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }

    @Override
    public void crear(String nombre_Archivo) throws AccesoDatosEx {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombre_Archivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }
    
    @Override
    public void borrar(String nombre_Archivo) throws AccesoDatosEx {
        File archivo = new File(nombre_Archivo);
        archivo.delete();
        System.out.println("Reiniciando archivo");
    }
}

