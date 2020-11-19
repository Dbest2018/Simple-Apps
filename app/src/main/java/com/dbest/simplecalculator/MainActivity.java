package com.dbest.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView shownText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getNumber(View view){
        shownText = findViewById(R.id.text_shown);
        switch (view.getId()){
            case R.id.number_zero:
                shownText.append("0");
                break;
            case R.id.number_nine:
                shownText.append("9");
                break;
            case R.id.number_eight:
                shownText.append("8");
                break;
            case R.id.number_seven:
                shownText.append("7");
                break;
            case R.id.number_six:
                shownText.append("6");
                break;
            case R.id.number_five:
                shownText.append("5");
                break;
            case R.id.number_four:
                shownText.append("4");
                break;
            case R.id.number_three:
                shownText.append("3");
                break;
            case R.id.number_two:
                shownText.append("2");
                break;
            case R.id.number_one:
                shownText.append("1");
                break;
            default:
                shownText.setText("");
        }
    }

    public void getOperator(View view){
        shownText = findViewById(R.id.text_shown);
        switch (view.getId()){
            case R.id.add_button:
                if (!shownText.getText().toString().contains("+"))
                shownText.append(" + ");
                break;
            case R.id.subtract_button:
                if (!shownText.getText().toString().contains("-"))
                shownText.append(" - ");
                break;
            case R.id.division_button:
                if (!shownText.getText().toString().contains("/"))
                shownText.append(" / ");
                break;
            case R.id.multiply_button:
                if (!shownText.getText().toString().contains("x"))
                shownText.append(" x ");
                break;
            case R.id.decimal_point:
                if (!shownText.getText().toString().contains("."))
                shownText.append(".");
                break;
            case R.id.clear_button:
                shownText.setText("");
                break;
            case R.id.backspace:
                removePreviousElement();
                break;
            case R.id.equal_sign:
                evaluate();
                break;
        }
    }

    public void evaluate(){
        String textExpression = shownText.getText().toString();
        String[] expArray = textExpression.split(" ");
        float firstOperand = Float.parseFloat(expArray[0]);
        float secondOperand = Float.parseFloat(expArray[2]);
        float result;
        if (expArray[1].equals("+")){
            result = firstOperand +  secondOperand;
            shownText.setText(Float.toString(result));
        }
        else if (expArray[1].equals("-")){
            result = firstOperand -  secondOperand;
            shownText.setText(Float.toString(result));
        }
        else if (expArray[1].equals("x")){
            result = firstOperand *  secondOperand;
            shownText.setText(Float.toString(result));
        }
        else if (expArray[1].equals("/") && secondOperand != 0){
            result = firstOperand /  secondOperand;
            shownText.setText(Float.toString(result));
        }
        else{
            Toast.makeText(this, "error dividing by zero", Toast.LENGTH_SHORT).show();
        }
    }
    /*get text from the text view and remove the last element and store in a new string */
    public void removePreviousElement(){
        String oldText = shownText.getText().toString();
        if(oldText.isEmpty()){
            Toast.makeText(this, "no value entered", Toast.LENGTH_SHORT).show();
        }
        else {
            String currentText = oldText.substring(0, oldText.length() - 1);
            shownText.setText(currentText);
        }

    }
}
