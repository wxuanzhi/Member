package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class AgeActivity extends AppCompatActivity {

    private EditText edage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        findViewById(R.id.right2).setOnClickListener((View.OnClickListener) this);
    }
    public void gender(){
        Intent gender = new Intent(this,GenderActivity.class);
        SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
        pref.edit()
                .putString("age",edage.getText().toString())
                .commit();
        startActivityForResult(gender,10);
    }
    public void onClick(View view){
        edage = findViewById(R.id.age);
        String testNickname = edage.getText().toString();
        if(!TextUtils.isEmpty(edage.getText().toString())){
            setResult(RESULT_OK);
            finish();
            gender();
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("Message")
                    .setMessage("Can not be a blank space")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
}
