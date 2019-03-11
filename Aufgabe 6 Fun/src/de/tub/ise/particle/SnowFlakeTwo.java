package de.tub.ise.particle;

import java.io.IOException;

public class SnowFlakeTwo extends SnowFlake {
	
	public SnowFlakeTwo()throws IOException{
		super();
	}
	
	@Override
    protected boolean update() {
    	super.y += 1;
    	super.x= x+(int)(Math.sin(y/3)*10)-1;
    	return true;
    }

}
