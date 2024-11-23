package ejercicios;

public class EjerciciosLogica {

    public static boolean verificarNumerosPrimos(int n) {
        if (n <= 1) return false; // Los números menores o iguales a 1 no son primos
        if (n <= 3) return true;  // 2 y 3 son primos
        if (n % 2 == 0 || n % 3 == 0) return false; // Descartar múltiplos de 2 y 3

        // Solo verificar divisores hasta √n, incrementando de forma eficiente
        int limite = (int) Math.sqrt(n);
        for (int i = 5; i <= limite; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
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


    public static void main(String[] args) {
        //Pruebas primo
        int numeroPrimo = 6;
        System.out.println("numero " + numeroPrimo + " es primo? " + verificarNumerosPrimos(numeroPrimo));

        // Pruebas Palindrome
        String prueba1 = "radar";
        String prueba2 = "hola";
        String prueba3 = "Anita lava la tina";

        System.out.println(String.format("¿Es %s un palíndromo? ", prueba1) + esPalindromo(prueba1));
        System.out.println(String.format("¿Es %s un palíndromo? ", prueba2) + esPalindromo(prueba2));
        System.out.println(String.format("¿Es %s un palíndromo? ", prueba3) + esPalindromo(prueba3));

    }

}
