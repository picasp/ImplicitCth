package com.example.implicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnDialpad, btnContact, btnCamera, btnGallery, btnBrowser;
    EditText etHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialpad = findViewById(R.id.btnDialpad);
        btnContact = findViewById(R.id.btnContact);
        btnCamera = findViewById(R.id.btnCamera);
        btnGallery = findViewById(R.id.btnGallery);
        btnBrowser = findViewById(R.id.btnBrowser);
        etHp = findViewById(R.id.etHp);

        btnDialpad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etHp.getText().toString().isEmpty()) {
                    Intent i = new Intent();
                    i.setAction(Intent.ACTION_DIAL);
                    startActivity(i);
                } else {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + etHp.getText()));
                    startActivity(intent);
                }
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("content:contacts/people/"));
                startActivity(intent);
            }

        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
                startActivity(intent);
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("content://media/external/images/media"));
                startActivity(intent);
            }
        });

        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://amikom.ac.id/"));
                startActivity(Intent.createChooser(intent, "title"));
            }
        });
    }
}