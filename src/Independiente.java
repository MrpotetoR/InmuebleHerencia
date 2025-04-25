public class Independiente extends Urbana{
    private boolean unaHabitacion;
    public Independiente(int id, double areaMetrosCuadrados, double valorCompra, String direccion, int numHabitantes, int numBanos, int cantPisos, boolean unaHabitacion){
        super(id, areaMetrosCuadrados, valorCompra, direccion, numHabitantes, numBanos, cantPisos);
        this.unaHabitacion=unaHabitacion;

    }
    public boolean getUnaHabitacion(){
        return  unaHabitacion;
    }

    public void setUnaHabitacion(boolean unaHabitacion) {
        this.unaHabitacion = unaHabitacion;
    }
    public void mostrarInfo(){
        super.mostrarInfo();

    }
    public String toString() {
        return "Casas," + id + "," + areaMetrosCuadrados + "," + valorCompra + "," + direccion + "," +
                getNumHabitaciones() + "," + getNumBanos() + "," + cantPisos;
    }
}
