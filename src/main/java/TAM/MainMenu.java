package TAM;

import java.util.Scanner;
@SuppressWarnings("all")

public class MainMenu {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Scanner c = new Scanner(System.in);

        System.out.println("LOG: Game Started. Waiting input.");

        // LOOP PRINCIPAL: Roda continuamente para toda a sessão de jogo
        while (true) {
            GameState currentState = gameEngine.getCurrentState();

            // 1. Lógica do Menu Principal
            if (currentState == GameState.MAIN_MENU) {

                System.out.println("\n--- Those Animatronic's Memories ---");
                System.out.println("1. New Game");
                System.out.println("2. Continue");
                System.out.println("3. Configuration");
                System.out.println("4. Credits");
                System.out.println("5. Quit\n");
                System.out.print("Choose an option: ");

                // Apenas processa se houver um número para evitar erros de Scanner
                if (c.hasNextInt()) {
                    int choice = c.nextInt();
                    c.nextLine(); // Consome o ENTER

                    switch (choice) {
                        case 1: gameEngine.changeState(GameState.NEW_GAME); break;
                        case 2: gameEngine.changeState(GameState.CONTINUE_GAME); break;
                        case 3: gameEngine.changeState(GameState.CONFIGURATIONS); break;
                        case 4: gameEngine.changeState(GameState.CREDITS_SCREEN); break;
                        case 5: System.out.print("Exiting.."); System.exit(0); break;
                        default: System.out.println("Invalid input"); break;
                    }
                } else {
                    System.out.println("Invalid input, please digit some number.");
                    c.nextLine(); // Consome a entrada inválida
                }

                // Aguardar em telas de transição (Loading, Victory, Game Over)
                // Se o estado não for Menu nem Night, o GameEngine está controlando o fluxo (com sleep).
                // Apenas adicionamos um pequeno delay para evitar alto consumo de CPU.
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}