package com.example.petts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Users extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_deistv);

    }
    public void onClickToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickToDeleteUser(View view) {
        Intent intent = new Intent(this, Udalit_usera.class);
        startActivity(intent);
    }

    public void onClickToCreateUser(View view) {
        Intent intent = new Intent(this, Sozdanie_usera.class);
        startActivity(intent);
    }

    /*public void onClickToFindUser(View view) {
        Intent intent = new Intent(this, .class);
        startActivity(intent);
    }*/
}
