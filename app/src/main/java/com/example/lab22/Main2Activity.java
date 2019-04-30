package com.example.lab22;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.lab22.MainActivity";
    public static final int ITEMS_REQUEST = 123;
    private EditText mLocationET;

    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mLocationET = findViewById(R.id.location_editText);
        items = new ArrayList<>();
    }

    public void makeText(View view) {
        CheckBox selectedCheckBox = (CheckBox) view;
        String item = selectedCheckBox.getText().toString();
        Toast.makeText(this, item + " Added.", Toast.LENGTH_LONG).show();
        items.add(item);
    }

    public void finishAdding(View view) {
        Intent intent = new Intent();
        intent.putStringArrayListExtra(EXTRA_MESSAGE, items);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void findLocation(View view) {
        String location = mLocationET.getText().toString();
        Uri locUri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, locUri);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Log.d("Message", "Can't open the location!");
        }
    }
}