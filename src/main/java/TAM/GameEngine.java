package TAM;

@SuppressWarnings("all")

public class GameEngine {

    // Variável que guarda o estado atual
    private GameState currentState;

    // Construtor: O jogo sempre começa no menu
    public GameEngine() {
        this.currentState = GameState.MAIN_MENU;
    }

    /**
     * O método que você chamará do TAM.MainMenu para iniciar qualquer ação
     * @param newState O estado para o qual o jogo deve mudar (Ex: GameState.NIGHT_1)
     */
    public void changeState(GameState newState) {
        System.out.println("LOG: Transicao de estado: " + this.currentState + " -> " + newState);

        // Lógica que acontece ANTES da mudança
        switch (newState) {
            case LOADING_NIGHT:
                System.out.println("Exibindo tela de carregamento...");
                // Aqui você colocaria um atraso de 3 segundos para simular o carregamento
                // No futuro: mainFrame.switchPanel(new LoadingScreen());
                break;
            case NIGHT_1:
                System.out.println("Iniciando Noite 1. Bem-vindo ao Escritorio.");
                // Aqui você inicializaria as classes TAM.Player e TAM.Animatronic
                // No futuro: mainFrame.switchPanel(new GamePanel());
                break;
            case NIGHT_2:
                System.out.println("Iniciando Noite 2. Bem-vindo ao Escritorio.");
                // Aqui você inicializaria as classes TAM.Player e TAM.Animatronic
                // No futuro: mainFrame.switchPanel(new GamePanel());
                break;
            case NIGHT_3:
                System.out.println("Iniciando Noite 3. Bem-vindo ao Escritorio.");
                // Aqui você inicializaria as classes TAM.Player e TAM.Animatronic
                // No futuro: mainFrame.switchPanel(new GamePanel());
                break;
            case NIGHT_4:
                System.out.println("Iniciando Noite 4. Bem-vindo ao Escritorio.");
                // Aqui você inicializaria as classes TAM.Player e TAM.Animatronic
                // No futuro: mainFrame.switchPanel(new GamePanel());
                break;
            case NIGHT_5:
                System.out.println("Iniciando Noite 5. Bem-vindo ao Escritorio.");
                // Aqui você inicializaria as classes TAM.Player e TAM.Animatronic
                // No futuro: mainFrame.switchPanel(new GamePanel());
                break;
            case NIGHT_6:
                System.out.println("Iniciando Noite 6. Bem-vindo ao Escritorio.");
                // Aqui você inicializaria as classes TAM.Player e TAM.Animatronic
                // No futuro: mainFrame.switchPanel(new GamePanel());
                break;
            case NIGHT_7:
                System.out.println("Iniciando Noite 7. Bem-vindo ao Escritorio.");
                // Aqui você inicializaria as classes TAM.Player e TAM.Animatronic
                // No futuro: mainFrame.switchPanel(new GamePanel());
                break;
            case VICTORY_SCREEN:
                System.out.println("VICTORY SCREEN");
                // Aqui você salva o progesso da noite passada e chama aleatoriamente um minigame
                break;
            case GAME_OVER:
                System.out.println("GAME OVER");
                // Aqui você verifica qual noite o player está e após exibir a tela, chama de volta a noite que ele estava
                break;
            case CONTINUE_GAME:
                System.out.println("LOG: Tentando carregar jogo salvo...");
                // Lógica de leitura de arquivo
                break;
            case CONFIGURATIONS:
                System.out.println("Carregando configuracoes");
                // Demais lógicas de configuração
                break;
            case CREDITS_SCREEN:
                System.out.println("Exibindo creditos");
                break;
            case MINIGAME_1:
                System.out.println("MINIGAME 1");
                break;
            case MINIGAME_2:
                System.out.println("MINIGAME 2");
                break;
            case MINIGAME_3:
                System.out.println("MINIGAME 3");
                break;
            case MINIGAME_4:
                System.out.println("MINIGAME 4");
                break;
            case  MINIGAME_5:
                System.out.println("MINIGAME 5");
                break;
            case  MINIGAME_6:
                System.out.println("MINIGAME 6");
                break;
            case MINIGAME_7:
                System.out.println("MINIGAME 7");
                break;
        }

        // Atualiza o estado
        this.currentState = newState;
    }

    // Getter para saber o estado atual (útil para a interface)
    public GameState getCurrentState() {
        return currentState;
    }

    // Método que será chamado repetidamente para rodar a lógica do jogo (o "Tick" ou "Loop")
    public void update() {
        if (currentState == GameState.NIGHT_1) {
            // Lógica do jogo (movimentação, energia, etc.)
            System.out.println("LOG: Jogo rodando... Tick de lógica.");
        }
        // ... outras lógicas por estado
    }
}
