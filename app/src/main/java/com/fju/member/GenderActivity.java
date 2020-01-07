package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    private EditText edGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        findViewById(R.id.done).setOnClickListener((View.OnClickListener) this);
    }
    public void done(View view){
        edGender = findViewById(R.id.gender);
        String tsetGender = edGender.getText().toString();
        if(!TextUtils.isEmpty(edGender.getText().toString())){
            setResult(RESULT_OK);
            finish();
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("Message")
                    .setMessage("Can not be a blank space")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
}
