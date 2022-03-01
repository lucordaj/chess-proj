package com.vim.pieces;

import com.vim.board.Board;
import com.vim.board.Square;

public class Knight extends Piece {
    public Knight(boolean colour, String fName, char sName, byte value, char symbol) {
        super(colour, fName, sName, value, symbol);

    }

    @Override
    public void calculatePossibleMoves(Board board, Square currentSquare) {

    }
}
