public class Casas extends Vivienda {
    protected int cantPisos;

    public Casas(int id, double areaMetrosCuadrados, double valorCompra, String direccion, int numHabitaciones, int numBanos, int cantPisos){

        super(id, areaMetrosCuadrados, valorCompra, direccion, numHabitaciones, numBanos);
        this.cantPisos=cantPisos;
    }

    public int getCantPisos() {
        return cantPisos;
    }

    public void setCantPisos(int cantPisos) {
        this.cantPisos = cantPisos;
    }
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Cantidad de pisos: "+getCantPisos());

    }
    @Override
    public String toString() {
        return "Casas," + id + "," + areaMetrosCuadrados + "," + valorCompra + "," + direccion + "," +
                getNumHabitaciones() + "," + getNumBanos() + "," + cantPisos;
    }
}
