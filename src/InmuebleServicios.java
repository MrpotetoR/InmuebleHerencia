import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InmuebleServicios {
    private static Scanner sc = new Scanner(System.in);
    private static final String ARCHIVO = "datos.txt";
    public static List<Inmueble> inmuebles = new ArrayList<>();

    public void agregarInmuebleArchivo(Inmueble inmueble) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            writer.write(inmueble.toString());
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Error al registrar el inmueble en archivo: " + e.getMessage());
        }
    }


    public void listarInmuebles() {
        if (inmuebles.isEmpty()) {
            System.out.println("No hay inmuebles registrados.");
        } else {
            System.out.println("\nListado de inmuebles:");
            for (Inmueble inmueble : inmuebles) {
                inmueble.mostrarInfo();
                System.out.println("--------------------------");
            }
        }
    }


    public void actualizarInmueble() {
        System.out.print("Ingresa el id del inmueble a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
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

    public void buscarInmueble() {
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


    public void eliminarInmueble() {
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


    private void escribirArchivoCompleto() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Inmueble inmueble : inmuebles) {
                writer.write(inmueble.toString());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar archivo: " + e.getMessage());
        }
    }


    public void cargarDatos() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            System.out.println("\nCargando datos del archivo...");

            while ((linea = reader.readLine()) != null) {
                try {
                    // Saltar líneas vacías o comentarios
                    if (linea.trim().isEmpty() || linea.trim().startsWith("#")) {
                        continue;
                    }

                    Inmueble inmueble = Inmueble.fromString(linea);
                    inmuebles.add(inmueble);

                } catch (Exception e) {
                    System.err.println("Error en línea: " + linea);
                    System.err.println("Razón: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Error fatal al leer archivo: " + e.getMessage());
        }
    }
}
