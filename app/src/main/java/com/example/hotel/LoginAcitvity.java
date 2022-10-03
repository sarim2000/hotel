package com.example.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotel.Util.CurrentUser;
import com.example.hotel.Util.Reader;
import com.example.hotel.Util.User;

public class LoginAcitvity extends AppCompatActivity {
    EditText namer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acitvity);
    }

    public void doLogin(View view){
        User user = null;
        user = Reader.getUserList(getApplicationContext());
        namer = findViewById(R.id.username);
        String name = namer.getText().toString();
        if(user.getUsers().contains(name))
        {
            CurrentUser cuser = new CurrentUser(name);
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(),"Sorry",Toast.LENGTH_LONG).show();
    }
}
