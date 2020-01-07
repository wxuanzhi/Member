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

public class NicknameActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ednickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        findViewById(R.id.right1).setOnClickListener(this);
    }
    public void age(){
        Intent age = new Intent(this,AgeActivity.class);
        SharedPreferences pref = getSharedPreferences("test",MODE_PRIVATE);
        pref.edit()
                .putString("nickname",ednickname.getText().toString())
                .commit();
        startActivityForResult(age,10);
    }
    public void onClick(View view){
        ednickname = findViewById(R.id.nickname);
        String testNickname = ednickname.getText().toString();
        if(!TextUtils.isEmpty(ednickname.getText().toString())){
            setResult(RESULT_OK);
            finish();
            age();
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("Message")
                    .setMessage("Can not be a blank space")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
}
//