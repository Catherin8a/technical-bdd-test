package com.test.demo.steps;

import com.test.demo.pages.LoginPage;
import net.serenitybdd.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class LoginSteps {

    @Page
    private LoginPage loginPage;

    @Step("Hacer login con usuario {0} y clave {1}")
    public void hacerLogin(String usuario, String clave) {
        loginPage.getTxtUsername().type(usuario);
        loginPage.getTxtPassword().type(clave);
        loginPage.getBtnLogin().click();
    }

}
