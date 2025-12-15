package TAM;

import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("all")
public class Night {

    private final GameState nightIdentifier; // Ex: NIGHT_1, NIGHT_2
    private final int difficultyLevelBonnie;
    private final int difficultyLevelFreddy;
    private boolean isCompleted = false; // Se o jogador completou (6:00 AM)

    // Timer para o relógio do jogo
    private Timer gameTimer;

    // Variável que armazena o tempo decorrido, em segundos.
    private int timeElapsedSeconds = 0;
    private final int totalNightDurationSeconds = 3; // Duração de 3 minutos para teste!

    // Referência ao motor para poder chamar changeState (Victory/GameOver)
    private final GameEngine engine;

    public Night(GameEngine engine, GameState identifier, int bonnieDiff, int freddyDiff) {
        this.engine = engine;
        this.nightIdentifier = identifier;
        this.difficultyLevelBonnie = bonnieDiff;
        this.difficultyLevelFreddy = freddyDiff;
        System.out.println("LOG [Night]: " + identifier + " started. Difficult B/F: " + bonnieDiff + "/" + freddyDiff);
    }

    /**
     * Inicia o timer da noite.
     */
    public void startNight() {
        this.timeElapsedSeconds = 0;
        this.isCompleted = false;

        // Timer que executa a cada 1 segundo (simula o tempo real)
        gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeElapsedSeconds++;
                /*System.out.println("RELÓGIO: " + timeElapsedSeconds + "s / " + totalNightDurationSeconds + "s");*/

                // Verifica a condição de vitória
                if (timeElapsedSeconds == totalNightDurationSeconds) {
                    endNight(true); // Fim da noite (Vitória)
                    return;
                }

                // *** Aqui, no futuro, você chamará a lógica de Animatronic.move() ***
                // Ex: engine.getAnimatronicManager().updateAI(difficultyLevelBonnie, difficultyLevelFreddy);
            }
        }, 1000, 1000); // 1000ms de delay inicial, 1000ms de repetição
    }

    /**
     * Termina a noite e notifica o GameEngine.
     * @param victory true se o jogador venceu (6:00 AM), false se foi Game Over.
     */
    public void endNight(boolean victory) {
        if (gameTimer != null) {
            gameTimer.cancel(); // Para o timer para evitar que a noite continue
        }
        this.isCompleted = victory;

        if (victory) {
            engine.changeState(GameState.VICTORY_SCREEN);
        } else {
            engine.changeState(GameState.GAME_OVER);
        }
    }

    // Métodos para o motor poder verificar o estado
    public int getDifficultyLevelBonnie() { return difficultyLevelBonnie; }
    public int getDifficultyLevelFreddy() { return difficultyLevelFreddy; }
    public GameState getNightIdentifier() { return nightIdentifier; }
    public boolean isCompleted() { return isCompleted; }

    // Metodo de teste: Chamado para simular o jumpscare
    public void triggerGameOver() {
        System.out.println("JUMPSCARE! GAME OVER.");
        endNight(false);
    }
}
