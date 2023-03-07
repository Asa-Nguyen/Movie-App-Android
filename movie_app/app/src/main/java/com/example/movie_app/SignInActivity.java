package com.example.movie_app;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignInActivity extends AppCompatActivity {

    private EditText email;
    private EditText passw;
    // Connect database
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://movie-app-eb471-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

//      Set text color gradient SignUp button
        TextView textView = findViewById(R.id.btnSignUp);
        setTextViewColor(textView,
                getResources().getColor(R.color.light_gradient1),
                getResources().getColor(R.color.light_gradient2));

//      This function go to HomeFullActivity
        Button signInClick=(Button)findViewById(R.id.signIn_btn);
        signInClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String emailTxt = email.getText().toString();
                final String passwTxt = passw.getText().toString();

                if(emailTxt.isEmpty() || passwTxt.isEmpty()){
                    Toast.makeText(SignInActivity.this, "Please enter your email or password", Toast.LENGTH_SHORT).show();
                }else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(emailTxt)){
                                final String getPassw = snapshot.child(emailTxt).child("password").getValue(String.class);

                                if(getPassw.equals(passwTxt)){
                                    Toast.makeText(SignInActivity.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                    // Open main activity
                                    onHomeFullActivity();
                                    finish();
                                }else{
                                    Toast.makeText(SignInActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(SignInActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        email = findViewById(R.id.email_data);
        passw = findViewById(R.id.password_data);

//      This function go to SignUpActivity
        Button signUpClick=(Button)findViewById(R.id.btnSignUp);
        signUpClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set text size button
                signUpClick.setTextSize(12);
                onSignUpActivity();
            }
        });



    }

    private void setTextViewColor(TextView textView, int...color) {
        TextPaint paint = textView.getPaint();
        float width = paint.measureText(textView.getText().toString());

        Shader shader = new LinearGradient(0, 0, width, textView.getTextSize(), color, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);
        textView.setTextColor(color[0]);

    }

    private boolean validateEmailAddress(EditText email){
        String emailInput = email.getText().toString();

        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            Toast.makeText(this, "Email Validate Successfully!", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

//  FUNCTION OnClick()
    public void onHomeFullActivity(){
        Intent intent = new Intent(this, HomeFullActivity.class);
        startActivity(intent);
    }

    public void onSignUpActivity(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

}