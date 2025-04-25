public class Locales extends Inmueble{
    protected boolean esInterno;

   public Locales(int id, double areaMetrosCuadrados, double valorCompra,String direccion, boolean esInterno ){
       super(id, areaMetrosCuadrados, valorCompra, direccion);
       this.esInterno=esInterno;
   }
    public boolean getEsInterno() {
        return esInterno;
    }
    public void setEsInterno(boolean esInterno) {
        this.esInterno = esInterno;
    }
    @Override
    public void mostrarInfo(){
       super.mostrarInfo();
       System.out.println("Interno o Externo: "+getEsInterno());
    }
    @Override
    public String toString() {
        return "Locales," + id + "," + areaMetrosCuadrados + "," + valorCompra + "," + direccion + "," + esInterno;
   }
}
