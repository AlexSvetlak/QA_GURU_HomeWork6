package anotation.test;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class AnotationTest extends Steps {
    private static final String URL = "https://github.com/qa-guru";
    private static final String REPOSITORY = "allure-notifications";
    private static final int ISSUE_NUMBER = 64;

    private final Steps steps = new Steps();

    @Owner("AlexSvet")
    @Feature("Gidhub")
    @Story("Issues")
    @DisplayName("Annotation Test")
    @Link(name = "GitHub", url = "https://github.com/qa-guru")

    @Test
    public void checkIssue() {
        steps.openGithubPage(URL);
        steps.finedRepository(REPOSITORY);
        steps.finedIssues();
        steps.finedNumberInIssues(ISSUE_NUMBER);
        steps.takeScreenshot();
    }


}