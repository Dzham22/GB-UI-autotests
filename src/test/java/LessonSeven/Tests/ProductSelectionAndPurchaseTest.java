package LessonSeven.Tests;

import LessonFive.BaseTest;
import LessonSeven.Pages.ProductSelectionAndPurchasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Выбор и покупка товара")
public class ProductSelectionAndPurchaseTest extends BaseTest {

    @Test
    @Description("В этом тесте проверяется выбор и покупка товаров")
    @Severity(SeverityLevel.BLOCKER)
    void PositiveProductTest() {

        webDriver.get(URL);
        new ProductSelectionAndPurchasePage(webDriver).moveToHeaderMenu()
                .clickTheLaptopsSubmenu()
                .clickOnTheLaptop()
                .clickOnModification()
                .moveToOnlineStoreAndClickOnIt();

    }


}
