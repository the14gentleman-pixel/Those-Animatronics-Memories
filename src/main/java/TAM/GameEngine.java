package TAM;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("all")

public class GameEngine {

    // Variável que guarda o estado e noite atual
    private GameState currentState;
    private Night activeNight;
    private GameState currenteNight;

    // Construtor: O jogo sempre começa no menu
    public GameEngine() {
        this.currentState = GameState.MAIN_MENU;
        this.currenteNight = GameState.NIGHT_1;
    }

    public void changeState(GameState newState) {
        // É importante manter esta linha para saber o que está acontecendo!
        System.out.println("LOG: Changing state: " + this.currentState + " -> " + newState);

        switch (newState) {

            case NEW_GAME:
                this.currenteNight = GameState.NIGHT_1;
                changeState(GameState.LOADING_NIGHT);
                break;

            case LOADING_NIGHT:
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                // CRÍTICO: Após carregar, MUDAR o estado para a noite REAL que está salva.
                // Isso evita loops e garante que o jogo avance.
                changeState(this.currenteNight);
                return; // Usar 'return' aqui impede que o 'this.currentState = newState' no final seja executado.

            case CONTINUE_GAME:
                System.out.println("LOG: Trying load the save...");
                changeState(GameState.LOADING_NIGHT);
                break;

            case NIGHT_1:
                this.currenteNight = GameState.NIGHT_1;
                System.out.println("\nNight 1 Started");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_1, 1, 1);
                activeNight.startNight();
                break;

            case NIGHT_2:
                this.currenteNight = GameState.NIGHT_2;
                System.out.println("\nNight 2 Started");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_2, 3, 2);
                activeNight.startNight();
                break;

