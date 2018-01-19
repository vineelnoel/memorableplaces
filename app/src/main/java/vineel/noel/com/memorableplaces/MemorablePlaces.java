package vineel.noel.com.memorableplaces;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MemorablePlaces extends AppCompatActivity {
    ListView lvPlaces;
    static List<String> places;
    static ArrayAdapter arrayAdapter;
    static List<LatLng> locations;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memorable_places);
        lvPlaces = (ListView) findViewById(R.id.lvPlaces);

        places = new ArrayList<String>();
        places.add("Add a new Place...");
        locations = new ArrayList<LatLng>();
        locations.add(new LatLng(0,0));

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,places);
        lvPlaces.setAdapter(arrayAdapter);

        lvPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),AddingPlaces.class);
                intent.putExtra("locationInfo",i);
                startActivity(intent);
            }
        });
    }

}
