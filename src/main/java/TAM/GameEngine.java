package TAM;

import java.util.concurrent.TimeUnit;
import java.util.Scanner; // Necessário para inputs em Minigames (futuro)

@SuppressWarnings("all")
public class GameEngine {

    public enum GameState {
        MAIN_MENU, NEW_GAME, CONTINUE_GAME, CONFIGURATIONS, CREDITS_SCREEN,
        LOADING_NIGHT, NIGHT_1, GAME_OVER, VICTORY_SCREEN, MINIGAME_START
    }

    private GameState currentState;
    private GameState currenteNight;
    private Night activeNight;
    private final Player player;

    public GameEngine() {
        this.currentState = GameState.MAIN_MENU;
        this.currenteNight = GameState.NIGHT_1; // Começa sempre na Noite 1
        this.player = new Player();
    }

    /**
     * Gerencia as transições de estado do jogo.
     */
    public void changeState(GameState newState) {
        System.out.println("LOG: Changing state: " + currentState.name() + " -> " + newState.name());
        this.currentState = newState;

        switch (newState) {
            case NEW_GAME:
                // Lógica de reset/start da nova partida
                changeState(GameState.LOADING_NIGHT);
                break;

            case LOADING_NIGHT:
                // Simula a tela de carregamento
                System.out.println("Loading Night...");
                try {
                    TimeUnit.SECONDS.sleep(3); // Espera 3 segundos
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                changeState(this.currenteNight);
                break;

            case NIGHT_1:
                // Inicializa a Noite 1 com dificuldade 1/1
                this.activeNight = new Night(1, 1, this);
                System.out.println("Night 1 Started");
                this.activeNight.startNight();
                break;

            case CONFIGURATIONS:
                // Exibe config (Main Menu trata o input de 'X')
                System.out.println("\n--- CONFIGURATIONS ---");
                System.out.println("Sound: Hight");
                System.out.println("Screen Brightness: 50%");
                System.out.println("-------------------------");
                System.out.println("PRESS 'X' ou 'x' TO GET BACK AT THE MAIN MENU");
                break;

            case CREDITS_SCREEN:
                // Exibe créditos (Main Menu trata o input de 'X')
                System.out.println("\n--- CREDITS_SCREEN ---");
                System.out.println("Creator: The14Gentleman Pixel");
                System.out.println("Motor: Java POO Console Engine");
                System.out.println("-------------------------");
                System.out.println("PRESS 'X' ou 'x' TO GET BACK AT THE MAIN MENU");
                break;

            case GAME_OVER:
                // Lógica de Game Over (Jumpscare ou Colapso Mental)
                System.out.println("GAME OVER!");
                break;

            default:
                // Outros estados não necessitam de lógica aqui
                break;
        }
    }

    /**
     * Chamado pela Night.java quando o jogo termina.
     */
    public void endNight(boolean win) {
        if (win) {
            changeState(GameState.VICTORY_SCREEN);
        } else {
            changeState(GameState.GAME_OVER);
        }
    }

    // ----------------------------------------------------
    // GETTERS
    // ----------------------------------------------------

    public GameState getCurrentState() {
        return currentState;
    }

    public Player getPlayer() {
        return player;
    }

    public Night getActiveNight() {
        return activeNight;
    }
}