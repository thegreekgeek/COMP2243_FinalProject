public class Main {

    public static void main(String[] args) throws Exception {
        Whistle crunch = new Whistle(2600.0);
        TonePlayer player = new TonePlayer();

        Tone t = crunch.blow(1000);
        player.play(t);
    }
}
