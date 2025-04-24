public class Departamentos extends Vivienda{
    private double administracion;

    public Departamentos(int id, double areaMetrosCuadrados,double valorCompra,String direccion,int numHabitaciones,int numBanos, double administracion){
        super(id,areaMetrosCuadrados,valorCompra,direccion,numHabitaciones,numBanos);
        this.administracion=administracion;
    }
    public double getAdministracion() {
        return administracion;
    }
    public void setAdministracion(double administracion) {
        this.administracion = administracion;
    }
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Costo de Administracion: "+getAdministracion());
    }
}
