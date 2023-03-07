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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    //Test object Email, Password for firebase
    private FirebaseFirestore firebaseFirestore;
    private TextView username;
    private TextView email;
    private TextView passw;
    //
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

                //        Test fire base
                firebaseFirestore = FirebaseFirestore.getInstance();

                username =  findViewById(R.id.su_fullname_data);
                email =  findViewById(R.id.su_email_data);
                passw =  findViewById(R.id.su_passw_data);

                String username_data = username.getText().toString().trim();
                String email_data = email.getText().toString().trim();
                String passw_data = passw.getText().toString().trim();


                Map<String, Object> users = new HashMap<>();
                users.put("username", username_data);
                users.put("email", email_data);
                users.put("passw", passw_data);

//        DocumentReference firebaseFirestore;
                firebaseFirestore.collection("users").add(users).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });


//
    }
}