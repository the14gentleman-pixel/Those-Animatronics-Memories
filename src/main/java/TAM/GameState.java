package TAM;

@SuppressWarnings("all")

public enum GameState {
    // Enumeração para o estado principal do jogo (o que está acontecendo)

    // Estados do Menu/Pré-Jogo
    MAIN_MENU,
    CONTINUE_GAME,
    CONFIGURATIONS,
    CREDITS_SCREEN,

    // Estados de Jogo
    LOADING_NIGHT, // Sua "tela de carregamento"
    NIGHT_1,
    NIGHT_2,
    NIGHT_3,
    NIGHT_4,
    NIGHT_5,
    NIGHT_6,
    NIGHT_7,
    GAME_OVER,
    MINIGAME_1,
    MINIGAME_2,
    MINIGAME_3,
    MINIGAME_4,
    MINIGAME_5,
    MINIGAME_6,
    MINIGAME_7,
    VICTORY_SCREEN
    // ... adicione mais noites e estados conforme necessário
}
