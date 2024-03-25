package com.example.ex5_anynomous;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private EditText edtA;
    private EditText edtB;
    private EditText edtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các EditText
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtRes = findViewById(R.id.edtRes);

        findViewById(R.id.btnCong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        findViewById(R.id.btnTru).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        findViewById(R.id.btnNhan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        findViewById(R.id.btnChia).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
    }

    private void calculate(char operator) {
        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double result;

        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                } else {
                    edtRes.setText("Không thể chia cho 0");
                    return;
                }
                break;
            default:
                return;
        }

        edtRes.setText(String.valueOf(result));
    }
}