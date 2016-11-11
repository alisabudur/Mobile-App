package com.example.alisa.myapplication.repositories;

import com.example.alisa.myapplication.domain.Travel;
import com.example.alisa.myapplication.repositories.interfaces.ITravelRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Alisa on 11/3/2016.
 */

public class TravelRepository implements ITravelRepository {

    private List<Travel> travelList;

    public TravelRepository() {
        travelList = new ArrayList<Travel>();
        travelList.add(new Travel(1, "Cluj", "Medias", new Date(), 1));
        travelList.add(new Travel(2, "Medias", "Cluj", new Date(), 1));
        travelList.add(new Travel(3, "Bucuresti", "Baia-Mare", new Date(), 1));
        travelList.add(new Travel(4, "Zalau", "Oradea", new Date(), 1));
    }

    @Override
    public List<Travel> getTravelsByUser(long userId) {
        return travelList;
    }

    @Override
    public void updateTravel(final Travel travel) {
        Travel travelToUpdate = getById(travel.getId());

        if (travelToUpdate != null) {
            travelToUpdate.setStartLocation(travel.getStartLocation());
            travelToUpdate.setEndLocation(travel.getEndLocation());
        }
    }

    public Travel getById(Integer id) {
        for (int i = 0; i < travelList.size(); i++) {
            if (travelList.get(i).getId() == id) {
                return travelList.get(i);
            }
        }
        return null;
    }
}
