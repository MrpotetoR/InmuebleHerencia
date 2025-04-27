import java.io.*;
import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static InmuebleServicios servicios=new InmuebleServicios();
    public static void main(String[] args) {

        servicios.cargarDatos();
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
                    servicios.listarInmuebles();
                    break;
                case 3:
                    servicios.actualizarInmueble();
                    break;
                case 4:
                    servicios.buscarInmueble();
                    break;
                case 5:
                    servicios.eliminarInmueble();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private static int validarSegundaOpcion() {
        int option = 0;
        boolean valido = false;
        while (!valido) {
            System.out.println("selecciona una opcion (1-2): ");
            try {
                option = sc.nextInt();
                if (option == 1 || option == 2) {
                    valido = true;

                } else {
                    System.out.println("Opcion Invalida la opcion debe ser 1 o 2");
                }
            } catch (Exception e) {
                System.out.println("Debes ingresar un numero valido");
                sc.nextLine();
            }
        }
        return option;
    }

    private static int validarID() {
        int id = 0;
        boolean valido = false;
        while (!valido) {
            System.out.println("Ingresa el id del inmueble: ");

            try {
                id = sc.nextInt();
                for (Inmueble inmueble : servicios.inmuebles) {
                    if (inmueble.getId() == id) {
                        System.out.println("El id ya existe");
                        valido = false;
                        break;
                    } else {
                        valido = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("Debes ingresar un ID diferente");
                sc.nextLine();
            }
        }
        return id;
    }

    private static double validarValorDouble() {
        double valorDouble = 0;
        boolean valido = false;
        while (!valido) {
            System.out.println("Ingresa un valor: ");
            try {
                valorDouble = sc.nextDouble();
                if (valorDouble < 1) {
                    System.out.println("No es posible ingresar valores negativos o 0!!");
                } else {
                    valido = true;
                }
            } catch (Exception e) {
                System.out.println("Debe ingresar valores positivos");
                sc.nextLine();
            }
        }
        return valorDouble;
    }

    private static float validarValorFloat() {
        float valorfloat = 0;
        boolean valido = false;
        while (!valido) {
            System.out.println("Ingresa una cantidad:");
            try {
                valorfloat = sc.nextInt();
                if (valorfloat < 1) {
                    System.out.println("No es posible ingresar valores negativos o 0");
                } else {
                    valido = true;
                }
            } catch (Exception e) {
                System.out.println("Error al ingresar valores!!");
                sc.nextLine();
            }
        }
        return valorfloat;
    }

    private static int validarValorInt() {
        int valorInt = 0;
        boolean valido = false;
        while (!valido) {
            System.out.println("Ingresa una cantidad:");
            try {
                valorInt = sc.nextInt();
                if (valorInt < 1) {
                    System.out.println("No es posible ingresar valores negativos o 0");
                } else {
                    valido = true;
                }
            } catch (Exception e) {
                System.out.println("Error al ingresar valores!!");
                sc.nextLine();
            }
        }
        return valorInt;
    }

    private static boolean validarInterno() {
        boolean interno = false;
        boolean valido = false;
        while (!valido) {
            System.out.println("Ingrese 's' o 'n': ");
            try {
                String respuesta = sc.nextLine().trim().toLowerCase();
                if (respuesta.equals("s")) {
                    interno = true;
                    valido = true;
                } else if (respuesta.equals("n")) {
                    interno = false;
                    valido = true;
                } else {
                    System.out.println("Valor inválido, debes ingresar 's' o 'n'.");
                }
            } catch (Exception e) {
                System.out.println("Valor invalido!!");
            }
        }
        return interno;
    }

    private static void agregarInmueble() {
        double valor;
        System.out.println("\nSeleccione el tipo de inmueble a agregar:");
        System.out.println("1. Local");
        System.out.println("2. Vivienda");
        System.out.print("Seleccione una opción: ");
        int opcionTipo = validarSegundaOpcion();
        sc.nextLine();
        try {
            int id = validarID();
            System.out.println(" Area en m²: ");
            double area = validarValorDouble();
            sc.nextLine();
            System.out.println("Ingresa la dirección: ");
            String direccion = sc.nextLine();

            Inmueble inmueble = null;
            switch (opcionTipo) {
                case 1:
                    System.out.print("¿El local es interno? ");
                    boolean esInterno = validarInterno();
                    System.out.println("\nTipos de local: ");
                    System.out.println("1. Local Comercial");
                    System.out.println("2. Oficina");
                    int option = validarSegundaOpcion();
                    sc.nextLine();

                    switch (option) {
                        case 1:
                            valor = 3000;
                            System.out.println("Valor por m²: " + valor);
                            System.out.println("Centro comercial donde se ubica: ");
                            String centroComercial = sc.nextLine();
                            inmueble = new Comerciales(id, area, valor, direccion, centroComercial, esInterno);
                            break;
                        case 2:
                            valor = 3500;
                            System.out.println("Valor por m²: " + valor);
                            System.out.println("La oficina es de gobierno? (s/n): ");
                            boolean gobierno = validarInterno();
                            inmueble = new Oficina(id, area, valor, direccion, esInterno, gobierno);
                            break;
                        default:
                            System.out.println("Opcion Invalida!!");
                            return;
                    }
                    break;
                case 2:
                    System.out.print("Cantidad de habitaciones: ");
                    int numHabitaciones = validarValorInt();
                    System.out.println("Cantidad de banos ");
                    int numBanos = validarValorInt();
                    System.out.println("\nTipos de vivienda: ");
                    System.out.println("1. Departamento");
                    System.out.println("2. Casa");
                    int opcion1 = validarSegundaOpcion();
                    switch (opcion1) {
                        case 1:
                            valor = 2000;
                            System.out.print("Valor por m²: " + valor);
                            System.out.println("Costo de administracion: ");
                            double costoAdmin = validarValorDouble();
                            if (numHabitaciones > 1) {
                                inmueble = new Familia(id, area, valor, direccion, numHabitaciones, numBanos, costoAdmin);
                            } else {
                                valor = 1500;
                                System.out.print("Valor por m²: " + valor);
                                inmueble = new Individual(id, area, valor, direccion, numHabitaciones, numBanos, costoAdmin);
                            }
                            break;
                        case 2:
                            System.out.println("Cantidad de pisos: ");
                            int numPisos = validarValorInt();
                            System.out.println("\nSeleccione el tipo de casa: ");
                            System.out.println("1. Urbana");
                            System.out.println("2. Rural");
                            int opcion2 = validarSegundaOpcion();
                            switch (opcion2) {
                                case 1:
                                    System.out.println("La casa es de Conjunto Cerrado?");
                                    boolean conjuntoCerrado = validarInterno();
                                    if (!conjuntoCerrado) {
                                        valor = 3000;
                                        System.out.println("Valor por m²: " + valor);
                                        inmueble = new Independiente(id, area, valor, direccion, numHabitaciones, numBanos, numPisos);
                                    } else {
                                        valor = 2500;
                                        System.out.println("Valor por m²: " + valor);
                                        System.out.println("Tiene areas comunes?");
                                        boolean areasComunes = validarInterno();
                                        System.out.println("Costo de Administracion: ");
                                        double costoAdmin1 = validarValorDouble();
                                        inmueble = new ConjuntoCerrado(id, area, valor, direccion, numHabitaciones, numBanos, numPisos, costoAdmin1, areasComunes);
                                    }
                                    break;
                                case 2:
                                    valor = 1500;
                                    System.out.println("Valor por m²: " + valor);
                                    System.out.println("Latitud sobre el nivel del mar ");
                                    float latitudNivel = validarValorFloat();
                                    System.out.println("Distacia en Km a la cabecera Municipal");
                                    float distanciaMunicipal = validarValorFloat();
                                    inmueble = new Rural(id, area, valor, direccion, numHabitaciones, numBanos, numPisos, latitudNivel, distanciaMunicipal);
                                    break;
                            }
                    }
                    break;
                default:
                    System.out.println("Opción de tipo inválida.");
                    return;
            }
            InmuebleServicios.inmuebles.add(inmueble);
            servicios.agregarInmuebleArchivo(inmueble);
            System.out.println("Inmueble creado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al ingresar datos: " + e.getMessage());
            sc.nextLine();
        }
    }
}
