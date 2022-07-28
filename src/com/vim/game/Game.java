package com.vim.game;
import com.vim.board.Board;
import com.vim.board.ConsoleColors;
import com.vim.board.Square;
import com.vim.players.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    // List of chars used to match the user input to a usable value
    static List<Character> chars = List.of('a', 'b', 'c', 'd', 'e', 'f',  'g', 'h');
    private boolean whitesTurn;
    private boolean playing;
    public static White white;
    public static Black black;
    private Board board;

    public Game() {

        board = new Board();

        white = new White(board.whitePieces);
        black = new Black(board.blackPieces);
        whitesTurn = true;

        Scanner scanner = new Scanner(System.in);

        byte[] currentCoords;
        byte[] destinationCoords;

        playing = true;

        while (playing) {

            String[] input = obtainInput(scanner);

            currentCoords = calculateInput(input[0]);
            destinationCoords = calculateInput(input[1]);

            Square currentSquare = board.chessBoard[currentCoords[0]][currentCoords[1]];

            if (!currentSquare.isSquareOccupied()){
                clearConsole();
                System.out.println("Square has no piece.");
            } else {
               if (!validateColour(currentCoords)){
                   clearConsole();
                   System.out.println("Move a piece of your own colour.");
               } else {
                    clearConsole();
                   currentSquare.getCurrentPiece().calculatePossibleMoves(board, currentSquare);
                   if (board.movePiece(currentSquare, destinationCoords)){
                       whitesTurn = !whitesTurn;
                   }

               }
            }

            board.displayBoard();
            }
        }

         // Typical scanner based input getter from console.
        private String[] obtainInput(Scanner scanner){

            while (true) {
                try {
                    if (whitesTurn){
                        System.out.print("(WHITE) ");
                    } else {
                        System.out.print("(BLACK) ");
                    }


                    System.out.println("\033[3mExample move: h2,h4\033[3m");
                    System.out.print("Enter move ->");
                    String input = scanner.nextLine();

                    if (validateInput(input)) {

                        return input.split(",");

                    } else {
                        clearConsole();
                        System.out.println("Invalid input.");
                        board.displayBoard();
                    }
                } catch (Exception e) {
                    clearConsole();
                    System.out.println("Enter a valid input.");
                    board.displayBoard();
                }

            }
        }

        // Returns an array of bytes, found from the user inputs. Converts the user input
        // into index-able values that can be used for array indexing. Lettering
        // is equal to the columns.
        private byte[] calculateInput(String coord){

            // Converting 'B2' e.g. to an array-index value
            byte newRow = (byte) (8 - Character.getNumericValue(coord.charAt(1)));
            byte newColumn = (byte) chars.indexOf(coord.charAt(0));

            return new byte[]{newRow, newColumn};
        }

        // I'm sure there is a way to optimise this, but
        // this will have to do for now
        private boolean validateInput(String input){

            if (input.length() == 5){
                if (input.charAt(2) == ','){
                    if (chars.contains(input.charAt(0)) && chars.contains(input.charAt(3))){
                        if (Character.isDigit(input.charAt(1)) & Character.isDigit(input.charAt(4))){
                            if (Character.getNumericValue(input.charAt(1)) > 0 && Character.getNumericValue(input.charAt(1)) < 9){
                                return Character.getNumericValue(input.charAt(4)) > 0 && Character.getNumericValue(input.charAt(4)) < 9;
                            } else {return false;}
                        } else {return false;}
                    } else {return false;}
                } else {return false;}
            } else {return false;}
        }

        // Check team so only white can move white etc. If the piece's colour
        // on the starting coord is the same as the current turn's colour, then return true
        private boolean validateColour(byte[] coords){

            return board.findASquare(coords).getCurrentPiece().getColour() == whitesTurn;
        }

        // A method to display available moves that are calculated for
        // the desired piece.
        private void displayAvailableMoves(Square currentSquare){
            for (byte[] b : currentSquare.getCurrentPiece().getPossibleMoves()) {
                System.out.println(Arrays.toString(b));
            }
        }

        private void clearConsole(){
            for (int i = 0; i <=10; i++){
                System.out.println();
            }
        }
    }

