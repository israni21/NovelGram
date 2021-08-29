package com.androidcoding.novelgram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

//Custom adapter class
class BookNameAdapter extends ArrayAdapter<BookName> {

    public BookNameAdapter(Context context, int resource, ArrayList<BookName> bookNameList) {
        super(context, resource, bookNameList);
    }

    //Perform getView
    public View getView(int position, View convertView, ViewGroup parent) {
        BookName bookName = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.all_books, parent, false);
        }
        ImageView searchView = convertView.findViewById(R.id.book_image);
        if (bookName != null) {
            searchView.setImageResource(bookName.getImage());
            ((TextView) convertView.findViewById(R.id.textView1)).setText(bookName.getBook_name());
            ((TextView) convertView.findViewById(R.id.textView2)).setText(bookName.getAuthor_name());
            return convertView;
        }
        throw new AssertionError();
    }
}
