package ru.praktikum.yandex.pages.rentpage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.praktikum.yandex.pages.confirmorderpage.ConfirmOrderPage;

import static com.codeborne.selenide.Selenide.page;

public class RentPage {

    @FindBy(how = How.XPATH, using = ".//input[@placeholder='* Когда привезти самокат']")
    private SelenideElement dateField;

    @FindBy(how = How.CLASS_NAME, using = "react-datepicker__day")
    private ElementsCollection dayList;

    @FindBy(how = How.CLASS_NAME, using = "Dropdown-placeholder")
    private SelenideElement rentField;

    @FindBy(how = How.CLASS_NAME, using = "Dropdown-option")
    private ElementsCollection rentOptions;

    @FindBy(how = How.CLASS_NAME, using = "Checkbox_Label__3wxSf")
    private ElementsCollection colorCheckBox;

    @FindBy(how = How.XPATH, using = ".//input[@placeholder='Комментарий для курьера']")
    private SelenideElement commentField;

    @FindBy(how = How.XPATH, using = "//div/div[2]/div[3]/button[2]")
    private  SelenideElement makeOrderButton;

    public void dateFieldClick() {
        dateField.click();
    }

    public void rentFieldClick() {
        rentField.click();
    }

    public RentPage setDateFieldWithFirstDay() {
        dateFieldClick();
        dayList.first().click();
        return this;
    }

    public RentPage setDateField(String date) {
        dateField.setValue(date).pressEnter();
        return this;
    }

    public RentPage selectRentOption(String rentOption) {
        rentFieldClick();
        rentOptions.findBy(Condition.text(rentOption)).click();
        return this;
    }

    public RentPage selectScooterColor(String color) {
        colorCheckBox.findBy(Condition.text(color)).click();
        return this;
    }

    public RentPage setComment(String comment) {
        commentField.setValue(comment);
        return this;
    }

    public ConfirmOrderPage makeOrderButtonClick() {
        makeOrderButton.click();
        return page(ConfirmOrderPage.class);
    }
}
