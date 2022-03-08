package com.vim.pieces;

import com.vim.board.Board;
import com.vim.board.Square;

public class Pawn extends Piece{

    public Pawn(boolean colour, String fName, char sName, byte value, char symbol) {
        super(colour, fName, sName, value, symbol);

    }

    // Another issue is piece colour, if the piece is white, the calculation must subtract
    // from the row (ascend matrix/board), if black then add to the row (to descend the matrix/board).
    // All ternary operations seen in this function are to determine which colour is moving.
    @Override
    public void calculatePossibleMoves(Board board, Square currentSquare) {

        byte[] move;
        Square leftDiagonalSquare = new Square((byte) 0, (byte) 0);
        Square rightDiagonalSquare = new Square((byte) 0, (byte) 0);

        // Two separate if blocks for if the piece is black or white.

        if (this.colour) {
            if (firstMove && !board.chessBoard[currentSquare.getRow() - 2][currentSquare.getCol()].isSquareOccupied()){
                possibleMoves.add(new byte[]{(byte) (currentSquare.getRow() - 2), currentSquare.getCol()});
            }
            if (!board.chessBoard[currentSquare.getRow() - 1][currentSquare.getCol()].isSquareOccupied()){
                possibleMoves.add(new byte[]{(byte) (currentSquare.getRow() - 1), currentSquare.getCol()});
            }

        }
        if (!this.colour){
            if (firstMove && !board.chessBoard[currentSquare.getRow() + 2][currentSquare.getCol()].isSquareOccupied()){
                possibleMoves.add(new byte[]{(byte) (currentSquare.getRow() + 2), currentSquare.getCol()});
            }
            if (!board.chessBoard[currentSquare.getRow() + 1][currentSquare.getCol()].isSquareOccupied()){
                possibleMoves.add(new byte[]{(byte) (currentSquare.getRow() + 1), currentSquare.getCol()});
            }
        }

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

        // Must determine if the diagonal square is occupied, and if the square is occupied then
        // what the colour is. If the piece is the same colour as the moving one, it cannot be a valid
        // move, as you cannot take your own pieces.
        if (leftDiagonalSquare.isSquareOccupied() && leftDiagonalSquare.getCurrentPiece().getColour() != this.colour){
           move = (this.colour) ? new byte[]{(byte) (currentSquare.getRow() - 1), (byte) (currentSquare.getCol() - 1)}
                   : new byte[]{(byte) (currentSquare.getRow() + 1), (byte) (currentSquare.getCol() - 1)};
           possibleMoves.add(move);
        } else if (rightDiagonalSquare.isSquareOccupied() && rightDiagonalSquare.getCurrentPiece().getColour() != this.colour){
            move = (this.colour) ? new byte[]{(byte) (currentSquare.getRow() - 1), (byte) (currentSquare.getCol() + 1)}
                    : new byte[]{(byte) (currentSquare.getRow() + 1), (byte) (currentSquare.getCol() + 1)};
            possibleMoves.add(move);
        }

    }

}
// Previous algorithm
 //if (firstMove){
 //        if (this.colour && board.chessBoard[currentSquare.getRow()] - [currentSquare.getCol()])
 //        move = (this.colour) ? new byte[]{(byte) (currentSquare.getRow() - 2), currentSquare.getCol()}
 //        : new byte[]{(byte) (currentSquare.getRow() + 2), currentSquare.getCol()};
 //        possibleMoves.add(move);
 //        }

 //        move = (this.colour) ? new byte[]{(byte) (currentSquare.getRow() - 1), currentSquare.getCol()}
 //        : new byte[]{(byte) (currentSquare.getRow() + 1), currentSquare.getCol()};
 //        possibleMoves.add(move);



