package com.example.yearb1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    Button b1, b2, b3;
    int s1 = 0, s2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 += 1;
            }
        });

        b2.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View v) {
        s2 += 2;
        return true;
    }

    public void show_results(View view) {
        Intent results = new Intent(this,Results.class);
        results.putExtra("s1",s1);
        results.putExtra("s2",s2);
        startActivityForResult(results,1);
    }

    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if (data_back != null) {
            s1 = 0;
            s2 = 0;
            System.out.println("res2");
        }
    }
}