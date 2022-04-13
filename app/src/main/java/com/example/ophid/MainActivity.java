package com.example.ophid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ophid.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Calendar;

//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    Button btnlogin;
    EditText username;
    EditText password;


   // Intent x =new Intent(this, MainActivity.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);

        addButtonListener();


        }

    public void addButtonListener(){

       btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {


            //@Override

            public void onClick(View view) {


                String usernamevalue = username.getText().toString();
                String passwordvalue =password.getText().toString();



                if(usernamevalue.equals("ophid") && passwordvalue.equals("ophid"))
                {
                    //Intent x =new Intent(this, MainActivity.class);
                    Intent intent1 = new Intent(MainActivity.this,Welcome.class);

                    startActivity(intent1);


                }
                else

                {
                    Intent intent1 = new Intent(MainActivity.this,Welcome.class);

                    startActivity(intent1);
                    //Toast toast = Toast.makeText(getApplicationContext(),"musdara",Toast.LENGTH_SHORT);
                    //toast.show();

                }

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

class MySQLiteOpenHelper extends SQLiteOpenHelper {

    // database name
    private static final String DATABASE_NAME = "ophiddatabase";

    // table name
    private static final String TABLE_NAME = "user";
    private static final String TABLE_NAME_PATIENT = "patient";

    // database version
    private static final int DATABASE_VERSION = 1;

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String CLIENTNAME= "clientname";
    public static final String CLIENTGENDER = "clientgender";
    public static final String DATEOFBIRTH = "dateofbirth";


    // sql to create table
    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_NAME
            + " ("
            + USERNAME + " TEXT, "
            + PASSWORD + " TEXT"
            + ");";


    // sql to create table
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME_PATIENT
            + " ("
            + CLIENTNAME + " TEXT PRIMARY KEY, "
            + CLIENTGENDER + " TEXT DEFAULT '', "
            + DATEOFBIRTH + " TEXT DEFAULT ''"
            + ");";

    // sql to drop table
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String DROP_TABLE_ADMIN = "DROP TABLE IF EXISTS " + TABLE_NAME_PATIENT;

    // custom constructor
    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //  db.execSQL(DROP_TABLE);
        //  db.execSQL(DROP_TABLE_ADMIN);
        //  onCreate(db);
    }

   /* public boolean updateNameStatus(int id, int status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_STATUS, status);
        db.update(TABLE_NAME, contentValues, NOVO_ID + "=" + id, null);
        // db.close();
        return true;
    }*/

    /*
     * this method will give us all the name stored in sqlite
     * */
    public Cursor getNames() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " ORDER BY ic7 ASC;";
        Cursor c = db.rawQuery(sql, null);
        return c;
    }

    public Cursor getAdminFields()
    {

        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + ";";
        Cursor c = db.rawQuery(sql, null);
        return c;
    }



    /*
     * this method is for getting all the unsynced name
     * so that we can sync it with database
     * */


}