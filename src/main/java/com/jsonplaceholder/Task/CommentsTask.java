package com.jsonplaceholder.Task;

import com.jsonplaceholder.Models.CommentsModel;

import com.jsonplaceholder.Utils.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.jsonplaceholder.Constants.Constants.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CommentsTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Get.resource(endpoint)
                        .with(
                                requestSpecification -> requestSpecification
                                        .header("Accept","*/*")
                                        .contentType(ContentType.JSON)
                                        .queryParam(Data.extractData().get(0).get("params"), Data.extractData().get(0).get("id"))
                                        .log().all()
                        )
        );


    }

    public static CommentsTask fromComments() {
        return instrumented(CommentsTask.class);
    }
}
