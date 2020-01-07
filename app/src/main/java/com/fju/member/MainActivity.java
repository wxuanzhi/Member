package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nickname;
    private EditText age;
    private EditText gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nickname = findViewById(R.id.nn);
        age = findViewById(R.id.ag);
        gender = findViewById(R.id.ge);
    }

    public void next(View view){
        Intent nickname = new Intent(this,NicknameActivity.class);
        startActivityForResult(nickname,10);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 10){
            if(resultCode != RESULT_OK){
                finish();
            }else{
                nickname.setText(getSharedPreferences("test",MODE_PRIVATE).getString("nickname",""));
                age.setText(getSharedPreferences("test",MODE_PRIVATE).getString("age",""));
                gender.setText(getSharedPreferences("test",MODE_PRIVATE).getString("gender",""));
            }
        }
    }
}
