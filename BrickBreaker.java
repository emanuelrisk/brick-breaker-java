import java.util.Scanner;

public class BrickBreakerGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int paddlePosition = 5;
        int ballPosition = 0;
        int ballDirection = 1; // 1 for right, -1 for left
        int score = 0;
        int bricks = 10;

        while (bricks > 0) {
            // Clear the console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Display the game board
            displayGameBoard(paddlePosition, ballPosition, bricks, score);

            // Move the ball
            ballPosition += ballDirection;

            // Move the paddle based on user input
            System.out.print("Move the paddle (L for left, R for right, or Q to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("L") && paddlePosition > 0) {
                paddlePosition--;
            } else if (input.equalsIgnoreCase("R") && paddlePosition < 9) {
                paddlePosition++;
            } else if (input.equalsIgnoreCase("Q")) {
                break;
            }

            // Check for collision with bricks
            if (ballPosition >= 0 && ballPosition <= 9) {
                bricks--;
                score++;
                ballDirection = -ballDirection;
            }
        }

        System.out.println("Game Over! Your score: " + score);
        scanner.close();
    }

    public static void displayGameBoard(int paddlePosition, int ballPosition, int bricks, int score) {
        System.out.println("Brick Breaker Game");
        System.out.println("Score: " + score);
        System.out.println("Bricks left: " + bricks);
        System.out.print(" ");
        for (int i = 0; i < 10; i++) {
            System.out.print(bricks > 0 ? "[]" : "  ");
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
            if (i == paddlePosition) {
                System.out.print("=");
            } else if (i == ballPosition) {
                System.out.print("O");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
