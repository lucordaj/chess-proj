package com.vim.pieces;

import com.vim.board.Board;
import com.vim.board.Square;

public class Pawn extends Piece{

    public byte timesMoved;

    public Pawn(boolean colour, String fName, char sName, byte value, char symbol) {
        super(colour, fName, sName, value, symbol);

    }

    @Override
    public void calculatePossibleMoves(Board board, Square currentSquare, Square desiredSquare) {


        if (timesMoved == 0){
            this.possibleMoves.add(new byte[currentSquare.getRow() + 2][currentSquare.getCol()]);
        }
            this.possibleMoves.add(new byte[currentSquare.getRow() + 1][currentSquare.getCol()]);

        Square leftDiagonalSquare = board.chessBoard[currentSquare.getRow() - 1][currentSquare.getCol() - 1];
        Square rightDiagonalSquare = board.chessBoard[currentSquare.getRow() - 1][currentSquare.getCol() + 1];

        if (leftDiagonalSquare.isSquareOccupied() && leftDiagonalSquare.getCurrentPiece().getColour() != this.colour){
            this.possibleMoves.add(new byte[currentSquare.getRow() - 1][currentSquare.getCol() - 1]);
        } else if (rightDiagonalSquare.isSquareOccupied() && rightDiagonalSquare.getCurrentPiece().getColour() != this.colour){
            this.possibleMoves.add(new byte[currentSquare.getRow() - 1][currentSquare.getCol() + 1]);
        }

    }

}


