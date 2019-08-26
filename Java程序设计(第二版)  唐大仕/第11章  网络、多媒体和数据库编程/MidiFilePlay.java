import javax.sound.midi.*;
import java.io.*;

class MidiFilePlay {
	public static void main(String[] args) {
		Sequencer sequencer;
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();

			File myMidiFile = new File("passport.mid");

			Sequence mySeq = MidiSystem.getSequence(myMidiFile);
			sequencer.setSequence(mySeq);
			sequencer.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}