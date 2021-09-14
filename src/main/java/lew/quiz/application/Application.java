package lew.quiz.application;

import com.mashape.unirest.http.exceptions.UnirestException;
import lew.quiz.models.Question;
import lew.quiz.repositories.OpenTDB;

import java.util.List;

public class Application {
    public static void main(String[] args) throws UnirestException {

        System.out.println("Hello World !");
        OpenTDB thisQuestionnaire = new OpenTDB();

        List<Question> listOfQuestions = thisQuestionnaire.GetQuestionsFromAPI(12);
        for (Question currentQuestion : listOfQuestions){
            System.out.println(currentQuestion.toString());
        }
    }
}
