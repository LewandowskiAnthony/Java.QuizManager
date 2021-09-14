package lew.quiz.models;

public abstract class Question {

    protected String _category;
    protected String _difficulty;
    protected String _question;

    protected Question(String category, String difficulty, String question) {
        _category = category;
        _difficulty = difficulty;
        _question = question;
    }

    protected abstract String AskTheQuestion();

}
