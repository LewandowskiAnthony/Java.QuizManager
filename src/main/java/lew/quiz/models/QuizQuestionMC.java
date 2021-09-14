package lew.quiz.models;

public class QuizQuestionMC extends Question {

    private String _type;

    public QuizQuestionMC(String type, String category, String difficulty, String question) {
        super(category, difficulty, question);
        this._type = "QCM";
    }

    @Override
    protected String AskTheQuestion() {
        return this._question;
    }
}
