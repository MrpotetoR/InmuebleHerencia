public class Inmueble {
    private int id;
    private double areaMetrosCuadrados;
    private double valorCompra;
    private String direccion;

    public Inmueble(int id, double areaMetrosCuadrados, double valorCompra, String direccion) {
        this.id = id;
        this.areaMetrosCuadrados = areaMetrosCuadrados;
        this.valorCompra = valorCompra;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }
    public double getAreaMetrosCuadrados(){
        return areaMetrosCuadrados;}
    public double getValorCompra() {
        return valorCompra;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAreaMetrosCuadrados(float areaMetrosCuadrados) {
        this.areaMetrosCuadrados = areaMetrosCuadrados;
    }
    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double calcularValor(){
        return getValorCompra()*getAreaMetrosCuadrados();
    }

    public void mostrarInfo(){
        System.out.println("ID: "+getId());
        System.out.println("Area m^2: "+getAreaMetrosCuadrados());
        System.out.println("Valor por m^2: "+getValorCompra());
        System.out.println("Direccion: "+getDireccion());
        System.out.println("||Valor total: "+calcularValor());
    }
}
