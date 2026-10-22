package com.Step1.app1;

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

public class MainActivity extends AppCompatActivity {

    private TextInputEditText emailInput;
    private TextInputEditText passwordInput;

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

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        MaterialButton btnLogin = findViewById(R.id.btnlogin);

        btnLogin.setOnClickListener(v -> handleLogin());

        findViewById(R.id.forgotPassword).setOnClickListener(v ->
                Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
        );

        findViewById(R.id.registerLink).setOnClickListener(v -> finish());

        findViewById(R.id.btnGoogle).setOnClickListener(v ->
                Toast.makeText(this, "Google Sign-In clicked", Toast.LENGTH_SHORT).show()
        );

        findViewById(R.id.btnFacebook).setOnClickListener(v ->
                Toast.makeText(this, "Facebook Sign-In clicked", Toast.LENGTH_SHORT).show()
        );

        findViewById(R.id.btnGithub).setOnClickListener(v ->
                Toast.makeText(this, "GitHub Sign-In clicked", Toast.LENGTH_SHORT).show()
        );
    }

    private void handleLogin() {
        String email = emailInput.getText() != null ? emailInput.getText().toString().trim() : "";
        String password = passwordInput.getText() != null ? passwordInput.getText().toString().trim() : "";

        if (TextUtils.isEmpty(email)) {
            emailInput.setError("Please enter your email or username");
            emailInput.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordInput.setError("Please enter your password");
            passwordInput.requestFocus();
            return;
        }

        Toast.makeText(this, "Logging in with " + email, Toast.LENGTH_SHORT).show();
    }
}