package ar.gob.afip.mobile.android.tutorial.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import ar.gob.afip.mobile.android.tutorial.login.utils.Validator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText mUserEmail;
    TextInputEditText mUserPassword;
    Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserEmail = findViewById(R.id.user_email_edit_text);
        mUserPassword = findViewById(R.id.user_password_edit_text);
        mLoginButton = findViewById(R.id.login_button);

        mLoginButton.setOnClickListener(this);

        Log.d(MainActivity.class.getSimpleName(), "onCreate");
    }


    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.login_button) {
            String email = mUserEmail.getText().toString();
            String password = mUserPassword.getText().toString();


            boolean valid = true;
            String errorMsg = "";
            if (! Validator.validateEmail(email)){
                errorMsg += getString(R.string.invalid_email);
                mUserEmail.setError(errorMsg);
                valid = false;
            }
            if (! Validator.validatePassword(password)){
                errorMsg += getString(R.string.invalid_password);
                valid = false;
            }


            if (!valid){
                Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
                Log.d("TAG", errorMsg);
            }
        }
    }
}
