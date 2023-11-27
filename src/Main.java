import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        int opc;
        Scanner sc = new Scanner(System.in);
        Parqueadero e = new Parqueadero();

        do {
            System.out.println("1. Ingresar carro");
            System.out.println("2. Dar salida a carro");
            System.out.println("3. Informar ingresos");
            System.out.println("4. Consultar puestos disponibles");
            System.out.println("5. Avanzar reloj del parqueadero");
            System.out.println("6. Cambiar tarifa del parqueadero");
            System.out.println("7. Tiempo promedio de estadia");
            System.out.println("8. Carro con más horas en el parqueadero");
            System.out.println("9. ¿Hay carro parqueado por más de 8 horas?");
            System.out.println("10. Carros parqueados por más de tres horas");
            System.out.println("11. ¿Hay carros con la misma placa?");
            System.out.println("12. Cantidad de carros con placa PB");
            System.out.println("13. ¿Hay carro parqueado por 24 o más horas?");
            System.out.println("14. Desocupar parqueadero");
            System.out.println("15. Salir");
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
                    e.darTiempoParqueadero();
                    System.out.println("El promedio de estadia: " + e.darTiempoParqueadero());
                    break;
                case 8:
                    e.carroConMasHoras();
                    System.out.println("El carro con mas horas es: " + e.carroConMasHoras());
                    break;

                case 9:
                    e.darCarroMasDeOchoHoras();
                    System.out.println("Los carros con mas de 8 horas son: " + e.darCarroMasDeOchoHoras());
                    break;
                case 10:
                    e.darCarrosMasDeTresHorasParqueados();
                    System.out.println("Los carros con mas de 3 horas son: " +e.darCarrosMasDeTresHorasParqueados());
                    break;
                case 11:
                    e.hayCarrosPlacaIgual();
                    System.out.println("Los carros con la misma placa son: " +e.hayCarrosPlacaIgual());
                    break;
                case 12:
                    e.contarCarrosQueComienzanConPlacaPB();
                    System.out.println("Los carros que comienzan con la placa PB son: " +e.contarCarrosQueComienzanConPlacaPB());
                    break;
                case 13:
                    e.metodo1();
                    System.out.println(" " + e.metodo1());
                    break;
                case 14:
                    e.metodo2();
                    System.out.println(" " + e.metodo2());
                    break;
                case 15:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        } while (opc != 15);
    }
}
