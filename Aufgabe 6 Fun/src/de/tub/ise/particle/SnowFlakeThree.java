package de.tub.ise.particle;

import java.io.IOException;

import de.tub.ise.Animation;

public class SnowFlakeThree extends SnowFlake {
	private double mass = (int)(Math.random()*0.1)-0.02;
	private double gravity = 9.81;
	
	public SnowFlakeThree()throws IOException{
		super();
	}
	
	@Override
    protected boolean update() {
    	super.y += 1-mass*y*gravity;
    	super.x+=-1;
    	return true;
    }

}
