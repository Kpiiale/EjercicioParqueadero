import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        int opc;
        Scanner sc = new Scanner(System.in);
        Parqueadero e = new Parqueadero();

        do {
            System.out.println("Seleccione una opcion: ");
            System.out.println("1. Ingresar un carro al parqueadero.");
            System.out.println("2. Dar salida a un carro del parqueadero");
            System.out.println("3. Informar los ingresos del parqueadero");
            System.out.println("4. Mostrar cantidad de puestos libres.");
            System.out.println("5. Avanzar el reloj del parqueadero.");
            System.out.println("6. Cambiar la tarifa del parqueadero");
            System.out.println("7. Salir");
            System.out.println("ingrese una opcion.");
            opc = Integer.parseInt(sc.next());
            switch (opc) {
                case 1:
                    System.out.println("Ingrese la placa del carro:");
                    String placa = sc.next();

                    int resultadoIngreso = e.entrarCarro(placa);

                    switch (resultadoIngreso) {
                        case Parqueadero.NO_HAY_PUESTO:
                            System.out.println("El parqueadero está lleno. No hay puestos disponibles.");
                            break;
                        case Parqueadero.PARQUEADERO_CERRADO:
                            System.out.println("El parqueadero está cerrado en este momento.");
                            break;
                        case Parqueadero.CARRO_YA_EXISTE:
                            System.out.println("Ya hay un carro en el parqueadero con la misma placa.");
                            break;
                        default:
                            System.out.println("El carro ha sido ingresado correctamente en el puesto " + resultadoIngreso+1);
                            break;
                    }


                    break;
                case 2:
                    System.out.println("Ingrese la placa del carro a sacar:");
                    String placaSalida = sc.next();

                    int resultadoSalida = e.sacarCarro(placaSalida);

                    switch (resultadoSalida) {
                        case Parqueadero.CARRO_NO_EXISTE:
                            System.out.println("No hay un carro en el parqueadero con la placa proporcionada.");
                            break;
                        case Parqueadero.PARQUEADERO_CERRADO:
                            System.out.println("El parqueadero está cerrado en este momento.");
                            break;
                        default:
                            System.out.println("El carro con placa " + placaSalida + " ha salido del parqueadero. Monto a pagar: " + resultadoSalida + "$");
                            break;
                    }

                    break;

                case 3:
                    e.darMontoCaja();
                    System.out.println("Los ingresos son: " + e.darMontoCaja());
                    break;

                case 4:
                    e.calcularPuestosLibres();
                    System.out.println("Los puestos libres son: " + e.calcularPuestosLibres());

                    break;
                case 5:
                    e.avanzarHora();
                    System.out.println("la hora ha sido avanzada correctamente " + "\n la hora actual es:" + e.darHoraActual());
                    break;
                case 6:
                    int nuevaTarifa;
                    System.out.println("ingrese una nueva tarifa.");
                    nuevaTarifa = sc.nextInt();
                    e.cambiarTarifa(nuevaTarifa);
                    break;
                case 7:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        } while (opc != 7);
    }
}
