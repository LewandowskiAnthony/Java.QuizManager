package lew.quiz.ui;

import com.mashape.unirest.http.exceptions.UnirestException;
import lew.quiz.models.*;
import lew.quiz.repositories.OpenTDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QuizInterface {

    JPanel MainGui;
    private JButton playButton;
    private JComboBox numberOfQuestions;
    private JTextField username;
    static JFrame frame;
    private List<Question> questionsList = new ArrayList<>();

    public QuizInterface(){
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!username.getText().isEmpty()) {
                    OpenTDB questionApiConnector = new OpenTDB();
                    try {
                        questionsList = questionApiConnector.GetQuestionsFromAPI(Integer.parseInt((String) numberOfQuestions.getItemAt(numberOfQuestions.getSelectedIndex())));
                    } catch (UnirestException unirestException) {
                        unirestException.printStackTrace();
                    }
                    System.out.println(numberOfQuestions.getSelectedIndex());
                    JFrame quizFrame = new JFrame("QuizInterface");
                    quizFrame.setResizable(false);
                    quizFrame.setMinimumSize(new Dimension(500, 400));
                    quizFrame.setContentPane(new QuestionsGUI(questionsList).getQuizPanel());
                    quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    quizFrame.pack();
                    quizFrame.setLocationRelativeTo(null);
                    quizFrame.setVisible(true);
                    frame.dispose();
                }
            }
        });
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {

        JButton playButton = new JButton("Play");

        frame = new JFrame("QuizInterface");
        frame.setResizable(false);
        frame.setMinimumSize(new Dimension(500, 400));
        frame.setContentPane(new QuizInterface().MainGui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        System.out.println("Hello !");

    }
}
