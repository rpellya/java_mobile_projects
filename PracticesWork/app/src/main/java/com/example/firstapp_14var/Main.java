package com.example.firstapp_14var;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Main extends AppCompatActivity
        implements AdapterView.OnItemClickListener{
    private ArrayAdapter<String> arad; //ссылка на стандартный строковый адаптер – объект класса ArrayAdapter<String>
    private ListView lw;
    private EditText editText1, editText2;
    private View curView = null;
    int curP;
    Button del, btnEdit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        arad=new ArrayAdapter<String>(this,R.layout.le); //создаем стандартный строковый адаптер, второй параметр конструктора – файл с разметкой для элемента списка

        lw=(ListView)findViewById(R.id.listView); //получаем ссылку на ListView
        lw.setAdapter(arad); //устанавливаем для списка адаптер
        lw.setOnItemClickListener(this);

        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(curView != null){
            curView.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        }
        String s = arad.getItem(position);

        curP = position;

        view.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200));
        curView = view;
    }

    public void toClear(View view){
        arad.clear();
    }

    public void buttonSquare(View view) {
        String text1 = editText1.getText().toString();
        String text2 = editText2.getText().toString();
        arad.add("[" + text1 + "][" + text2 + "]");
    };

    public void buttonCurly(View view) {
        String text1 = editText1.getText().toString();
        String text2 = editText2.getText().toString();
        arad.add("{" + text1 + "}{" + text2 + "}");
    };

    public void buttonAngle(View view) {
        String text1 = editText1.getText().toString();
        String text2 = editText2.getText().toString();
        arad.add("<" + text1 + "><" + text2 + ">");
    };

    public void buttonRound(View view) {
        String text1 = editText1.getText().toString();
        String text2 = editText2.getText().toString();
        arad.add("(" + text1 + ")(" + text2 + ")");
    };

    public void themeOne(View view){
        editText1.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_green));
        editText1.setTextColor(ContextCompat.getColor(this, R.color.white));
        editText2.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_green));
        editText2.setTextColor(ContextCompat.getColor(this, R.color.white));

    }
    public void themeTwo(View view){
        editText1.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_black));
        editText1.setTextColor(ContextCompat.getColor(this, R.color.blue_green));
        editText2.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_black));
        editText2.setTextColor(ContextCompat.getColor(this, R.color.blue_green));

    }
}
