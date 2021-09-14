package lew.quiz.models;

public class QuizQuestionBool extends Question<Boolean>{

    private String _type= "boolean";
    private boolean _answer;

    public QuizQuestionBool(String category, String difficulty, String question, boolean answer) {
        super(category, difficulty, question);
        _answer = answer;
    }

    @Override
    public boolean CheckAnswer(Boolean answer) {
        if(_answer == answer){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String ShowAnswers() {
        return "True or False ? \n";
    }


    @Override
    public String toString() {
        return "QuizQuestionBool{" + '\n' +
                "_category='" + _category + '\'' + '\n' +
                ", _difficulty='" + _difficulty + '\'' + '\n' +
                ", _question='" + _question + '\'' + '\n' +
                ", _type='" + _type + '\'' + '\n' +
                ", _answer=" + _answer + '\n' +
                '}';
    }

    public String get_type() {
        return _type;
    }
}

