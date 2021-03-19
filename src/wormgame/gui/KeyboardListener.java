package wormgame.gui;

import wormgame.domain.Direction;
import wormgame.domain.Worm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    private Worm worm;

    public KeyboardListener(Worm worm) {
        this.worm = worm;
    }


    @Override
    public void keyPressed( KeyEvent e ) {
        if ( e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            worm.setDirection( Direction.E );
        } else if ( e.getKeyCode() == KeyEvent.VK_LEFT ) {
            worm.setDirection( Direction.W );
        } else if ( e.getKeyCode() == KeyEvent.VK_DOWN ) {
            worm.setDirection( Direction.S );
        } else if ( e.getKeyCode() == KeyEvent.VK_UP ) {
            worm.setDirection( Direction.N );
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
