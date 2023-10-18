package com.example.nineapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    private SharedPreferences preferences;  //ссылка на объект-настройку
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        //метод getSharedPreferences возвращает объект-настройку с именем, которое содержится в первом параметре.
        preferences = getSharedPreferences(getString(R.string.preferences),MODE_PRIVATE); //имя настройки здесь берется из строкового ресурса. MODE_PRIVATE – только наше приложение может читать этот файл-настройку

        editText1 = (EditText) findViewById(R.id.edtT1);
        editText2 = (EditText) findViewById(R.id.edtT2);
        editText3 = (EditText) findViewById(R.id.edtT3);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String elKey1 = getString(R.string.string_el1);
        String elKey2 = getString(R.string.string_el2);
        String elKey3 = getString(R.string.int_el); //получаем из строкового ресурса ключ. Все ключи – строкового типа

        String stringEl1 = preferences.getString(elKey1, "default1");
        String stringEl2 = preferences.getString(elKey2, "default2");
        int intEl3 = preferences.getInt(elKey3, 0);

        editText1.setText(stringEl1);
        editText2.setText(stringEl2);
        editText3.setText(String.valueOf(intEl3));
    }


    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit(); //с помощью метода edit объекта-активности получаем объект-редактор editor

        String value1 = editText1.getText().toString();
        String value2 = editText2.getText().toString();
        int value3 = Integer.valueOf(editText3.getText().toString());

        editor.putString(getString(R.string.string_el1), value1);
        editor.putString(getString(R.string.string_el2), value2);
        editor.putInt(getString(R.string.int_el), value3); //с помощью редактора помещаем в настройку элемент. Первый параметр putInt – ключ элемента, взятый из строкового ресурса, второй параметр – значение элемента, извлеченное из соответствующего EditText-а

        editor.commit();   //применяем изменения настройки
    }
}
