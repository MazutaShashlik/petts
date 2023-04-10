package com.example.petts;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sozdanie_usera extends AppCompatActivity {

    private ProgressBar pBar;
    private TextView errors;
    private EditText editUserID;
    private EditText editUserLogin;
    private EditText editUserFName;
    private EditText editUserLName;
    private EditText editUserEmail;
    private EditText editUserPassword;
    private EditText editUserPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sozdanie_usera);

        errors = (TextView) findViewById(R.id.errors3);
        pBar = (ProgressBar) findViewById(R.id.progressBar5);
        editUserID = (EditText) findViewById(R.id.UserInputID);
        editUserLogin = (EditText) findViewById(R.id.UserInputLogin);
        editUserFName = (EditText) findViewById(R.id.UserInputFName);
        editUserLName = (EditText) findViewById(R.id.UserInputLName);
        editUserEmail = (EditText) findViewById(R.id.UserInputEmail);
        editUserPassword = (EditText) findViewById(R.id.UserInputPassword);
        editUserPhone = (EditText) findViewById(R.id.UserInputPhone);

        pBar.setVisibility(View.INVISIBLE);
    }

    public void OnClickCreate(View view) {
        if (TextUtils.isEmpty(editUserID.getText().toString()) ||
                TextUtils.isEmpty(editUserLogin.getText().toString()) ||
                TextUtils.isEmpty(editUserFName.getText().toString()) ||
                TextUtils.isEmpty(editUserLName.getText().toString()) ||
                TextUtils.isEmpty(editUserEmail.getText().toString()) ||
                TextUtils.isEmpty(editUserPassword.getText().toString()) ||
                TextUtils.isEmpty(editUserPhone.getText().toString())) {
            Toast.makeText(Sozdanie_usera.this, "Заполните все поля.", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(Sozdanie_usera.this, "Выполняется...", Toast.LENGTH_SHORT).show();

            User user = new User(Integer.parseInt(editUserID.getText().toString()), editUserLogin.getText().toString(),
                    editUserFName.getText().toString(),
                    editUserLName.getText().toString(),
                    editUserEmail.getText().toString(),
                    editUserPassword.getText().toString(),
                    editUserPhone.getText().toString(), 1);



            createUser(user);
        }
    }

    private void createUser(User user) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://petstore.swagger.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserAPI userAPI = retrofit.create(UserAPI.class);

        pBar.setVisibility(View.VISIBLE);

        Call<User> call = userAPI.createUser(user);


        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                String success = ("Юзер добавлен");
                Toast.makeText(Sozdanie_usera.this, success, Toast.LENGTH_SHORT).show();
                pBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(Sozdanie_usera.this, t.toString(), Toast.LENGTH_SHORT).show();
                errors.setText(t.getMessage());
                pBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void OnClickReturnToStart(View view) {
        Intent intent = new Intent(this, Users.class);
        startActivity(intent);
    }
}