package com.example.android.thefinalpizzaquiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String COUNTER_A = "counterA";
    private static final String COUNTER_B = "counterB";
    private static final String COUNTER_C = "counterC";
    private static final String COUNTER_D = "counterD";
    private static final String COUNTER_E = "counterE";
    private static final String COUNTER_F = "counterF";
    private static final String COUNTER_G = "counterG";

    //GLOBAL VARIABLE
    int numberOfCorrectAnswers = 0;
    int answerFour = 0;
    int numberOfQuestions = 6;
    int answerOneState = 0;
    int answerTwoState = 0;
    int answerThreeState = 0;
    int answerFourState = 0;
    int answerFiveState = 0;
    int answerSixState = 0;
    ScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            answerOneState = savedInstanceState.getInt(COUNTER_A);
            answerTwoState = savedInstanceState.getInt(COUNTER_B);
            answerThreeState = savedInstanceState.getInt(COUNTER_C);
            answerFourState = savedInstanceState.getInt(COUNTER_D);
            answerFiveState = savedInstanceState.getInt(COUNTER_E);
            answerSixState = savedInstanceState.getInt(COUNTER_F);
            numberOfCorrectAnswers = savedInstanceState.getInt(COUNTER_G);
        }
        mScrollView = findViewById(R.id.myScrollView);
        Button answerOneButton = findViewById(R.id.check_answer_1);
        Button answerTwoButton = findViewById(R.id.check_answer_2);
        Button answerThreeButton = findViewById(R.id.check_answer_3);
        Button answerFourButton = findViewById(R.id.check_answer_4);
        Button answerFiveButton = findViewById(R.id.check_answer_5);
        Button answerSixButton = findViewById(R.id.check_answer_6);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        if (answerOneState == 1) {
            answerOneButton.setEnabled(false);
        }
        if (answerTwoState == 1) {
            answerTwoButton.setEnabled(false);
        }
        if (answerThreeState == 1) {
            answerThreeButton.setEnabled(false);
        }
        if (answerFourState == 1) {
            answerFourButton.setEnabled(false);
        }
        if (answerFiveState == 1) {
            answerFiveButton.setEnabled(false);
        }
        if (answerSixState == 1) {
            answerSixButton.setEnabled(false);
        }
    }

    /***
     * I found the code for saving the Scroll position upon screen rotation on the following site
     * https://stackoverflow.com/questions/29208086/save-the-position-of-scrollview-when-the-orientation-changes/29208325#29208325
     *
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the values you need from your textview into "outState"-object
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_A, answerOneState);
        outState.putInt(COUNTER_B, answerTwoState);
        outState.putInt(COUNTER_C, answerThreeState);
        outState.putInt(COUNTER_D, answerFourState);
        outState.putInt(COUNTER_E, answerFiveState);
        outState.putInt(COUNTER_F, answerSixState);
        outState.putInt(COUNTER_G, numberOfCorrectAnswers);
        outState.putIntArray("ARTICLE_SCROLL_POSITION",
                new int[]{mScrollView.getScrollX(), mScrollView.getScrollY()});
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        final int[] position = savedInstanceState.getIntArray("ARTICLE_SCROLL_POSITION");
        if (position != null)
            mScrollView.post(new Runnable() {
                public void run() {
                    mScrollView.scrollTo(position[0], position[1]);
                }
            });
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
            answerOneState = 1;
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
            answerTwoState = 1;
        } else {
            Toast.makeText(this, getString(R.string.wrongAnswer), Toast.LENGTH_SHORT).show();
        }
    }

    //    this methods get called upon pressing Submit answer button located under question 3
    public void checkAnswerThree(View view) {
        EditText questionThree = findViewById(R.id.edit_text_3);
        Button answerButtonThree = findViewById(R.id.check_answer_3);
        checkAnswersEditBoxes(questionThree, answerButtonThree);
    }

    /**
     * check answer to question 3 and requires input and responds accordingly until the user
     * gets the right answer
     * */
    private void checkAnswersEditBoxes(EditText userAnswer, Button answerButtonThree) {

        String userAnswerString = userAnswer.getText().toString();

        if (userAnswerString.matches("")) {
            Toast.makeText(this, getString(R.string.pizza_place_name), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.return_answer_3) + " " + userAnswerString + "\n" +
                    getString(R.string.return_answer_3_2), Toast.LENGTH_LONG).show();
            numberOfCorrectAnswers++;
            answerButtonThree.setEnabled(false);
            answerThreeState = 1;
            EditText questionThree = findViewById(R.id.edit_text_3);
            questionThree.setFocusable(false);
            questionThree.setFocusableInTouchMode(false);
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
            answerFourState = 1;
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
            answerFiveState = 1;
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
            answerSixState = 1;
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
        toastView.setBackgroundColor(Color.WHITE);
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




