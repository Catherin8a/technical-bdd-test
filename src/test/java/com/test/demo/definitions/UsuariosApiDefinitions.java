package com.test.demo.definitions;

import com.test.demo.steps.UserApiSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import java.util.Map;

public class UsuariosApiDefinitions {

    @Steps
    UserApiSteps userApiSteps;

    private Map<String, String> mapUserData;
    private Response response;
    private String id;

    @Dado("que tengo los siguientes datos de usuario:")
    public void almacenarDatos(DataTable datosUsuario) {
        mapUserData = datosUsuario.transpose().asMap();
    }

    @Dado("que creé un usuario con los siguientes datos")
    public void crearUsuario(DataTable userData) {
        response = userApiSteps.crearUsuario(userData.transpose().asMap());
    }

    @Cuando("envíe una solicitud POST al endpoint de usuarios")
    public void enviarSolicitudCrearUsuario() {
        response = userApiSteps.crearUsuario(mapUserData);
    }

    @Entonces("el usuario deberá ser creado")
    public void verificarUsuarioCreado() {
        response.then().log().all();
        Assert.assertEquals("El servicio no respondió 201.", HttpStatus.SC_CREATED, response.getStatusCode());
    }

    @Entonces("el cuerpo de la respuesta deberá contener un campo {string}")
    public void verificarCampoId(String campo) {
        Assert.assertNotNull("El campo id no existe en la respuesta del servicio.", response.jsonPath().getString(campo));
    }

    @Cuando("obtenga el usuario creado mediante el id")
    public void obtenerUsuario() {
        response.then().log().all();
        id = response.jsonPath().getString("id");
        response = userApiSteps.obtenerUsuario("3");
    }

    @Entonces("la respuesta deberá ser exitosa")
    public void verificarRespuestaExitosa() {
        response.then().log().all();
        Assert.assertEquals("No se encontró el usuario con id: " + id, HttpStatus.SC_OK, response.getStatusCode());
    }

    @Entonces("el cuerpo de la respuesta deberá contener los siguientes datos:")
    public void verificarDatosRespuesta(Map<String, String> datosEsperados) {
        SoftAssertions softAssertions = new SoftAssertions();
        for (Map.Entry<String, String> registro : datosEsperados.entrySet()) {
            softAssertions.assertThat(response.jsonPath().getString("data." + registro.getKey()))
                    .as("No se encontró el valor")
                    .isEqualTo(registro.getValue());
        }
        softAssertions.assertAll();
    }
}
