package com.rohit.listview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv=(ListView) findViewById(R.id.List_View);
        String[] teams = getResources().getStringArray(R.array.teams);
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.List_View, teams));

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               String team = ((TextView) view).getText().toString();
               Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
               // sending data to new activity
               intent.putExtra("team", team);
               startActivity(intent);

           }
       });

    }
}
