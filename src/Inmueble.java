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
    public double getAreaMetrosCuadrados() {
        return areaMetrosCuadrados;
    }
    public double getValorCompra() {
        return valorCompra;
    }
    public String getDireccion() {
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


    public double calcularValor() {
        return valorCompra * areaMetrosCuadrados;
    }


    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Area m^2: " + areaMetrosCuadrados);
        System.out.println("Valor por m^2: " + valorCompra);
        System.out.println("Direccion: " + direccion);
        System.out.println("||Valor total: " + calcularValor());
    }


    @Override
    public String toString() {

        return "Inmueble," + id + "," + areaMetrosCuadrados + "," + valorCompra + "," + direccion;
    }


    public static Inmueble fromString(String str) {
        String[] partes = str.split(",");

        if (partes.length < 5) {
            throw new IllegalArgumentException("Formato de cadena incorrecto: " + str);
        }
        String tipo = partes[0];
        int id = Integer.parseInt(partes[1]);
        double area = Double.parseDouble(partes[2]);
        double valor = Double.parseDouble(partes[3]);
        String direccion = partes[4];

        switch (tipo) {
            case "Inmueble":

                return new Inmueble(id, area, valor, direccion);

            case "Comercial":

                if (partes.length != 8)
                    throw new IllegalArgumentException("Formato de Comerciales incorrecto: " + str);
                boolean esInterno = Boolean.parseBoolean(partes[5]);
                String centroComercial = partes[6];
                return new Comerciales(id, area, valor, direccion, centroComercial, esInterno);

            case "Oficina":

                if (partes.length != 7)
                    throw new IllegalArgumentException("Formato de Oficina incorrecto: " + str);
                esInterno = Boolean.parseBoolean(partes[5]);
                boolean deGobierno = Boolean.parseBoolean(partes[6]);
                return new Oficina(id, area, valor, direccion, esInterno, deGobierno);

            case "Rural":

                if (partes.length != 10)
                    throw new IllegalArgumentException("Formato de Rural incorrecto: " + str);
                int numHabitacionesCasa = Integer.parseInt(partes[5]);
                int numBanosCasa = Integer.parseInt(partes[6]);
                int cantPisos = Integer.parseInt(partes[7]);
                float latitudNivelMar = Float.parseFloat(partes[8]);
                float distanciaCabMuniKM = Float.parseFloat(partes[9]);
                return new Rural(id, area, valor, direccion, numHabitacionesCasa, numBanosCasa, cantPisos, latitudNivelMar, distanciaCabMuniKM);

            case "Familia":

                if (partes.length != 8)
                    throw new IllegalArgumentException("Formato de Familia incorrecto: " + str);
                numHabitacionesCasa = Integer.parseInt(partes[5]);
                numBanosCasa = Integer.parseInt(partes[6]);
                double administracion = Double.parseDouble(partes[7]);
                return new Familia(id, area, valor, direccion, numHabitacionesCasa, numBanosCasa, administracion);

            case "Individual":

                if (partes.length != 8)
                    throw new IllegalArgumentException("Formato de Individual incorrecto: " + str);
                numHabitacionesCasa = Integer.parseInt(partes[5]);
                numBanosCasa = Integer.parseInt(partes[6]);
                administracion = Double.parseDouble(partes[7]);
                return new Individual(id, area, valor, direccion, numHabitacionesCasa, numBanosCasa, administracion);

            case "ConjuntoCerrado":

                if (partes.length != 10)
                    throw new IllegalArgumentException("Formato de ConjuntoCerrado incorrecto: " + str);
                cantPisos = Integer.parseInt(partes[5]);
                numHabitacionesCasa = Integer.parseInt(partes[6]);
                numBanosCasa = Integer.parseInt(partes[7]);
                administracion = Double.parseDouble(partes[8]);
                boolean areasComunes = Boolean.parseBoolean(partes[9]);
                return new ConjuntoCerrado(id, area, valor, direccion, numHabitacionesCasa, numBanosCasa, cantPisos, administracion, areasComunes);

            case "Independiente":

                if (partes.length != 8)
                    throw new IllegalArgumentException("Formato de Independiente incorrecto: " + str);
                cantPisos = Integer.parseInt(partes[5]);
                numHabitacionesCasa = Integer.parseInt(partes[6]);
                numBanosCasa = Integer.parseInt(partes[7]);
                return new Independiente(id, area, valor, direccion, numHabitacionesCasa, numBanosCasa, cantPisos);

            default:
                throw new IllegalArgumentException("Tipo de inmueble desconocido: " + tipo);
        }
    }
}
