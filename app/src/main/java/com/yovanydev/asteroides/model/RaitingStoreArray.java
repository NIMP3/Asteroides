package com.yovanydev.asteroides.model;

import java.util.Vector;

public class RaitingStoreArray implements RaitingStore {

    private Vector<String> raitings;

    public RaitingStoreArray() {
        raitings = new Vector<>();

        raitings.add("123000 - Juan Carlos");
        raitings.add("111000 - Andres Felipe");
        raitings.add("011000 - Pedro Pablo");
    }

    @Override
    public void saveRaiting(int score, String name, long date) {
        raitings.add(0, score + " - " + name);
    }

    @Override
    public Vector<String> raitingList(int quantity) {
        return raitings;
    }
}
