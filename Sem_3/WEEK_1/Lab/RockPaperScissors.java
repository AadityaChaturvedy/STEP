import java.util.Scanner;

public class RockPaperScissors{

    public static int getComputerChoice() {
        return (int) (Math.random() * 3);
    }

    public static int findWinner(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return 0;
        } else if ((playerChoice == 0 && computerChoice == 2) ||
                   (playerChoice == 1 && computerChoice == 0) ||
                   (playerChoice == 2 && computerChoice == 1)) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of games to play: ");
        try {
            int numGames = sc.nextInt();
            int playerScore = 0;
            int computerScore = 0;
            String[] choices = {"Rock", "Paper", "Scissors"};

            for (int i = 0; i < numGames; i++) {
                System.out.println("\n--- Game " + (i + 1) + " ---");
                System.out.print("Choose your move (0=Rock, 1=Paper, 2=Scissors): ");
                int playerMove = sc.nextInt();
                int computerMove = getComputerChoice();
                System.out.println("You chose: " + choices[playerMove]);
                System.out.println("Computer chose: " + choices[computerMove]);
                int winner = findWinner(playerMove, computerMove);
                if (winner == 1) {
                    System.out.println("You win!");
                    playerScore++;
                } else if (winner == -1) {
                    System.out.println("Computer wins!");
                    computerScore++;
                } else {
                    System.out.println("It's a tie!");
                }
            }

            System.out.println("\n--- Final Game Stats ---");
            System.out.println("Total Games: " + numGames);
            System.out.println("Player Wins: " + playerScore);
            System.out.println("Computer Wins: " + computerScore);
            System.out.printf("Player Win Percentage: %.2f%%\n", (double) playerScore / numGames * 100);
            System.out.printf("Computer Win Percentage: %.2f%%\n", (double) computerScore / numGames * 100);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        sc.close();
    }
}
