public class Tone {

    private final double FREQUENCY;
    private final int DURATION_MS;
    private final double AMPLITUDE; // 0.0–1.0

    public Tone(double FREQUENCY, int DURATION_MS, double AMPLITUDE) {
        this.FREQUENCY = FREQUENCY;
        this.DURATION_MS = DURATION_MS;
        this.AMPLITUDE = AMPLITUDE;
    }

    public double[] getFrequencies() {
        return new double[] { FREQUENCY };
    }

    public int getDurationMs() {
        return DURATION_MS;
    }

    public double getAmplitude() {
        return AMPLITUDE;
    }
}
