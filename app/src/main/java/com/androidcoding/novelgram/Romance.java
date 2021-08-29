package com.androidcoding.novelgram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Romance extends AppCompatActivity {

    //Initialise image buttons
    ImageButton book39;
    ImageButton back_button;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romance);


        //Assign the values
        book39 = findViewById(R.id.book39);
        book39.setOnClickListener(this::onClick);

        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(this::onClick);
    }

    //Perform onClick
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.book39:
                Intent intent = new Intent(getApplicationContext(), Book18.class);
                startActivity(intent);

            case R.id.back_button:
                finish();

            default:
                break;
        }
    }

    public void ClickLogOut(View view){
        //Close app
        Logout(this);
    }

    public static void Logout(final Activity activity){
        //Initialise alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set title
        builder.setTitle("Logout");
        //Set message
        builder.setMessage("Are you sure you want to logout?");
        //Positive yes button
        builder.setPositiveButton("YES", (dialog, which) -> {
            //Finish activity
            activity.finishAffinity();
            //Exit app
            System.exit(0);
        });
        //Negative no button
        builder.setNegativeButton("NO", (dialog, which) -> {
            //Dismiss dialog
            dialog.dismiss();
        });
        //Show dialog
        builder.show();
    }
}
