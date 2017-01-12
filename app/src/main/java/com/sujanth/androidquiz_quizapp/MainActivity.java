package com.sujanth.androidquiz_quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int totalNumberOfQuizzes = 5;
    int totalCorrectAnswers = 0;

    private RadioGroup quizOneRadioGroup;
    private RadioGroup quizFiveRadioGroup;
    private RadioButton quizOneRadioButton;
    private RadioButton quizFiveRadioButton;

    //Answers for quizzes
    String correctAnswerForQuizOne = "Java";
    String correctAnswerForQuizTwo = "Gingerbread, Lollipop and Nougat";
    String correctAnswerForQuizThree = "Implicit and Explicit Intents";
    String correctAnswerForQuizFour = "Application Package";
    String correctAnswerForQuizFive = "False";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String testTaker = displayUserName();
                String checkResultForQuizOne = checkAnswerForQuizOne();
                String checkResultForQuizTwo = checkAnswerForQuizTwo();
                String checkResultForQuizThree = checkAnswerForQuizThree();
                String checkResultForQuizFour = checkAnswerForQuizFour();
                String checkResultForQuizFive = checkAnswerForQuizFive();

                Toast.makeText(MainActivity.this, "Thank you " + testTaker + " for attempting the quizzes." +
                        "\n\nCorrect Answer For Quiz 1: " + correctAnswerForQuizOne + "\n" + checkResultForQuizOne +
                        "\n\nCorrect Answer For Quiz 2: " + correctAnswerForQuizTwo + "\n" + checkResultForQuizTwo +
                        "\n\nCorrect Answer For Quiz 3: " + correctAnswerForQuizThree + "\n" + checkResultForQuizThree +
                        "\n\nCorrect Answer For Quiz 4: " + correctAnswerForQuizFour + "\n" + checkResultForQuizFour +
                        "\n\nCorrect Answer For Quiz 5: " + correctAnswerForQuizFive + "\n" + checkResultForQuizFive +
                        "\n\nTotal Correct Answers: " + totalCorrectAnswers, Toast.LENGTH_LONG).show();
                displayAnswersForAllQuizzes();
                totalCorrectAnswers = 0;
            }
        });
    }


    private String checkAnswerForQuizOne() {
        quizOneRadioGroup = (RadioGroup) findViewById(R.id.quiz_one_radio_group);
        int selectedAnswerForQuizOne = quizOneRadioGroup.getCheckedRadioButtonId();

        quizOneRadioButton = (RadioButton) findViewById(selectedAnswerForQuizOne);

        if (quizOneRadioButton != null) {
            String answer = quizOneRadioButton.getText().toString();

            if (answer.equalsIgnoreCase(correctAnswerForQuizOne)) {
                totalCorrectAnswers = totalCorrectAnswers + 1;
                return "You are right!";
            } else {
                return "You are wrong!";
            }
        }else {
            return "No answer selected for quiz one!";
        }
    }

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

    private String checkAnswerForQuizThree() {
        CheckBox implicitIntent = (CheckBox) findViewById(R.id.implicit_intent_check_box);
        CheckBox explicitIntent = (CheckBox) findViewById(R.id.explicit_intent_check_box);
        CheckBox internalIntent = (CheckBox) findViewById(R.id.internal_intent_check_box);
        CheckBox externalIntent = (CheckBox) findViewById(R.id.external_intent_check_box);

        if (implicitIntent.isChecked() && explicitIntent.isChecked() && !internalIntent.isChecked() && !externalIntent.isChecked()) {
            totalCorrectAnswers = totalCorrectAnswers + 1;
            return "Fantastic, You are on fire!";
        } else {
            return "Please go back to the class.";
        }
    }

    private String checkAnswerForQuizFour() {
        EditText quizFourEditText = (EditText) findViewById(R.id.quiz_four_edit_text);
        String quizForAnswer = quizFourEditText.getText().toString();
        if (quizForAnswer.equalsIgnoreCase(correctAnswerForQuizFour)) {
            totalCorrectAnswers = totalCorrectAnswers + 1;
            return "Fabulous, Keep your awesome work!";
        } else {
            return "Sorry mate, you are missing something here!";
        }
    }

    private String checkAnswerForQuizFive() {
        quizFiveRadioGroup = (RadioGroup) findViewById(R.id.quiz_five_radio_group);
        int selectedAnswerForQuizFive  = quizFiveRadioGroup.getCheckedRadioButtonId();

        quizFiveRadioButton = (RadioButton) findViewById(selectedAnswerForQuizFive);

        if (quizFiveRadioButton != null) {
            String answerForQuizFive = quizFiveRadioButton.getText().toString();

            if (answerForQuizFive.equalsIgnoreCase(correctAnswerForQuizFive)){
                totalCorrectAnswers = totalCorrectAnswers + 1;
                return "Amazing answer, You can continue to code!";
            } else {
                return "It can be a tricky question, but there are so many ways you can get it right!";
            }
        } else {
            return "No answer selected for quiz five!";
        }
    }

    private String displayUserName() {
        EditText userNameEditText = (EditText) findViewById(R.id.user_name_edit_text);
        String userName = userNameEditText.getText().toString();
        return userName;
    }

    private void displayAnswersForAllQuizzes() {
        TextView displayAnswers = (TextView) findViewById(R.id.display_answer_text_view);
        displayAnswers.setText("Answers: \nQuiz 1: " + correctAnswerForQuizOne +
                "\nQuiz 2: " + correctAnswerForQuizTwo +
                "\nQuiz 3: " + correctAnswerForQuizThree +
                "\nQuiz 4: " + correctAnswerForQuizFour +
                "\nQuiz 5: " + correctAnswerForQuizFive +
                "\n\nTotal Correct Answer: " + totalCorrectAnswers +"/"+ totalNumberOfQuizzes);
    }

}
