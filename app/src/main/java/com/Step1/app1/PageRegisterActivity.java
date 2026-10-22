package com.Step1.app1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class PageRegisterActivity extends AppCompatActivity {

    private TextInputEditText nameInput;
    private TextInputEditText emailInput;
    private TextInputEditText passwordInput;
    private TextInputEditText confirmPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        MaterialButton btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> handleRegister());

        findViewById(R.id.loginLink).setOnClickListener(v ->
                startActivity(new Intent(PageRegisterActivity.this, MainActivity.class))
        );

        findViewById(R.id.btnGoogle).setOnClickListener(v ->
                Toast.makeText(this, "Google Sign-Up clicked", Toast.LENGTH_SHORT).show()
        );

        findViewById(R.id.btnFacebook).setOnClickListener(v ->
                Toast.makeText(this, "Facebook Sign-Up clicked", Toast.LENGTH_SHORT).show()
        );

        findViewById(R.id.btnGithub).setOnClickListener(v ->
                Toast.makeText(this, "GitHub Sign-Up clicked", Toast.LENGTH_SHORT).show()
        );
    }

    private void handleRegister() {
        String name = nameInput.getText() != null ? nameInput.getText().toString().trim() : "";
        String email = emailInput.getText() != null ? emailInput.getText().toString().trim() : "";
        String password = passwordInput.getText() != null ? passwordInput.getText().toString().trim() : "";
        String confirmPassword = confirmPasswordInput.getText() != null ? confirmPasswordInput.getText().toString().trim() : "";

        if (TextUtils.isEmpty(name)) {
            nameInput.setError("Please enter your full name");
            nameInput.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            emailInput.setError("Please enter your email");
            emailInput.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordInput.setError("Please enter a password");
            passwordInput.requestFocus();
            return;
        }

        if (!TextUtils.equals(password, confirmPassword)) {
            confirmPasswordInput.setError("Passwords do not match");
            confirmPasswordInput.requestFocus();
            return;
        }

        Toast.makeText(this, "Account created for " + name, Toast.LENGTH_SHORT).show();
    }
}