package LessonSeven.Tests;

import LessonFive.BaseTest;
import LessonSeven.MainPages.MainProductSearchPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Поиск товара на сайте")
public class ProductSearchTest extends BaseTest {


    @Test
    @Description("В этом тесте проверяется корректность поиска товаров на сайте")
    @Severity(SeverityLevel.CRITICAL)
    void ProductSearchTest() {
        webDriver.get(URL);

       new MainProductSearchPage(webDriver).clickInTheSearchField()
                              .enterAValueInTheSearch()
                              .clickSearchButton()
                              .moveToAccordeonElement()
                              .chooseOneOfTheAccordeonOptions()
                              .moveAndSelectDeliveryCheckbox();
   }
}
