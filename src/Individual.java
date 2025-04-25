public class Individual extends Departamentos{
    public Individual(int id, double areaMetrosCuadrados, double valorCompra, String direccion, int numHabitaciones, int numBanos, double administracion){
        super(id, areaMetrosCuadrados, valorCompra, direccion, numHabitaciones, numBanos, administracion);
    }
    @Override
    public void mostrarInfo(){
        System.out.println("Departamento Individual");
        super.mostrarInfo();
    }
    @Override
    public String toString() {
        return "Casas," + id + "," + areaMetrosCuadrados + "," + valorCompra + "," + direccion + "," +
                getNumHabitaciones() + "," + getNumBanos() + "," +","+administracion;
    }
}
