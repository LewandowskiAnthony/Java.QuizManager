package lew.quiz.ui;

import lew.quiz.models.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuestionsGUI {
    private JButton ResponseB;
    private JButton ResponseC;
    private JButton ResponseA;
    private JButton ResponseD;
    private JLabel questionLabel;
    private List<Question> _questionList;
    private int questionIndex = 0;
    private JPanel QuizPanel;
    private JButton nextQuestionButton;

    public JPanel getQuizPanel() {
        return QuizPanel;
    }

    public QuestionsGUI(List<Question> questionList){
        nextQuestionButton.setVisible(false);
        _questionList = questionList;
        ChangeQuestionGUI(questionIndex);

        ResponseA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(_questionList.get(questionIndex).get_type() == "QCM")
                    AnswerReaction(ResponseA, 'A');
                else if (_questionList.get(questionIndex).get_type() == "boolean")
                    AnswerReaction(ResponseA, true);
            }
        });

        ResponseB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(_questionList.get(questionIndex).get_type() == "QCM")
                    AnswerReaction(ResponseB, 'B');
                else if (_questionList.get(questionIndex).get_type() == "boolean")
                    AnswerReaction(ResponseB, false);
            }
        });

        ResponseC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnswerReaction(ResponseC, 'C');
            }
        });

        ResponseD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnswerReaction(ResponseD, 'D');
            }
        });

        nextQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeQuestionGUI(questionIndex);
                nextQuestionButton.setVisible(false);
            }
        });
    }

    private void AnswerReaction(JButton thisButton, Object answer){
        System.out.println(_questionList.get(questionIndex).CheckAnswer(answer));
        ResponseA.setEnabled(false);
        ResponseB.setEnabled(false);
        ResponseC.setEnabled(false);
        ResponseD.setEnabled(false);
        if(_questionList.get(questionIndex).CheckAnswer(answer))
            thisButton.setBackground(Color.green);
        else
            thisButton.setBackground(Color.red);
        questionIndex++;
        nextQuestionButton.setVisible(true);
    }

    private void ChangeQuestionGUI(int i){

        if(i == _questionList.size()){
            ResponseA.setVisible(false);
            ResponseB.setVisible(false);
            ResponseC.setVisible(false);
            ResponseD.setVisible(false);
            questionLabel.setVisible(false);
            return;
        }

        ResponseA.setBackground(new JButton().getBackground());
        ResponseB.setBackground(new JButton().getBackground());
        ResponseC.setBackground(new JButton().getBackground());
        ResponseD.setBackground(new JButton().getBackground());
        ResponseA.setEnabled(true);
        ResponseB.setEnabled(true);
        ResponseC.setEnabled(true);
        ResponseD.setEnabled(true);

        questionLabel.setText("<html><p style=\"width:300px; text-align:center;\">"+_questionList.get(i).AskTheQuestion()+"</p></html>");
        ResponseA.setText(_questionList.get(i).get_allAnswers().get(0).toString());
        ResponseB.setText(_questionList.get(i).get_allAnswers().get(1).toString());
        if(_questionList.get(i).get_type() == "boolean") {
            ResponseC.setVisible(false);
            ResponseD.setVisible(false);
        } else {
            ResponseC.setVisible(true);
            ResponseD.setVisible(true);
            ResponseC.setText(_questionList.get(i).get_allAnswers().get(2).toString());
            ResponseD.setText(_questionList.get(i).get_allAnswers().get(3).toString());
        }
    }

}
