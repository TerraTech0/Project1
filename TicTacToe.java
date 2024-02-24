import java.util.*;

/*
- using 2D array .. Done
- use methods .. Done
- should display the game board .. Done
- Ask palyer a position .. Done
- Check if the position is available or not .. Done
- computer choose random poistion .. Done
- check the winner .. Done



ideas for extra credit ..
1. play one round .. Done
2. play 3 rounds and then determine the winner .. Done

if there's more time add next:
and choice to player 1v1 against another player
1- Player1 vs Player2
2- Player1 vs Computer

 */
public class TicTacToe {
    static List<Integer> playerPos = new ArrayList<>();
    static List<Integer> computerPos = new ArrayList<>();
    static Scanner data = new Scanner(System.in);

    public static void main(String[] args)throws Exception{


        while (true) {
            try {
            System.out.println("Welcome To My Tic Tac Toe");
            System.out.println("Enter 1 to play 1 round: ");
            System.out.println("Enter 2 to play 3 rounds: ");
            System.out.println("Enter 3 to Exit: ");


                int choice = data.nextInt();
                switch (choice) {
                    case 1:
                        oneRound();
                        break;
                    case 2:
//                System.out.println("Enter 2 to play 3 rounds: ");
                        threeRounds();
                        break;
                    case 3:
                        System.out.println("Exit");
                        return;
                    default:
                        throw new Exception("Out Of Range, Please Enter Number Between 1-3");
                }

            } catch (InputMismatchException e) {
//                throw new Exception("Please enter number: ");
                System.out.println("Wrong Input, Please enter a number.");
                data.nextLine();
            }catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        }
    }


    public static void oneRound() throws Exception {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };

        displayGameBoard(gameBoard);


        while (true) {
            try {

                int player = playerMove();
                if (player < 0 || player > 9){
//                    throw new Exception("Out Of Range");
                    System.out.println("Out of Range");
                    playerMove();
                }
                while (playerPos.contains(player) || computerPos.contains(player)) {
                    System.out.print("The Position isn't available, ");
                    player = playerMove();
                }
                position(gameBoard, player, "Player");

                String result = checkWinner();
                if (!result.isEmpty()) {
                    System.out.println(result);
                    break;
                }

                int computer = getComputerInput();
                while (playerPos.contains(computer) || computerPos.contains(computer)) {
                    computer = getComputerInput();
                }
                position(gameBoard, computer, "Computer");
                displayGameBoard(gameBoard);

                result = checkWinner();
                if (!result.isEmpty()) {
                    System.out.println(result);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please Enter a Valid Number.");
                data.nextLine();
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            } finally {
                System.out.println("Test!, The code still working");

            }

        }
    }

    public static void threeRounds() throws Exception{
        playerPos.clear();
        computerPos.clear();
        int playerWins = 0;
        int computerWins = 0;


        for (int round = 1; round <= 3; round++) {
            System.out.println("Round: " + round);
            oneRound();

            String result = checkWinner();
            if (result.contains("Congratulations you won.")) {
                playerWins++;
            }
            if (result.contains("Computer wins, HardLuck!!")) {
                computerWins++;
            }


            playerPos.clear();
            computerPos.clear();
        }

        System.out.println("Total Results: ");
        System.out.println("Player Wins: " + playerWins);
        System.out.println("Computer Wins: " + computerWins);
        if (playerWins > computerWins) {
            System.out.println("Congratulations, you are the winner!");
        } else if (computerWins > playerWins) {
            System.out.println("HardLuck!! the computer is the winner ):");
        } else {
            System.out.println("It's a Draw!!!");
        }
    }


    public static void displayGameBoard(char[][] gameBoard) {

        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static int playerMove() {
        System.out.print("Please Enter Your Position From 1-9: ");
        return data.nextInt();
    }

    public static int getComputerInput() {
        return new Random().nextInt(10);
    }

    public static void position(char[][] gameBoard, int position, String user) {

        char symbol = ' ';
        if (user.equals("Player")) {
            symbol = 'X';
            playerPos.add(position);
        } else if (user.equals("Computer")) {
            symbol = 'O';
            computerPos.add(position);
        }
        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }

    }

    public static String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List firstColumn = Arrays.asList(1, 4, 7);
        List midColumn = Arrays.asList(2, 5, 8);
        List rightColumn = Arrays.asList(3, 6, 9);
        List diag1 = Arrays.asList(1, 5, 9);
        List diag2 = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(bottomRow);
        winning.add(firstColumn);
        winning.add(midColumn);
        winning.add(rightColumn);
        winning.add(diag1);
        winning.add(diag2);

        for (List list : winning) {
            if (playerPos.containsAll(list)) {
                return "Congratulations you won.";
            } else if (computerPos.containsAll(list)) {
                return "Computer wins, HardLuck!!";
            } else if (playerPos.size() + computerPos.size() == 9) {
                return "Draw, Play again.";
            }
        }
        return "";
    }
}




