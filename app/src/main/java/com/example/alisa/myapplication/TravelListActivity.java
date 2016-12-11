package com.example.alisa.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.*;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.alisa.myapplication.constants.StringConstants;
import com.example.alisa.myapplication.dialogs.AddTravelDialog;
import com.example.alisa.myapplication.domain.Travel;
import com.example.alisa.myapplication.repositories.TravelDbRepository;
import com.example.alisa.myapplication.repositories.interfaces.ITravelRepository;

import java.util.List;

public class TravelListActivity extends FragmentActivity implements AddTravelDialog.NoticeDialogListener{

    private ListView mListView;
    private ITravelRepository travelRepository;

    public TravelListActivity(){
        travelRepository = TravelDbRepository.getInstance(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travellist);

        mListView = (ListView) findViewById(R.id.travel_list_view);
//        long id = travelRepository.addTravel(new Travel("Medias", "Cluj"));
//        long id = travelRepository.addTravel(new Travel("Oradea", "Bucuresti"));
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

    public void onAddButttonClick(View view){
        DialogFragment newFragment = new AddTravelDialog();
        newFragment.show(getSupportFragmentManager(), "missiles");
    }

    @Override
    public void onDialogPositiveClick(DialogInterface dialog) {
        Dialog d = (Dialog) dialog;
        final EditText addStartLocation = (EditText) d.findViewById(R.id.addStartLocation);
        final EditText addEndLocation = (EditText) d.findViewById(R.id.addEndLocation);
        String startLocation = addStartLocation.getText().toString();
        String endLocation = addEndLocation.getText().toString();
        Travel travel = new Travel (startLocation, endLocation);
        travelRepository.addTravel(travel);
        Intent intent = new Intent(this, TravelListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDialogNegativeClick(DialogInterface dialog) {
        Intent intent = new Intent(this, TravelListActivity.class);
        startActivity(intent);
    }
}

