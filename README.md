# COMP2243 FINAL PROJECT

## Description
My final project is a blue box, which is an early phone hacking device designed to automatically send signaling tones to telephone trunks for a variety of purposes.

## History
Blue boxes were devices created for exploring the Bell/AT&T telephone network, after a video released in the 1950s gave the burgeoning hobbyist electronics enthusiasts something new to chew on. Prior to digital telephone networks introducing out-of-band signalling, information about the number dialed was sent over the voice channel, which was used to route the telephone number to its destination. Enterprising induividuals discovered that certain tones could disconnect the call, which eventually led to the discovery that a captain crunch cereal box toy boatswain's whistle could reproduce the signal that the phone trunks used to indicate that there was a open line waiting to make a call. This led to John Draper being asked to create an electronic tone generator, which eventually made it's way to the public conciousness as the infamous "Blue Box" (The first one reportedly captured by AT&T security was blue).

## Design
### Backend
The main components are the Tone, ToneSequence, and TonePlayer classes, which establish how the tone is created, arranged and played. The Whistle class was the pre-UI testing class and ended up being incorporated to send the 2600Hz tone.

### Frontend
A sharp-eyed observer will note that there is a mismatch between the keypad implemented and the signals emitted, this is intentional. While the original blue boxes were designed to be used on POTS trunk systems, which used MF signalling, they were commonly made from salvaged telelphone parts, which commonly included a DTMF keypad. The keypad designed for this applicaiton was modelled after the original DTMF/Autovon keypad, which had 16 keys, which added priority signalling.
