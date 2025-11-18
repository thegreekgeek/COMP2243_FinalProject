public class Tone {
    private final double frequency;
    private final int durationMs;
    private final double amplitude; // 0.0–1.0

    public Tone(double frequency, int durationMs, double amplitude) {
        this.frequency = frequency;
        this.durationMs = durationMs;
        this.amplitude = amplitude;
    }

    public double getFrequency() {
        return frequency;
    }

    public int getDurationMs() {
        return durationMs;
    }

    public double getAmplitude() {
        return amplitude;
    }
}
