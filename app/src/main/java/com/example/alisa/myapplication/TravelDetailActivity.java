package com.example.alisa.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alisa.myapplication.constants.StringConstants;
import com.example.alisa.myapplication.domain.Travel;
import com.example.alisa.myapplication.repositories.TravelDbRepository;
import com.example.alisa.myapplication.repositories.interfaces.ITravelRepository;

import java.util.Date;

public class TravelDetailActivity extends TravelListActivity {

    private ITravelRepository travelRepository;

    public TravelDetailActivity(){
        travelRepository = TravelDbRepository.getInstance(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_detail);

        Long id = this.getIntent().getLongExtra(StringConstants.ID, 0);
        String startLocation = this.getIntent().getExtras().getString(StringConstants.START_LOCATION);
        String endLocation = this.getIntent().getExtras().getString(StringConstants.END_LOCATION);

        final TextView hiddenId = (TextView) findViewById(R.id.travelId);
        final EditText editStartLocation = (EditText) findViewById(R.id.editStartLocation);
        final EditText editEndLocation = (EditText) findViewById(R.id.editEndLocation);

        editStartLocation.setText(startLocation, TextView.BufferType.EDITABLE);
        editEndLocation.setText(endLocation, TextView.BufferType.EDITABLE);
        hiddenId.setText(id.toString());
    }

    public void sendDetailsToUpdate(View view){
        final TextView hiddenId = (TextView) findViewById(R.id.travelId);
        final EditText editStartLocation = (EditText) findViewById(R.id.editStartLocation);
        final EditText editEndLocation = (EditText) findViewById(R.id.editEndLocation);

        String idString = hiddenId.getText().toString();
        Long id = Long.parseLong(idString);
        String startLocation = editStartLocation.getText().toString();
        String endLocation = editEndLocation.getText().toString();

        Travel travel = new Travel(id, startLocation, endLocation, new Date(), 1);
        travelRepository.updateTravel(travel);

        Intent intent = new Intent(this, TravelListActivity.class);
        startActivity(intent);
    }

    public void cancel(View view){
        Intent intent = new Intent(this, TravelListActivity.class);
        startActivity(intent);
    }
}
