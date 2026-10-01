import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //https://github.com/JesusGonzalez7777/Ejercicio-7.git
        
        Scanner scanner = new Scanner(System.in);
        List<Integer> listaNumeros = new ArrayList<>();
        int opcion = 0;

        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");

            // Validación de entrada para asegurar que se ingrese un número
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                procesarOpcion(opcion, listaNumeros, scanner);
            } else {
                System.out.println(" Error: Debe ingresar un número entero válido.");
                scanner.next(); // Limpiar el búfer
            }
            System.out.println(); // Salto de línea
        } while (opcion != 7);

        scanner.close();
    }

    // Muestra el menú de opciones en la consola
    public static void mostrarMenu() {

        System.out.println("        MENÚ DE OPCIONES         ");
        System.out.println("---------------------------------");
        System.out.println("1.- Leer dato");
        System.out.println("2.- Muestre números pares");
        System.out.println("3.- Muestre los cuadrado de los valores");
        System.out.println("4.- Suma de los elementos de la lista");
        System.out.println("5.- Buscar un elementos de la lista");
        System.out.println("6.- Encontrar valor maximo");
        System.out.println("7.- Salir");

    }

    // Maneja la lógica según la opción seleccionada
    public static void procesarOpcion(int opcion, List<Integer> lista, Scanner scanner) {
        switch (opcion) {
            case 1:
                leerDato(lista, scanner);
                break;
            case 2:
                mostrarPares(lista);
                break;
            case 3:
                mostrarCuadrados(lista);
                break;
            case 4:
                mostrarSuma(lista);
                break;
            case 5:
                buscarElemento(lista, scanner);
                break;
            case 6:
                mostrarMaximo(lista);
                break;
            case 7:
                System.out.println(" Saliendo ...");
                break;
            default:
                System.out.println("⚠ Opción no válida");
        }
    }

    // 1. Añade un entero (Integer) a la lista
    public static void leerDato(List<Integer> lista, Scanner scanner) {
        System.out.print("Ingrese un número entero a la lista: ");
        if (scanner.hasNextInt()) {
            int numero = scanner.nextInt();
            lista.add(numero);
            System.out.println(" El número " + numero + " fue agregado a la lista.");
        } else {
            System.out.println(" Entrada no valida");
            scanner.next();
        }
    }

    // 2. Muestra los números pares de la lista
    public static void mostrarPares(List<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("⚠️ La lista está vacía.");
            return;
        }

        System.out.print("Números pares en la lista: ");
        boolean hayPares = false;
        for (Integer num : lista) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
                hayPares = true;
            }
        }
        if (!hayPares) {
            System.out.print("No se encontraron números pares.");
        }
        System.out.println();
    }

    // 3. Muestra el cuadrado de cada número
    public static void mostrarCuadrados(List<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("⚠️ La lista está vacía.");
            return;
        }

        System.out.println("Cuadrado de los valores de la lista:");
        for (Integer num : lista) {
            long cuadrado = (long) num * num;
            System.out.println("  " + num + " -> " + cuadrado);
        }
    }

    // 4. Calcula y muestra la suma total
    public static void mostrarSuma(List<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("⚠️ La lista está vacía. La suma es 0.");
            return;
        }

        long suma = 0;
        for (Integer num : lista) {
            suma += num;
        }
        System.out.println("La suma de los elementos de la lista es: " + suma);
    }

    // 5. Busca un elemento y reporta la posición
    public static void buscarElemento(List<Integer> lista, Scanner scanner) {
        if (lista.isEmpty()) {
            System.out.println("⚠️ La lista está vacía.");
            return;
        }

        System.out.print("Ingrese el elemento a buscar: ");
        if (scanner.hasNextInt()) {
            int elemento = scanner.nextInt();
            int indice = lista.indexOf(elemento);

            if (indice != -1) {
                System.out.println(" El número " + elemento + " se encuentra en el índice: " + indice);
            } else {
                System.out.println(" El número " + elemento + " no se encuentra en la lista.");
            }
        } else {
            System.out.println(" Entrada inválida.");
            scanner.next();
        }
    }

    // 6. Determina y muestra el valor máximo
    public static void mostrarMaximo(List<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("⚠️ La lista está vacía.");
            return;
        }

        int maximo = lista.get(0);
        for (Integer num : lista) {
            if (num > maximo) {
                maximo = num;
            }
        }
        System.out.println("El valor máximo de la lista es: " + maximo);
    }
}