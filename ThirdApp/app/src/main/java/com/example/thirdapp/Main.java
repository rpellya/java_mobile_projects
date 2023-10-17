package com.example.thirdapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Main extends AppCompatActivity {
    private LinearLayout linearLayout;
    private TextView textView1, textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        linearLayout=(LinearLayout)findViewById(R.id.body); //создаем объект LinearLayout, соответствующий корневому элементу разметки
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
    }

    public void toBlueTextView(View view){
        textView1.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
        textView2.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
    }

    public void toWhiteTextView(View view){
        textView1.setTextColor(ContextCompat.getColor(this, R.color.black));
        textView2.setTextColor(ContextCompat.getColor(this, R.color.black));
        textView1.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        textView2.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
    }

    public void toBlackTextView(View view){
        textView1.setTextColor(ContextCompat.getColor(this, R.color.white));
        textView2.setTextColor(ContextCompat.getColor(this, R.color.white));
        textView1.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        textView2.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
    }

    public void toBlueBody(View view){
        linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.blue)); //красим активность (ее корневой элемент) в цвет из ресурса цветов
    }

    public void toWhiteBody(View view){
        linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white)); //красим активность (ее корневой элемент) в цвет из ресурса цветов
    }

    public void toBlackBody(View view){
        linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.black)); //красим активность (ее корневой элемент) в цвет из ресурса цветов
    }
}
