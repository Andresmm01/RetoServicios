package com.jsonplaceholder.StepDefinitions;

import com.jsonplaceholder.Task.CommentsTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.jsonplaceholder.Constants.Constants.baseUrl;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.hasItem;

public class CommentsStepDefinitions {

    private String restBaseUrl;
    private EnvironmentVariables environmentVariables;
    private Actor user;
    @Before
    public void setUpBaseUrl(){
        restBaseUrl= environmentVariables.optionalProperty("restapi.baseurl")
                .orElse(baseUrl);
        user= Actor.named("User final").whoCan(
                CallAnApi.at(restBaseUrl)
        );
    }

    @When("I consume the comments endpoint for comments with query parameter")
    public void iConsumeTheCommentsEndpointForCommentsWithQueryParameter() {
        user.attemptsTo(
                CommentsTask.fromComments()
        );
    }
    @Then("I should see the list of available comments")
    public void iShouldSeeTheListOfAvailableComments() {

        String Email = "Veronica_Goodwin@timmothy.net";

        user.should(
                seeThatResponse(
                        "The Email of commets is",
                        response -> response.body("email", hasItem(Email))
                ).orComplainWith(
                        AssertionError.class, "The email in the response body did not match the expected value: " + Email
                )
        );

        // Agregar información personalizada al informe
        Serenity.recordReportData().withTitle("Email Verification").andContents("Email: " + Email);
    }

}
