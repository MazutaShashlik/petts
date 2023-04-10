package com.example.petts;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Udalit extends AppCompatActivity {

    private TextView errors;
    private ProgressBar pBar;
    private ImageView petImage;
    private TextView petName;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.udal);

        errors = (TextView) findViewById(R.id.errors69420);
        pBar = (ProgressBar) findViewById(R.id.progressBar3);
        edit = (EditText) findViewById(R.id.petId);
        petName = (TextView) findViewById(R.id.petName2);
        pBar.setVisibility(View.INVISIBLE);
        petName.setVisibility(View.INVISIBLE);
    }

    public void OnClickDel(View view){

        String PetIDInput = edit.getText().toString();
        if (TextUtils.isEmpty(PetIDInput)){
            Toast.makeText(Udalit.this, "Заполните все поля.", Toast.LENGTH_SHORT).show();
        }
        else {
            petName.setVisibility(View.VISIBLE);
            pBar.setVisibility(View.VISIBLE);


            deletePet(edit.getText().toString());
        }
    }

    private void deletePet(String idPet) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://petstore.swagger.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PetsAPI petAPI = retrofit.create(PetsAPI.class);

        pBar.setVisibility(View.VISIBLE);

        Call<Pet> call = petAPI.deletePet(idPet);


        call.enqueue(new Callback<Pet>() {
            @Override
            public void onResponse(Call<Pet> call, Response<Pet> response) {
                String success = ("Питомец успешно удален.");
                Toast.makeText(Udalit.this, success, Toast.LENGTH_SHORT).show();
                pBar.setVisibility(View.INVISIBLE);
                petName.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<Pet> call, Throwable t) {
                Toast.makeText(Udalit.this, t.toString(), Toast.LENGTH_SHORT).show();
                errors.setText(t.getMessage());
                pBar.setVisibility(View.INVISIBLE);
                petName.setVisibility(View.INVISIBLE);
            }
        });
    }
    public void onClickBackToPet4(View view) {
        Intent intent = new Intent(this, Pets.class);
        startActivity(intent);
    }
}