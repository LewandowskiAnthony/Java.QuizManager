package lew.quiz.models;

public class QuizQuestionBool extends Question{

    private String _type;

    public QuizQuestionBool(String category, String difficulty, String question) {
        super(category, difficulty, question);
        _type = "boolean";
    }

    @Override
    protected String AskTheQuestion() {
        return null;
    }
}
