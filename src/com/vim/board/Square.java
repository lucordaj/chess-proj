package com.vim.board;

import com.vim.pieces.Piece;

public class Square {

    private Piece currentPiece;
    private boolean isOccupied;
    // Colour is determined by True (white) and False (black)
    private boolean colour;
    private char colourGraphic;
    private final byte row;
    private final byte col;

    public Square(byte row, byte col){
        this.row = row; this.col = col;
        determineSquareColour();

    }

    private void determineSquareColour(){

        // By adding together the position values of each square, each black square will always
        // be an odd number when both values are combined, and each white square even.

        byte tempVar = (byte) (this.row + this.col);
        this.colour = tempVar % 2 == 0;
    }

    protected void setCurrentPiece(Piece piece){
        this.currentPiece = piece;
        this.isOccupied = true;
    }
    public void removeCurrentPiece(){this.currentPiece = null; this.isOccupied = false;}
    public boolean isSquareOccupied(){return this.isOccupied;}
    public Piece getCurrentPiece(){return this.currentPiece;}
    public boolean getColour(){return this.colour;}
    public char getColourGraphic(){return this.colourGraphic;}
    public byte getRow(){return this.row;}
    public byte getCol(){return this.col;}
}
