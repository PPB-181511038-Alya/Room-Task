package com.example.roomwordsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText taskName;
    private EditText taskDeadline;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        taskName = findViewById(R.id.txtTask);
        taskDeadline = findViewById(R.id.txtDeadline);

        final Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(taskName.getText())||TextUtils.isEmpty(taskDeadline.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String name = taskName.getText().toString();
                    String deadline = taskDeadline.getText().toString();
                    replyIntent.putExtra("name", name);
                    replyIntent.putExtra("deadline", deadline);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
