package LessonSix.Tests;

import LessonFive.BaseTest;
import LessonSix.Pages.ProductSelectionAndPurchasePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Выбор и покупка товара")
public class ProductSelectionAndPurchaseTest extends BaseTest {

    @Test
    void PositiveProductTest() {

        webDriver.get(URL);
        new ProductSelectionAndPurchasePage(webDriver).moveToHeaderMenu()
                .clickTheLaptopsSubmenu()
                .clickOnTheLaptop()
                .clickOnModification()
                .selectAnOptionAndClickButton();

    }


}
