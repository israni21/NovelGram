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

public class MainActivity extends AppCompatActivity {

    //Initialise buttons
    Button read_more1;
    ImageButton book7;
    ImageButton book18;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialise and assign value
        read_more1 = findViewById(R.id.more_books);
        read_more1.setOnClickListener(this::onClick);

        book7 = findViewById(R.id.book7);
        book7.setOnClickListener(this::onClick);

        book18 = findViewById(R.id.book18);
        book18.setOnClickListener(this::onClick);


        //Initialise and assign value
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Books Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            if (id == R.id.home) {
                overridePendingTransition(0,0);
                return true;
            }

            else if (id == R.id.books) {
                startActivity(new Intent(getApplicationContext(),
                        MyBooks.class));
                overridePendingTransition(0,0);
                return true;
            }

            else if (id == R.id.search) {
                startActivity(new Intent(getApplicationContext(),
                        Search.class));
                overridePendingTransition(0,0);
                return true;
            }

            else {
                return false;
            }
        });


    }

    //Perform onClick
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.more_books:
                Intent intent1 = new Intent(this, MyBooks.class);
                startActivity(intent1);
                break;

            case R.id.book7:
                Intent intent2 = new Intent(this,Book7.class);
                startActivity(intent2);break;

            case R.id.book18:
                Intent intent3 = new Intent(this, Book18.class);
                startActivity(intent3);break;

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








