package com.example.localadmin.toiletsamadhan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by localadmin on 15/09/17.
 */

public class DisplayPlace extends AppCompatActivity {
    int from_Where_I_Am_Coming = 0;
    public AddPlaceByUserDB mydb ;

    TextView palceName ;
    TextView placeDescription;
    TextView comment;
    TextView rating;
    TextView lati;
    TextView longit;
    EditText palceNamEdit ;
    EditText palceDescEdit;
    EditText commentEdit;
//    EditText ratingEdit;
    Button save,view;
    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_add_places);
        palceNamEdit = (EditText) findViewById(R.id.placeNameEdit);
        commentEdit = (EditText) findViewById(R.id.commentsEdit);
        palceDescEdit = (EditText) findViewById(R.id.placeDescEdit);
//        ratingEdit = (EditText) findViewById(R.id.ratingsEdit);
        save = (Button) findViewById(R.id.save);
        view = (Button) findViewById(R.id.view);

        mydb = new AddPlaceByUserDB(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String plName ="", plDesc="", plComments="", plRating="";
                plName = palceNamEdit.getText().toString();
                plDesc = palceDescEdit.getText().toString();
                plComments = commentEdit.getText().toString();
//                plRating = ratingEdit.getText().toString();
//                mydb = new AddPlaceByUserDB(this);
//                mydb.insertNewPlace(23.32,44.56,plName,plDesc,plComments, Integer.parseInt(plRating));
                mydb.insertNewPlace(23.32,44.56,plName,plDesc,plComments);
                Toast.makeText(DisplayPlace.this,"values entered",Toast.LENGTH_LONG).show();
            }
        });

//        mydb = new AddPlaceByUserDB(this);
//
//        Bundle extras = getIntent().getExtras();
//        if(extras !=null) {
//            int Value = extras.getInt("id");
//
//            if(Value>0){
//                //means this is the view part not the add contact part.
//                Cursor rs = mydb.getData(Value);
//                id_To_Update = Value;
//                rs.moveToFirst();
//
//                String name = rs.getString(rs.getColumnIndex(AddPlaceByUserDB.PLACENAME));
//                String desc = rs.getString(rs.getColumnIndex(AddPlaceByUserDB.DESCRIPTION));
//                String comments = rs.getString(rs.getColumnIndex(AddPlaceByUserDB.COMMENTS));
//                String ratings = rs.getString(rs.getColumnIndex(AddPlaceByUserDB.RATINGS));
//                String lat = rs.getString(rs.getColumnIndex(AddPlaceByUserDB.LATITUDE));
//                String longi = rs.getString(rs.getColumnIndex(AddPlaceByUserDB.LONGITUDE));
//
//                if (!rs.isClosed())  {
//                    rs.close();
//                }
//                Button save = (Button)findViewById(R.id.save);
//                Button view = (Button)findViewById(R.id.view);
//                save.setVisibility(View.INVISIBLE);
//
//                palceName.setText((CharSequence)name);
//
//                placeDescription.setText((CharSequence)desc);
//
//                comment.setText((CharSequence)comments);
//
//                lati.setText((CharSequence)lat);
//
//                longit.setText((CharSequence)longi);
//            }
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        Bundle extras = getIntent().getExtras();
//
//        if(extras !=null) {
//            int Value = extras.getInt("id");
//            if(Value>0){
//                getMenuInflater().inflate(R.menu.display_contact, menu);
//            } else{
//                getMenuInflater().inflate(R.menu.menu_main menu);
//            }
//        }
//        return true;
//    }
//
//    public void run(View view) {
//        Bundle extras = getIntent().getExtras();
//        if(extras !=null) {
//            int Value = extras.getInt("id");
//            if(Value>0){
//                if(mydb.updateContact(id_To_Update,name.getText().toString(),
//                        phone.getText().toString(), email.getText().toString(),
//                        street.getText().toString(), place.getText().toString())){
//                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                    startActivity(intent);
//                } else{
//                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
//                }
//            } else{
//                if(mydb.insertContact(name.getText().toString(), phone.getText().toString(),
//                        email.getText().toString(), street.getText().toString(),
//                        place.getText().toString())){
//                    Toast.makeText(getApplicationContext(), "done",
//                            Toast.LENGTH_SHORT).show();
//                } else{
//                    Toast.makeText(getApplicationContext(), "not done",
//                            Toast.LENGTH_SHORT).show();
//                }
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(intent);
//            }
//        }
    }
}
