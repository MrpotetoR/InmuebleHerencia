public class Urbana extends Casas{

    public Urbana(int id, double areaMetrosCuadrados, double valorCompra, String direccion, int numHabitantes, int numBanos, int cantPisos){
        super(id, areaMetrosCuadrados, valorCompra, direccion, numHabitantes, numBanos, cantPisos);

    }
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
    }
    @Override
    public String toString() {
        return "Casas," + id + "," + areaMetrosCuadrados + "," + valorCompra + "," + direccion + "," +
                getNumHabitaciones() + "," + getNumBanos() + "," + cantPisos;
    }
}
