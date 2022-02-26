package com.vim.pieces;



public class Piece {

    private final String fName;
    private final char sName;
    private final byte value;
    private final char symbol;
    private final boolean colour;


    protected Piece(boolean colour, String fName, char sName, byte value, char symbol){
        // NOTE: If you swap around these variables, they become unable to be assigned properly and
        // can become null.
        this.fName = fName; this.sName = sName; this.value = value; this.symbol = symbol ;
        this.colour = colour;
    }

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








}
