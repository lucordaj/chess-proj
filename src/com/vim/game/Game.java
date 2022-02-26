package com.vim.game;
import com.vim.board.Board;
import com.vim.players.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    List<Character> chars = List.of('a', 'b', 'c', 'd', 'e', 'f',  'g', 'h');
    private boolean whitesTurn;
    private boolean playing;
    private White white;
    private Black black;
    private Board board;

    public Game() {

        board = new Board();

        white = new White(board.whitePieces);
        black = new Black(board.blackPieces);

        Scanner scanner = new Scanner(System.in);

        playing = true;

        while (playing) {

            String[] input = obtainInput(scanner);

            System.out.print(Arrays.toString(calculateInput(input[0])));
            System.out.print(Arrays.toString(calculateInput(input[1])));

        }
    }
        private String[] obtainInput(Scanner scanner){

            while (true) {
                try {

                    System.out.println("\033[3mExample move: h2,h4\033[3m");
                    System.out.print("Enter move ->");
                    String input = scanner.nextLine();

                    if (validateInput(input)) {

                        return input.split(",");

                    }
                } catch (Exception e) {

                    System.out.println("Enter a valid input.");

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
    }

