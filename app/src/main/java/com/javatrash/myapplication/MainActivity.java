package com.javatrash.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void button_click(){

    }

    public void button_click(View view) {
        EditText inputbox_sen = findViewById(R.id.editTextText);
        String sentence = inputbox_sen.getText().toString();
        EditText inputbox_key = findViewById(R.id.editTextText2);
        String key = inputbox_key.getText().toString();
        try {
            if (functions.char_split(sentence).size() > 4 && functions.char_split(key).size() > 3 && functions.char_split(sentence).size() > functions.char_split(key).size()) {
                String enc_txt = functions.encrypt(sentence, key);
                inputbox_sen.setText(enc_txt);
            } else {
                inputbox_sen.setText("sentence must be > 4 letters and sentence > key and key>3 letters");
                Log.d("fail", "button_click: sentence and key size error"+sentence+key);

            }
        }
        catch (Exception e){
            inputbox_sen.setText("error");
        }


    }
}