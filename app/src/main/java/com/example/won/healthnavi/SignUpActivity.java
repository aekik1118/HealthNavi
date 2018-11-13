package com.example.won.healthnavi;

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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        final EditText emailTxt = (EditText) findViewById(R.id.editText3);
        final EditText nameTxt = (EditText) findViewById(R.id.editText6);
        final EditText pwTxt = (EditText) findViewById(R.id.editText5);
        Button signUpBtn = (Button) findViewById(R.id.button);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailTxt.getText().toString();
                String name = nameTxt.getText().toString();
                String pw = pwTxt.getText().toString();

                Toast.makeText(SignUpActivity.this,"가입 신청",Toast.LENGTH_SHORT).show();
                signUpStart(email,name,pw);
            }
        });

    }

    public void signUpStart(String email,final String name,String pw) {
        mAuth.createUserWithEmailAndPassword(email,pw)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(!task.isSuccessful()){
                            try{
                                throw task.getException();
                            }catch (FirebaseAuthWeakPasswordException e){
                                Toast.makeText(SignUpActivity.this,"비밀번호가 간단",Toast.LENGTH_SHORT).show();
                            }catch (FirebaseAuthInvalidCredentialsException e){
                                Toast.makeText(SignUpActivity.this,"email 형식에 맞지 않음",Toast.LENGTH_SHORT).show();
                            }catch (FirebaseAuthUserCollisionException e){
                                Toast.makeText(SignUpActivity.this,"이미 존재하는 email",Toast.LENGTH_SHORT).show();
                            }catch (Exception e){
                                Toast.makeText(SignUpActivity.this,"다시 확인해주세요",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {

                            currentUser = mAuth.getCurrentUser();
                            Toast.makeText(SignUpActivity.this, "가입 성공" + name + " ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this,MainActivity.class));
                            finish();

                        }
                    }
                });


    }
}
