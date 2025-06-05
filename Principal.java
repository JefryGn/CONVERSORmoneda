

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        System.out.println("Escriba el código de la moneda base (ej: USD, EUR):");
        try {
            var codigoMoneda = lectura.nextLine().toUpperCase();
            Moneda moneda = consulta.buscaTasaCambio(codigoMoneda);

            // Paso 8: Filtrar moneda destino
            System.out.println("Escriba el código de la moneda destino (ej: EUR, JPY):");
            var codigoDestino = lectura.nextLine().toUpperCase();
            Double tasaDestino = moneda.getConversionRate(codigoDestino);

            if (tasaDestino == null) {
                System.out.println("Moneda no encontrada.");
            } else {
                System.out.printf("Tasa de cambio %s a %s: %.4f%n",
                        codigoMoneda, codigoDestino, tasaDestino);

                // Paso 9: Conversión de valores
                System.out.println("Ingrese el monto a convertir:");
                double monto = Double.parseDouble(lectura.nextLine());
                double montoConvertido = monto * tasaDestino;

                System.out.printf("%.2f %s = %.2f %s%n",
                        monto, codigoMoneda, montoConvertido, codigoDestino);
            }

        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}