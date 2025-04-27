public class Rural extends Casas{
    private float latitudNivelMar;
    private float distanciaCabMuniKM;

    public Rural(int id, double areaMetrosCuadrados, double valorCompra, String direccion, int numHabitantes, int numBanos, int cantPisos,float latitudNivelMar,float distanciaCabMuniKM){
        super(id, areaMetrosCuadrados, valorCompra, direccion, numHabitantes, numBanos, cantPisos);
        this.distanciaCabMuniKM=distanciaCabMuniKM;
        this.latitudNivelMar=latitudNivelMar;
    }
    public float getDistanciaCabMuniKM() {
        return distanciaCabMuniKM;
    }

    public float getLatitudNivelMar() {
        return latitudNivelMar;
    }
    public void setLatitudNivelMar(float latitudNivelMar) {
        this.latitudNivelMar = latitudNivelMar;
    }

    public void setDistanciaCabMuniKM(float distanciaCabMuniKM) {
        this.distanciaCabMuniKM = distanciaCabMuniKM;
    }
    @Override
    public void mostrarInfo(){
        System.out.println("CASA RURAL");
        super.mostrarInfo();
        System.out.println("Latitud a nivel del mar: "+getLatitudNivelMar());
        System.out.println("Distancia a la cabecera Municipal: "+ getDistanciaCabMuniKM());
    }
    @Override
    public String toString() {
        return "RURAL," + id + "," + areaMetrosCuadrados + "," + valorCompra + "," + direccion + "," + numHabitaciones + "," +numBanos + "," + cantPisos+","+latitudNivelMar+","+distanciaCabMuniKM;
    }
}
