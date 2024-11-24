package com.test.demo.definitions;

import com.test.demo.steps.HomeSteps;
import com.test.demo.steps.LoginSteps;
import com.test.demo.utils.BaseSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class TransaccionesDefinitions {

    @Steps(shared = true)
    private BaseSteps baseSteps;

    @Steps(shared = true)
    private LoginSteps loginSteps;

    @Steps(shared = true)
    private HomeSteps homeSteps;

    private List<Map<String, Object>> mapValoresMonto;


    @Dado("que el usuario navegó a la página de inicio de sesión de Applitools Demo")
    public void navegarAlSitioWebApplitools() {
        baseSteps.navegar("https://demo.applitools.com/hackathonV2.html");
    }

    @Cuando("ingrese las credenciales usuario: {string} y contraseña: {string}")
    public void ingresarCredencialesCorrectas(String usuario, String clave) {
        loginSteps.hacerLogin(usuario, clave);
    }

    @Entonces("iniciará sesión con éxito")
    public void verificarInicioSesionExitoso() {
        Assert.assertEquals("El inicio de sesión no fue exitoso", "https://demo.applitools.com/hackathonAppV2.html", homeSteps.obtenerUrlActual());
    }

    @Entonces("podrá ver {int} transacciones en la tabla de gastos")
    public void verificarTamanoTabla(int cantidadTransacciones) {
        mapValoresMonto = homeSteps.obtenerValoresMonto();
        Assert.assertEquals("No existen exactamente " + cantidadTransacciones + " en la tabla de transacciones",
                cantidadTransacciones, homeSteps.obtenerCantidadTransacciones());
    }

    @Entonces("el saldo total será de {string}")
    public void verificarSaldoTotal(String saldoTotal) {
        Assert.assertEquals("El saldo total no es el esperado", saldoTotal, homeSteps.obtenerSaldoTotal());
    }

    @Entonces("el crédito disponible será de {string}")
    public void verificarCreditoDisponible(String creditoDisponible) {
        Assert.assertEquals("El crédito disponible no es el esperado", creditoDisponible, homeSteps.obtenerCreditoDisponible());
    }

    @Entonces("los valores positivos deberán estar en verde")
    public void verificarValoresPositivos() {
        SoftAssertions softAssertions = new SoftAssertions();

        for (Map<String, Object> registro : mapValoresMonto) {
            // Obtiene el valor y la clase
            Double valorNumerico = (Double) registro.get("value");
            String claseCelda = (String) registro.get("class");

            // Verifica que los valores positivos tengan la clase "text-success"
            if (valorNumerico != null && valorNumerico > 0) {
                softAssertions.assertThat(claseCelda)
                        .as("Este valor es positivo y debería imprimirse en verde", valorNumerico)
                        .isEqualTo("text-success");
            }
        }
        // Ejecuta todas las aserciones acumuladas
        softAssertions.assertAll();
    }

    @Entonces("los valores negativos deberán estar en rojo")
    public void verificarValoresNegativos() {
        SoftAssertions softAssertions = new SoftAssertions();

        for (Map<String, Object> registro : mapValoresMonto) {
            // Obtiene el valor y la clase
            Double valorNumerico = (Double) registro.get("value");
            String claseCelda = (String) registro.get("class");

            // Verifica que los valores negativos tengan la clase "text-danger"
            if (valorNumerico != null && valorNumerico < 0) {
                softAssertions.assertThat(claseCelda)
                        .as("Este valor " + valorNumerico + " es negativo y debería imprimirse en rojo")
                        .isEqualTo("text-danger");
            }
        }

        // Ejecuta todas las aserciones acumuladas
        softAssertions.assertAll();
    }

}
