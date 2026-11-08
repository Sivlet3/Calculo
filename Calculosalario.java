
import java.util.Scanner;

public class CalculoSalario {

    public static double calcularSalario(double horas, int categoria) {

        double tarifa;

        // Validar horas trabajadas
        if (horas < 0) {
            throw new IllegalArgumentException(
                "Las horas no pueden ser negativas."
            );
        }

        // Validar categoría
        if (categoria < 1 || categoria > 3) {
            throw new IllegalArgumentException(
                "La categoría debe ser 1, 2 o 3."
            );
        }

        // Asignar tarifa según categoría
        switch (categoria) {
            case 1:
                tarifa = 12000;
                break;
            case 2:
                tarifa = 17000;
                break;
            case 3:
                tarifa = 22000;
                break;
            default:
                throw new IllegalArgumentException(
                    "Categoría inválida."
                );
        }

        // Calcular salario con horas extras
        if (horas > 40) {
            double horasNormales = 40;
            double horasExtras = horas - 40;

            return (horasNormales * tarifa)
                    + (horasExtras * tarifa * 1.25);
        }

        // Calcular salario sin horas extras
        return horas * tarifa;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        try {
            System.out.println("=== CALCULO DE SALARIO ===");

            System.out.print("Ingrese las horas trabajadas: ");
            double horas = entrada.nextDouble();

            System.out.print("Ingrese la categoria (1, 2 o 3): ");
            int categoria = entrada.nextInt();

            double salario = calcularSalario(horas, categoria);

            System.out.printf(
                "El salario del trabajador es: $%.2f%n",
                salario
            );

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: debe ingresar datos numericos.");

        } finally {
            entrada.close();
        }
    }
}
