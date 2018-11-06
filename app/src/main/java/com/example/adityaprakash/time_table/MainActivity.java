package com.example.adityaprakash.time_table;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public void generateTable(int number){
        ArrayList <String> tableContent = new ArrayList<>();
        for(int j=1;j<=10;j++){
            tableContent.add(Integer.toString(number)+" X "+Integer.toString(j)+" = "+Integer.toString(j*number));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tableContent);
        listView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        listView  = findViewById(R.id.listView);

        seekBar.setProgress(6);
        seekBar.setMax(21);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int number;
                if(progress<min){
                    number=min;
                    seekBar.setProgress(min);
                }
                else{
                    number=progress;
                }
                Log.i("number is",Integer.toString(number));
                Toast.makeText(getApplicationContext(),"Multiplication Table of "+number, Toast.LENGTH_SHORT).show();
                generateTable(number);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
