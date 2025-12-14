import java.util.ArrayList;
import java.util.List;

public class ToneSequence {
    private final List<Tone> tones = new ArrayList<>();

    public void add(Tone t) {
        tones.add(t);
    }

    public List<Tone> getTones() {
        return tones;
    }

    public int size() {
        return tones.size();
    }
}
