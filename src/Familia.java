public class Familia extends Departamentos{
    public Familia(int id, double areaMetrosCuadrados, double valorCompra, String direccion, int numHabitaciones, int numBanos, double administracion){
        super(id, areaMetrosCuadrados, valorCompra, direccion, numHabitaciones, numBanos, administracion);
    }
    @Override
    public void mostrarInfo(){
        System.out.println("Departamento Familiar");
        super.mostrarInfo();
    }
    @Override
    public String toString() {
        return "Casas," + id + "," + areaMetrosCuadrados + "," + valorCompra + "," + direccion + "," +
                getNumHabitaciones() + "," + getNumBanos() + "," +","+administracion;
    }
}
