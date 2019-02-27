package com.app.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SeekBar seekBar;
    Button button;
    EditText editText;

    public void generate(int progress)
    {
        ArrayList<String> arrayList=new ArrayList<>();
        for(int i=1;i<=10;i++)
        {
            arrayList.add(""+progress+" * " +i+ " = "+progress*i);
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=findViewById(R.id.seekBar1);
        editText=findViewById(R.id.editText);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        listView=findViewById(R.id.listView1);
        button=findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=Integer.parseInt(editText.getText().toString());
                seekBar.setMax(i*2);
                seekBar.setProgress(i-1);
                generate(i);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int times;
                if(progress<min) {
                    times=min;
                    seekBar.setProgress(min);
                }
                else
                    times=progress;
                generate(times);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generate(10);
    }
}
