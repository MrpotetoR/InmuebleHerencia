public class Oficina extends Locales {
    private boolean deGobierno;

    public Oficina(int id, double areaMetrosCuadrados,double valorCompra,String direccion,boolean esInterno, boolean deGobierno){
        super(id,areaMetrosCuadrados,valorCompra,direccion,esInterno);
        this.deGobierno=deGobierno;
    }
    public boolean getDeGobierno() {
        return deGobierno;
    }
    public void setDeGobierno(boolean deGobierno) {
        this.deGobierno = deGobierno;
    }
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Gobierno si/no : "+getDeGobierno());
    }
}
