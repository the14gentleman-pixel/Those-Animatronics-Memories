package TAM;

@SuppressWarnings("all")
public class AssetManager {

    // Caminho base para todos os recursos.
    private static final String RESOURCE_BASE_PATH = "resources/img/";

    // Imagens do Menu e Telas Estáticas (USANDO .JPG)
    public static final String MAIN_MENU_IMAGE = RESOURCE_BASE_PATH + "main_menu.jpg";
    public static final String LOADING_SCREEN_IMAGE = RESOURCE_BASE_PATH + "loading_screen.jpg";
    public static final String CREDITS_IMAGE = RESOURCE_BASE_PATH + "credits_screen.jpg";

    // Imagens de Jogo (USANDO .JPG)
    public static final String OFFICE_BACKGROUND_IMAGE = RESOURCE_BASE_PATH + "office_background.jpg";
    public static final String MINIGAME_SCENE_IMAGE = RESOURCE_BASE_PATH + "minigame_scene.jpg";
    public static final String GAME_OVER_IMAGE = RESOURCE_BASE_PATH + "game_over_jumpscare.jpg";

    /**
     * Simula o carregamento de um recurso.
     */
    public static void loadImage(String path) {
        System.out.println("LOG [Assets]: Imagem carregada: " + path);
        // Em uma GUI real, a lógica de carregar a imagem ocorreria aqui.
    }
}