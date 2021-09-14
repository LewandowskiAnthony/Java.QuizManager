package lew.quiz.application;

import com.mashape.unirest.http.exceptions.UnirestException;
import lew.quiz.repositories.OpenTDB;

public class Application {
    public static void main(String[] args) throws UnirestException {

        System.out.println("Hello World !");
        OpenTDB thisQuestionnaire = new OpenTDB();
        System.out.println(thisQuestionnaire.GetQuestions(12));
    }
}
