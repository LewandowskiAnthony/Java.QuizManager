package lew.quiz.models;

public abstract class Question<T> {

    protected String _category;
    protected String _difficulty;
    protected String _question;

    protected Question(String category, String difficulty, String question) {
        _category = category;
        _difficulty = difficulty;
        _question = question;
    }

    public String AskTheQuestion(){
        return _question;
    }

    public abstract boolean CheckAnswer(T answer);

    public abstract String ShowAnswers();

    public abstract String get_type();

}
