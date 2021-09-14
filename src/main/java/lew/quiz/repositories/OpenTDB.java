package lew.quiz.repositories;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class OpenTDB {

    public OpenTDB(){

    }

    public String GetQuestions(int amoutOfQuestions) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://opentdb.com/api.php?amount=" + amoutOfQuestions)
                .header("Cookie", "PHPSESSID=7759a9d455f1288a16d04c1c28f4f762")
                .asString();
        return response.getBody();
    }
}
