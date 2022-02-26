package com.vim.players;

import com.vim.pieces.Piece;

import java.util.ArrayList;

public class Player {

    private ArrayList<Piece> availablePieces = new ArrayList<>();
    private ArrayList<Piece> capturedPieces = new ArrayList<>();

    public Player(ArrayList<Piece> pieces){
        this.availablePieces = pieces;
    }
    public void pieceTaken(Piece piece){
        capturedPieces.add(piece);
    }
    public void removePiece(Piece piece){
        availablePieces.remove(piece);
    }
}