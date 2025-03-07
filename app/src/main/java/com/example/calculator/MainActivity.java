package com.example.calculator;

import static java.lang.Math.round;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber1;
    private EditText inputNumber2;
    private TextView result;
    private TextView appTitle;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        inputNumber1 = findViewById(R.id.inputNumber1);
        inputNumber2 = findViewById(R.id.inputNumber2);
        result = findViewById(R.id.result);
        appTitle = findViewById(R.id.appTitle);

        //initialize the size of the texts
        result.setTextSize(30);
        appTitle.setTextSize(40);
    }
    //create the 2 numbers to be added
    float number1;
    float number2;
    String res;


    //method to sum two numbers
    public void sum(View view) {
        //get the numbers from the input fields and convert them to float
        number1 = Float.parseFloat(inputNumber1.getText().toString());
        number2 = Float.parseFloat(inputNumber2.getText().toString());
        //round the result to 2 decimal places
        res = String.format("%.2f", number1 + number2);
        //set the result
        result.setText(String.valueOf(res));

    }

    //method to subtract two numbers
    public void substract(View view) {
        //get the numbers from the input fields and convert them to float
        number1 = Float.parseFloat(inputNumber1.getText().toString());
        number2 = Float.parseFloat(inputNumber2.getText().toString());
        //round the result to 2 decimal places
        res = String.format("%.2f", number1 - number2);
        //set the result
        result.setText(String.valueOf(res));
    }

    //method to multiply two numbers
    public void multiply(View view) {
        //get the numbers from the input fields and convert them to float
        number1 = Float.parseFloat(inputNumber1.getText().toString());
        number2 = Float.parseFloat(inputNumber2.getText().toString());
        //round the result to 2 decimal places
        res = String.format("%.2f", number1 * number2);
        //set the result
        result.setText(String.valueOf(res));
    }

    //method to divide
    public void divide(View view) {
        //get the numbers from the input fields and convert them to float
        number1 = Float.parseFloat(inputNumber1.getText().toString());
        number2 = Float.parseFloat(inputNumber2.getText().toString());
        //check for zero division
        if (number2 == 0){
            //display a toast message
            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            result.setText("");
        }else{
            //round the result to 2 decimal places
            res = String.format("%.2f", number1 / number2);
            //set the result
            result.setText(String.valueOf(res));
        }
    }

}