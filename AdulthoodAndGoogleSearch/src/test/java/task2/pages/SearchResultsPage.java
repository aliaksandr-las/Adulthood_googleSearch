package task2.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    private final ElementsCollection elements = $$("div#rso a[jsname] h3");

    public SearchResultsPage shouldHaveSizeGreaterThan(int size) {
        elements.shouldHave(CollectionCondition.sizeGreaterThan(size));
        return this;
    }

    public SearchResultsPage shouldHaveResult(int index, String text) {
        elements.get(index).shouldHave(Condition.text(text));
        return this;
    }

    public GooglePage clickOnGoogleLogo() {
        $("div.logo a[href]").click();
        return new GooglePage();
    }

    public SearchResultsPage toScreen() {
        System.out.println("\nSearch Result size = " + elements.size() + "\n");
        for (SelenideElement element : elements) {
            System.out.println(element.text());
        }
        return this;
    }
}
