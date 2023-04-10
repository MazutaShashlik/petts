package com.example.petts;

import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;


    import android.util.Log;
    import android.view.View;
    import android.widget.ImageView;
    import android.widget.ProgressBar;
    import android.widget.TextView;
    import android.widget.Toast;


    import com.squareup.picasso.Picasso;

    import java.io.IOException;

    import okhttp3.ResponseBody;
    import retrofit2.Call;
    import retrofit2.Callback;
    import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nach);

    }

    public void onClickPet(View view) {
        Intent intent = new Intent(this, Pets.class);
        startActivity(intent);
    }

    public void onClickUser(View view) {
        Intent intent = new Intent(this, Users.class);
        startActivity(intent);
    }
}