import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner sc= new Scanner(System.in);
    private static final  String ARCHIVO = "datos.txt";
    public static void main(String[] args) {

        int opcion;
        do{
            System.out.println("\n MENU CRUD ");
            System.out.println("1. Agregar inmueble");
            System.out.println("2. Listar inmuebles");
            System.out.println("3. Actualizar inmueble");
            System.out.println("4. Buscar inmueble");
            System.out.println("5. Eliminar inmueble");
            System.out.println("6. Salir");
            System.out.print("Seleccione la opcion del 1-6 ");
            opcion=sc.nextInt();

            switch (opcion){
                case 1:
                    agregarInmueble();
                    break;
                case 2:
                    listarInmuebles();
                    break;
                case 3:
                    actualizarInmuebles();
                    break;
                case 4:
                    buscarInmueble();
                    break;
                case 5:
                    eliminarInmueble();
                case 6:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("Opcion Invalida!!");
            }
        }while(opcion!=6);
                                    :D


    }
}