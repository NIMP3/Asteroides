package com.yovanydev.asteroides.model;

import java.util.Vector;

public interface RaitingStore {
    public void saveRaiting(int score, String name, long date);
    public Vector<String> raitingList(int quantity);
}
