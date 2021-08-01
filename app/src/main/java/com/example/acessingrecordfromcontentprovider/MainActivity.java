package com.example.acessingrecordfromcontentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static  final String CONTENT_AUTHORITY="com.example.contentproviderdemo.user";
    public static final String uri="content://"+CONTENT_AUTHORITY+"/users";

    public static Uri CONTENT_URI=Uri.parse(uri);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadDetails(View view)
    {
        TextView textView=findViewById(R.id.result);
        Cursor cursor=getContentResolver().query(CONTENT_URI,null,null,null,null);
        StringBuilder stringBuilder=new StringBuilder();

        if (cursor.moveToFirst())
        {
            while (!cursor.isAfterLast())
            {
                stringBuilder.append("\n"+cursor.getString(cursor.getColumnIndex("name")));
                cursor.moveToNext();
            }

            textView.setText(stringBuilder);
        }
        else
        {
            Toast.makeText(this,"Record not Found......",Toast.LENGTH_LONG).show();
        }
    }
}