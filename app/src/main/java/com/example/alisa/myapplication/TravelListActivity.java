package com.example.alisa.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alisa.myapplication.constants.StringConstants;
import com.example.alisa.myapplication.domain.Travel;
import com.example.alisa.myapplication.repositories.TravelRepository;
import com.example.alisa.myapplication.repositories.interfaces.ITravelRepository;

import java.util.List;

public class TravelListActivity extends AppCompatActivity {

    private ListView mListView;
    protected static ITravelRepository travelRepository = new TravelRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travellist);

        mListView = (ListView) findViewById(R.id.travel_list_view);
        final List<Travel> travelList = travelRepository.getTravelsByUser(1);
        String[] listItems = new String[travelList.size()];

        for (int i = 0; i < travelList.size(); i++) {
            Travel travel = travelList.get(i);
            listItems[i] = "From " + travel.getStartLocation() + " to " + travel.getEndLocation();
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Travel travel = travelList.get(position);
                Intent intent = new Intent(v.getContext(), TravelDetailActivity.class);

                intent.putExtra(StringConstants.ID, travel.getId());
                intent.putExtra(StringConstants.START_LOCATION, travel.getStartLocation());
                intent.putExtra(StringConstants.END_LOCATION, travel.getEndLocation());

                startActivity(intent);
            }
        });
    }
}
