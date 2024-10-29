import jdk.dynalink.linker.support.SimpleLinkRequest;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<CuentaUsuario> cuentas=new ArrayList<>();
    private static ArrayList<Pelicula>  peliculas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        inicializarPeliculas();
        CuentaUsuario cuentaActual = null;
        boolean continuar = true;
        try {
        while (continuar){
            System.out.println("\n servicios de peliculas");
            System.out.println("1. crear una cuenta");
            System.out.println("2. pagar suscripcion");
            System.out.println("3 ver lista de peliculas");
            System.out.println("4 cancelar membresia");
            System.out.println("5. salir");

            System.out.println("selecciona una opcion");
            int opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    cuentaActual=crearCuenta(scanner);
                    break;
                case 2:
                    if (cuentaActual !=null){
                        cuentaActual.pagarSuscripcion();
                    } else {
                        System.out.println("debe crear una cuenta primero");
                    }
                    break;
                case 3:
                    if (cuentaActual !=null){
                        cuentaActual.verPeliculas(peliculas);
                    }else {
                        System.out.println("deve crear una cuenta propia");
                    }
                case 4:
                    if (cuentaActual !=null){
                        cuentaActual.cancelarSuscripciones();
                    }else{
                        System.out.println("debe validar cuenta");
                    }
                    break;
                case 5:
                    continuar=false;
                    System.out.println("gracias por utilizar el servicio de estrimin");
                default:
                    System.out.println("opcion no valida");
                    break;

            }
        }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void inicializarPeliculas(){
        peliculas.add(new Pelicula("Venom 3","Accion",2024) );
        peliculas.add(new Pelicula("Spiderman 3","Accion",2021) );
        peliculas.add(new Pelicula("Jurasick World","Ciencia Ficcion",2023) );
        peliculas.add(new Pelicula("Jocker 2","Musical",2024) );
        peliculas.add(new Pelicula("Titanic","Romance",1995) );
        peliculas.add(new Pelicula("Venom 2","Accion",2022) );
    }

    public static CuentaUsuario crearCuenta(Scanner scanner) throws CuentaExistenteException {
        System.out.println("Ingrese el nombre de usuario");
        String nombreUsuario=scanner.next();

        //Verificar si ya existe
        for(CuentaUsuario cuenta: cuentas){
            if (cuenta.getNombreUsuario().equals(nombreUsuario)) {
                throw new CuentaExistenteException("Error: el nombre de usuario ya existe, intente con  otro usuaio");
            }
        }
        System.out.println("Ingrese la password minimo 8 caracteres");
        String password = scanner.next();

        System.out.println("Seleccione un plan BASICO, ESTANDAR, PREMIUM");
        Plan plan = Plan.valueOf(scanner.nextLine().toUpperCase());

        //crear una nueva cuenta
        CuentaUsuario nuevaCuenta = new CuentaUsuario(nombreUsuario,password,plan);
        cuentas.add(nuevaCuenta);
        System.out.println("cuenta creada exitosamente");
        return nuevaCuenta;
    }

}
