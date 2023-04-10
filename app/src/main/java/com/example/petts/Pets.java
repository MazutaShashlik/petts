package com.example.petts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Pets extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pets_deistv);
    }
    public void onClickToCreatePet(View view) {
        Intent intent = new Intent(this, Sozdat.class);
        startActivity(intent);
    }

    public void onClickToFindPet(View view) {
        Intent intent = new Intent(this, FindPet.class);
        startActivity(intent);
    }

    public void onClickToDeletePet(View view) {
        Intent intent = new Intent(this, Udalit.class);
        startActivity(intent);
    }

    public void onClickToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}