package ru.praktikum.yandex.pages.confirmorderpage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.praktikum.yandex.pages.finalorderpage.FinalOrderPage;

import static com.codeborne.selenide.Selenide.page;

public class ConfirmOrderPage {

    @FindBy(how = How.CLASS_NAME, using = "Order_ModalHeader__3FDaJ")
    private SelenideElement headerTitle;

    @FindBy(how = How.XPATH, using = "//button[text()='Да']")
    private SelenideElement yesButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Нет']")
    private SelenideElement noButton;

    public FinalOrderPage yesButtonClick() {
        yesButton.click();
        return page(FinalOrderPage.class);
    }
}
