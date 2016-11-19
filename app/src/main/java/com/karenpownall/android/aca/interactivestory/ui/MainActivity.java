package com.karenpownall.android.aca.interactivestory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.karenpownall.android.aca.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText mNameField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameField = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameField.getText().toString();
                startStory(name);
            }
        });
    } //end onCreate

    private void startStory(String name){
        Intent intent = new Intent(this, StoryActivity.class);
        //pass in current context (MainActivity), then activity want to start
        intent.putExtra(getString(R.string.key_name), name);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText("");
    }
} //end MainActivity
