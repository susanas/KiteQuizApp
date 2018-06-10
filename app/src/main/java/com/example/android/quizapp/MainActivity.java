package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int counterQ1 = 0;
    int counterQ2 = 1;
    int counterQ3 = 0;
    int counterQ4 = 0;
    int counterQ5 = 0;
    int counterQ6 = 0;
    int gotItRight = 0;
    int totalGrade;
    String kiteFlyerAnswer = "yes";
    String kiteFlyerAnswerNo = "no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //      Question 2
    public void onCheckBoxClicked(View view) {

        CheckBox CheckboxQtrA = findViewById(R.id.correct_qTwoA);
        CheckBox CheckboxQtrB = findViewById(R.id.correct_qTwoB);
        CheckBox CheckboxQtrC = findViewById(R.id.correct_qTwoC);
        CheckBox CheckboxQtrE = findViewById(R.id.correct_qTwoE);
        CheckBox CheckboxQtwD = findViewById(R.id.wrong_qTwoD);

        // Which check box was checked?
        // Question 2: If A, B, C, E are all selected, add 1 point to total grade.  Else set point = 0.
        // Are all the correct check boxes checked?
        if (CheckboxQtrA.isChecked() && CheckboxQtrB.isChecked() && CheckboxQtrC.isChecked() && CheckboxQtrE.isChecked() && !CheckboxQtwD.isChecked()) {
            gotItRight++;
        } else {
            gotItRight = 0;
        }

        if (gotItRight < 4) {
            counterQ2 = 0;
        }

    }

//      Question 1

    public void onRadioButtonClicked(View view) {
        // Is the button selected?
        boolean checked = ((RadioButton) view).isChecked();
        // Add 1 point for each correct answer selected.
        RadioButton correctAnswerOne = findViewById(R.id.correct_radio_button_b);
        RadioButton correctAnswerThree = findViewById(R.id.correct_qThrA);
        RadioButton correctAnswerFour = findViewById(R.id.correct_yes_radio_button4);
        RadioButton correctAnswerFive = findViewById(R.id.yes_radio_button5);

        // Which radio button was clicked?
        switch (view.getId()) {
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

    //    After pressing Grade Quiz button, this method calls createGradeSummary method to display toast message;
    public void gradeQuiz(View view) {
        EditText nameField = findViewById(R.id.name_field);
        String nameInput = nameField.getText().toString();
        EditText kiteFlyer = findViewById(R.id.flown_kite);
        String kFlyerInput = kiteFlyer.getText().toString().toLowerCase();


//      Question 6

        if (kFlyerInput.compareTo(kiteFlyerAnswer) == 0) counterQ6 = 1;
        if (kFlyerInput.compareTo(kiteFlyerAnswerNo) == 0) counterQ6 = 1;

        totalGrade = calculateGrade(counterQ1, counterQ2, counterQ3, counterQ4, counterQ5, counterQ6);
        String yourGradeMessage = createGradeSummary(nameInput, totalGrade, counterQ1, counterQ2, counterQ3, counterQ4, counterQ5, counterQ6);
        Toast.makeText(this, yourGradeMessage, Toast.LENGTH_LONG).show();
    }

    private int calculateGrade(int counterQ1, int counterQ2, int counterQ3, int counterQ4, int counterQ5, int counterQ6) {
        int calcGrade = counterQ1 + counterQ2 + counterQ3 + counterQ4 + counterQ5 + counterQ6;
        return calcGrade;
    }

    //    Returns score total and breakdown in a string.
    private String createGradeSummary(String nameField, int totalGrade, int counterQ1, int counterQ2, int counterQ3, int counterQ4, int counterQ5, int counterQ6) {
        return "Hi " + nameField + "\nYour score: " + totalGrade + "\nScore breakdown:" + "\nQuestion 1: " + counterQ1 +
                "\nQuestion 2: " + counterQ2 + "\nQuestion 3: " + counterQ3 + "\nQuestion 4: " + counterQ4 + "\nQuestion 5: " + counterQ5 + "\nQuestion 6: " + counterQ6 + "\n\nThank you for taking this quiz!";
    }

    public void submitGrade(View view) {
        EditText nameField = findViewById(R.id.name_field);
        String nameInput = nameField.getText().toString();
        /*EditText kiteFlyer = findViewById(R.id.flown_kite);
        String kFlyerInput = kiteFlyer.getText().toString();*/
        totalGrade = calculateGrade(counterQ1, counterQ2, counterQ3, counterQ4, counterQ5, counterQ6);
        String yourGradeMessage = createGradeSummary(nameInput, totalGrade, counterQ1, counterQ2, counterQ3, counterQ4, counterQ5, counterQ6);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: "));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your Kite Quiz Score");
        intent.putExtra(Intent.EXTRA_TEXT, yourGradeMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
