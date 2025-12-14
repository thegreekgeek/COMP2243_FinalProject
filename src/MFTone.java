public class MFTone extends Tone {

    private final double frequency1;
    private final double frequency2;

    public MFTone(double frequency1, double frequency2, int durationMs) {
        super(frequency1, durationMs, 0.55);
        this.frequency1 = frequency1;
        this.frequency2 = frequency2;
    }

    public double[] getFrequencies() {
        return new double[] { frequency1, frequency2 };
    }

    /** Factory for MF digits */
    public static MFTone fromDigit(char d, int durationMs) {
        return switch (d) {
            case '1' -> new MFTone(700, 900, durationMs);
            case '2' -> new MFTone(700, 1100, durationMs);
            case '3' -> new MFTone(900, 1100, durationMs);
            case '4' -> new MFTone(700, 1300, durationMs);
            case '5' -> new MFTone(900, 1300, durationMs);
            case '6' -> new MFTone(1100, 1300, durationMs);
            case '7' -> new MFTone(700, 1500, durationMs);
            case '8' -> new MFTone(900, 1500, durationMs);
            case '9' -> new MFTone(1100, 1500, durationMs);
            case '0' -> new MFTone(1300, 1500, durationMs);
            case 'K' -> new MFTone(1100, 1700, durationMs); // KP
            case 'S' -> new MFTone(1500, 1700, durationMs); // ST
            default -> throw new IllegalArgumentException("Invalid MF digit");
        };
    }
}
