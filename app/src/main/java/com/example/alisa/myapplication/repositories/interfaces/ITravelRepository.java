package com.example.alisa.myapplication.repositories.interfaces;

import com.example.alisa.myapplication.domain.Travel;

import java.util.List;

/**
 * Created by Alisa on 11/3/2016.
 */

public interface ITravelRepository {
    public List<Travel> getTravelsByUser(long userId);
    public void updateTravel(Travel travel);
}
