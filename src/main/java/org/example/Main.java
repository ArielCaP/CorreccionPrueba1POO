package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TarjetaMetro.mostrarTarifas();
        System.out.println("Titular: ");
        String titular = sc.nextLine();
        System.out.println("Cedula: ");
        String cedula = sc.nextLine();
        System.out.println("Edad: ");
        int edad=sc.nextInt();
        sc.nextLine();
        System.out.println("Tiene discapacidad?(s/n): ");
        String respuesta = sc.nextLine();
        boolean tieneDiscapacidad=respuesta.equalsIgnoreCase("s");
        System.out.println("Saldo Inicial: ");
        double saldoInicial=sc.nextDouble();
        sc.nextLine();

        TarjetaMetro tarjeta1=new TarjetaMetro(titular, cedula, edad, saldoInicial, tieneDiscapacidad);
        int opcion;
        do {
            System.out.println("1.Recargar");
            System.out.println("2.Pagar Viaje");
            System.out.println("3.Consultar tarjeta");
            System.out.println("4.Simular Recarga");
            System.out.println("5.Salir");
            System.out.println("Ingrese una opcion");
            opcion=sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Monto deseado para recargar: ");
                    double monto=sc.nextDouble();
                    tarjeta1.recargar(monto);
                    break;
                case 2:
                    tarjeta1.pagarViaje();
                    break;
                case 3:
                    tarjeta1.mostrarInformacion();
                    break;
                case 4:
                    System.out.println("Monto deseado de simular: ");
                    double montoS=sc.nextDouble();
                    System.out.printf("Con el monto simulado estos serian tus viajes totales: "+tarjeta1.calcularViajesDisponibles(montoS));
                    break;
                case 5:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while (opcion!=5);
        sc.close();

    }
}