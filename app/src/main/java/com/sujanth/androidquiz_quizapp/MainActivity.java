package com.sujanth.androidquiz_quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int totalNumberOfQuizzes = 10;
    int totalCorrectAnswers = 0;

    private RadioGroup quizOneRadioGroup;
    private RadioButton quizOneRadioButton;

    //Answers for quizzes
    String correctAnswerForQuizOne = "Java";
    String correctAnswerForQuizTwo = "Gingerbread, Lollipop and Nougat";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String checkResultForQuizOne = checkAnswerForQuizOne();
                String checkResultForQuizTwo = checkAnswerForQuizTwo();

                Toast.makeText(MainActivity.this, "Correct Answer For Quiz 1: " + correctAnswerForQuizOne + "\n" + checkResultForQuizOne +
                        "\n\nCorrect Answer For Quiz 2: " + correctAnswerForQuizTwo + "\n" + checkResultForQuizTwo +
                        "\nTotal Correct Answers: " + totalCorrectAnswers, Toast.LENGTH_LONG).show();
                displayAnswersForAllQuizes();
                totalCorrectAnswers = 0;
            }
        });
    }




    //Selected answer for quiz two
    private String checkAnswerForQuizTwo() {
        CheckBox checkBoxForGingerBread = (CheckBox) findViewById(R.id.ginger_bread_check_box);
        CheckBox checkBoxForLollipop = (CheckBox) findViewById(R.id.lollipop_check_box);
        CheckBox checkBoxForNougat = (CheckBox) findViewById(R.id.nougat_check_box);
        CheckBox checkBoxForMuffin = (CheckBox) findViewById(R.id.muffin_check_box);

        if (checkBoxForGingerBread.isChecked() && checkBoxForLollipop.isChecked() && checkBoxForNougat.isChecked() && !checkBoxForMuffin.isChecked()) {
            totalCorrectAnswers = totalCorrectAnswers + 1;
            return "Awesome work, all options are right!";
        } else {
            return "Hey, You have to Google it to get right answer for this question.";
        }



    }

    private String checkAnswerForQuizOne() {
        quizOneRadioGroup = (RadioGroup) findViewById(R.id.quiz_one_radio_group);
        int selectedAnswerForQuizOne = quizOneRadioGroup.getCheckedRadioButtonId();

        quizOneRadioButton = (RadioButton) findViewById(selectedAnswerForQuizOne);
        String answer = quizOneRadioButton.getText().toString();

        if (answer.equalsIgnoreCase(correctAnswerForQuizOne)) {
            totalCorrectAnswers = totalCorrectAnswers + 1;
            return "You are right!";
        } else {
            return "You are wrong!";
        }
    }

    private void displayAnswersForAllQuizes() {
        TextView displayAnswers = (TextView) findViewById(R.id.display_answer_text_view);
        displayAnswers.setText("Answers: \nQuiz 1: " + correctAnswerForQuizOne +
                "\nQuiz 2: " + correctAnswerForQuizTwo +
                "\n\nTotal Correct Answer: " + totalCorrectAnswers +"/"+ totalNumberOfQuizzes);
    }

}
