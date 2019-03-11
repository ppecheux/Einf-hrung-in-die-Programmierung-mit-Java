import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class MidiThreadPlayer {
	public int noteDuration;
	Synthesizer midiSynth;
	MidiChannel[] mChannels;
	
	public static void main(String[] args) {
		MidiThreadPlayer tp = new MidiThreadPlayer();
		
		int[] cdur = {0,4,7};
		
		int[] ddur = {2,6,9};
		
		int[] gdur = {0,4,7};
		
		tp.playNotes(cdur);
		
		try {
			Thread.currentThread().sleep(tp.noteDuration);
		} catch (InterruptedException e) {}
		
		tp.playNotes(ddur);
	}
	
	/**
	 * 
	 * @param noteDuration pause inbetween two notes
	 */
	public MidiThreadPlayer(int noteDuration) {
		this.noteDuration = noteDuration;
        try {
        	midiSynth = MidiSystem.getSynthesizer();
			midiSynth.open();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
        Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
        mChannels = midiSynth.getChannels();
        midiSynth.loadInstrument(instr[0]);
        
        //Spiele ein C für 100ms. Sonst wird der erste Ton häufig doppelt gespielt
        
        //mChannels[0].noteOn(60, 1);
        //sleep(100);
        //mChannels[0].noteOff(60);
	}
	
	public MidiThreadPlayer() {
		this(500);
	}

	/**
	 * play a single note
	 * @param height where 60 = C
	 */
	public void playNote(final int height) {
		
		new Thread(new Runnable() {
			
			//@Override
			public void run() {
				mChannels[0].noteOn(height, 127);
				try {
					Thread.currentThread().sleep(noteDuration);
				} catch (InterruptedException e) {}
				mChannels[0].noteOff(height, 127);
			}
		}).start();
	}
	
	/**
	 * play multiple notes where 0 = C
	 * @param notes
	 */
	public void playNotes(int[] notes) {
		//kleine Pause, damit man die Methodenaufrufe auseinanderhalten kann
		for(int note: notes) {
			playNote(note+60);
		}
		//Letzte Note bekommt etwas Zeit
	}
	
	public void close() {
		midiSynth.close();
	}
}
