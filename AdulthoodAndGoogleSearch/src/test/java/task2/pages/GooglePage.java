package task2.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GooglePage {
    public GooglePage open() {
        Selenide.open("http://google.com");
        return this;
    }

    public SearchResultsPage searchFor(String text) {
        $("[name='q']").setValue(text).pressEnter();
        return new SearchResultsPage();
    }

    public SelenideElement getEditField() {
        return $("[name='q']");
    }

    public SelenideElement getGoogleLogo() {
        return $("img[alt=\"Google\"]");
    }

    public SelenideElement getElementWithTooltip() {
        return $("[data-base-lens-url='https://lens.google.com']");
    }

    public String getElementWithTooltipAttrText(SelenideElement elementWithTooltip) {
        String attrTxt = elementWithTooltip.attr("aria-label");
        System.out.println("attrTxt = " + attrTxt);
        return attrTxt;
    }

    public SelenideElement hoverElementAndReturnTooltip(SelenideElement elementWithTooltip) {
        elementWithTooltip.hover()
                .shouldHave(Condition.attribute("aria-label"), Duration.ofSeconds(3));
        return $x(".//div[@style and .//div[@style and .//div[@style]]]");
    }
}