            case NIGHT_3:
                this.currenteNight = GameState.NIGHT_3;
                System.out.println("\nNight 3 Started");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_3, 6, 4);
                activeNight.startNight();
                break;

            case NIGHT_4:
                this.currenteNight = GameState.NIGHT_4;
                System.out.println("\nNight 4 Started");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_4, 9, 8);
                activeNight.startNight();
                break;

            case NIGHT_5:
                this.currenteNight = GameState.NIGHT_5;
                System.out.println("\nNight 5 Started");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_5, 13, 12);
                activeNight.startNight();
                break;

            case NIGHT_6:
                this.currenteNight = GameState.NIGHT_6;
                System.out.println("\nNight 6 Started");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_6, 15, 13);
                activeNight.startNight();
                break;

            case NIGHT_7:
                System.out.println("\nNight 7 Started");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_7, 17, 15);
                activeNight.startNight();
                break;

            case VICTORY_SCREEN:
                System.out.println("\n###############################");
                System.out.println("##    HORRAY! 6:00 AM!   ##");
                System.out.println("###############################");

                // 1. Simula salvamento (define a próxima noite como a nova noite atual)
                GameState nextNight = getNextNight();

                // CRÍTICO: SOMENTE atualizamos o currenteNight SE A NOITE NÃO FOR A ÚLTIMA.
                if (nextNight != GameState.MAIN_MENU) {
                    this.currenteNight = nextNight;
                    System.out.println("\nSaved progress. Next night: " + nextNight);
                } else {
                    // SE FOR O FIM DO JOGO, MANTEMOS O VALOR DA ÚLTIMA NOITE VENCIDA (NIGHT_7).
                    // currentNight continua sendo NIGHT_7 (ou a última noite que foi setada).
                    System.out.println("\nGame completed. Progress saved on: " + this.currenteNight);
                }

                // 2. Pausa para o jogador ver a tela
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // 3. DECISÃO GENÉRICA: Chama o Minigame correspondente à próxima noite.

                // CRÍTICO: Se a próxima noite é MAIN_MENU, o jogo terminou!
                if (nextNight == GameState.MAIN_MENU) {
                    System.out.println("\nEND GAME: All nights completed!");
                    changeState(GameState.MAIN_MENU); // Volta para o menu principal
                } else {
                    // Se não for o fim do jogo, chame o Minigame
                    GameState minigameToLoad = mapNightToMinigame(nextNight);
                    System.out.println("\nLoading minigame: " + minigameToLoad);
                    changeState(minigameToLoad);
                }
                return;

            case GAME_OVER:
                System.out.println("\n===============================");
                System.out.println("==     GAME OVER - END!      ==");
                System.out.println("===============================");

                // A noite atual (currenteNight) já está salva.

                // 1. Pausa para a tela de susto/derrota
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("\nBacking to Menu");

                // 2. Força o início da mesma noite
                changeState(GameState.MAIN_MENU);
                return;

            case CONFIGURATIONS:
                // Em vez de só imprimir, chama o loop de entrada
                handleStaticScreen("CONFIGURATIONS");
                return; // CRÍTICO: Use return para evitar que o changeState no final execute.

            case CREDITS_SCREEN:
                // Em vez de só imprimir, chama o loop de entrada
                handleStaticScreen("CREDITS_SCREEN");
                return; // CRÍTICO: Use return aqui também.

            case MINIGAME_1:
                System.out.println("\nMinigame 1");
                handleMinigameScreen(GameState.MINIGAME_1);
                return;

            case MINIGAME_2:
                System.out.println("\nMinigame 2");
                handleMinigameScreen(GameState.MINIGAME_2);
                return;

            case MINIGAME_3:
                System.out.println("\nMinigame 3");
                handleMinigameScreen(GameState.MINIGAME_3);
                return;

            case MINIGAME_4:
                System.out.println("\nMinigame 4");
                handleMinigameScreen(GameState.MINIGAME_4);
                return;

            case MINIGAME_5:
                System.out.println("\nMinigame 5");
                handleMinigameScreen(GameState.MINIGAME_5);
                return;

            case MINIGAME_6:
                System.out.println("\nMinigame 6");
                handleMinigameScreen(GameState.MINIGAME_6);
                return;

            case MINIGAME_7:
                System.out.println("\nMinigame 7");
                handleMinigameScreen(GameState.MINIGAME_7);
                return;
        }

        // Atualiza o estado
        this.currentState = newState;
    }

    private void handleMinigameScreen(GameState minigameIdentifier) {
        System.out.println("\n--- START MINIGAME ---");
        System.out.println("\nLOADING: " + minigameIdentifier);

        // Simulação do conteúdo do Minigame
        System.out.println("> This is just a minigame {need replace for a real one}");

        // Pausa para o jogador ler
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Press [ENTER] to complet the minigame and proceed with the game...");

        // Espera o ENTER do usuário
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Apenas espera a linha (o ENTER)

        System.out.println("\nMinigame passed, going to the next night.");

        // CRÍTICO: Avança para a próxima noite, que já está salva em currenteNight.
        // Se viemos do VICTORY_SCREEN, currenteNight já está setada para NIGHT_2, NIGHT_3, etc.
        changeState(GameState.LOADING_NIGHT);
    }

    private void handleStaticScreen(String screenName) {
        System.out.println("\n--- " + screenName + " ---");
        // Conteúdo fictício da tela
        if (screenName.contains("CREDITS")) {
            System.out.println("Creator: The14Gentleman Pixel");
            System.out.println("Motor: Java POO Console Engine");
        } else if (screenName.contains("CONFIGURATIONS")) {
            System.out.println("Sound: Hight");
            System.out.println("Screen Brightness: 50%");
        }
        System.out.println("-------------------------");
        System.out.println("PRESS 'X' ou 'x' TO GET BACK AT THE MAIN MENU");

        Scanner screenScanner = new Scanner(System.in);
        String input;

        // Loop que só termina quando 'x' ou 'X' for digitado
        do {
            System.out.print("> ");
            // Lê a linha inteira para garantir que o ENTER não seja problema
            input = screenScanner.nextLine().trim();
        } while (!input.equalsIgnoreCase("x"));

        // Se o loop terminou, o usuário digitou 'X' ou 'x'
        System.out.println("Going to the menu...");
        changeState(GameState.MAIN_MENU);
        // Não precisamos de return aqui, pois a chamada para changeState(MAIN_MENU)
        // será a última ação antes que o metodo changeState principal atualize o currentState.
    }

    private GameState mapNightToMinigame(GameState targetNight) {
        return switch (targetNight) {
            case NIGHT_2 -> GameState.MINIGAME_1;
            case NIGHT_3 -> GameState.MINIGAME_2;
            case NIGHT_4 -> GameState.MINIGAME_3;
            case NIGHT_5 -> GameState.MINIGAME_4;
            case NIGHT_6 -> GameState.MINIGAME_5;
            case NIGHT_7 -> GameState.MINIGAME_6;
            // Se for NIGHT_7, o jogo acaba, então não há Minigame
            default -> GameState.VICTORY_SCREEN; // Caso de segurança, cai em Victory/EndGame
        };
    }

    private GameState getNextNight() {
        return switch (this.currenteNight) {
            case NIGHT_1 -> GameState.NIGHT_2;
            case NIGHT_2 -> GameState.NIGHT_3;
            case NIGHT_3 -> GameState.NIGHT_4;
            case NIGHT_4 -> GameState.NIGHT_5;
            case NIGHT_5 -> GameState.NIGHT_6;
            case NIGHT_6 -> GameState.NIGHT_7;
            case NIGHT_7 -> GameState.MAIN_MENU; // Se vencer a Noite 7, o jogo termina ou vai para uma tela especial.
            default -> GameState.MAIN_MENU; // Falha de lógica
        };
    }

    // NOVO METODO (Getter para a noite ativa)
    public Night getActiveNight() {
        return activeNight;
    }

    // Getter para saber o estado atual (útil para a interface)
    public GameState getCurrentState() {
        return currentState;
    }
}
