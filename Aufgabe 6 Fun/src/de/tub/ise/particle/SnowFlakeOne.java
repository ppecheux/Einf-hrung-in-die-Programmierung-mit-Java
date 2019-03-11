package de.tub.ise.particle;

import java.io.IOException;

public class SnowFlakeOne extends SnowFlake {
	
	public SnowFlakeOne()throws IOException{
		super();
	}
	
	@Override
    protected boolean update() {
    	super.y += 1;
    	super.x= x+1;
    	return true;
    }

}
