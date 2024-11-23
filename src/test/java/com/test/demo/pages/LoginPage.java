package com.test.demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

    @FindBy(id = "username")
    protected WebElementFacade txtUsername;

    @FindBy(id = "password")
    protected WebElementFacade txtPassword;

    @FindBy(id = "log-in")
    protected WebElementFacade btnLogin;

    public WebElementFacade getTxtUsername() {
        return txtUsername;
    }

    public WebElementFacade getTxtPassword() {
        return txtPassword;
    }

    public WebElementFacade getBtnLogin() {
        return btnLogin;
    }
}
