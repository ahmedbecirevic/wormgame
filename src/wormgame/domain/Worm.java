package wormgame.domain;

import java.util.ArrayList;
import java.util.List;

public class Worm {

    private int wormLength;
    private Direction originalDirection;
    private List<Piece> wormStructure;
    private boolean growYesNo;

    public Worm ( int originalX, int originalY, Direction originalDirection ) {

        this.wormLength = 1;
        this.originalDirection = originalDirection;
        wormStructure = new ArrayList<Piece>();
        wormStructure.add( new Piece( originalX, originalY ) );

    }

    public Direction getDirection () {
        return originalDirection;
    }
    public void setDirection ( Direction dir ) { this.originalDirection = dir; }


    public int getLength () {
        return getPieces().size();
    }

    public List<Piece> getPieces () {
        return this.wormStructure;
    }

    public void grow ( ) {
        this.growYesNo = true;
    }


    public void move () {

        if ( wormStructure.size() < 3 ) grow();



        int x = wormStructure.get( getLength() - 1 ).getX();
        int y = wormStructure.get( getLength() - 1 ).getY();


        if ( getDirection() == Direction.N ) {

            wormStructure.add( new Piece( x, y - 1 ) );

        } else if ( getDirection() == Direction.S ) {

            wormStructure.add( new Piece( x, y + 1 ) );

        } else if ( getDirection() == Direction.E ) {

            wormStructure.add( new Piece( x + 1, y ) );

        } else if ( getDirection() == Direction.W ) {

            wormStructure.add( new Piece( x - 1, y ) );

        }

        if ( !growYesNo ) {
            wormStructure.remove( 0 );
        } else {
            this.growYesNo = false;
        }


    }

    public boolean runsInto ( Piece piece ) {

        for ( Piece worm : this.wormStructure ) {

            if ( worm.getX() == piece.getX() && worm.getY() == piece.getY() ) return true;

        }

        return false;
    }

    public boolean runsIntoItself () {

        int headX = wormStructure.get( getLength() - 1 ).getX();
        int headY = wormStructure.get( getLength() - 1 ).getY();

        for ( int i = 0; i < getLength() - 2; i++ ) {

                if ( wormStructure.get( i ).getX() == headX && wormStructure.get( i ).getY() == headY ) {
                    return true;
                }

            }
        return false;
    }

    public Piece getLastWormPiece () {
        return wormStructure.get( getLength() - 1 );
    }
}
