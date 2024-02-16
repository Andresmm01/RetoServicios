package com.jsonplaceholder.Questions;

import com.jsonplaceholder.Models.CommentsModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseComments implements Question<CommentsModel> {

    @Override
    public CommentsModel answeredBy(Actor actor) {

        return SerenityRest.lastResponse().jsonPath()
                .getObject("data", CommentsModel.class);
    }

    public static ResponseComments was(){
        return new ResponseComments();
    }
}
