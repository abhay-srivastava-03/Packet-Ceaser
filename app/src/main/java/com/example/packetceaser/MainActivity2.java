package com.example.packetceaser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText url;
    private Button btn;
    public static final String Extra_Name = "com.example.packetceaser.url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        url = findViewById(R.id.url);
        btn = findViewById(R.id.load);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = url.getText().toString();
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                intent.putExtra(Extra_Name,data);
                startActivity(intent);
            }
        });
    }
}