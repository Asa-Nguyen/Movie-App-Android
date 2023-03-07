package com.example.movie_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    //Test object Email, Password for firebase
    private FirebaseFirestore firebaseFirestore;
    private TextView username;
    private TextView email;
    private TextView passw;
    private TextView conPassw;

    //Create object of DatabaseReference class
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://movie-app-eb471-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button click=(Button)findViewById(R.id.signUp_btn);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);

//              Test fire base
                firebaseFirestore = FirebaseFirestore.getInstance();
//              Get data from EditTexts

                username = findViewById(R.id.su_fullname_data);
                email =  findViewById(R.id.su_email_data);
                passw =  findViewById(R.id.su_passw_data);
                conPassw = findViewById(R.id.su_confirm_passw_data);

                final String usernameTxt = username.getText().toString();
                final String emailTxt = email.getText().toString();
                final String passwTxt = passw.getText().toString();
                final String conPasswTxt = conPassw.getText().toString();
//              Check is true value
                if(usernameTxt.isEmpty() || emailTxt.isEmpty() || passwTxt.isEmpty() || conPasswTxt.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                }
//              Check passw equals conPassw
                else if(!passwTxt.equals(conPasswTxt)){
                    Toast.makeText(SignUpActivity.this, "Password are not matching", Toast.LENGTH_SHORT).show();
                }else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(emailTxt)){
                                Toast.makeText(SignUpActivity.this, "Email is already registered!", Toast.LENGTH_SHORT).show();
                            }else{
                                databaseReference.child("users").child(emailTxt).child("username").setValue(usernameTxt);
                                databaseReference.child("users").child(emailTxt).child("password").setValue(passwTxt);
                                Toast.makeText(SignUpActivity.this, "Create account successfully!", Toast.LENGTH_SHORT).show();
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


//
    }
}