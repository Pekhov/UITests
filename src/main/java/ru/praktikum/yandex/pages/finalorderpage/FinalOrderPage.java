package ru.praktikum.yandex.pages.finalorderpage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.praktikum.yandex.pages.statusorderpage.StatusOrderPage;

import static com.codeborne.selenide.Selenide.page;

public class FinalOrderPage {

    @FindBy(how = How.CLASS_NAME, using = "Order_Text__2broi")
    private SelenideElement orderText;

    @FindBy(how = How.XPATH, using = "//button[text()='Посмотреть статус']")
    private SelenideElement showStatusButton;

    public StatusOrderPage showStatusButtonClick() {
        showStatusButton.click();
        return page(StatusOrderPage.class);
    }
}
