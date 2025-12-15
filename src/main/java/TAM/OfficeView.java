package TAM;

// Enum que representa a perspectiva atual do jogador no escritório
public enum OfficeView {
    FRONT_VIEW,     // Olhando para o corredor frontal (posição default)
    LEFT_DOOR,      // Olhando para a porta lateral (SpringBonnie)
    RIGHT_DOOR,     // Vista lateral oposta (NÃO USADA AINDA)
    CAMERA_MONITOR, // Monitor de câmeras ativo
    UNDER_DESK      // Escondido debaixo da mesa
}