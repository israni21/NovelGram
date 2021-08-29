package com.androidcoding.novelgram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import com.github.barteksc.pdfviewer.PDFView;

public class Book7 extends AppCompatActivity {

    //Initialise buttons
    Switch switch_theme7;
    ImageButton back_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Switch theme

        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }

        else{
            setTheme(R.style.MainTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book7);

        switch_theme7 = findViewById(R.id.switch_theme7);
        switch_theme7.setOnCheckedChangeListener((compoundButton, isChecked) -> {
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
        PDFView pdfView7 = findViewById(R.id.pdfbook7);
        pdfView7.fromAsset("LittleWomen.pdf").load();
    }

    //Perform onClick
    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}