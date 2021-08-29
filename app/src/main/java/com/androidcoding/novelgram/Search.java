package com.androidcoding.novelgram;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;


public class Search extends AppCompatActivity {

    //Initialise variable
    public static ArrayList<BookName> bookNameList = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ImageButton back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(this::onClick);

        //Perform functions
        setUpData();
        setUpList();
        setUpOnClickListener();
        setUpOnSpinnerClick();

        //Initialise and assign value
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Search Selected
        bottomNavigationView.setSelectedItemId(R.id.search);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            if (id == R.id.home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(0,0);
                return true;
            }
            else if (id == R.id.books) {
                startActivity(new Intent(getApplicationContext(), MyBooks.class));
                overridePendingTransition(0,0);
                return true;
            }

            else if (id == R.id.search) {
                overridePendingTransition(0,0);
                return true;
            }

            else {
                return false;
            }
        });
    }


    private void initSearchWidgets1(){
        SearchView searchView = findViewById(R.id.search_bar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<BookName> filteredBookNames = new ArrayList<>();

                for(BookName bookName: bookNameList){
                    if(bookName.getBook_name().toLowerCase().startsWith(s.toLowerCase()) ||
                            bookName.getAuthor_name().toLowerCase().startsWith(s.toLowerCase())){
                        filteredBookNames.add(bookName);
                    }


                }

                BookNameAdapter adapter = new BookNameAdapter(getApplicationContext(),0, filteredBookNames);
                listView.setAdapter(adapter);
                return false;
            }});
    }

    private void initSearchWidgets2(){
        SearchView searchView = findViewById(R.id.search_bar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<BookName> filteredBookNames = new ArrayList<>();
                for(BookName bookName: bookNameList){
                    if(bookName.getBook_name().toLowerCase().startsWith(s.toLowerCase())){
                        filteredBookNames.add(bookName);
                    }


                }

                BookNameAdapter adapter = new BookNameAdapter(getApplicationContext(),0, filteredBookNames);
                listView.setAdapter(adapter);
                return false;
            }});
    }

    private void initSearchWidgets3(){
        SearchView searchView = findViewById(R.id.search_bar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<BookName> filteredBookNames = new ArrayList<>();
                for(BookName bookName: bookNameList){
                    if(bookName.getAuthor_name().toLowerCase().startsWith(s.toLowerCase()))
                    {
                        filteredBookNames.add(bookName);
                    }


                }

                BookNameAdapter adapter = new BookNameAdapter(getApplicationContext(),0, filteredBookNames);
                listView.setAdapter(adapter);
                return false;
            }});
    }


    //Set up data
    private static void setUpData(){
        BookName bookName1 = new BookName("b1", "Malibu Rising", "Taylor Jenkins Reid", R.drawable.image_1);
        bookNameList.add(bookName1);

        BookName bookName2 = new BookName("b2", "People We Meet On Vacation", "Emily Henry", R.drawable.image_2);
        bookNameList.add(bookName2);

        BookName bookName3 = new BookName("b3", "The Four Winds", "Kristin Hannah", R.drawable.image_3);
        bookNameList.add(bookName3);

        BookName bookName4 = new BookName("b4", "The Last thing He Told Me", "Laura Dave", R.drawable.image_4);
        bookNameList.add(bookName4);

        BookName bookName5 = new BookName("b5", "Pride and Prejudice", "Jane Austen", R.drawable.image_5);
        bookNameList.add(bookName5);

        BookName bookName6 = new BookName("b6", "Godaan", "Premchand", R.drawable.image_6);
        bookNameList.add(bookName6);

        BookName bookName7 = new BookName("b7", "Little Women", "Louisa May Alcott", R.drawable.image_7);
        bookNameList.add(bookName7);

        BookName bookName8 = new BookName("b8", "Madhushala", "Harivansh Rai Bachchan", R.drawable.image_8);
        bookNameList.add(bookName8);

        BookName bookName9 = new BookName("b9", "The Palace of Illusions", "Chitra Banerjee Divakaruni", R.drawable.image_9);
        bookNameList.add(bookName9);

        BookName bookName10 = new BookName("b10", "Quantum Roots II: Worm Holes", "Kyle Keyes",R.drawable.image_10);
        bookNameList.add(bookName10);

        BookName bookName11 = new BookName("b11", "The Ancestor", "Danielle Trussoni", R.drawable.image_11);
        bookNameList.add(bookName11);

        BookName bookName12 = new BookName("b12", "Underland", "Robert Macfarlane", R.drawable.image_12);
        bookNameList.add(bookName12);

        BookName bookName13 = new BookName("b13", "Nirmala", "Premchand", R.drawable.image_13);
        bookNameList.add(bookName13);

        BookName bookName14 = new BookName("b14", "Train to Pakistan", "Khushwant Singh", R.drawable.image_14);
        bookNameList.add(bookName14);

        BookName bookName15 = new BookName("b15", "Chandragupta", "Jaishankar Prasad", R.drawable.image_15);
        bookNameList.add(bookName15);

        BookName bookName16 = new BookName("b16", "Tamas", "Bhisham Sahni", R.drawable.image_16);
        bookNameList.add(bookName16);

        BookName bookName17 = new BookName("b17", "Summer Water ", "Sarah Moss", R.drawable.image_17);
        bookNameList.add(bookName17);

        BookName bookName18 = new BookName("b18", "The Fault in our Stars", "John Green", R.drawable.image_18);
        bookNameList.add(bookName18);

        BookName bookName19 = new BookName("b19", "Mr. Penumbra's 24-Hour Bookstore", "Robin Sloan", R.drawable.image_19);
        bookNameList.add(bookName19);

        BookName bookName20 = new BookName("b20", "Billy Summers", "Stephen King", R.drawable.image_20);
        bookNameList.add(bookName20);

        BookName bookName21 = new BookName("b21", "The Goldfinch", "Donna Tartt", R.drawable.image_21);
        bookNameList.add(bookName21);

        BookName bookName22 = new BookName("b22", "To Kill a Mockingbird", "Harper Lee", R.drawable.image_22);
        bookNameList.add(bookName22);

        BookName bookName23 = new BookName("b23", "Of Mice and Men", "John Steinbeck", R.drawable.image_23);
        bookNameList.add(bookName23);

        BookName bookName24 = new BookName("b24", "Jane Eyre", "Charlotte Bronte", R.drawable.image_24);
        bookNameList.add(bookName24);

        BookName bookName25 = new BookName("b25", "The Woman in the Window", "A. J. Finn", R.drawable.image_25);
        bookNameList.add(bookName25);

        BookName bookName26 = new BookName("b26", "And Then There Were None", "Agatha Christie", R.drawable.image_26);
        bookNameList.add(bookName26);

        BookName bookName27 = new BookName("b27", "Liane Moriarty", "Big Little Lies", R.drawable.image_27);
        bookNameList.add(bookName27);

        BookName bookName28 = new BookName("b28", "The Kind Worth Killing", "Peter Swanson", R.drawable.image_28);
        bookNameList.add(bookName28);

        BookName bookName29 = new BookName("b29", "The Exorcist", "William Peter Blatty", R.drawable.image_29);
        bookNameList.add(bookName29);

        BookName bookName30 = new BookName("b30", "A Face In The Dark", "Ruskin Bond", R.drawable.image_30);
        bookNameList.add(bookName30);

        BookName bookName31 = new BookName("b31", "The Shining", "Stephen King", R.drawable.image_31);
        bookNameList.add(bookName31);

        BookName bookName32 = new BookName("b32", "Coffin Hill", "Caitlin Kittredge", R.drawable.image_32);
        bookNameList.add(bookName32);

        BookName bookName34 = new BookName("b34", "The Nightingale", "Kristin Hannah", R.drawable.image_34);
        bookNameList.add(bookName34);

        BookName bookName35 = new BookName("b35", "The Other Boleyn Girl", "Philippa Gregory", R.drawable.image_35);
        bookNameList.add(bookName35);

        BookName bookName37 = new BookName("b37", "The Notebook", "Nicholas Sparks", R.drawable.image_37);
        bookNameList.add(bookName37);

        BookName bookName38 = new BookName("b38", "Every Breath", "Nicholas Sparks", R.drawable.image_38);
        bookNameList.add(bookName38);

        BookName bookName41 = new BookName("b41", "A Wrinkle in Time", "Madeleine L'Engle", R.drawable.image_41);
        bookNameList.add(bookName41);

        BookName bookName42 = new BookName("b42", "Dark Matter", "Blake Crouch", R.drawable.image_42);
        bookNameList.add(bookName42);

        BookName bookName43 = new BookName("b43", "Harry Potter", "J. K. Rowling", R.drawable.image_43);
        bookNameList.add(bookName43);

        BookName bookName44 = new BookName("b44", "2001: A Space Odyssey ", "Arthur C. Clarke", R.drawable.image_44);
        bookNameList.add(bookName44);

    }

    //Set up list
    private void setUpList(){
        BookNameAdapter bookNameAdapter = new BookNameAdapter(getApplicationContext(), 0, bookNameList);
        listView = findViewById(R.id.booksListSearchView);
        listView.setAdapter(bookNameAdapter);
    }

    //Perform ItemClickListener
    private void setUpOnClickListener(){
        listView.setOnItemClickListener((adapterView, view, position, l) -> {
            BookName selectBook = (BookName) (listView.getItemAtPosition(position));
            String id = selectBook.getId();

            switch (id) {
                case "b7": {
                    Intent showDetail = new Intent(getApplicationContext(), Book7.class);
                    showDetail.putExtra("id", selectBook.getId());
                    startActivity(showDetail);
                    break;
                }
                case "b18": {
                    Intent showDetail = new Intent(getApplicationContext(), Book18.class);
                    showDetail.putExtra("id", selectBook.getId());
                    startActivity(showDetail);
                    break;
                }
                case "b22": {
                    Intent showDetail = new Intent(getApplicationContext(), Book22.class);
                    showDetail.putExtra("id", selectBook.getId());
                    startActivity(showDetail);
                    break;
                }
            }


        });
    }

    //Perform Spinner
    private void setUpOnSpinnerClick(){
        Spinner spinner = findViewById(R.id.spinner);

        ArrayList<String> sort = new ArrayList<>();

        sort.add("  All  ");
        sort.add("  Name of Book  ");
        sort.add("  Name of Author  ");

        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sort));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    initSearchWidgets1();
                    Toast.makeText(getApplicationContext(), sort.get(position), Toast.LENGTH_SHORT).show();
                }

                else if(position == 1){
                    initSearchWidgets2();
                    Toast.makeText(getApplicationContext(), sort.get(position), Toast.LENGTH_SHORT).show();
                }
                else if(position == 2){
                    initSearchWidgets3();
                    Toast.makeText(getApplicationContext(), sort.get(position), Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    //Perform onClick
    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            Intent intent = new Intent(this, MyBooks.class);
            startActivity(intent);
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