package com.comp2243.bluebox.tone;

public class Whistle {

    private final double BASE_FREQUENCY;

    public Whistle(double BASE_FREQUENCY) {
        this.BASE_FREQUENCY = BASE_FREQUENCY;
    }

    private void addSweep(
        ToneSequence seq,
        double startFreq,
        double endFreq,
        int durationMs,
        double amplitude
    ) {
        int stepMs = 10; // resolution of glide (smaller = smoother)
        int steps = durationMs / stepMs;

        double df = (endFreq - startFreq) / steps;

        double f = startFreq;
        for (int i = 0; i < steps; i++) {
            seq.add(new Tone(f, stepMs, amplitude));
            f += df;
        }
    }

    // Produce a simple one-tone sequence
    public ToneSequence blow(int durationMs) {
        ToneSequence seq = new ToneSequence();
        seq.add(new Tone(BASE_FREQUENCY, durationMs, 1.0));
        return seq;
    }

    // More advanced pattern: break the whistle into bursts
    public ToneSequence chirpPattern() {
        ToneSequence seq = new ToneSequence();
        seq.add(new Tone(BASE_FREQUENCY, 100, 1.0));
        seq.add(new Tone(BASE_FREQUENCY, 100, 0.5));
        seq.add(new Tone(BASE_FREQUENCY, 200, 1.0));
        seq.add(new Tone(2700.0, 200, 1.0));
        return seq;
    }

    public ToneSequence captainAboard() {
        ToneSequence seq = new ToneSequence();

        // Step 1: Short high chirp (start attention)
        seq.add(new Tone(1600, 150, 1.0));

        // Step 2: Glide up: 1600 → 2200 Hz in steps
        seq.add(new Tone(1700, 80, 1.0));
        seq.add(new Tone(1850, 80, 1.0));
        seq.add(new Tone(2000, 80, 1.0));
        seq.add(new Tone(2150, 80, 1.0));
        seq.add(new Tone(2200, 80, 1.0)); // peak

        // Step 3: Sustain the high clear note
        seq.add(new Tone(2200, 600, 1.0));

        // Step 4: Glide down: 2200 → 1500 Hz
        seq.add(new Tone(2100, 80, 1.0));
        seq.add(new Tone(1900, 80, 1.0));
        seq.add(new Tone(1700, 80, 1.0));
        seq.add(new Tone(1500, 120, 1.0));

        // Step 5: Brief cutoff/rest effect (optional)
        seq.add(new Tone(0, 120, 0.0)); // silence if your system supports 0 Hz rest
        return seq;
    }

    public ToneSequence captainAboardSweep() {
        ToneSequence seq = new ToneSequence();

        // Step 1: short attention chirp
        seq.add(new Tone(1600, 150, 1.0));

        // Step 2: smooth glide up (1600 → 2200 Hz over ~400 ms)
        addSweep(seq, 1600, 2200, 400, 1.0);

        // Step 3: hold high clear note
        seq.add(new Tone(2200, 600, 1.0));

        // Step 4: smooth glide down (2200 → 1500 Hz over ~400 ms)
        addSweep(seq, 2200, 1500, 400, 1.0);

        return seq;
    }
}
