
public class GoUp extends Thread {
	MidiThreadPlayer mp;
	int[] notes = {1,2,3,4};
	
	public GoUp(MidiThreadPlayer mp){
		this.mp=mp;
	}

	@Override
	public void run(){
		synchronized(mp){
			for(int note:notes){
				mp.playNote(note);
				try{
					sleep(mp.noteDuration);
				}catch(InterruptedException e){}
			}
		}
	}
}
