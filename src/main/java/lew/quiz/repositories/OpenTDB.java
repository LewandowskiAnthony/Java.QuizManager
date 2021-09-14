package lew.quiz.repositories;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lew.quiz.models.Question;
import lew.quiz.models.QuizQuestionMC;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OpenTDB {

    private List<Question> listOfQuestions;

    public OpenTDB(){
        listOfQuestions = new ArrayList<>();
    }

    public List<Question> GetQuestionsFromAPI(int amountOfQuestions) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://opentdb.com/api.php?amount=" + amountOfQuestions)
                .header("Cookie", "PHPSESSID=7759a9d455f1288a16d04c1c28f4f762")
                .asString();
        CreateQuestions(new JSONObject(response.getBody()));
        return this.listOfQuestions;
    }

    private void CreateQuestions(JSONObject JSON){
        JSONObject jobject = JSON;
        JSONArray jarray = jobject.getJSONArray("results");

        for(int i=0; i<= jarray.length()-1; i++){
            switch(jarray.getJSONObject(i).getString("type")){
                case "multiple":
                    listOfQuestions.add(new QuizQuestionMC(
                            jarray.getJSONObject(i).getString("category"),
                            jarray.getJSONObject(i).getString("difficulty"),
                            jarray.getJSONObject(i).getString("question"),
                            GetIncorrectAnswers(jarray.getJSONObject(i)),
                            jarray.getJSONObject(i).getString("correct_answer")
                    ));
                    break;
                case "boolean" :
                    break;
                default:
                    break;
            }
        }

        JSONObject first = jarray.getJSONObject(0);
        System.out.println(first.toString());
    }

    private List<String> GetIncorrectAnswers(JSONObject questionDatas){
        JSONArray fakeAnswersArray = questionDatas.getJSONArray("incorrect_answers");
        List<String> incorrectAnswers = new ArrayList<>();
        for(int i=0; i<=fakeAnswersArray.length()-1; i++){
            incorrectAnswers.add(fakeAnswersArray.getString(i));
        }
        return incorrectAnswers;
    }

}
