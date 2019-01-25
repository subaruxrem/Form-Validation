package com.muyco.formvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText etUsername, etPassword, etConfirmPassword, etFullName;
    String username, password, confirmPassword, fullName;
    Integer formsuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etFullName = findViewById(R.id.etFullName);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_cancel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnSave:
                formsuccess = 6;

                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                confirmPassword = etConfirmPassword.getText().toString();
                fullName = etFullName.getText().toString();

                if (username.equals("")) {
                    etUsername.setError("This field is required");
                    formsuccess--;
                }

                if (password.equals("")) {
                    etPassword.setError("This field is required");
                    formsuccess--;
                }

                if (!confirmPassword.equals(password)) {
                    etConfirmPassword.setError("Password mismatch");
                    formsuccess--;
                }

                if (fullName.equals("")) {
                    etFullName.setError("This field is required");
                    formsuccess--;
                }

                if (confirmPassword.equals("")) {
                    etConfirmPassword.setError("This field is required");
                    formsuccess--;
                }

                if (formsuccess==6) {
                    Toast.makeText(this, "Form Successfully Validated", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnCancel:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
