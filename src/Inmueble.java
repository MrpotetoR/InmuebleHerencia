
public class Inmueble {
    protected int id;
    protected double areaMetrosCuadrados;
    protected double valorCompra;
    protected String direccion;

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
    public void setAreaMetrosCuadrados(double areaMetrosCuadrados) {
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


    @Override
    public String toString() {
        return "Inmueble,"+ id + "," + areaMetrosCuadrados + "," + valorCompra + "," + direccion;
    }


    public static Inmueble fromString(String str) {
        String[] partes = str.split(",");
        if (partes.length < 4) {
            throw new IllegalArgumentException("Formato de cadena incorrecto");
        }
        String tipo= partes[0];
        int id= Integer.parseInt(partes[1]);
        double area=Double.parseDouble(partes[2]);
        double valor= Double.parseDouble(partes[3]);
        String direccion=partes[4];

        switch (tipo){
            case "Inmueble":
                return new Inmueble(id,area,valor,direccion);
            case "Locales":
                if(partes.length != 6)
                    throw new IllegalArgumentException("Formato de Locales incorrecto: " + str);
                boolean esInterno = Boolean.parseBoolean(partes[5]);
                return new Locales(id, area, valor, direccion, esInterno);
            case "Vivienda":
                if(partes.length != 7)
                    throw new IllegalArgumentException("Formato de Vivienda incorrecto: " + str);
                int numHabitaciones = Integer.parseInt(partes[5]);
                int numBanos = Integer.parseInt(partes[6]);
                return new Vivienda(id, area, valor, direccion, numHabitaciones, numBanos);
            case "Casas":
                if(partes.length != 8)
                    throw new IllegalArgumentException("Formato de Casas incorrecto: " + str);
                int numHabitacionesCasa = Integer.parseInt(partes[5]);
                int numBanosCasa = Integer.parseInt(partes[6]);
                int cantPisos = Integer.parseInt(partes[7]);
                return new Casas(id, area, valor, direccion, numHabitacionesCasa, numBanosCasa, cantPisos);
            default:
                throw new IllegalArgumentException("Tipo de inmueble desconocido: " + tipo);
        }
    }
}
