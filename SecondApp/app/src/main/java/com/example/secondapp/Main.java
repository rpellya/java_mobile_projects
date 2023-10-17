package com.example.secondapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    // на уровне класса определяем ссылки на TextView и Button, пока эти ссылки пустые
    // здесь мы не можем вызвать метод findViewById, который ищет и возвращает ссылку на объект

    TextView textView1, textView2;
    Button buttonAdd, buttonCopy;
    String star = "*";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_act);
            textView1=(TextView)findViewById(R.id.textView1);
            textView2=(TextView)findViewById(R.id.textView2);

            buttonAdd=(Button)findViewById(R.id.btn1);
            buttonCopy=(Button)findViewById(R.id.btn2);

            //находим в дереве объектов объект textView1,
            //возвращаем на него ссылку, преобразуем ссылку на View к ссылке на TextView
            //и присваиваем эту ссылку textView1.
            //Предполагается, что в файле разметки у одного из элементов TextView
            //есть параметр id со значением textView1.

            // Если написать здесь оператор TextView textView1=(TextView)findViewById(R.id.tv1);
            //то создастся локальный объект textView1, который пропадет сразу после того,
            //как отработает метод onCreate, а ссылка-поле textView1 на уровне класса
            //останется пустой, соответственно, мы не сможем использовать, например,
            //оператор textView1.setText(...) в каком-либо другом методе, кроме onCreate
    }

    public void onAdd(View view){
        String textFromTextView1 = textView1.getText().toString(); // берем текст из textView1 и преобразуем его в строку\

        String resultView = textFromTextView1 += star;

        textView1.setText(resultView); // копируем строку на первую кнопку
    }

    public void onCopy(View view){
        String textFromTextView1 = textView1.getText().toString();
        textView2.setText(textFromTextView1);
    }
}
