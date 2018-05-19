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

    public void checkAnswerOne(View view) {
        RadioGroup radioGroupOne = findViewById(R.id.radio_group_1);
        int selectedId = radioGroupOne.getCheckedRadioButtonId();
        RadioButton answerRadioOne = findViewById(R.id.radio_button_1);
        Button answerOneButton = findViewById(R.id.check_answer_1);
        checkAnswersRadio(selectedId, answerRadioOne, answerOneButton);
    }

    /**
     * Check the answer to question one and return the result of question 1 upon pressing the      *
     * Check answer button that is located right under Question 1.
     */
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

    public void checkAnswerTwo(View view) {
        //figure out if the user wants whipped cream topping
        CheckBox questionTwoCheckBoxOne = findViewById(R.id.checkBoxOne);
        //figure out if the user wants whipped cream topping
        CheckBox questionTwoCheckBoxTwo = findViewById(R.id.checkBoxTwo);
        //figure out if the user wants whipped cream topping
        CheckBox questionTwoCheckBoxThree = findViewById(R.id.checkBoxThree);
        //figure out if the user wants whipped cream topping
        CheckBox questionTwoCheckBoxFour = findViewById(R.id.checkBoxFour);
        Button answerTwoButton = findViewById(R.id.check_answer_2);
        checkAnswersCheckboxes(questionTwoCheckBoxOne, questionTwoCheckBoxTwo, questionTwoCheckBoxThree, questionTwoCheckBoxFour, answerTwoButton);
    }

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

    public void checkAnswerThree(View view) {
        EditText questionThree = findViewById(R.id.edit_text_3);
        String answerThree = getString(R.string.food_item_name);
        Button answerButtonThree = findViewById(R.id.check_answer_3);
        checkAnswersEditBoxes(questionThree, answerThree, answerButtonThree);
    }

    /**
     * Check for answers for a question, then checks if correct and output correctness message and if correct, adds to score
     *
     * @param userAnswer which is the input and key, which is the answer stored in Strings.xml
     *                   myButton is the button from the question to disable when the answer is correct
     * @returns none; Toast outputs on screen
     */
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


    public void choseOptionOne(View view) {
        // Do something in response to button click
        answerFour = 1;
    }

    public void choseOptionTwo(View view) {
        // Do something in response to button click
        answerFour = 2;
    }

    public void choseOptionThree(View view) {
        // Do something in response to button click
        answerFour = 3;
    }

    public void choseOptionFour(View view) {
        // Do something in response to button click
        answerFour = 4;
    }

    public void checkAnswerFour(View view) {
        int answer = answerFour;
        checkAnswersFourButtons(answer);
    }

    /**
     * Check the answer to question one and return the result of question 1 upon pressing the      *
     * Check answer button that is located right under Question 1.
     */
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

    public void checkAnswerFive(View view) {
        RadioGroup radioGroupTwo = (RadioGroup) findViewById(R.id.radio_group_2);
        int selectedId = radioGroupTwo.getCheckedRadioButtonId();
        RadioButton answerRadioFive = (RadioButton) findViewById(R.id.radio_button_8);
        Button answerFiveButton = (Button) findViewById(R.id.check_answer_5);
        checkAnswersRadioFive(selectedId, answerRadioFive, answerFiveButton);
    }

    /**
     * Check the answer to question one and return the result of question 1 upon pressing the      *
     * Check answer button that is located right under Question 1.
     */
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

    public void checkAnswerSix(View view) {
        RadioGroup radioGroupThree = (RadioGroup) findViewById(R.id.radio_group_3);
        int selectedId = radioGroupThree.getCheckedRadioButtonId();
        RadioButton answerRadioSix = (RadioButton) findViewById(R.id.radio_button_11);
        Button answerSixButton = (Button) findViewById(R.id.check_answer_6);
        checkAnswersRadioSix(selectedId, answerRadioSix, answerSixButton);
    }

    /**
     * Check the answer to question one and return the result of question 1 upon pressing the      *
     * Check answer button that is located right under Question 1.
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
     */
    public void submitQuiz(View view) {
        int percentScore = (numberOfCorrectAnswers * 100 / numberOfQuestions);
        String correctNumberOfAnswers = getString(R.string.totalAnswersTextView1) + " ";
        correctNumberOfAnswers += numberOfCorrectAnswers + " " + getString(R.string.totalAnswersTextView2);
        correctNumberOfAnswers += "\n" + getString(R.string.totalAnswersTextView3) + " ";
        correctNumberOfAnswers += percentScore + " %";

        Toast toast = Toast.makeText(this, correctNumberOfAnswers, Toast.LENGTH_LONG);
        View toastView = toast.getView(); // This'll return the default View of the Toast.

        /* And now you can get the TextView of the default View of the Toast. */
        TextView toastMessage = (TextView) toastView.findViewById(android.R.id.message);
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




