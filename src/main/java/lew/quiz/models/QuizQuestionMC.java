package lew.quiz.models;

import java.util.Collections;
import java.util.List;

public class QuizQuestionMC extends Question<Character> {

    private String _type= "QCM";
    private List<String> _allAnswers;
    private String _correctAnswer;


    public QuizQuestionMC(String category, String difficulty, String question, List<String> _incorrectAnswers, String _correctAnswers) {
        super(category, difficulty, question);
        this._allAnswers = _incorrectAnswers;
        this._correctAnswer = _correctAnswers;
        _allAnswers.add(_correctAnswers);
        Collections.shuffle(_allAnswers);
    }

    @Override
    public String toString() {
        return "QuizQuestionMC{" + '\n' +
                "_category='" + _category + '\''+ '\n' +
                ", _difficulty='" + _difficulty + '\''+ '\n' +
                ", _question='" + _question + '\''+ '\n' +
                ", _type='" + _type + '\''+ '\n' +
                ", _incorrectAnswers=" + _allAnswers + '\n' +
                ", _correctAnswers='" + _correctAnswer + '\'' + '\n' +
                '}';
    }

    @Override
    public boolean CheckAnswer(Character answer) {
        answer = Character.toUpperCase(answer);
        int intAnswerValue;
        switch (answer){
            case 'A':
                intAnswerValue = ResponsesEnum.A;
                break;
            case 'B':
                intAnswerValue = ResponsesEnum.B;
                break;
            case 'C':
                intAnswerValue = ResponsesEnum.C;
                break;
            case 'D':
                intAnswerValue = ResponsesEnum.D;
                break;
            default:
                intAnswerValue = -1;
                break;
        }

        if(intAnswerValue>=0 && _allAnswers.get(intAnswerValue) == _correctAnswer){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String ShowAnswers() {
        char x='A';
        String answersToShow = "";
        for(String answer : _allAnswers){
            answersToShow += x + " : " + answer + "\n";
            x+=1;
        }
        return answersToShow;
    }

    public String get_type() {
        return _type;
    }


}


class ResponsesEnum {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 3;
}
