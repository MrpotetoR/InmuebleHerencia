public class ConjuntoCerrado extends Urbana {
    private double valorAdministrativo;
    private  boolean areasComunes;
    public ConjuntoCerrado(int id, double areaMetrosCuadrados, double valorCompra, String direccion, int numHabitantes, int numBanos, int cantPisos,float valorAdministrativo,boolean areasComunes){

        super(id, areaMetrosCuadrados, valorCompra, direccion, numHabitantes, numBanos, cantPisos);
        this.valorAdministrativo=valorAdministrativo;
        this.areasComunes=areasComunes;
    }
    public double getValorAdministrativo(){
        return valorAdministrativo;
    }
    public boolean getAreasComunes(){
        return areasComunes;
    }
    public void setValorAdministrativo(double valorAdministrativo){
        this.valorAdministrativo = valorAdministrativo;
    }
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Costo Administrativo: "+getValorAdministrativo());
        System.out.println("Areas Comunes: "+getAreasComunes());
    }
    public String toString() {
        return "Casas," + id + "," + areaMetrosCuadrados + "," + valorCompra + "," + direccion + "," +
                getNumHabitaciones() + "," + getNumBanos() + "," + cantPisos+","+valorAdministrativo+","+areasComunes;
    }
}
