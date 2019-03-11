package de.tub.ise.particle;

import de.tub.ise.Animation;
import de.tub.ise.MagicImageLoader;

import java.io.IOException;

public class Santa extends Sprite {
	
	private int speed = 2;

    public Santa(int x, int y) throws IOException {
        super(MagicImageLoader.getSanta());
        setSpawnX();
        setSpawnY();
    }
    
    /**
     * this method sets the initial x position of the Sprite
     */
    @Override
    protected void setSpawnX() {
        super.x = (Animation.WIDTH/2-100);
    }

    /**
     * this method sets the initial y position of the Sprite
     */
    @Override
    protected void setSpawnY() {
        super.y = (Animation.HEIGHT/2)-60;
    }
    
    @Override
    protected boolean update() {
    	super.x =(super.x+this.speed)%Animation.WIDTH;
    	super.y=(y+(int)(Math.sin(super.x/(speed*2))*10))%Animation.HEIGHT;
    
    	return true;
    }
    
    
}
