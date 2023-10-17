package com.example.kr1_10_var;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.ListView;
        import android.widget.Toast;

        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.content.ContextCompat;

public class First extends AppCompatActivity {
    private ArrayAdapter<String> arad;
    private ListView lw;
    private LinearLayout linearLayout;
    private EditText EditText1, EditText2, EditText3;
    private Button add, clear, blue, red, theme1, theme2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_act);

        arad = new ArrayAdapter<String>(this, R.layout.le);
        lw = (ListView) findViewById(R.id.listView);
        lw.setAdapter(arad);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        EditText1 = (EditText) findViewById(R.id.editText1);
        EditText2 = (EditText) findViewById(R.id.editText2);
        EditText3 = (EditText) findViewById(R.id.editText3);

        add = (Button) findViewById(R.id.add);
        clear = (Button) findViewById(R.id.clear);
        blue = (Button) findViewById(R.id.blue);
        red = (Button) findViewById(R.id.red);
        theme1 = (Button) findViewById(R.id.theme1);
        theme2 = (Button) findViewById(R.id.theme2);
    }

    public boolean hasErr(EditText num1, EditText num2, EditText num3) {
        if (num1.getText().toString().equals("") || num2.getText().toString().equals("") || num3.getText().toString().equals("")) {
            Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void toAdd(View view) {
        if (!hasErr(EditText1, EditText2, EditText3)) return;

        double num1 = Double.valueOf(EditText1.getText().toString());
        double num2 = Double.valueOf(EditText2.getText().toString());
        double num3 = Double.valueOf(EditText3.getText().toString());

        double res = num1 + num2 + num3;
        arad.add(String.valueOf(res) + " = " + String.valueOf(num1) + " + " + String.valueOf(num2) + " + " + String.valueOf(num3));
    }

    public void toClear(View view) {
        arad.clear();
    }

    public void toBlue(View view) {
        linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
    }

    public void toRed(View view) {
        linearLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700));
    }

    public void toTheme1(View view) {
        EditText1.setTextColor(ContextCompat.getColor(this, R.color.black));
        EditText1.setBackgroundColor(ContextCompat.getColor(this, R.color.white));

        EditText2.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        EditText2.setTextColor(ContextCompat.getColor(this, R.color.black));

        EditText3.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_200));
        EditText3.setTextColor(ContextCompat.getColor(this, R.color.teal_700));
    }

    public void toTheme2(View view) {
        EditText1.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        EditText1.setTextColor(ContextCompat.getColor(this, R.color.black));

        EditText2.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        EditText2.setTextColor(ContextCompat.getColor(this, R.color.black));

        EditText3.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700));
        EditText3.setTextColor(ContextCompat.getColor(this, R.color.teal_200));
    }
}