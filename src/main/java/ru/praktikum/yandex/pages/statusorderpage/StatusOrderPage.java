package ru.praktikum.yandex.pages.statusorderpage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StatusOrderPage {

    @FindBy(how = How.CLASS_NAME, using = "Track_Input__1g7lq")
    private SelenideElement orderNumberField;

    @FindBy(how = How.XPATH, using = "//button[text()='Отменить заказ']")
    private SelenideElement cancelButton;

    public String getOrderNumber() {
        System.out.println(orderNumberField.getValue());
        return orderNumberField.getValue();
    }

    public boolean isCancelButtonDisplayed() {
        return cancelButton.isDisplayed();
    }
}