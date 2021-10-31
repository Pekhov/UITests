package ru.praktikum.yandex.pages.orderpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.praktikum.yandex.pages.rentpage.RentPage;

import static com.codeborne.selenide.Selenide.page;

public class OrderPage {
    @FindBy(how = How.CLASS_NAME, using = "Order_Header__BZXOb")
    private SelenideElement orderHeader;

    @FindBy(how = How.XPATH, using = ".//input[@placeholder='* Имя']")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = ".//input[@placeholder='* Фамилия']")
    private SelenideElement surNameField;

    @FindBy(how = How.XPATH, using = ".//input[@placeholder='* Адрес: куда привезти заказ']")
    private SelenideElement addressField;

    @FindBy(how = How.XPATH, using = ".//input[@placeholder='* Станция метро']")
    private SelenideElement metroField;

    @FindBy(how = How.CLASS_NAME, using = "select-search")
    private SelenideElement metroSearchField;

    @FindBy(how = How.CLASS_NAME, using = "select-search__row")
    private ElementsCollection metroStationsList;

    @FindBy(how = How.XPATH, using = ".//input[@placeholder='* Телефон: на него позвонит курьер']")
    private SelenideElement phoneField;

    @FindBy(how = How.XPATH, using = ".//button[text()='Далее']")
    private  SelenideElement nextButton;

    public OrderPage setName(String name) {
        nameField.setValue(name);
        return this;
    }

    public OrderPage setSurName(String surName) {
        surNameField.setValue(surName);
        return this;
    }

    public OrderPage setAddress(String address) {
        addressField.setValue(address);
        return this;
    }

    public OrderPage metroSearchClick() {
        metroField.click();
        return this;
    }

    public OrderPage setMetroStation(String metro) {
        metroSearchClick();
        metroStationsList.findBy(Condition.text(metro)).click();
        return this;
    }

    public OrderPage setPhoneNumber(String number) {
        phoneField.setValue(number);
        return this;
    }

    public RentPage nextButtonClick() {
        nextButton.click();
        return page(RentPage.class);
    }
}
