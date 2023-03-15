package com.example.movie_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.movie_app.Model.HelperClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity {
    //Test object Email, Password for firebase
    private FirebaseFirestore firebaseFirestore;
    private TextView username;
    private TextView email;
    private TextView passw;
    private TextView conPassw;
    //
    private Button btnSignUp;

    //Create object of DatabaseReference class
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://movie-app-eb471-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initUi();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              Get data from EditTexts
                String usernameTxt = username.getText().toString();
                String emailTxt = email.getText().toString();
                String passwTxt = passw.getText().toString();
                String conPasswTxt = conPassw.getText().toString();
                // Check is true value
                if(!usernameTxt.isEmpty() || !emailTxt.isEmpty() || !passwTxt.isEmpty() || !conPasswTxt.isEmpty()){
                    btnSignUp.setBackgroundResource(R.drawable.custom_main_button);
                }
                if(usernameTxt.isEmpty() || emailTxt.isEmpty() || passwTxt.isEmpty() || conPasswTxt.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                }
                // Check passw equals conPassw
                else if(!passwTxt.equals(conPasswTxt)){
                    Toast.makeText(SignUpActivity.this, "Password are not matching", Toast.LENGTH_SHORT).show();
                }
                // Check if email is valid
//                else if(!isValidEmail(emailTxt)){
//                    Toast.makeText(SignUpActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
//                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(usernameTxt) || snapshot.child(usernameTxt).hasChild(emailTxt)){
                                Toast.makeText(SignUpActivity.this, "Email or username is already registered!", Toast.LENGTH_SHORT).show();
                            }else{
                                HelperClass helperClass = new HelperClass(emailTxt, usernameTxt,passwTxt);
                                databaseReference.child("users").child(usernameTxt).setValue(helperClass);
                                Toast.makeText(SignUpActivity.this, "Create account successfully!", Toast.LENGTH_SHORT).show();
                                onSignInActivity();
                                finish();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });
    }

    private void initUi(){
        btnSignUp =(Button)findViewById(R.id.signUp_btn);
        username = findViewById(R.id.su_username_data);
        email =  findViewById(R.id.su_email_data);
        passw =  findViewById(R.id.su_passw_data);
        conPassw = findViewById(R.id.su_confirm_passw_data);
    }

    // check is email value
    public static boolean isValidEmail(CharSequence email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }
    // go to sign-in activity
    public void onSignInActivity(){
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }
}