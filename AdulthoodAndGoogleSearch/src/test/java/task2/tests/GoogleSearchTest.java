package task2.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import task2.pages.GooglePage;
import task2.pages.SearchResultsPage;

import java.time.Duration;

public class GoogleSearchTest {
    SearchResultsPage results;
    private static final String searchText = "Aliaksandr Liatokha";


    @Test
    public void googleSearch() {
        GooglePage google = new GooglePage();
        SelenideElement elementWithTooltip = google.open().getElementWithTooltip();
        String attrText = google.getElementWithTooltipAttrText(elementWithTooltip);
        SelenideElement tooltip = google.hoverElementAndReturnTooltip(elementWithTooltip);
        tooltip.shouldHave(Condition.text(attrText));

        results = google.searchFor(searchText).toScreen();
        google = results.shouldHaveSizeGreaterThan(0)
                .shouldHaveResult(0, searchText)
                .clickOnGoogleLogo();

        google.getEditField().shouldBe(Condition.visible, Duration.ofSeconds(4));
        google.getGoogleLogo().shouldBe(Condition.visible, Duration.ofSeconds(4));
    }
}
