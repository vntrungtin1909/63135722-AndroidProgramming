package com.example.vd2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // Khai báo tên đăng nhập và mật khẩu đúng
    private static final String CORRECT_USERNAME = "Brovu";
    private static final String CORRECT_PASSWORD = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void XacNhanLogin(View v){
        // Lấy đối tượng EditText cho tên đăng nhập và mật khẩu
        EditText edtUsername = findViewById(R.id.editTextUsername);
        EditText edtPassword = findViewById(R.id.editTextPassword);

        // Lấy chuỗi từ EditText
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        // Kiểm tra nếu tên đăng nhập và mật khẩu đúng
        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
            // Nếu đúng, chuyển sang activity mới
            Intent iXacNhan = new Intent(this, HomeActivity.class);
            startActivity(iXacNhan);
        } else {
            // Nếu sai, hiển thị thông báo lỗi
            Toast.makeText(this, "Tên đăng nhập hoặc mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
        }
    }
}
