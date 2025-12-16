package com.comp2243.bluebox.tone;

import java.util.ArrayList;
import java.util.List;

public class ToneSequence {

    private final List<Tone> TONES = new ArrayList<>();

    public void add(Tone t) {
        TONES.add(t);
    }

    public List<Tone> getTones() {
        return TONES;
    }

    public int size() {
        return TONES.size();
    }
}
