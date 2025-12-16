public class DTMFTone extends Tone {

    private final double FREQUENCY1;
    private final double FREQUENCY2;

    public DTMFTone(double FREQUENCY1, double FREQUENCY2, int durationMs) {
        super(FREQUENCY1, durationMs, 0.66);
        this.FREQUENCY1 = FREQUENCY1;
        this.FREQUENCY2 = FREQUENCY2;
    }

    public double[] getFrequencies() {
        return new double[] { FREQUENCY1, FREQUENCY2 };
    }

    /** Factory for DTMF digits */
    public static DTMFTone fromDigit(char d, int durationMs) {
        return switch (d) {
            case '1' -> new DTMFTone(697, 1209, durationMs);
            case '2' -> new DTMFTone(697, 1336, durationMs);
            case '3' -> new DTMFTone(697, 1477, durationMs);
            case 'A' -> new DTMFTone(697, 1633, durationMs);
            case '4' -> new DTMFTone(770, 1209, durationMs);
            case '5' -> new DTMFTone(770, 1336, durationMs);
            case '6' -> new DTMFTone(770, 1477, durationMs);
            case 'B' -> new DTMFTone(770, 1633, durationMs);
            case '7' -> new DTMFTone(852, 1209, durationMs);
            case '8' -> new DTMFTone(852, 1336, durationMs);
            case '9' -> new DTMFTone(852, 1477, durationMs);
            case 'C' -> new DTMFTone(852, 1633, durationMs);
            case '*' -> new DTMFTone(941, 1209, durationMs);
            case '0' -> new DTMFTone(941, 1336, durationMs);
            case '#' -> new DTMFTone(941, 1477, durationMs);
            case 'D' -> new DTMFTone(941, 1633, durationMs);
            default -> throw new IllegalArgumentException("Invalid DTMF digit");
        };
    }
}
