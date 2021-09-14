package lew.quiz.application;

import com.mashape.unirest.http.exceptions.UnirestException;
import lew.quiz.models.Question;
import lew.quiz.models.QuizQuestionBool;
import lew.quiz.models.QuizQuestionMC;
import lew.quiz.repositories.OpenTDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {
    public static void main(String[] args) throws UnirestException, IOException {

        System.out.println("Hello World !");
        OpenTDB thisQuestionnaire = new OpenTDB();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Question> listOfQuestions = thisQuestionnaire.GetQuestionsFromAPI(12);

        for (Question currentQuestion : listOfQuestions){
            boolean isCorrect = false;
            System.out.println(currentQuestion.AskTheQuestion());
            System.out.println(currentQuestion.ShowAnswers());
            System.out.println("Enter the right answer");
            if(currentQuestion instanceof QuizQuestionMC) {
                var _answer = br.readLine().charAt(0);
                isCorrect = currentQuestion.CheckAnswer(_answer);
            }
            else if (currentQuestion instanceof QuizQuestionBool) {
                var _answer = Boolean.parseBoolean(br.readLine());
                isCorrect = currentQuestion.CheckAnswer(_answer);
            }

            if(isCorrect)
                System.out.println("Bonne Réponse");
            else
                System.out.println("Mauvaise Réponse");
        }
    }
}
