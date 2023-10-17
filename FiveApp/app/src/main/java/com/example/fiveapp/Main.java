package com.example.fiveapp;

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
    private ArrayAdapter<String>arad; //ссылка на стандартный строковый адаптер – объект класса ArrayAdapter<String>
    private ListView lw;
    private EditText editText;
    private View curView = null;
    int curP;
    Button del, btnEdit;


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(curView != null){
            curView.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        }
        String s=arad.getItem(position); //метод getItem адаптера, связанного со списком, по элементу которого щелкнули, возвращает содержимое элемента списка, в данном случае – строку, по ее номеру поместим строку в EditText
        curP = position;
        editText.setText(s);
        btnEdit.setEnabled(true);
        del.setEnabled(true);
        view.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200));
        curView = view;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        arad=new ArrayAdapter<String>(this,R.layout.le); //создаем стандартный строковый адаптер, второй параметр конструктора – файл с разметкой для элемента списка

        editText=(EditText)findViewById(R.id.editText);

        lw=(ListView)findViewById(R.id.listView); //получаем ссылку на ListView
        lw.setAdapter(arad); //устанавливаем для списка адаптер

        arad.add("first"); // через метод add адаптера добавляем в список первую строку
        arad.add("second");

        btnEdit=(Button)findViewById(R.id.btnEdit);
        btnEdit.setEnabled(false);
        del=(Button)findViewById(R.id.btnDel);
        del.setEnabled(false);

        lw.setAdapter(arad);
        lw.setOnItemClickListener(this);
    }

    public void toAdd(View view){
        arad.add(editText.getText().toString());
    }

    public void toClear(View view){
        arad.clear();
        btnEdit.setEnabled(false);
        del.setEnabled(false);
    }

    public void toEdit(View view){
        arad.remove(arad.getItem(curP));
        arad.insert(editText.getText().toString(), curP);
        btnEdit.setEnabled(false);
    }

    public void toDelete(View view){
        arad.remove(
                arad.getItem(curP));
        del.setEnabled(false);
        curView = null;
    }
}
