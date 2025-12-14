package TAM;

import java.util.Scanner;
@SuppressWarnings("all")

public class MainMenu {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        System.out.println("Those Animatronic's Memories\n");
        System.out.println("New Game");
        System.out.println("Continue");
        System.out.println("Configuration");
        System.out.println("Credits");
        System.out.println("Quit\n");
        Scanner c = new Scanner(System.in);
        int choice = c.nextInt();
        switch (choice) {
            case 1: gameEngine.changeState(GameState.LOADING_NIGHT); break;
            case 2: gameEngine.changeState((GameState.CONTINUE_GAME)); break;
            case 3: gameEngine.changeState((GameState.CONFIGURATIONS)); break;
            case 4: gameEngine.changeState((GameState.CREDITS_SCREEN)); break;
            case 5: System.out.print("Exiting..");  System.exit(0); break;
            default: System.out.println("Invalid input"); break;
        }
    }
}