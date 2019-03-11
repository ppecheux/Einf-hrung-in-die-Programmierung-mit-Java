package de.tub.ise;

import de.tub.ise.particle.Santa;
import de.tub.ise.particle.SnowFlake;
import de.tub.ise.particle.SnowFlakeOne;
import de.tub.ise.particle.SnowFlakeThree;
import de.tub.ise.particle.SnowFlakeTwo;
import de.tub.ise.particle.Sprite;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;

public class Animation {

	/**
	 * This method is used to add snow flakes to the animation
	 * @param painter
	 * @throws IOException
	 */
    private static void addSnow(Animation painter) throws IOException {
    	painter.add(new SnowFlakeOne());
    	painter.add(new SnowFlakeTwo());
    	painter.add(new SnowFlakeThree());
    	painter.add(new SnowFlakeOne());
    	painter.add(new SnowFlakeTwo());
    	painter.add(new SnowFlakeThree());
    	painter.add(new SnowFlakeOne());
    	painter.add(new SnowFlakeTwo());
    	painter.add(new SnowFlakeThree());
    }

    //DO NOT CHANGE ANYTHING BELOW
    
    public static void main(String[] args) throws IOException {
        Animation painter = new Animation();

        painter.add(new Santa(200,100));

        addSnow(painter);

        painter.build();
    }


    

    public static final int WIDTH = 680;
    public static final int HEIGHT = 480;

    final PixelPanel panel;

    private Animation(){
        panel = new PixelPanel(WIDTH,HEIGHT,60);
    }

    private void build(){
        JFrame frame = new JFrame("XMAS");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private void add(Sprite sprite){
        panel.add(sprite);
    }

}
