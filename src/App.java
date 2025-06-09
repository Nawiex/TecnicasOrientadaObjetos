import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> historial = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            Decorador.imprimirCabecera("Calculadora de Areas");
            System.out.println("Seleccione una figura:");
            System.out.println("1. Círculo");
            System.out.println("2. Rectángulo");
            System.out.println("3. Triángulo");
            System.out.println("4. Mostrar historial");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            Figura figura = null;

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el radio: ");
                        double radio = scanner.nextDouble();
                        figura = new Circulo(radio);
                        break;
                    case 2:
                        System.out.print("Ingrese la base: ");
                        double baseR = scanner.nextDouble();
                        System.out.print("Ingrese la altura: ");
                        double alturaR = scanner.nextDouble();
                        figura = new Rectangulo(baseR, alturaR);
                        break;
                    case 3:
                        System.out.print("Ingrese la base: ");
                        double baseT = scanner.nextDouble();
                        System.out.print("Ingrese la altura: ");
                        double alturaT = scanner.nextDouble();
                        figura = new Triangulo(baseT, alturaT);
                        break;
                    case 4:
                        Decorador.imprimirCabecera("Historial de Calculos");
                        if (historial.isEmpty()) {
                            System.out.println("No hay calculos previos.");
                        } else {
                            for (String entry : historial) {
                                System.out.println(entry);
                            }
                        }
                        continue;
                    case 5:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opcion no válida.");
                        continue;
                }

                if (figura != null) {
                    double area = figura.calcularArea();
                    String resultado = "Figura: " + figura.getClass().getSimpleName() + " - Area: " + area;
                    historial.add(resultado);
                    System.out.println(resultado);
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        mostrarEstadisticas(historial);
    }

    public static void mostrarEstadisticas(ArrayList<String> historial) {
        Decorador.imprimirCabecera("Estadísticas Finales");
        System.out.println("Total de calculos realizados: " + historial.size());

        if (!historial.isEmpty()) {
            double sumaAreas = 0;
            for (String entry : historial) {
                String[] partes = entry.split(": ");
                sumaAreas += Double.parseDouble(partes[2]);
            }
            System.out.println("Promedio de areas calculadas: " + (sumaAreas / historial.size()));
        }
    }
}

class Decorador {
    public static void imprimirCabecera(String titulo) {
        System.out.println("\n====================");
        System.out.println(titulo);
        System.out.println("====================");
    }

    public static void imprimirLinea() {
        System.out.println("--------------------");
    }
}
