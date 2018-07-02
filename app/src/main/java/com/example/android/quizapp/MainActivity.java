package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswer(View view) {
        /*
        *All marks at the start of the Quiz are Zero
         */
        int marks = 0;
        /*
        *if else Statements to calculate the final marks of the Quiz.
         */

        if (checkQuestion1Answer()) {
            marks += 25;
            displayStatus(getString(R.string.correct), findViewById(R.id.question1Status));

        } else {
            displayStatus(getString(R.string.wrong), findViewById(R.id.question1Status));
            }

        if (checkQuestion2Answer()) {
            marks += 25;
            displayStatus(getString(R.string.correct), findViewById(R.id.question2Status));

        } else {
            displayStatus(getString(R.string.wrong), findViewById(R.id.question2Status));
            }

            if (checkQuestion3Answer()) {
            marks += 25;
            displayStatus(getString(R.string.correct), findViewById(R.id.question3Status));

        } else {
            displayStatus(getString(R.string.wrong), findViewById(R.id.question3Status));

        }

        if (checkQuestion4Answer()) {
            marks += 25;
            displayStatus(getString(R.string.correct), findViewById(R.id.question4Status));

        } else {
            displayStatus(getString(R.string.wrong), findViewById(R.id.question4Status));
            }
            /*
            *Pass mark of the Quiz.Below 75% is Fail Result
            */

            if (marks >= 75) {
            String message = getString(R.string.Pass) + " " + marks;
            message += getString(R.string.percentPass);
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        } else {
            String message = getString(R.string.Fail) + " " + marks;
            message += getString(R.string.percentFail);
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

        }
    }

    private void displayStatus(String text, View statusID) {
        TextView statusTextView = (TextView) statusID;
        statusTextView.setText(text);
    }

    /*
     * This code checks the multiple answers for Question 1 selected and returns a correct or wrong Answer
     *
     */
    private boolean checkQuestion1Answer() {
        CheckBox question1A = findViewById(R.id.question1A);
        CheckBox question1B = findViewById(R.id.question1B);
        CheckBox question1C = findViewById(R.id.question1C);
        CheckBox question1D = findViewById(R.id.question1D);
        return (question1A.isChecked() && question1C.isChecked()) && !(question1B.isChecked() || question1D.isChecked());
        }


    /**
     * This code checks the multiple answers for Question 2 selected and returns a correct or wrong Answer
     */

    private boolean checkQuestion2Answer() {
        CheckBox question2A = findViewById(R.id.question2A);
        CheckBox question2B = findViewById(R.id.question2B);
        CheckBox question2C = findViewById(R.id.question2C);
        CheckBox question2D = findViewById(R.id.question2D);
        return (question2A.isChecked() && question2D.isChecked()) && !(question2B.isChecked() || question2C.isChecked());

    }


    /**
     * This code isfor Question 3 and returns a value True or false.
     */
    private boolean checkQuestion3Answer() {
        RadioButton question3A = findViewById(R.id.question3A);
        return question3A.isChecked();
    }

    /**
     * This code is for Question 4 and returns a value entered manually and checks for the correct Answer.
     */

    private boolean checkQuestion4Answer() {
        EditText question4Option = findViewById(R.id.question4);
        return getString(R.string.question4Answer).equalsIgnoreCase(question4Option.getText().toString());
    }
}