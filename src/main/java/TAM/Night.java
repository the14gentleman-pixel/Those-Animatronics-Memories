package TAM;

import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("all")
public class Night {

    // Constantes de Jogo (Configuração da Noite)
    private final int SPRING_BONNIE_DIFFICULTY; // 1-20
    private final int FREDBEAR_DIFFICULTY;      // 1-20

    // Lógica de Tempo (8 min e 30 seg total / 85 seg por hora do jogo)
    private final int SECONDS_PER_GAME_HOUR = 85;
    private final int totalNightDurationSeconds = 510; // 6 * 85 = 510 segundos
    private int timeElapsedSeconds = 0;

    private Timer timer;
    private GameEngine gameEngine;

    public Night(int springBonnieDiff, int fredbearDiff, GameEngine engine) {
        this.SPRING_BONNIE_DIFFICULTY = springBonnieDiff;
        this.FREDBEAR_DIFFICULTY = fredbearDiff;
        this.gameEngine = engine;
        System.out.println("LOG [Night]: " + gameEngine.getCurrentState().name() +
                " started. Difficult B/F: " + springBonnieDiff + "/" + fredbearDiff);
    }

    /**
     * Inicia o loop de jogo (TimerTask) que roda a cada segundo.
     */
    public void startNight() {
        this.timer = new Timer(true); // true = daemon thread (para fechar com o programa)
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // APENAS LÓGICA DE CÁLCULO E ATUALIZAÇÃO DE ESTADO. NENHUM print AQUI.
                timeElapsedSeconds++;

                // 1. CHECAGEM DE VITÓRIA (6:00 AM)
                if (timeElapsedSeconds >= totalNightDurationSeconds) {
                    timer.cancel(); // Para o TimerTask
                    gameEngine.endNight(true); // Chamada para vitória
                    return;
                }

                // 2. LÓGICA DE SANIDADE E AÇÕES DO JOGADOR
                // ESTE SERÁ O PRÓXIMO PASSO DE IMPLEMENTAÇÃO.
            }
        }, 1000, 1000); // Executa a cada 1000ms (1 segundo)
    }

    // ----------------------------------------------------
    // GETTERS
    // ----------------------------------------------------

    public int getTimeElapsedSeconds() {
        return timeElapsedSeconds;
    }

    /**
     * Retorna o tempo formatado (simulando 12:00 AM -> 6:00 AM).
     */
    public String getFormattedTime() {
        if (timeElapsedSeconds >= totalNightDurationSeconds) {
            return "6:00 AM (VICTORY)";
        }

        int gameHour = timeElapsedSeconds / SECONDS_PER_GAME_HOUR;
        int displayedHour = (12 + gameHour) % 12;
        if (displayedHour == 0) {
            displayedHour = 12;
        }

        // Simulação de minutos FNaF: (60 minutos do jogo / 85 segundos reais)
        int secondsIntoHour = timeElapsedSeconds % SECONDS_PER_GAME_HOUR;
        int gameMinutes = (secondsIntoHour * 60) / SECONDS_PER_GAME_HOUR;
        String formattedMinutes = String.format("%02d", gameMinutes);

        return displayedHour + ":" + formattedMinutes + " AM";
    }
}