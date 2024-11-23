package com.test.demo;

public class Utils {

    /**
     * Limpia el texto de la celda para obtener solo el valor numérico y lo convierte a Double.
     */
    public static Double limpiarCeldasNumericas(String text) {
        try {
            // Elimina signos, comas y texto no numérico
            String textoLimpio = text.replaceAll("[^\\d.-]", ""); // Conserva dígitos, signos negativos y puntos decimales
            return Double.parseDouble(textoLimpio); // Convierte a Double
        } catch (NumberFormatException e) {
            return null; // Devuelve null si la conversión falla
        }
    }
}
