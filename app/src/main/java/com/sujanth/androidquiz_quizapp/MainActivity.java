package com.sujanth.androidquiz_quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int totalNumberOfQuizes = 10;
    int totalCorrectAnswers = 0;

    private RadioGroup quizOneRadioGroup;
    private RadioButton quizOneRadioButton;

    //Answers for quizes
    String correctAnswerForQuizOne = "Java";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String answerOne = selectedAnswerForQuizOne();
                String checkResultForQuizOne = checkAnswer();
                Toast.makeText(MainActivity.this, "Selected Answer: " + answerOne + "\nCorrect Answer: " + correctAnswerForQuizOne + "\n" + checkResultForQuizOne, Toast.LENGTH_LONG).show();
                displayAnswersForAllQuizes();
            }
        });
    }



    private String selectedAnswerForQuizOne() {
        quizOneRadioGroup = (RadioGroup) findViewById(R.id.quiz_one_radio_group);
        int selectedAnswerForQuizOne = quizOneRadioGroup.getCheckedRadioButtonId();
        quizOneRadioButton = (RadioButton) findViewById(selectedAnswerForQuizOne);
        String answer = quizOneRadioButton.getText().toString();
        return answer;
    }

    private String checkAnswer() {
        String selectedAnswerForQuizOne = selectedAnswerForQuizOne();

        if (selectedAnswerForQuizOne.equalsIgnoreCase(correctAnswerForQuizOne)) {
            return "You are right!";
        } else {
            return "You are wrong!";
        }
    }

    private void displayAnswersForAllQuizes() {
        TextView displayAnswers = (TextView) findViewById(R.id.display_answer_text_view);
        displayAnswers.setText("Answers: \nQuiz 1: " + correctAnswerForQuizOne);
    }

}
