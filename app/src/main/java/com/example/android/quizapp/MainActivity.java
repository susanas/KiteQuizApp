package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int counterQ1 = 0;
    int counterQ2 = 0;
    int counterQ3 = 0;
    int counterQ4 = 0;
    int counterQ5 = 0;
    int totalGrade;

    public void onCheckBoxClicked(View view) {
        // Is the check box now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Add 1 point for each correct answer selected.
        CheckBox correctAnswerTwoA = (CheckBox) findViewById(R.id.correct_qTwoA);
        CheckBox correctAnswerTwoB = (CheckBox) findViewById(R.id.correct_qTwoB);
        CheckBox correctAnswerTwoC = (CheckBox) findViewById(R.id.correct_qTwoC);
        CheckBox correctAnswerTwoE = (CheckBox) findViewById(R.id.qTwoE);

        // Which check box was checked?
        switch (view.getId()) {
//      Question 2: A, B, C, F are correct answers, add 1 point to total grade.
            case R.id.correct_qTwoA:
                if (checked) {
                    correctAnswerTwoA.setChecked(true);
                    Toast.makeText(this, "You got it!", Toast.LENGTH_LONG).show();
                    counterQ2 = 1;
                }
                break;

            case R.id.correct_qTwoB:
                if (checked) {
                    correctAnswerTwoB.setChecked(true);
                    Toast.makeText(this, "You got it!", Toast.LENGTH_LONG).show();
                    counterQ2 = 1;
                }
                break;

            case R.id.correct_qTwoC:
                if (checked) {
                    correctAnswerTwoC.setChecked(true);
                    Toast.makeText(this, "You got it!", Toast.LENGTH_LONG).show();
                    counterQ2 = 1;
                }
                break;

            case R.id.qTwoE:
                if (checked) {
                    correctAnswerTwoE.setChecked(true);
                    Toast.makeText(this, "You got it!", Toast.LENGTH_LONG).show();
                    counterQ2 = 1;
                }
                break;

            case R.id.qTwoD:
                if (checked) {
                    ((CheckBox) view).setChecked(true);
                    Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
                    if (counterQ2 == 1) {
                        // no point
                        counterQ2 = 0;
                    }
                }
                break;
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button selected?
        boolean checked = ((RadioButton) view).isChecked();
        // Add 1 point for each correct answer selected.
        RadioButton correctAnswerOne = (RadioButton) findViewById(R.id.correct_radio_button_b);
        RadioButton correctAnswerThree = (RadioButton) findViewById(R.id.correct_qThrA);
        RadioButton correctAnswerFour = (RadioButton) findViewById(R.id.correct_yes_radio_button4);
        RadioButton correctAnswerFive = (RadioButton) findViewById(R.id.yes_radio_button5);

        // Which radio button was clicked?
        switch (view.getId()) {
//      Question 1
            case R.id.radio_button_a:
                if (checked) {
                    ((RadioButton) view).setChecked(true);
                    Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
                    if (counterQ1 == 1) {
                        // no point
                        counterQ1 = 0;
                    }
                }
                break;

            case R.id.radio_button_c:
                if (checked) {
                    ((RadioButton) view).setChecked(true);
                    Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
                    if (counterQ1 == 1) {
                        // no point
                        counterQ1 = 0;
                    }
                }
                break;

            case R.id.correct_radio_button_b:
                if (checked) {
                    correctAnswerOne.setChecked(true);
                    Toast.makeText(this, "You got it!", Toast.LENGTH_SHORT).show();
                    counterQ1 = 1;
                }
                break;

//      Question 3
            case R.id.correct_qThrA:
                if (checked) {
                    correctAnswerThree.setChecked(true);
                    Toast.makeText(this, "You got it!", Toast.LENGTH_SHORT).show();
                    counterQ3 = 1;
                }
                break;

            case R.id.correct_qThrB:
                if (checked) {
                    ((RadioButton) view).setChecked(true);
                    Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
                    if (counterQ3 == 1) {
                        // no point
                        counterQ3 = 0;
                    }
                }
                break;

            case R.id.correct_qThrC:
                if (checked) {
                    ((RadioButton) view).setChecked(true);
                    Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
                    if (counterQ3 == 1) {
                        // no point
                        counterQ3 = 0;
                    }
                }
                break;


//      Question 4
            case R.id.no_radio_button4:
                if (checked) {
                    ((RadioButton) view).setChecked(true);
                    Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
                    if (counterQ4 == 1) {
                        // no point
                        counterQ4 = 0;
                    }
                }
                break;

            case R.id.correct_yes_radio_button4:
                if (checked) {
                    correctAnswerFour.setChecked(true);
                    Toast.makeText(this, "You got it!", Toast.LENGTH_SHORT).show();
                    counterQ4 = 1;
                }
                break;

//      Question 5
            case R.id.no_radio_button5:
                if (checked) {
                    ((RadioButton) view).setChecked(true);
                    Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
                    if (counterQ5 == 1) {
                        // no point
                        counterQ5 = 0;
                    }
                }
                break;

            case R.id.yes_radio_button5:
                if (checked) {
                    correctAnswerFive.setChecked(true);
                    Toast.makeText(this, "You got it!", Toast.LENGTH_SHORT).show();
                    counterQ5 = 1;
                }
                break;
        }
        Log.v("MainActivity", "Radio button points so far: " + counterQ1 + counterQ2 + counterQ3 + counterQ4 + counterQ5);
    }

    //    After pressing Grade Quiz button, this method calls createGradeSummary method to get string;
//    then calls displayMessage to display string.
    public void gradeQuiz(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String nameInput = nameField.getText().toString();
        totalGrade = calculateGrade(counterQ1, counterQ2, counterQ3, counterQ4, counterQ5);
        String yourGradeMessage = createGradeSummary(nameInput, totalGrade, counterQ1, counterQ2, counterQ3, counterQ4, counterQ5);
        displayMessage(yourGradeMessage);
    }

    private int calculateGrade(int counterQ1, int counterQ2, int counterQ3, int counterQ4, int counterQ5) {
        int calcGrade = counterQ1 + counterQ2 + counterQ3 + counterQ4 + counterQ5;
        return calcGrade;
    }

    //    Returns score total and breakdown in a string.
    private String createGradeSummary(String nameField, int totalGrade, int counterQ1, int counterQ2, int counterQ3, int counterQ4, int counterQ5) {
        return nameField + ", this is your total score: " + totalGrade + "\nTotal score breakdown:" + "\nQuestion 1: " + counterQ1 +
                "\nQuestion 2: " + counterQ2 + "\nQuestion 3: " + counterQ3 + "\nQuestion 4: " + counterQ4 + "\nQuestion 5: " + counterQ5;
    }

    private void displayMessage(String message) {
        TextView yourGradeTextView = (TextView) findViewById(R.id.yourGrade);
        yourGradeTextView.setText(message);
    }

    public void submitGrade(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String nameInput = nameField.getText().toString();
        totalGrade = calculateGrade(counterQ1, counterQ2, counterQ3, counterQ4, counterQ5);
        String yourGradeMessage = createGradeSummary(nameInput, totalGrade, counterQ1, counterQ2, counterQ3, counterQ4, counterQ5);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: "));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your Kite Quiz Score");
        intent.putExtra(Intent.EXTRA_TEXT, yourGradeMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
