package com.androidcoding.novelgram;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import com.github.barteksc.pdfviewer.PDFView;

public class Book22 extends AppCompatActivity {

    //Initialise buttons
    Switch switch_theme22;
    ImageButton back_button;
    protected void onCreate(Bundle savedInstanceState) {

        //Switch theme
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }

        else{
            setTheme(R.style.MainTheme);
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book22);

        switch_theme22 = findViewById(R.id.switch_theme22);
        switch_theme22.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if(isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        //Assign back button
        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(this::onClick);

        //Initialise and assign pdf view
        PDFView pdfView22 = findViewById(R.id.pdfbook22);
        pdfView22.fromAsset("To-Kill-a-Mockingbird.pdf").load();
    }

    //Perform onClick
    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            finish();
        }
    }
}
