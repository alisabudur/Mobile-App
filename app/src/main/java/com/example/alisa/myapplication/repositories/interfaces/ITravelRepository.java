package com.example.alisa.myapplication.repositories.interfaces;

import android.content.Context;

import com.example.alisa.myapplication.domain.Travel;

import java.util.List;

/**
 * Created by Alisa on 11/3/2016.
 */

public interface ITravelRepository {
    List<Travel> getTravelsByUser(long userId);
    void updateTravel(Travel travel);
    long addTravel(Travel travel);
}
