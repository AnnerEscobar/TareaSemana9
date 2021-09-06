
package negocio;

public interface NominaE {
    public void iniciarArchivo(String nombreArchivo);
    public void agregarEmpleado(String nombreArchivo, String nombreEmpleado, Double enero, Double febrero, Double marzo);
    public void buscarMayorYMenorVendedorPorMes(String nombreArchivo, int mes);
    public void buscarMayorVendedorGeneral(String nombreArchivo);
    public void editarDato(String nombreArchivo, String nuevoDato, int registro, int columna);
    public void buscarPorCantidad(String nombreArchivo, Double cantidad);
    public void listarEmpleados(String nombreArchivo);
}
