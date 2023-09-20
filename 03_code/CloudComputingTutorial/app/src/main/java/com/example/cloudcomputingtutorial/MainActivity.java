package com.example.cloudcomputingtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView nameInput;
    private TextView idInput;

    private Button writeButton;

    private TextView targetNameInput;

    private Button readButton;

    private TextView targetNameOutput;
    private TextView idText;

    private ServiceApi service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.NameInput);
        idInput = findViewById(R.id.IdInput);

        writeButton = findViewById(R.id.WriteBtn);

        targetNameInput = findViewById(R.id.TargetNameInput);

        readButton = findViewById(R.id.ReadBtn);

        targetNameOutput = findViewById(R.id.TargetNameOutput);
        idText = findViewById(R.id.IdOutput);

        service = RetrofitClient.getClient().create(ServiceApi.class);

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = nameInput.getText().toString();
                String userId = idInput.getText().toString();

                NameIdData requestData = new NameIdData(userName, userId);

                service.userWrite(requestData).enqueue(new Callback<CodeMessageResponse>() {
                    @Override
                    public void onResponse(Call<CodeMessageResponse> call, Response<CodeMessageResponse> response) {
                        CodeMessageResponse result = response.body();
                        Toast.makeText(MainActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<CodeMessageResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Write Error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}