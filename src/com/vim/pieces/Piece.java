package com.vim.pieces;


import com.vim.board.Board;
import com.vim.board.Square;

import java.util.ArrayList;

public abstract class Piece {

    protected final String fName;
    protected final char sName;
    protected final byte value;
    protected final char symbol;
    protected final boolean colour;
    public boolean firstMove = true;
    protected ArrayList<byte[]> possibleMoves;


    protected Piece(boolean colour, String fName, char sName, byte value, char symbol){
        // NOTE: If you swap around these variables, they become unable to be assigned properly and
        // can become null.
        this.fName = fName; this.sName = sName; this.value = value; this.symbol = symbol ;
        this.colour = colour;
        this.possibleMoves = new ArrayList<>();
    }

    // Abstract method as each piece's movement will be different.
    public abstract void calculatePossibleMoves(Board board, Square currentSquare);

    public boolean getColour(){ return colour;}

    public String getfName() {
        return fName;
    }

    public char getsName() {
        return sName;
    }

    public byte getValue() {
        return value;
    }

    public char getSymbol() {
        return symbol;
    }

    public ArrayList<byte[]> getPossibleMoves(){return possibleMoves;}


}
