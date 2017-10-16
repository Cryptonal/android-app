package com.example.lthammad.work;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import static android.R.attr.name;

public class signup extends AppCompatActivity implements View.OnClickListener {

    EditText username,email,password;
    Button signup;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        auth=FirebaseAuth.getInstance();
        username=(EditText)findViewById(R.id.usernamesignup);
        email=(EditText)findViewById(R.id.signupemail);
        password=(EditText)findViewById(R.id.passwordsignup);
        signup=(Button)findViewById(R.id.signup);
        signup.setOnClickListener(this);

    }

    public void saveuser(String Email,String Password)
    {
        Email=email.getText().toString().trim();
        Password=password.getText().toString().trim();
        auth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(signup.this,"User created Successfully ",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(signup.this,"Sorry this email already exist.......  ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        saveuser(email.getText().toString().trim(),password.getText().toString().trim());


    }
    public void savedata(){

        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference mref=database.getReference("Hammad");
        String getusername=username.getText().toString().trim();
        DatabaseReference refrence;
        refrence=mref.push().child("Information");
        refrence.child("Username").setValue(getusername);


    }

}
