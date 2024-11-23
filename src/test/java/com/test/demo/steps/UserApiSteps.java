package com.test.demo.steps;

import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

public class UserApiSteps {

    @Step("Crear un nuevo usuario con los siguientes datos {0}")
    public Response crearUsuario(Map<String, String> mapUserData) {
        return SerenityRest.given().log().all()
                .contentType("application/json")
                .body(mapUserData)
                .post("https://reqres.in/api/users");
    }

    @Step("Obtener los detalles del usuario con ID {0}")
    public Response obtenerUsuario(String userId) {
        return SerenityRest.given().log().all()
                .get("https://reqres.in/api/users/" + userId);
    }
}
