
package datos;

import dominio.MdEmpleado;
import excepciones.*;
import java.util.*;


public interface AccesoDatos {
    boolean existe(String nombre_Archivo) throws AccesoDatosEx;
    public List<MdEmpleado> listar(String nombre_Archivo) throws LecturaDatosEx;
    void escribir(MdEmpleado empleado, String nombre_Archivo, boolean anexar) throws EscrituraDatosEx;
    public String buscar(String nombre_Archivo, Double buscar) throws LecturaDatosEx;
    public void crear(String nombre_Archivo) throws AccesoDatosEx;
    public void borrar(String nombre_Archivo) throws AccesoDatosEx;
}
