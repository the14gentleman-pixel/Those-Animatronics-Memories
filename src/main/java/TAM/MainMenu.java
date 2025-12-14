package TAM;

import java.util.Scanner;
@SuppressWarnings("all")

public class MainMenu {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Scanner c = new Scanner(System.in);

        // LOOP PRINCIPAL: Roda enquanto o jogo estiver no menu
        do {
            System.out.println("\n--- Those Animatronic's Memories ---");
            System.out.println("1. New Game");
            System.out.println("2. Continue");
            System.out.println("3. Configuration");
            System.out.println("4. Credits");
            System.out.println("5. Quit\n");
            System.out.print("Escolha uma opcao: ");

            // Lógica de leitura de entrada aqui
            if (c.hasNextInt()) {
                int choice = c.nextInt();
                // O próximo nextLine() consome o resto da linha (o ENTER) que nextInt() não consumiu.
                // É crucial para evitar problemas com o Scanner na próxima leitura.
                c.nextLine();

                switch (choice) {
                    case 1: gameEngine.changeState(GameState.NEW_GAME); break;
                    case 2: gameEngine.changeState((GameState.CONTINUE_GAME)); break;
                    case 3: gameEngine.changeState((GameState.CONFIGURATIONS)); break;
                    case 4: gameEngine.changeState((GameState.CREDITS_SCREEN)); break;
                    case 5: System.out.print("Exiting.."); System.exit(0); break;
                    default: System.out.println("Opção Inválida."); break;
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                c.nextLine(); // Consome a entrada inválida e evita loop infinito
            }

            // Repete enquanto o GameEngine estiver no estado de menu
        } while (gameEngine.getCurrentState() == GameState.MAIN_MENU);
    }
}