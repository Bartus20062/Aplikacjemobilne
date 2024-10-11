package com.example.statemanagementapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;



public class MainActivity extends AppCompatActivity {
    private CountViewModel countViewModel;
    private TextView textViewCount;
    private EditText editText;
    private Switch switch1;
    private CheckBox checkBox;
    private TextView textView1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textViewCount = findViewById(R.id.textViewCount);
        Button buttonIncrement = findViewById(R.id.ButtonIncrement);
        Switch switch1 = findViewById(R.id.switch1);
        TextView textView1 = findViewById(R.id.textView1);
        CheckBox checkBox1 = findViewById(R.id.checkBox);


        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    textView1.setVisibility(View.VISIBLE);
                } else {
                    textView1.setVisibility(View.GONE);
                }
            }
        });


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                }
            }
        });





        countViewModel = new ViewModelProvider(this).get(CountViewModel.class);
        updateCountText();

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countViewModel.incrementCount();

                updateCountText();
            }
        });
    }
    private void updateCountText(){
        textViewCount.setText("Licznik: "+ countViewModel.getCount());
    }
}
