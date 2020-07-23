package com.example.flames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.NamedNodeMap;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    private EditText name,cname;
    private Button button;
    private String Name,Cname;
    int[] a = new int[26];
    private int ct=0;
    List<Character> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editText);
        cname = findViewById(R.id.editText2);
        button = findViewById(R.id.button);
        list = new ArrayList<Character>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name = name.getText().toString().toLowerCase();
                Cname = cname.getText().toString().toLowerCase();
                if(Name.equals("") || Cname.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"A pair is made by two hearts buddy",Toast.LENGTH_LONG).show();
                }
                else
                {
                    add_data();
                    find_redundancy();
                    if(ct>0)
                    {find_your_luck();}
                    else
                    {
                        String single = "single";
                        Intent intent = new Intent(getApplicationContext(),result.class);
                        intent.putExtra("answer",single);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }

    private void add_data()
    {
        list.add('f');
        list.add('l');
        list.add('a');
        list.add('m');
        list.add('e');
        list.add('s');
    }
    private void find_redundancy()
    {
        for (int i = 0;i<Name.length();i++)
        {
            String space = String.valueOf(Name.charAt(i));
            if(Name.charAt(i)>=97 && Name.charAt(i)<=122)
            {
                a[Name.charAt(i)-97]++;
            }
        }
        for (int i=0;i<Cname.length();i++)
        {
            String space = String.valueOf(Cname.charAt(i));
            if(Cname.charAt(i)>=97 && Cname.charAt(i)<=122)
            {
                a[Cname.charAt(i)-97]--;
            }
        }
        for (int i=0;i<26;i++)
        {
            a[i] = Math.abs(a[i]);
            if (a[i]>0)
                {
                    ct+=a[i];
                }
        }
    }


    private void find_your_luck() {
        int iteration = 0, cit = -1;
        Log.d("val",String.valueOf(ct));
        while (list.size() > 1) {

            iteration++;
            cit++;
            if (cit == list.size()) {
                cit = 0;
            }
            if (iteration == ct) {
                iteration = 0;
                list.remove(cit);
                --cit;
            }
        }
        String Ans = null;
        for (char i : list) {
            Ans = String.valueOf(i);
        }
        name.setText("");
        cname.setText("");
        Intent intent = new Intent(getApplicationContext(), result.class);
        intent.putExtra("answer", Ans);
        startActivity(intent);
        finish();
    }
}
