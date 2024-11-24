package ejercicios;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EjerciciosLogica {

    public static boolean verificarNumerosPrimos(int numero) {
        if (numero <= 1) return false; // Los números menores o iguales a 1 no son primos
        if (numero <= 3) return true;  // 2 y 3 son primos
        if (numero % 2 == 0 || numero % 3 == 0) return false; // Descartar múltiplos de 2 y 3

        // Solo verificar divisores hasta √n, incrementando de forma eficiente
        int limite = (int) Math.sqrt(numero);
        for (int i = 5; i <= limite; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }

        return true; // Si no encontró divisores, el número es primo
    }

    public static boolean esPalindromo(String cadena) {
        // Eliminar espacios en blanco y convertir a minúsculas para comparar
        String limpia = cadena.replaceAll("\\s+", "").toLowerCase();
        int longitud = limpia.length();

        // Comparar los caracteres desde los extremos hacia el centro
        for (int i = 0; i < longitud / 2; i++) {
            if (limpia.charAt(i) != limpia.charAt(longitud - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static String ordenarCadenas(String entrada) {
        if (entrada == null || entrada.isBlank()) {
            return ""; // Retorna directamente si la entrada es nula o vacía
        }

        // Divide, ordena ignorando mayúsculas/minúsculas y une en una sola línea
        return Arrays.stream(entrada.split("\\s+"))
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .reduce((a, b) -> a + " " + b)
                .orElse("");
    }

    public static void generarFibonacci(int numero) {
        if (numero <= 0) {
            System.out.println("No hay números en la secuencia.");
            return;
        }

        // Variables para almacenar los valores actuales
        int a = 0, b = 1;

        // Generar e imprimir la secuencia directamente
        for (int i = 0; i < numero; i++) {
            System.out.print(a + (i < numero - 1 ? ", " : "")); // Imprimir con formato
            int siguiente = a + b;  // Calcular el siguiente número
            a = b;  // Actualizar a al siguiente número
            b = siguiente;  // Actualizar b al siguiente número
        }

        System.out.println();
    }

    public static int[] encontrarParSuma(List<Integer> numeros, int objetivo) {
        // Usamos un Set para almacenar los números vistos
        Set<Integer> numerosVistos = new HashSet<>();

        for (int numero : numeros) {
            int complemento = objetivo - numero;

            // Si encontramos el complemento, devuelve el par
            if (numerosVistos.contains(complemento)) {
                return new int[] {complemento, numero};
            }

            // Guardamos el número en el Set
            numerosVistos.add(numero);
        }

        // Si no encontramos ningún par, devuelve null
        return null;
    }

    public static void main(String[] args) {
        //Pruebas primo
        int numeroPrimo = 6;
        System.out.println("numero " + numeroPrimo + " es primo? " + verificarNumerosPrimos(numeroPrimo));

        //Pruebas Palindrome
        String prueba1 = "radar";
        String prueba2 = "hola";
        String prueba3 = "Anita lava la tina";

        System.out.println(String.format("¿Es %s un palíndromo? ", prueba1) + esPalindromo(prueba1));
        System.out.println(String.format("¿Es %s un palíndromo? ", prueba2) + esPalindromo(prueba2));
        System.out.println(String.format("¿Es %s un palíndromo? ", prueba3) + esPalindromo(prueba3));

        //Prueba ordenar cadenas
        String entrada = "perro gato casa";
        String resultado = ordenarCadenas(entrada);
        System.out.println("La cadena ordenada es: " + resultado);

        //Prueba Fibonacci
        int numeroSecuencia = 5;
        System.out.print("Secuencia de Fibonacci para n = " + numeroSecuencia + ": ");
        generarFibonacci(numeroSecuencia);

        //Prueba encontrar par suma
        List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5);
        int objetivo = 9;

        int[] resultadoSuma = encontrarParSuma(listaNumeros, objetivo);

        System.out.println(resultadoSuma != null
                ? "Par encontrado: (" + resultadoSuma[0] + ", " + resultadoSuma[1] + ")"
                : "No se encontró ningún par.");
    }

}
