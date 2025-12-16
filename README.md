# COMP2243 FINAL PROJECT

## Description

My final project is a blue box, which is an early phone hacking device designed to automatically send signaling tones to telephone trunks for a variety of purposes.

## Features

- MF Tone generator capable of storing and playing series of control signals to an audio device.
- Logging output to keep a record of your current session.


## Usage

Upon launching the program, during normal usage you would dial a long-distance number, then send a 2600Hz tone as it began to ring. This would signal the trunk to disconnect the call, marking it as free, and to listen for new instructions. Then user would then send a "Key Pulse" (mapped to * key), dial the desired number, then finish up with a "Start" Tone (mapped to #). Additionally, this program emulates some of the higher-tier blue box features, which could save a series of MF tones and play them back upon request.

## Building from source

If just is installed you can use the just file to either run the command ```just start``` and build and run the compiled JAR file, or you can run these commands from the source folder:

```powershell
javac -d target/classes src/main/java/com/comp2243/bluebox/Main.java src/main/java/com/comp2243/bluebox/UserInterface.java src/main/java/com/comp2243/bluebox/ui/TextAreaOutputStream.java src/main/java/com/comp2243/bluebox/tone/*.java
java -cp target/classes com.comp2243.bluebox.Main
```

## History

Blue boxes were devices created for exploring the Bell/AT&T telephone network, after a video released in the 1950s gave the burgeoning hobbyist electronics enthusiasts something new to chew on. Prior to digital telephone networks introducing out-of-band signalling, information about the number dialed was sent over the voice channel, which was used to route the telephone number to its destination. Enterprising induividuals discovered that certain tones could disconnect the call, which eventually led to the discovery that a captain crunch cereal box toy boatswain's whistle could reproduce the signal that the phone trunks used to indicate that there was a open line waiting to make a call. This led to John Draper being asked to create an electronic tone generator, which eventually made it's way to the public conciousness as the infamous "Blue Box" (The first one reportedly captured by AT&T security was blue).

## Design

### Backend

The main components are the Tone, ToneSequence, and TonePlayer classes, which establish how the tone is created, arranged and played. The Whistle class was the pre-UI testing class and ended up being incorporated to send the 2600Hz tone.

### Frontend

A sharp-eyed observer will note that there is a mismatch between the keypad implemented and the signals emitted, this is intentional. While the original blue boxes were designed to be used on POTS trunk systems, which used MF signalling, they were commonly made from salvaged telelphone parts, which commonly included a DTMF keypad. The keypad designed for this applicaiton was modelled after the original DTMF/Autovon keypad, which had 16 keys, which added priority signalling.
