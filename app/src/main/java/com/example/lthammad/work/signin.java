package com.example.lthammad.work;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {
    Button signin;
    EditText email,pass;
    FirebaseAuth mauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mauth=FirebaseAuth.getInstance();
        signin=(Button)findViewById(R.id.signinbutton);
        email=(EditText)findViewById(R.id.emailtext);
        pass=(EditText)findViewById(R.id.passwordtext);

signin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(signin.this,MapsActivity.class);
        startActivity(intent);
    }
});

    }


    public void usersign(String Email,String password)
    {
        Email= email.getText().toString().trim();
        password=pass.getText().toString().trim();
        mauth.signInWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(signin.this, "Signed in Successfully ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(signin.this, "Enter correct email&password ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
