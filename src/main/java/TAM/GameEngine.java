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
        System.out.println("LOG: Transicao de estado: " + this.currentState + " -> " + newState);

        switch (newState) {

            case NEW_GAME:
                changeState(GameState.LOADING_NIGHT);
                this.currenteNight = GameState.NIGHT_1;
                break;

            case LOADING_NIGHT:
                try {
                    System.out.println("Aguardando 3 segundos para carregar a Noite...");
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
                System.out.println("LOG: Tentando carregar jogo salvo...");
                changeState(GameState.LOADING_NIGHT);
                break;

            case NIGHT_1:
                this.currenteNight = GameState.NIGHT_1;
                System.out.println("Iniciando Noite 1. Bem-vindo ao Escritorio.");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_1, 1, 1);
                activeNight.startNight();
                break;

            case NIGHT_2:
                this.currenteNight = GameState.NIGHT_2;
                System.out.println("Iniciando Noite 2. Bem-vindo ao Escritorio.");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_1, 3, 2);
                activeNight.startNight();
                break;

            case NIGHT_3:
                this.currenteNight = GameState.NIGHT_3;
                System.out.println("Iniciando Noite 3. Bem-vindo ao Escritorio.");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_1, 6, 4);
                activeNight.startNight();
                break;

            case NIGHT_4:
                this.currenteNight = GameState.NIGHT_4;
                System.out.println("Iniciando Noite 4. Bem-vindo ao Escritorio.");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_1, 9, 8);
                activeNight.startNight();
                break;

            case NIGHT_5:
                this.currenteNight = GameState.NIGHT_5;
                System.out.println("Iniciando Noite 5. Bem-vindo ao Escritorio.");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_1, 13, 12);
                activeNight.startNight();
                break;

            case NIGHT_6:
                this.currenteNight = GameState.NIGHT_6;
                System.out.println("Iniciando Noite 6. Bem-vindo ao Escritorio.");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_1, 15, 13);
                activeNight.startNight();
                break;

            case NIGHT_7:
                System.out.println("Iniciando Noite 7. Bem-vindo ao Escritorio.");
                // CRIA E INICIA A NOITE
                // Dificuldade (Bonnie/Freddy)
                activeNight = new Night(this, GameState.NIGHT_1, 17, 15);
                activeNight.startNight();
                break;

            case VICTORY_SCREEN:
                System.out.println("\n###############################");
                System.out.println("##    PARABÉNS! 6:00 AM!   ##");
                System.out.println("###############################");

                // 1. Simula salvamento (define a próxima noite como a nova noite atual)
                GameState nextNight = getNextNight();
                this.currenteNight = nextNight;

                System.out.println("Progresso salvo. Próxima Noite: " + nextNight);

                // 2. Pausa para o jogador ver a tela
                try {
                    System.out.println("Pausa de 5 segundos...");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // 3. DECISÃO GENÉRICA: Chama o Minigame correspondente à próxima noite.
                if (nextNight == GameState.VICTORY_SCREEN) {
                    // Significa que vencemos a NIGHT_7: Fim do Jogo.
                    changeState(GameState.MAIN_MENU);
                } else {
                    // Se não for o fim do jogo, chame o Minigame
                    GameState minigameToLoad = mapNightToMinigame(nextNight);
                    System.out.println("Carregando Minigame: " + minigameToLoad);
                    changeState(minigameToLoad);
                }
                return;

            case GAME_OVER:
                System.out.println("\n===============================");
                System.out.println("==     GAME OVER - FIM!      ==");
                System.out.println("===============================");

                // A noite atual (currenteNight) já está salva.

                // 1. Pausa para a tela de susto/derrota
                try {
                    System.out.println("Pausa de 4 segundos...");
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Voltando para a última noite: " + this.currenteNight);

                // 2. Força o início da mesma noite
                changeState(GameState.LOADING_NIGHT);
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
                System.out.println("Minigame 1");
                handleMinigameScreen(GameState.MINIGAME_1);
                return;

            case MINIGAME_2:
                System.out.println("Minigame 2");
                handleMinigameScreen(GameState.MINIGAME_2);
                return;

            case MINIGAME_3:
                System.out.println("Minigame 3");
                handleMinigameScreen(GameState.MINIGAME_3);
                return;

            case MINIGAME_4:
                System.out.println("Minigame 4");
                handleMinigameScreen(GameState.MINIGAME_4);
                return;

            case MINIGAME_5:
                System.out.println("Minigame 5");
                handleMinigameScreen(GameState.MINIGAME_5);
                return;

            case MINIGAME_6:
                System.out.println("Minigame 6");
                handleMinigameScreen(GameState.MINIGAME_6);
                return;

            case MINIGAME_7:
                System.out.println("Minigame 7");
                handleMinigameScreen(GameState.MINIGAME_7);
                return;
        }

        // Atualiza o estado
        this.currentState = newState;
    }

    private void handleMinigameScreen(GameState minigameIdentifier) {
        System.out.println("\n--- INÍCIO DO MINIGAME ---");
        System.out.println("CARREGANDO: " + minigameIdentifier);

        // Simulação do conteúdo do Minigame
        System.out.println("> Esta é a cena da memória. (Imagine gráficos pixelizados aqui)");

        // Pausa para o jogador ler
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Pressione [ENTER] para completar a memória e continuar o jogo...");

        // Espera o ENTER do usuário
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Apenas espera a linha (o ENTER)

        System.out.println("Memória liberada. Avançando para a próxima noite.");

        // CRÍTICO: Avança para a próxima noite, que já está salva em currenteNight.
        // Se viemos do VICTORY_SCREEN, currenteNight já está setada para NIGHT_2, NIGHT_3, etc.
        changeState(GameState.LOADING_NIGHT);
    }

    private void handleStaticScreen(String screenName) {
        System.out.println("\n--- " + screenName + " ---");
        // Conteúdo fictício da tela
        if (screenName.contains("CREDITS")) {
            System.out.println("Criador: The14Gentleman Pixel");
            System.out.println("Motor: Java POO Console Engine");
        } else if (screenName.contains("CONFIGURATIONS")) {
            System.out.println("Som: Alto");
            System.out.println("Brilho: 50%");
        }
        System.out.println("-------------------------");
        System.out.println("TECLE 'X' ou 'x' PARA VOLTAR AO MENU PRINCIPAL");

        Scanner screenScanner = new Scanner(System.in);
        String input;

        // Loop que só termina quando 'x' ou 'X' for digitado
        do {
            System.out.print("> ");
            // Lê a linha inteira para garantir que o ENTER não seja problema
            input = screenScanner.nextLine().trim();
        } while (!input.equalsIgnoreCase("x"));

        // Se o loop terminou, o usuário digitou 'X' ou 'x'
        System.out.println("Voltando ao menu...");
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
            case NIGHT_7 -> GameState.VICTORY_SCREEN; // Se vencer a Noite 7, o jogo termina ou vai para uma tela especial.
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
