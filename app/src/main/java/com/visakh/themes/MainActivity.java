package com.visakh.themes;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] themes = { "Light", "Dark", "Black", "Red", "Green", "Blue", "Yellow", "Purple"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMyTheme();

        setContentView(R.layout.activity_main);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,themes);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }


    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

        SharedPreferences.Editor editor = getSharedPreferences("theme", MODE_PRIVATE).edit();
        editor.putString("style", themes[position]);
        editor.apply();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    public void changeTheme(View view) {
        recreate();
    }

    public void setMyTheme(){
        SharedPreferences prefs = getSharedPreferences("theme", MODE_PRIVATE);
        String style = prefs.getString("style", null);
        if (style == null) {
            style = themes[0];
        }
        switch (style){
            case "Light":
                setTheme(R.style.AppTheme_light);
                break;
            case "Dark":
                setTheme(R.style.AppTheme_dark);
                break;
            case "Black":
                setTheme(R.style.AppTheme_black);
                break;
            case "Red":
                setTheme(R.style.AppTheme_red);
                break;
            case "Green":
                setTheme(R.style.AppTheme_green);
                break;
            case "Blue":
                setTheme(R.style.AppTheme_blue);
                break;
            case "Yellow":
                setTheme(R.style.AppTheme_yellow);
                break;
            case "Purple":
                setTheme(R.style.AppTheme_purple);
                break;
        }
    }
}
