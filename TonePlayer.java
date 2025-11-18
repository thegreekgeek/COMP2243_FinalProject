import javax.sound.sampled.*;

public class TonePlayer {

    public void play(Tone tone) throws LineUnavailableException {
        float sampleRate = 44100f;
        int samples = (int) ((tone.getDurationMs() * sampleRate) / 1000.0);

        // Stereo (2 channels), 16-bit => 4 bytes per sample (2 per channel)
        byte[] buf = new byte[samples * 4];

        for (int i = 0; i < samples; i++) {
            double angle =
                (2.0 * Math.PI * i * tone.getFrequency()) / sampleRate;
            short value = (short) (Math.sin(angle) *
                32767 *
                tone.getAmplitude());

            // Little-endian
            buf[4 * i] = (byte) (value & 0xff); // Left LSB
            buf[4 * i + 1] = (byte) ((value >> 8) & 0xff); // Left MSB
            buf[4 * i + 2] = buf[4 * i]; // Right LSB
            buf[4 * i + 3] = buf[4 * i + 1]; // Right MSB
        }

        AudioFormat fmt = new AudioFormat(sampleRate, 16, 2, true, false); // Stereo, signed, little-endian

        try (SourceDataLine line = AudioSystem.getSourceDataLine(fmt)) {
            line.open(fmt);
            line.start();
            line.write(buf, 0, buf.length);
            line.drain();
        }
    }
}
