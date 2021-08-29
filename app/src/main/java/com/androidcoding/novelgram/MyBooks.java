package com.androidcoding.novelgram;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MyBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_books);


        //Initialise and assign value
        Button button1 = findViewById(R.id.literary_fiction);
        button1.setOnClickListener(this::onClick);

        Button button2 = findViewById(R.id.thriller_mystery);
        button2.setOnClickListener(this::onClick);

        Button button3 = findViewById(R.id.horror);
        button3.setOnClickListener(this::onClick);

        Button button4 = findViewById(R.id.historical);
        button4.setOnClickListener(this::onClick);

        Button button5 = findViewById(R.id.romance);
        button5.setOnClickListener(this::onClick);

        Button button6 = findViewById(R.id.science_fiction);
        button6.setOnClickListener(this::onClick);

        ImageButton back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(this::onClick);



        //Initialise and assign value
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Books Selected
        bottomNavigationView.setSelectedItemId(R.id.books);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            if (id == R.id.home){
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(0,0);
                return true;

            }

            else if (id == R.id.books){
                overridePendingTransition(0,0);
                return true;
            }

            else if (id == R.id.search){
                startActivity(new Intent(getApplicationContext(),
                        Search.class));
                overridePendingTransition(0,0);
                return true;
            }

            else{
                return false;
            }

        });
    }

    //Perform onClick
    public void onClick(View view){
        switch (view.getId()){
            case R.id.literary_fiction:
                Intent intent1 = new Intent(this, Literary_Fiction.class);
                startActivity(intent1);
                break;

            case R.id.thriller_mystery:
                Intent intent2 = new Intent(this, Thriller_Mystery.class);
                startActivity(intent2);
                break;

            case R.id.horror:
                Intent intent3 = new Intent(this, Horror.class);
                startActivity(intent3);
                break;

            case R.id.historical:
                Intent intent4 = new Intent(this, Historical.class);
                startActivity(intent4);
                break;

            case R.id.romance:
                Intent intent5 = new Intent(this, Romance.class);
                startActivity(intent5);
                break;

            case R.id.science_fiction:
                Intent intent6 = new Intent(this, Science_Fiction.class);
                startActivity(intent6);
                break;

            case R.id.back_button:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

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