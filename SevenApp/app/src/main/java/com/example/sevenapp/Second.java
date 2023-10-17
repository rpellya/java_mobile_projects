package com.example.sevenapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {
    ListView listView1, listView2;
    EditText editText;
    ArrayAdapter<String> arrayAdapter1, arrayAdapter2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        arrayAdapter1 = new ArrayAdapter<String>(this, R.layout.item);
        arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.item);

        String[] ar1 = getResources().getStringArray(R.array.array1);
        String[] ar2 = getResources().getStringArray(R.array.array2);

        arrayAdapter1.addAll(ar1);
        arrayAdapter2.addAll(ar2);

        listView1 = (ListView) findViewById(R.id.listView1);
        listView2 = (ListView) findViewById(R.id.listView2);
        editText = (EditText)findViewById(R.id.editText);

        listView1.setAdapter(arrayAdapter1);
        listView2.setAdapter(arrayAdapter2);
    }
    public void toAddFirstList(View view){
        String s = editText.getText().toString();
        arrayAdapter1.add(s);
    }
    public void toAddSecondList(View view){
        String s = editText.getText().toString();
        arrayAdapter2.add(s);
    }

    public void toBack(View view){
        onBackPressed();
    }
}
