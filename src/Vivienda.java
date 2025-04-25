public class Vivienda extends Inmueble {
    protected int numHabitaciones;
    protected int numBanos;

    public Vivienda(int id, double areaMetrosCuadrados, double valorCompra, String direccion, int numHabitaciones, int numBanos){
        super(id, areaMetrosCuadrados, valorCompra, direccion);

        this.numHabitaciones=numHabitaciones;
        this.numBanos=numBanos;
    }
    public int getNumHabitaciones() {
        return numHabitaciones;
    }
    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }
    public int getNumBanos() {
        return numBanos;
    }
    public void setNumBanos(int numBanos) {
        this.numBanos = numBanos;
    }
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Numero de Habitaciones: "+getNumHabitaciones());
        System.out.println("Numero de banos: "+getNumBanos());
    }
    @Override
    public String toString() {
        return "Vivienda," + id + "," + areaMetrosCuadrados + "," + valorCompra + "," + direccion + "," + numHabitaciones + "," + numBanos;
    }

}
