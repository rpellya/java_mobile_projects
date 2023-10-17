package com.example.fourthapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    private TextView textView;
    private EditText editText1, editText2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        textView=(TextView)findViewById(R.id.textViewAnswer);
        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
    }

    public void plus(View view){
        int value_from_editText1 = Integer.valueOf(editText1.getText().toString());
        int value_from_editText2 = Integer.valueOf(editText2.getText().toString());

        int sum = value_from_editText1 + value_from_editText2;

        String resultView = value_from_editText1 + " + " + value_from_editText2 + " = " + sum;

        textView.setText(String.valueOf(resultView));
    }

    public void Decrease(View view){
        int value_from_editText1 = Integer.valueOf(editText1.getText().toString());
        int value_from_editText2 = Integer.valueOf(editText2.getText().toString());

        int decrease = value_from_editText1 - value_from_editText2;

        String resultView = value_from_editText1 + " - " + value_from_editText2 + " = " + decrease;

        textView.setText(String.valueOf(resultView));
    }
    public void Multiply(View view){
        int value_from_editText1 = Integer.valueOf(editText1.getText().toString());
        int value_from_editText2 = Integer.valueOf(editText2.getText().toString());

        int multiply = value_from_editText1 * value_from_editText2;

        String resultView = value_from_editText1 + " * " + value_from_editText2 + " = " + multiply;

        textView.setText(String.valueOf(resultView));
    }
    public void Divide(View view){
        int value_from_editText1 = Integer.valueOf(editText1.getText().toString());
        int value_from_editText2 = Integer.valueOf(editText2.getText().toString());

        int divide = value_from_editText1 / value_from_editText2;

        String resultView = value_from_editText1 + " / " + value_from_editText2 + " = " + divide;

        textView.setText(String.valueOf(resultView));
    }

}
