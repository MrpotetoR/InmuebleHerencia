public class Comerciales extends Locales{
    private String centroComercial;

    public Comerciales(int id, double areaMetrosCuadrados,double valorCompra,String direccion, String centroComercial,boolean esInterno){
        super(id,areaMetrosCuadrados,valorCompra,direccion,esInterno);
        this.centroComercial=centroComercial;
    }
    public String getCentroComercial() {
        return centroComercial;
    }
    public void setCentroComercial(String centroComercial) {
        this.centroComercial = centroComercial;
    }
    public void mostrarInfo(){
        System.out.println("LOCAL COMERCIAL");
        super.mostrarInfo();
        System.out.println("Centro comercial donde se encuentra: "+getCentroComercial());
    }
}
