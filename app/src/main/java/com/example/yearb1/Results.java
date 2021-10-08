package com.example.yearb1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    Intent gi;
    TextView t1, t2;
    String winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);

        gi = getIntent();
        int s1 = gi.getIntExtra("s1",1);
        int s2 = gi.getIntExtra("s2", 1);

        if (s1 > s2){
            winner = "the winner is \nBLUE!";
        }
        else if (s2 > s1){
            winner = "the winner is \nRED!";
        }
        else{
            winner = "its a TIE!";
        }
        t2.setText(""+winner+"\n(red: "+s2+" blue: "+s1+")");
        t1.setText(""+winner+"\n(blue: "+s1+" red: "+s2+")");

    }

    public void reset(View view) {
        gi.putExtra("res",1);
        setResult(RESULT_OK,gi);
        System.out.println("res1");
        finish();
    }
}