package com.test.demo.utils;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;

public class BaseSteps {

    @Steps(shared = true)
    PageObject page;

    @Step("Abrir el navegador e ingresar a la página {0}")
    public void navegar(String url) {
        page.setDefaultBaseUrl(url);
        page.open();
    }
}