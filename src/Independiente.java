public class Independiente extends Urbana{

    public Independiente(int id, double areaMetrosCuadrados, double valorCompra, String direccion, int numHabitaciones, int numBanos, int cantPisos){
        super(id, areaMetrosCuadrados, valorCompra, direccion, numHabitaciones, numBanos, cantPisos);


    }
    @Override
    public void mostrarInfo(){
        System.out.println("CASA URBANA INDEPENDIENTE");
        super.mostrarInfo();

    }
    @Override
    public String toString() {
        return "INDEPENDIENTE," + id + "," + areaMetrosCuadrados + "," + valorCompra + "," + direccion + "," + numHabitaciones + "," + numBanos + "," + cantPisos;
    }
}
