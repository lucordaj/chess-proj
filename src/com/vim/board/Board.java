package com.vim.board;

import com.vim.pieces.*;

import java.util.ArrayList;

public class Board {

    public Square[][] chessBoard = new Square[8][8];
    public ArrayList<Piece> whitePieces = new ArrayList<>();
    public ArrayList<Piece> blackPieces = new ArrayList<>();

    public Board() {

        generateBoard();
        generatePieces();
        initiateAvailablePieces();
        displayBoard();

    }

    // Function to delete piece on square and move it to another. Returns a boolean
    // result to indicate if it was successful or not.
    public boolean movePiece(Square currentSquare, Square destinationSquare){
       return false;
    }
    // Creates an 8x8 chess board in an array of Squares.
    private void generateBoard() {

        for (byte row = 0; row <= 7; row++) {
            for (byte col = 0; col <= 7; col++) {
                chessBoard[row][col] = new Square(row, col);
            }
        }
    }

    // Creates instances of each piece needed for white and black.
    private void generatePieces() {
        // King
        chessBoard[7][4].setCurrentPiece(new King(true, "King", 'K', (byte) 0, '♚'));
        chessBoard[0][4].setCurrentPiece(new King(false, "King", 'K', (byte) 0, '♔'));
        // Queen
        chessBoard[7][3].setCurrentPiece(new Queen(true, "Queen", 'Q', (byte) 9, '♛'));
        chessBoard[0][3].setCurrentPiece(new Queen(false, "Queen", 'Q', (byte) 9, '♕'));
        // Pawns
        for (byte col = 0; col <= 7; col++) {
            chessBoard[6][col].setCurrentPiece(new Pawn(true, "Pawn", 'P', (byte) 1, '♟'));
            chessBoard[1][col].setCurrentPiece(new Pawn(false, "Pawn", 'P', (byte) 1, '♙'));
        }
        // Rook
        chessBoard[7][0].setCurrentPiece(new Rook(true, "Rook", 'R', (byte) 5, '♜'));
        chessBoard[7][7].setCurrentPiece(new Rook(true, "Rook", 'R', (byte) 5, '♜'));
        chessBoard[0][0].setCurrentPiece(new Rook(false, "Rook", 'R', (byte) 5, '♖'));
        chessBoard[0][7].setCurrentPiece(new Rook(false, "Rook", 'R', (byte) 5, '♖'));
        // Knights
        chessBoard[7][1].setCurrentPiece(new Knight(true, "Knight", 'N', (byte) 3, '♞'));
        chessBoard[7][6].setCurrentPiece(new Knight(true, "Knight", 'N', (byte) 3, '♞'));
        chessBoard[0][1].setCurrentPiece(new Knight(false, "Knight", 'N', (byte) 3, '♘'));
        chessBoard[0][6].setCurrentPiece(new Knight(false, "Knight", 'N', (byte) 3, '♘'));
        // Bishops
        chessBoard[7][2].setCurrentPiece(new Bishop(true, "Bishop", 'B', (byte) 3, '♝'));
        chessBoard[7][5].setCurrentPiece(new Bishop(true, "Bishop", 'B', (byte) 3, '♝'));
        chessBoard[0][2].setCurrentPiece(new Bishop(false, "Bishop", 'B', (byte) 3, '♗'));
        chessBoard[0][5].setCurrentPiece(new Bishop(false, "Bishop", 'B', (byte) 3, '♗'));
    }

    // This fills up the arraylists of the white and black available
    // pieces with the relevant pieces.
    private void initiateAvailablePieces(){

        for (int row = 0; row <= 7; row++){
            for (int col = 0; col <= 7; col++){

                Square currentSquare = chessBoard[row][col];

                if (currentSquare.isSquareOccupied()){
                    if (currentSquare.getCurrentPiece().getColour()){
                        whitePieces.add(currentSquare.getCurrentPiece());
                    } else{
                        blackPieces.add(currentSquare.getCurrentPiece());
                    }
                }

            }
        }
    }
    // Displays these pieces and the board in the console. Displays accurately in
    // current Windows 10 IntelliJ build, risk of not displaying properly otherwise
    public void displayBoard() {

        for (byte row = 0; row <= 7; row++) {
            for (byte col = 0; col <= 7; col++) {

                Square currentSquare = chessBoard[row][col];

                if (currentSquare.isSquareOccupied()) {
                    Piece currentPiece = chessBoard[row][col].getCurrentPiece();

                    if (currentPiece.getColour()) {
                        if (currentSquare.getColour()){
                            System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT + ConsoleColors.CYAN_BACKGROUND_BRIGHT + " " + currentPiece.getSymbol() + " ");
                        }else{
                            System.out.print(ConsoleColors.WHITE_BOLD_BRIGHT + ConsoleColors.BLACK_BACKGROUND_BRIGHT + " " + currentPiece.getSymbol() + " ");
                        }
                    } else {
                        if (currentSquare.getColour()){
                            System.out.print(ConsoleColors.BLACK_BOLD_BRIGHT + ConsoleColors.CYAN_BACKGROUND_BRIGHT + " " + currentPiece.getSymbol() + " ");
                        } else {
                            System.out.print(ConsoleColors.BLACK_BOLD_BRIGHT + ConsoleColors.BLACK_BACKGROUND_BRIGHT+ " " + currentPiece.getSymbol() + " ");
                        }
                    }
                } else {
                    if (currentSquare.getColour()){
                        System.out.print(ConsoleColors.CYAN_BACKGROUND + "     ");
                    } else{
                        System.out.print(ConsoleColors.BLACK_BACKGROUND_BRIGHT + "     ");
                    }
                }
            }
            System.out.println(ConsoleColors.RESET);
        }
    }
}
