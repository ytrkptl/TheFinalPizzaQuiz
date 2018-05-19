package com.example.android.thefinalpizzaquiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //GLOBAL VARIABLE
    int numberOfCorrectAnswers = 0;
    int answerFour = 0;
    int numberOfQuestions = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //    method executed upon clicking the check_answer_1 button located under question 1
    public void checkAnswerOne(View view) {
        RadioGroup radioGroupOne = findViewById(R.id.radio_group_1);
        int selectedId = radioGroupOne.getCheckedRadioButtonId();
        RadioButton answerRadioOne = findViewById(R.id.radio_button_1);
        Button answerOneButton = findViewById(R.id.check_answer_1);
        checkAnswersRadio(selectedId, answerRadioOne, answerOneButton);
    }

    /**
     * check answer to question 1 and requires input and responds accordingly until the user
     * gets the right answer
     * */
    private void checkAnswersRadio(int selectedId, RadioButton answerRadioOne, Button answerOneButton) {

        if (selectedId == -1) {
            Toast.makeText(this, getString(R.string.selectAnAnswer), Toast.LENGTH_LONG).show();
        } else if (selectedId == answerRadioOne.getId()) {
            Toast.makeText(this, getString(R.string.rightAnswer), Toast.LENGTH_LONG).show();
            numberOfCorrectAnswers++;
            answerOneButton.setEnabled(false);
        } else {
            Toast.makeText(this, getString(R.string.wrongAnswer), Toast.LENGTH_SHORT).show();
        }
    }

    //    method executed upon clicking the check_answer_2 button located under question 2
    public void checkAnswerTwo(View view) {
        CheckBox questionTwoCheckBoxOne = findViewById(R.id.checkBoxOne);
        CheckBox questionTwoCheckBoxTwo = findViewById(R.id.checkBoxTwo);
        CheckBox questionTwoCheckBoxThree = findViewById(R.id.checkBoxThree);
        CheckBox questionTwoCheckBoxFour = findViewById(R.id.checkBoxFour);
        Button answerTwoButton = findViewById(R.id.check_answer_2);
        checkAnswersCheckboxes(questionTwoCheckBoxOne, questionTwoCheckBoxTwo, questionTwoCheckBoxThree, questionTwoCheckBoxFour, answerTwoButton);
    }

    /**
     * check answer to question 2 and requires input and responds accordingly until the user
     * gets the right answer
     */
    private void checkAnswersCheckboxes(CheckBox answer1, CheckBox answer2, CheckBox answer3, CheckBox answer4, Button answerTwoButton) {

        if (!answer1.isChecked() && !answer2.isChecked() && !answer3.isChecked() && !answer4.isChecked()) {
            Toast.makeText(this, getString(R.string.selectAnAnswer), Toast.LENGTH_LONG).show();
        } else if (answer1.isChecked() && answer2.isChecked() && !answer3.isChecked() && !answer4.isChecked()) {
            Toast.makeText(this, getString(R.string.rightAnswer), Toast.LENGTH_LONG).show();
            numberOfCorrectAnswers++;
            answerTwoButton.setEnabled(false);
        } else {
            Toast.makeText(this, getString(R.string.wrongAnswer), Toast.LENGTH_SHORT).show();
        }
    }

    //    this methods get called upon pressing Submit answer button located under question 3
    public void checkAnswerThree(View view) {
        EditText questionThree = findViewById(R.id.edit_text_3);
        String answerThree = getString(R.string.food_item_name);
        Button answerButtonThree = findViewById(R.id.check_answer_3);
        checkAnswersEditBoxes(questionThree, answerThree, answerButtonThree);
    }

    /**
     * check answer to question 3 and requires input and responds accordingly until the user
     * gets the right answer
     * */
    private void checkAnswersEditBoxes(EditText userAnswer, String key, Button answerButtonThree) {

        String userAnswerString = userAnswer.getText().toString();

        if (userAnswerString.matches("")) {
            Toast.makeText(this, getString(R.string.pizza_place_name), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.return_answer_3) + " " + userAnswerString + "\n" +
                    getString(R.string.return_answer_3_2), Toast.LENGTH_LONG).show();
            numberOfCorrectAnswers++;
            answerButtonThree.setEnabled(false);
        }
    }

    //  called upon pressing the Wood button, i.e. optionOne button under question 4
    public void choseOptionOne(View view) {
        // Do something in response to button click
        answerFour = 1;
    }

    //    called upon pressing the Animal button, i.e. optionTwo button under question 4
    public void choseOptionTwo(View view) {
        // Do something in response to button click
        answerFour = 2;
    }

    //    called upon pressing the Food button, i.e. optionThree button under question 4
    public void choseOptionThree(View view) {
        // Do something in response to button click
        answerFour = 3;
    }

    //    called upon pressing the Drink button, i.e. optionFour button under question 4
    public void choseOptionFour(View view) {
        // Do something in response to button click
        answerFour = 4;
    }

    //    called upon pressing the Check Answer button, i.e. check_answer_4 button under question 4
    public void checkAnswerFour(View view) {
        int answer = answerFour;
        checkAnswersFourButtons(answer);
    }

    /**
     * check answer to question 4 and requires input and responds accordingly until the user
     * gets the right answer
     * */
    private void checkAnswersFourButtons(int answer) {
        if (answer == 0) {
            Toast.makeText(this, getString(R.string.selectAnAnswer), Toast.LENGTH_LONG).show();
        } else if (answer == 3) {
            Toast.makeText(this, getString(R.string.rightAnswer), Toast.LENGTH_LONG).show();
            numberOfCorrectAnswers++;
            Button answerFourButton = findViewById(R.id.check_answer_4);
            answerFourButton.setEnabled(false);
        } else {
            Toast.makeText(this, getString(R.string.wrongAnswer), Toast.LENGTH_SHORT).show();
        }
    }

    //    called upon pressing the check_answer_5 button under question 5
    public void checkAnswerFive(View view) {
        RadioGroup radioGroupTwo = findViewById(R.id.radio_group_2);
        int selectedId = radioGroupTwo.getCheckedRadioButtonId();
        RadioButton answerRadioFive = findViewById(R.id.radio_button_8);
        Button answerFiveButton = findViewById(R.id.check_answer_5);
        checkAnswersRadioFive(selectedId, answerRadioFive, answerFiveButton);
    }

    /**
     * check answer to question 5 and requires input and responds accordingly until the user
     * gets the right answer
     * */
    private void checkAnswersRadioFive(int selectedId, RadioButton answerRadioFive, Button answerFiveButton) {

        if (selectedId == -1) {
            Toast.makeText(this, getString(R.string.selectAnAnswer), Toast.LENGTH_LONG).show();
        } else if (selectedId == answerRadioFive.getId()) {
            Toast.makeText(this, getString(R.string.rightAnswer), Toast.LENGTH_LONG).show();
            numberOfCorrectAnswers++;
            answerFiveButton.setEnabled(false);
        } else {
            Toast.makeText(this, getString(R.string.wrongAnswer), Toast.LENGTH_SHORT).show();
        }
    }

    //    called upon pressing the check_answer_6 button located under question 6
    public void checkAnswerSix(View view) {
        RadioGroup radioGroupThree = findViewById(R.id.radio_group_3);
        int selectedId = radioGroupThree.getCheckedRadioButtonId();
        RadioButton answerRadioSix = findViewById(R.id.radio_button_11);
        Button answerSixButton = findViewById(R.id.check_answer_6);
        checkAnswersRadioSix(selectedId, answerRadioSix, answerSixButton);
    }

    /**
     * check answer to question 6 and requires input and responds accordingly until the user
     * gets the right answer
     */
    private void checkAnswersRadioSix(int selectedId, RadioButton answerRadioSix, Button answerSixButton) {

        if (selectedId == -1) {
            Toast.makeText(this, getString(R.string.selectAnAnswer), Toast.LENGTH_LONG).show();
        } else if (selectedId == answerRadioSix.getId()) {
            Toast.makeText(this, getString(R.string.rightAnswer), Toast.LENGTH_LONG).show();
            numberOfCorrectAnswers++;
            answerSixButton.setEnabled(false);
        } else {
            Toast.makeText(this, getString(R.string.wrongAnswer), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Create summary of the quiz including the score.
     * Display summary in a toast message
     * the custom toast message code syntax was found at the following site.
     * https://stackoverflow.com/questions/11288475/custom-toast-on-android-a-simple-example
     */
    public void submitQuiz(View view) {
        int percentScore = (numberOfCorrectAnswers * 100 / numberOfQuestions);
        String correctNumberOfAnswers = getString(R.string.totalAnswersTextView1) + " ";
        correctNumberOfAnswers += numberOfCorrectAnswers + " " + getString(R.string.totalAnswersTextView2);
        correctNumberOfAnswers += "\n" + getString(R.string.totalAnswersTextView3) + " ";
        correctNumberOfAnswers += percentScore + " %";

        Toast toast = Toast.makeText(this, correctNumberOfAnswers, Toast.LENGTH_LONG);
        View toastView = toast.getView();
        TextView toastMessage = toastView.findViewById(android.R.id.message);
        toastMessage.setTextSize(16);
        toastMessage.setTextColor(Color.BLACK);
        toastMessage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pizza, 0, 0, 0);
        toastMessage.setGravity(Gravity.CENTER);
        toastMessage.setCompoundDrawablePadding(16);
        toastView.setBackgroundColor(Color.GRAY);
        toast.show();
    }

    /**
     * Create summary of the quiz.
     * Send the summary to the app in order to share.
     */
    public void shareScore(View view) {
        int percentScore = (numberOfCorrectAnswers * 100 / numberOfQuestions);
        String correctNumberOfAnswers = getString(R.string.totalAnswersTextView1) + " ";
        correctNumberOfAnswers += numberOfCorrectAnswers + " " + getString(R.string.totalAnswersTextView2);
        correctNumberOfAnswers += "\n" + getString(R.string.totalAnswersTextView3) + " ";
        correctNumberOfAnswers += percentScore + " %";
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My score on The Pizza Quiz App");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, correctNumberOfAnswers);
        startActivity(Intent.createChooser(sharingIntent, "Share on: "));
    }
}




