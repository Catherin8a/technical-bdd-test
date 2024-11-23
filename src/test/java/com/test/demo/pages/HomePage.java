package com.test.demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends PageObject {

    @FindBy(id = "transactionsTable")
    protected WebElementFacade tblTransacciones;

    @FindBy(xpath = "//*[@id='creditAvailable']/div[@class='balance-value']")
    protected WebElementFacade lblCreditoDisponible;

    @FindBy(xpath = "//*[@id='totalBalance']/div[@class='balance-value']/span")
    protected WebElementFacade lblSaldoTotal;

    public WebElementFacade getTblTransacciones() {
        return tblTransacciones;
    }

    public WebElementFacade getLblCreditoDisponible() {
        return lblCreditoDisponible;
    }

    public WebElementFacade getLblSaldoTotal() {
        return lblSaldoTotal;
    }

}
