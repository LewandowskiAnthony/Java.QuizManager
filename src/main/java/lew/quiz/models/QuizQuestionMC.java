package lew.quiz.models;

import java.util.Collections;
import java.util.List;

public class QuizQuestionMC extends Question {

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
    protected String AskTheQuestion() {
        return "done";
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
}
