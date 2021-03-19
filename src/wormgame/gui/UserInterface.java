package wormgame.gui;

import wormgame.game.WormGame;

import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {
    private DrawingBoard db;

    private JFrame frame;
    private WormGame wormG;
    private int sideSize;

    public UserInterface(WormGame wormG, int sideSize) {
        this.wormG = wormG;
        this.sideSize = sideSize;
    }

    @Override
    public void run() {
        frame = new JFrame("Worm Game");
        int width = ( wormG.getWidth() + 1 ) * sideSize + 10;
        int height = ( wormG.getHeight() + 2 ) * sideSize + 10;

        frame.setPreferredSize( new Dimension( width, height ) );
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents( frame.getContentPane() );

        frame.pack();
        frame.setVisible( true );

    }

    public void createComponents ( Container container ) {

        db = new DrawingBoard( wormG, sideSize );
        container.add( db );

        KeyboardListener kbl = new KeyboardListener( wormG.getWorm() );

        frame.addKeyListener( kbl );
    }

    public Updatable getUpdatable () {
        return this.db;
    }

    public JFrame getFrame() {
        return frame;
    }
}
