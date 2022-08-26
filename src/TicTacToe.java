import java.util.Scanner;


public class TicTacToe {
    public static void main(String[] args) {

        // create scanner 
        Scanner scanner = new Scanner(System.in); 

        // tic-tac-toe board
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        }; 


        // welcome statement, board printing
        System.out.println("Welcome to tic-tac-toe!");
        boardPrinter(board); 

        while(true) {
            // call playerTurn
            playerTurn(board, scanner);
            // check if game is over
            if (isGameOver(board)) {
                break; 
            }
            // call computerTurn
            computerTurn(board);
            // check if game is over
            if (isGameOver(board)) {
                break; 
            }
            boardPrinter(board);
        }
        
        // print board after both turns have been played
        // boardPrinter(board);
        // scanner.close();

    }

    // prints the board in terminal
    private static void boardPrinter(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

    // takes user input (1-9) and places X in that spot
    private static void playerTurn(char[][] board, Scanner scanner) {
        String userInput; 
        while(true) {
            // create scanner and prompt user for input
            System.out.println("Where would you like to place X? (1-9)");
            userInput = scanner.nextLine(); 
            // check if spot is available
            if(availabilityChecker(board, Integer.parseInt(userInput))) {
                break;
            } else {
                System.out.println("Invalid input " + userInput + " is already taken");
            }
        }
        // userInput and player turn X placement
        placeMove(board, userInput, 'X');
    }

    private static void computerTurn(char[][] board) {
        int randomNum; 
        // computer will keep picking a spot until it picks a valid one
        while(true) {
            randomNum = (int) (Math.random() * 9) + 1; 
            if(availabilityChecker(board, randomNum)){
                break; 
            }
        }
        // place the computers move and print the board
        System.out.println("Computer chose: " + randomNum );
        placeMove(board, Integer.toString(randomNum), 'O');
    }

    // check's whether the spot has been taken or not
    private static boolean availabilityChecker(char[][] board, int position) {
        switch(position) {
            case 1:
                return (board[0][0] == ' '); 
            case 2:
                return (board[0][1] == ' '); 
            case 3:
                return (board[0][2] == ' '); 
            case 4:
                return (board[1][0] == ' '); 
            case 5:
                return (board[1][1] == ' '); 
            case 6:
                return (board[1][2] == ' '); 
            case 7:
                return (board[2][0] == ' ');  
            case 8:
                return (board[2][1] == ' '); 
            case 9:
                return (board[2][2] == ' '); 
            default: 
                return false; 
        }
    }

    // places the move of either the computer or the player
    private static void placeMove(char[][] board, String position, char symbol) {
        switch(position) {
            case "1":
                board[0][0] = symbol; 
                break; 
            case "2":
                board[0][1] = symbol; 
                break; 
            case "3":
                board[0][2] = symbol; 
                break; 
            case "4":
                board[1][0] = symbol; 
                break;
            case "5":
                board[1][1] = symbol; 
                break; 
            case "6":
                board[1][2] = symbol; 
                break; 
            case "7":
                board[2][0] = symbol; 
                break; 
            case "8":
                board[2][1] = symbol;
                break; 
            case "9":
                board[2][2] = symbol;
                break; 
            default: 
                System.out.println("Ivalid input");
                return; 
        }
    }

    private static boolean isGameOver(char[][] board) {
        // check if someone has won 
        if ((board[0][0] == board[0][1] && board[0][1] == board[0][2]) ||
           (board[0][0] == board[1][0] && board[0][0] == board[2][0])) {
                System.out.println("Someone has won!");
                return true; 
        
        }


        // check if the board is full
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false; 
                } 
            }
        }
        boardPrinter(board);
        System.out.println("Tie! No more spots available");
        return true; 
    }
}
