package wormgame.game;

import wormgame.gui.Updatable;
import wormgame.domain.Apple;
import wormgame.domain.Direction;
import wormgame.domain.Worm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private Worm worm;
    private Apple apple;
    private Random rand1;
    private Random rand2;
    private boolean continues;
    private Updatable updatable;

    public WormGame ( int width, int height ) {

        super( 1000, null );

        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm( this.width / 2, this.height / 2, Direction.S );

        while ( true ) {
            rand1 = new Random();
            rand2 = new Random();

            int x = rand1.nextInt(this.width);
            int y = rand2.nextInt(this.height);
            apple = new Apple( x, y );

            if ( !worm.runsInto( apple )) break;
        }

        addActionListener( this );
        setInitialDelay( 2000 );
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if ( !this.continues ) {
            return;
        }

        worm.move();
        if ( worm.runsInto( apple ) ) {

            worm.grow();

            while ( true ) {

                apple = new Apple( new Random().nextInt( width ),new Random().nextInt( height ) );

                if ( !worm.runsInto( apple ) ) break;

            }
        }
        if ( worm.runsIntoItself() ) {
            this.continues = false;
        }

        if ( worm.getLastWormPiece().getX() <= 0 || worm.getLastWormPiece().getX() >= this.width ) continues = false;

        if ( worm.getLastWormPiece().getY() <= 0 || worm.getLastWormPiece().getY() >= this.height ) continues = false;

        updatable.update();
        setDelay( 1000 / worm.getLength( ) );
    }



    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

   /* public Apple createApple (  ) {
        Apple tempApple;
        int x = 0, y = 0;

        while ( true ) {

            x = rand.nextInt( this.width ) ;
            y = rand.nextInt( this.height );
            tempApple = new Apple( x, y );

            if ( worm.runsInto( tempApple ) ) break;

        }

        return  tempApple;
    }*/

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }
}
