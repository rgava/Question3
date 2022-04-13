package com.example.ophid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        addButtonListener();
    }

    public void addButtonListener(){

        Button btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {


            //@Override

            public void onClick(View view) {


                    Intent intent1 = new Intent(Welcome.this,NewPatient.class);

                    startActivity(intent1);




            }
        });
  /*      btnlogin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String usernamevalue = username.getText().toString();
                String passwordvalue =password.getText().toString();



                if(usernamevalue.equals("ophid") && passwordvalue.equals("ophid"))
                {
                    //Intent x =new Intent(this, MainActivity.class);
                    Toast.makeText(getBaseContext(),
                            "It works",
                            Toast.LENGTH_SHORT).show();

                }
                else

                {

                    Toast.makeText(getBaseContext(),
                            "Wrong credentials, please try again",
                            Toast.LENGTH_SHORT).show();

                }

            }
        });*/
    }
}
