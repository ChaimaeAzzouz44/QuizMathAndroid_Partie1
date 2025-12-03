package com.example.mathquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    TextView txtNum1, txtNum2, txtResult;
    Button btnAdd, btnSubtract, btnMultiply, btnGenerate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtNum1 = findViewById(R.id.txt2);
        txtNum2 = findViewById(R.id.txt3);
        txtResult = findViewById(R.id.txt4);

        btnAdd = findViewById(R.id.btn1);
        btnSubtract = findViewById(R.id.btn2);
        btnMultiply = findViewById(R.id.btn3);
        btnGenerate = findViewById(R.id.btn4);

        Random random = new Random();

        final int[] num1 = {random.nextInt(889) + 111};
        final int[] num2 = {random.nextInt(889) + 111};

        txtNum1.setText(String.valueOf(num1[0]));
        txtNum2.setText(String.valueOf(num2[0]));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = num1[0] + num2[0];
                txtResult.setText("Résultat : " + result);
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = num1[0] - num2[0];
                txtResult.setText("Résultat : " + result);
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = num1[0] * num2[0];
                txtResult.setText("Résultat : " + result);
            }
        });

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1[0] = random.nextInt(889) + 111;
                num2[0] = random.nextInt(889) + 111;

                txtNum1.setText(String.valueOf(num1[0]));
                txtNum2.setText(String.valueOf(num2[0]));
                txtResult.setText("Résultat :");
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}