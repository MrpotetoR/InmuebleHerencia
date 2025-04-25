import java.io.*;
import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static final String ARCHIVO = "datos.txt";
    private static List<Inmueble> inmuebles = new ArrayList<>();

    public static void main(String[] args) {
        cargarDatos();
        int opcion;
        do {
            System.out.println("\n===== MENU CRUD =====");
            System.out.println("1. Agregar inmueble");
            System.out.println("2. Listar inmuebles");
            System.out.println("3. Actualizar inmueble");
            System.out.println("4. Buscar inmueble");
            System.out.println("5. Eliminar inmueble");
            System.out.println("6. Salir");
            System.out.print("Seleccione la opción (1-6): ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    agregarInmueble();
                    break;
                case 2:
                    listarInmuebles();
                    break;
                case 3:
                    actualizarInmueble();
                    break;
                case 4:
                    buscarInmueble();
                    break;
                case 5:
                    eliminarInmueble();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }


    private static void agregarInmueble() {
        System.out.println("Seleccione el tipo de inmueble a agregar:");
        System.out.println("1. Inmueble general");
        System.out.println("2. Local");
        System.out.println("3. Vivienda");
        System.out.print("Seleccione una opción: ");
        int opcionTipo = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        try {
            System.out.print("Ingresa el id del inmueble: ");
            int id = sc.nextInt();
            System.out.print("Ingresa el área en m²: ");
            double area = sc.nextDouble();
            System.out.print("Ingresa el valor por m²: ");
            double valor = sc.nextDouble();
            sc.nextLine(); // Consumir salto de línea pendiente
            System.out.print("Ingresa la dirección: ");
            String direccion = sc.nextLine();

            Inmueble inmueble = null;
            switch (opcionTipo) {
                case 1:
                    inmueble = new Inmueble(id, area, valor, direccion);
                    break;
                case 2:
                    System.out.print("¿El local es interno? (true/false): ");
                    boolean esInterno = sc.nextBoolean();
                    System.out.println("|||||TIPO||||||");
                    System.out.println("1. Local Comercial");
                    System.out.println("2. Oficina" );
                    System.out.println("Seleccione el tipo de Local: ");
                    int option= sc.nextInt();
                    sc.nextLine();
                    switch (option){
                        case 1:
                            System.out.println("Centro comercial donde se ubica: ");
                            String centroComercial= sc.nextLine();
                            inmueble=new Comerciales(id,area,valor,direccion,centroComercial,esInterno);
                            break;
                        case 2:
                            System.out.println("La oficina es de gobierno? (true/false): ");
                            boolean gobierno=sc.nextBoolean();
                            inmueble=new Oficina(id,area,valor,direccion,esInterno,gobierno);
                    }
                    break;
                case 3:
                    System.out.print("Ingresa el número de habitaciones: ");
                    int numHabitaciones = sc.nextInt();
                    System.out.print("Ingresa el número de baños: ");
                    int numBanos = sc.nextInt();
                    System.out.println("Seleccione el tipo de vivienda: ");
                    System.out.println("1. Departamento");
                    System.out.println("2. Casa");
                    int opcion1= sc.nextInt();
                    switch (opcion1){
                        case 1:
                            System.out.println("Costo de administracion: ");
                            double costoAdmin= sc.nextDouble();
                            if (numHabitaciones>1){
                                inmueble=new Familia(id,area,valor,direccion,numHabitaciones,numBanos,costoAdmin);
                            }else {
                                inmueble=new Individual(id,area,valor,direccion,numHabitaciones,numBanos,costoAdmin);
                            }
                            break;
                        case 2:
                            System.out.println("Cantidad de pisos: ");
                            int numPisos= sc.nextInt();
                            System.out.println("Seleccione el tipo de casa: ");
                            System.out.println("1. Urbana");
                            System.out.println("2. Rural");
                            int opcion2= sc.nextInt();
                            switch (opcion2){
                                case 1:
                                    System.out.println();
                                case 2:
                                    System.out.println("Latitud sobre el nivel del mar: ");
                                    float latitudNivel= sc.nextFloat();
                                    System.out.println("Distacia en Km a la cabecera Municipal");
                                    float distanciaMunicipal= sc.nextFloat();
                                    System.out.println("Selecciona el tipo de casa urbana: ");
                                    System.out.println("1. Independiente");
                                    System.out.println("2. Conjunto cerrado ");
                                    int opcion3= sc.nextInt();

                                    }
                            }
                    }
                    break;
                default:
                    System.out.println("Opción de tipo inválida.");
                    return;
            }
            inmuebles.add(inmueble);
            agregarInmuebleArchivo(inmueble);
            System.out.println("Inmueble creado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al ingresar datos: " + e.getMessage());
            sc.nextLine(); // Limpiar buffer en caso de error
        }
    }


    private static void agregarInmuebleArchivo(Inmueble inmueble) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            writer.write(inmueble.toString());
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Error al registrar el inmueble en archivo: " + e.getMessage());
        }
    }


    private static void listarInmuebles() {
        if (inmuebles.isEmpty()) {
            System.out.println("No hay inmuebles registrados.");
        } else {
            System.out.println("Listado de inmuebles:");
            for (Inmueble inmueble : inmuebles) {
                inmueble.mostrarInfo();
                System.out.println("--------------------------");
            }
        }
    }


    private static void actualizarInmueble() {
        System.out.print("Ingresa el id del inmueble a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea
        Inmueble inmuebleEncontrado = null;
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getId() == id) {
                inmuebleEncontrado = inmueble;
                break;
            }
        }
        if (inmuebleEncontrado == null) {
            System.out.println("Inmueble no encontrado.");
            return;
        }

        System.out.println("Actualizando datos. Presiona Enter sin escribir nada para mantener el valor actual:");
        System.out.print("Área en m² (" + inmuebleEncontrado.getAreaMetrosCuadrados() + "): ");
        String areaInput = sc.nextLine();
        if (!areaInput.isEmpty()) {
            inmuebleEncontrado.setAreaMetrosCuadrados(Double.parseDouble(areaInput));
        }

        System.out.print("Valor por m² (" + inmuebleEncontrado.getValorCompra() + "): ");
        String valorInput = sc.nextLine();
        if (!valorInput.isEmpty()) {
            inmuebleEncontrado.setValorCompra(Double.parseDouble(valorInput));
        }

        System.out.print("Dirección (" + inmuebleEncontrado.getDireccion() + "): ");
        String nuevaDireccion = sc.nextLine();
        if (!nuevaDireccion.isEmpty()) {
            inmuebleEncontrado.setDireccion(nuevaDireccion);
        }


        if (inmuebleEncontrado instanceof Locales) {
            Locales local = (Locales) inmuebleEncontrado;
            System.out.print("Interno (" + local.getEsInterno() + ") (true/false): ");
            String internoInput = sc.nextLine();
            if (!internoInput.isEmpty()) {
                local.setEsInterno(Boolean.parseBoolean(internoInput));
            }
        } else if (inmuebleEncontrado instanceof Vivienda) {
            Vivienda viv = (Vivienda) inmuebleEncontrado;
            System.out.print("Número de habitaciones (" + viv.getNumHabitaciones() + "): ");
            String habInput = sc.nextLine();
            if (!habInput.isEmpty()) {
                viv.setNumHabitaciones(Integer.parseInt(habInput));
            }
            System.out.print("Número de baños (" + viv.getNumBanos() + "): ");
            String banosInput = sc.nextLine();
            if (!banosInput.isEmpty()) {
                viv.setNumBanos(Integer.parseInt(banosInput));
            }
            if (inmuebleEncontrado instanceof Casas) {
                Casas casa = (Casas) inmuebleEncontrado;
                System.out.print("Cantidad de pisos (" + casa.getCantPisos() + "): ");
                String pisosInput = sc.nextLine();
                if (!pisosInput.isEmpty()) {
                    casa.setCantPisos(Integer.parseInt(pisosInput));
                }
            }
        }
        System.out.println("Inmueble actualizado correctamente.");
        escribirArchivoCompleto();
    }

    private static void buscarInmueble() {
        System.out.print("Ingresa el id del inmueble a buscar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea
        boolean encontrado = false;
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getId() == id) {
                inmueble.mostrarInfo();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Inmueble no encontrado.");
        }
    }


    private static void eliminarInmueble() {
        System.out.print("Ingresa el id del inmueble a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea
        Inmueble inmuebleEliminar = null;
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getId() == id) {
                inmuebleEliminar = inmueble;
                break;
            }
        }
        if (inmuebleEliminar == null) {
            System.out.println("Inmueble no encontrado.");
        } else {
            inmuebles.remove(inmuebleEliminar);
            System.out.println("Inmueble eliminado correctamente.");
            escribirArchivoCompleto();
        }
    }


    private static void escribirArchivoCompleto() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Inmueble inmueble : inmuebles) {
                writer.write(inmueble.toString());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar archivo: " + e.getMessage());
        }
    }


    private static void cargarDatos() {
        File archivo = new File(ARCHIVO);
        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    try {
                        Inmueble inmueble = Inmueble.fromString(linea);
                        inmuebles.add(inmueble);
                    } catch (Exception e) {
                        System.out.println("Error al procesar la línea: " + linea);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error al cargar datos: " + e.getMessage());
            }
        }
    }
}
