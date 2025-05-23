public class ConjuntoCerrado extends Urbana {
    private double valorAdministrativo;
    private  boolean areasComunes;
    public ConjuntoCerrado(int id, double areaMetrosCuadrados, double valorCompra, String direccion, int numHabitaciones, int numBanos, int cantPisos, double valorAdministrativo, boolean areasComunes){

        super(id, areaMetrosCuadrados, valorCompra, direccion, numHabitaciones, numBanos, cantPisos);
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
    @Override
    public void mostrarInfo(){
        System.out.println("CASA URBANA EN CONJUNTO CERRADO");
        super.mostrarInfo();
        System.out.println("Costo Administrativo: "+getValorAdministrativo());
        System.out.println("Areas Comunes: "+getAreasComunes());
    }
    @Override
    public String toString() {
        return "CONJUNTOCERRADO," + id + "," + areaMetrosCuadrados + "," + valorCompra + "," + direccion + "," +
                numHabitaciones + "," + numBanos + "," + cantPisos+","+valorAdministrativo+","+areasComunes;
    }
}
