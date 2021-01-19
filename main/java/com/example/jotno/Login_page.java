package com.example.jotno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login_page extends AppCompatActivity {
    private EditText username,password ;
    private Button login,load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username =(EditText)findViewById(R.id.user);
        password=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.login);
       // load=(Button)findViewById((R.id.load));



        login.setOnClickListener(new View.OnClickListener() {
            @Override

           public void onClick(View view) {

                  if(username.getText().toString().matches("")) {
                      Toast.makeText(Login_page.this,"please provid the username",Toast.LENGTH_SHORT).show();

                  }
                  else
                  {
                   //   Toast.makeText(Login_page.this,username.getText().toString(),Toast.LENGTH_SHORT).show();
                      SharedPreferences sharedPreferences=getSharedPreferences("tutor_detail", Context.MODE_PRIVATE);
                      SharedPreferences.Editor editor=sharedPreferences.edit();
                      editor.putString("username",username.getText().toString());
                      editor.putString("password",password.getText().toString());
                      editor.commit();
                      Intent intent = new Intent(Login_page.this, profile.class);
                      String name = username.getText().toString();
                      intent.putExtra("name", name);
                      startActivity(intent);


                  }



            }
        });
        /*

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                      SharedPreferences sharedPreferences = getSharedPreferences("tutor_detail",Context.MODE_PRIVATE);
                      if(sharedPreferences.contains("username")&&sharedPreferences.contains("password"))
                      {
                          StringBuilder dataloader= new StringBuilder();
                          String usennameloaded=sharedPreferences.getString("username","kas koros na ken be ?");
                          String passwordloaded=sharedPreferences.getString("password","hello");
                          dataloader.append((usennameloaded+'\n'));
                          dataloader.append(passwordloaded+'\n');
                          Toast.makeText(Login_page.this,dataloader.toString(),Toast.LENGTH_SHORT).show();
                          //Toast.makeText(Login_page.this,usennameloaded,Toast.LENGTH_SHORT).show();
                      }
                      else {
                          Toast.makeText(Login_page.this,"hi there",Toast.LENGTH_SHORT).show();

                      }
            }
        });
        */





    }
}