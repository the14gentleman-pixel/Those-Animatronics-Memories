package TAM;

import java.util.Scanner;
import java.util.InputMismatchException;
import TAM.GameEngine.GameState; // Importa o GameState do GameEngine
// Importa o OfficeView
import TAM.OfficeView;

@SuppressWarnings("all")
public class MainMenu {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        // O Scanner é criado uma vez
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

                try {
                    // Leitura segura do input principal
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
                } catch (InputMismatchException e) {
                    c.nextLine();
                    System.out.println("Error reading input. Please try again.");
                }


                // 2. Lógica de Input Durante a Noite
            } else if (currentState.name().startsWith("NIGHT")) {

                handleNightInput(gameEngine, c);

                // 3. Aguardar em telas de transição (Loading, Victory, Game Over, Minigames)
            } else {
                // Trata input de 'X' para voltar ao menu (usado em CONFIGS e CREDITS)
                if (c.hasNextLine()) {
                    String input = c.nextLine().trim();
                    if (input.equalsIgnoreCase("X")) {
                        System.out.println("Going to the menu...");
                        gameEngine.changeState(GameState.MAIN_MENU);
                    }
                }

                // Pequeno delay para evitar alto consumo de CPU em loops rápidos.
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /**
     * Gerencia a interface e o input do jogador durante uma noite ativa.
     * @param engine O motor do jogo.
     * @param c O Scanner para ler o input.
     */
    private static void handleNightInput(GameEngine engine, Scanner c) {
        Player player = engine.getPlayer();
        OfficeView currentView = player.getCurrentView();

        // ----------------------------------------------------
        // I. EXIBIÇÃO DO ESTADO ATUAL
        // ----------------------------------------------------
        System.out.println("\n----------------------------------------------------");
        // Verifica se a noite está ativa antes de chamar getActiveNight()
        if (engine.getActiveNight() != null) {
            System.out.println("CURRENT VIEW: " + currentView.name() + " | TIME: " + engine.getActiveNight().getFormattedTime());
        } else {
            System.out.println("CURRENT VIEW: " + currentView.name() + " | TIME: 12:00 AM");
        }
        System.out.println("SANITY: " + player.getSanity() + "% | DOOR HELD: " + player.isHoldingDoor() + " | LIGHT: " + (player.isLightOn() ? "ON" : "OFF"));
        System.out.println("----------------------------------------------------");

        // ----------------------------------------------------
        // II. MENUS ESPECÍFICOS POR VISÃO
        // ----------------------------------------------------

        // A. MENU DA PORTA (LEFT_DOOR)
        if (currentView == OfficeView.LEFT_DOOR) {

            System.out.println("LEFT DOOR ACTIONS:");

            if (player.isHoldingDoor()) {
                System.out.println("1. RELEASE Door");
            } else {
                System.out.println("1. HOLD Door");
            }

            System.out.println("2. Toggle LIGHTS (" + (player.isLightOn() ? "ON" : "OFF") + ")");
            // Regra 1: Só pode sair se NÃO estiver segurando a porta
            if (!player.isHoldingDoor()) {
                System.out.println("3. BACK to Office View");
            }
            System.out.print("> Choose an action: ");

            // Leitura de Linha e Conversão (MAIS ROBUSTO)
            if (c.hasNextLine()) {
                String input = c.nextLine().trim();
                try {
                    int choice = Integer.parseInt(input);

                    switch (choice) {
                        case 1:
                            player.holdDoor(!player.isHoldingDoor());
                            break;
                        case 2:
                            player.toggleLight(!player.isLightOn());
                            break;
                        case 3:
                            // CRÍTICO: Só permite voltar se a porta NÃO estiver sendo segurada
                            if (!player.isHoldingDoor()) {
                                player.changeView(OfficeView.FRONT_VIEW);
                            } else {
                                System.out.println("ALERT: Release the door (Option 1) before leaving the view!");
                            }
                            break;
                        default:
                            System.out.println("Invalid Door Action.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Digits only.");
                }
            }


            // B. MENU PRINCIPAL (VISTAS ESTÁTICAS: FRONT_VIEW) - Menu de Navegação
        } else if (currentView == OfficeView.FRONT_VIEW) {

            System.out.println("OFFICE ACTIONS:");
            System.out.println("1. Go to LEFT DOOR");
            System.out.println("2. Go to DESK");
            System.out.println("3. Toggle CAMERAS");
            System.out.print("> Choose an action: ");

            // Leitura de Linha e Conversão (MAIS ROBUSTO)
            if (c.hasNextLine()) {
                String input = c.nextLine().trim();
                try {
                    int choice = Integer.parseInt(input);

                    switch (choice) {
                        case 1:
                            player.changeView(OfficeView.LEFT_DOOR);
                            break;
                        case 2:
                            player.toggleHide(true); // Entra no modo esconder
                            break;
                        case 3:
                            player.toggleCameras();
                            break;
                        default:
                            System.out.println("Invalid Action.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Digits only.");
                }
            }


            // C. VISTAS PENDENTES (Mesa e Câmeras)
        } else if (currentView == OfficeView.UNDER_DESK) {

            System.out.println("HIDING ACTIONS:");

            // Opção 1: Toggle Foto
            if (player.isPhotoActive()) {
                System.out.println("1. STOP looking at PHOTO"); // Se a foto está ativa, a opção é parar
            } else {
                System.out.println("1. Look at PHOTO (Recover Sanity)"); // Se a foto não está ativa, a opção é olhar
            }

            // Opção 2: STOP HIDING (Só aparece se a foto NÃO estiver ativa)
            if (!player.isPhotoActive()) {
                System.out.println("2. STOP HIDING");
            } else {
                System.out.println("ALERT: Stop looking at the photo (Option 1) before leaving the desk.");
            }

            System.out.print("> Choose an action: ");

            // Leitura de Linha e Conversão (MAIS ROBUSTO)
            if (c.hasNextLine()) {
                String input = c.nextLine().trim();
                try {
                    int choice = Integer.parseInt(input);

                    switch (choice) {
                        case 1:
                            // Alterna o estado da foto.
                            // Se estava olhando, para. Se não estava, começa.
                            player.lookAtPhoto(!player.isPhotoActive());
                            break;

                        case 2:
                            // CRÍTICO: Só permite sair se a foto NÃO estiver ativa.
                            if (!player.isPhotoActive()) {
                                player.toggleHide(false); // Sai de debaixo da mesa
                            } else {
                                System.out.println("Invalid Hiding Action. Cannot leave while photo is active.");
                            }
                            break;

                        default:
                            System.out.println("Invalid Hiding Action.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Digits only.");
                }
            }

        } else if (currentView == OfficeView.CAMERA_MONITOR) {

            System.out.println("CAMERA ACTIONS:");
            System.out.println("C. Change Camera (Pending...)");
            System.out.println("3. Toggle CAMERAS OFF");
            System.out.print("> Choose an action: ");

            // Permite '3' ou 'C'
            if (c.hasNextLine()) {
                String input = c.nextLine().trim();
                if (input.equals("3")) {
                    player.toggleCameras();
                } else if (input.equalsIgnoreCase("C")) {
                    System.out.println("Camera change logic is pending implementation.");
                } else {
                    System.out.println("Invalid Camera Action.");
                }
            }
        }
    }
}