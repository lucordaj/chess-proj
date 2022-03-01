package com.vim.pieces;

import com.vim.board.Board;
import com.vim.board.Square;

public class Pawn extends Piece{

    public byte timesMoved;

    public Pawn(boolean colour, String fName, char sName, byte value, char symbol) {
        super(colour, fName, sName, value, symbol);

    }

    @Override
    public void calculatePossibleMoves(Board board, Square currentSquare) {

        Square leftDiagonalSquare = new Square((byte) 0, (byte) 0);
        Square rightDiagonalSquare = new Square((byte) 0, (byte) 0);

        if (timesMoved == 0){
            this.possibleMoves.add(new byte[]{(byte) (currentSquare.getRow() + 2), currentSquare.getCol()});
        }
            this.possibleMoves.add(new byte[]{(byte) (currentSquare.getRow() + 1), currentSquare.getCol()});

        // If the column is on the edge of the board, obviously you cannot take a piece that isn't
        // on the board, so must ensure a square that is out of bounds doesn't get created.
        if (currentSquare.getCol() == 7){
            leftDiagonalSquare = board.chessBoard[currentSquare.getRow() - 1][currentSquare.getCol() - 1];
        } else if (currentSquare.getCol() == 0){
            rightDiagonalSquare = board.chessBoard[currentSquare.getRow() - 1][currentSquare.getCol() + 1];
        } else {
            leftDiagonalSquare = board.chessBoard[currentSquare.getRow() - 1][currentSquare.getCol() - 1];
            rightDiagonalSquare = board.chessBoard[currentSquare.getRow() - 1][currentSquare.getCol() + 1];
        }

        if (leftDiagonalSquare.isSquareOccupied() && leftDiagonalSquare.getCurrentPiece().getColour() != this.colour){
            this.possibleMoves.add(new byte[]{(byte) (currentSquare.getRow() - 1), (byte) (currentSquare.getCol() - 1)});
        } else if (rightDiagonalSquare.isSquareOccupied() && rightDiagonalSquare.getCurrentPiece().getColour() != this.colour){
            this.possibleMoves.add(new byte[]{(byte) (currentSquare.getRow() - 1), (byte) (currentSquare.getCol() + 1)});
        }

    }

}


