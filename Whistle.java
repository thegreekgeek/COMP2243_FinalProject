public class Whistle {
    private final double baseFrequency;

    public Whistle(double baseFrequency) {
        this.baseFrequency = baseFrequency;
    }

    public Tone blow(int durationMs) {
        // Creates a tone at the whistle’s base frequency.
        return new Tone(baseFrequency, durationMs, 1.0);
    }

    public Tone blowSoft(int durationMs) {
        return new Tone(baseFrequency, durationMs, 0.4);
    }
}
