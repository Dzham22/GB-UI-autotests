package LessonSeven.Tests;
import LessonFive.BaseTest;
import LessonSeven.MainPages.MainFiltersPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Фильтры и сравнение продуктов")
public class FiltersAndProductComparisonTest extends BaseTest {

    @Test
    @Description("В этом тесте проверются фильтры сравнение характеристик товаров")
    @Severity(SeverityLevel.NORMAL)
    void FilterTest(){
        webDriver.get(URL);

        new MainFiltersPage(webDriver).clickSubmenuLaptops()
                .clickOnParameterInTheFilter()
                .moveToElementAndClick()
                .findTheBrandAndClick()
                .selectAndClickTheFilterButton()
                .moveToChosenModifications()
                .chooseTwoOptionsForComparison()
                .clickTheCompareButton();
    }

}
