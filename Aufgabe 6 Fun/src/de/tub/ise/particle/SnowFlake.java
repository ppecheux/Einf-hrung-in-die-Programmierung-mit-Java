package de.tub.ise.particle;

import de.tub.ise.Animation;
import de.tub.ise.MagicImageLoader;

import java.io.IOException;

public class SnowFlake extends Sprite {


    public SnowFlake() throws IOException {
        super(MagicImageLoader.getSnowFlake());
        setSpawnX();
        setSpawnY((int)(Math.random()*Animation.HEIGHT));
    }


    protected void setSpawnY(int y) {
    	super.y = y;
    }


    @Override
    protected void setSpawnX() {
        super.x = (int)(Math.random()*Animation.WIDTH);
    }

    @Override
    protected boolean update() {
    	super.y += 1;
    	super.x= x+(int)(Math.sin(y/3)*10)-1;
    	return true;
    }
}
