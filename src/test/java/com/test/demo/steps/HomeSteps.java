package com.test.demo.steps;

import com.test.demo.Utils;
import com.test.demo.pages.HomePage;
import net.serenitybdd.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeSteps {

    @Page
    private HomePage homePage;

    @Step("Obtener la URL actual del navegador")
    public String obtenerUrlActual() {
        return homePage.getDriver().getCurrentUrl();
    }

    @Step
    public int obtenerCantidadTransacciones() {
        return homePage.getTblTransacciones().findBy(By.tagName("tbody")).findElements(By.tagName("tr")).size();
    }

    @Step
    public List<Map<String, Object>> obtenerValoresMonto() {
        // Encuentra todas las filas dentro del tbody de la tabla
        List<WebElement> filas = homePage.getTblTransacciones().findBy(By.tagName("tbody")).findElements(By.tagName("tr"));
        return extraerDatosTabla(filas);
    }

    /**
     * Extrae los datos de las filas de la tabla y los devuelve como una lista de mapas.
     */
    private static List<Map<String, Object>> extraerDatosTabla(List<WebElement> filas) {
        List<Map<String, Object>> listaDatos = new ArrayList<>();

        for (WebElement fila : filas) {
            WebElement celda = fila.findElement(By.xpath("./td[5]/span")); // Obtén la celda de la columna 5
            String textoCelda = celda.getText().trim(); // Obtén el texto de la celda
            String claseCelda = celda.getAttribute("class"); // Obtén las clases de la celda

            // Limpia y convierte el texto de la celda
            Double valorNumerico = Utils.limpiarCeldasNumericas(textoCelda);

            // Crea un mapa para almacenar el valor limpio y la clase
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("value", valorNumerico); // Valor como Double
            dataMap.put("class", claseCelda);   // Clase como String

            // Agrega el mapa a la lista
            listaDatos.add(dataMap);
        }

        return listaDatos;
    }

    @Step
    public String obtenerSaldoTotal() {
        return homePage.getLblSaldoTotal().getText();
    }

    @Step
    public String obtenerCreditoDisponible() {
        return homePage.getLblCreditoDisponible().getText();
    }
}
