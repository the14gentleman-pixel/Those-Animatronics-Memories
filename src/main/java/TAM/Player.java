package TAM;

@SuppressWarnings("all")
public class Player {

    // ----------------------------------------------------
    // ATTRIBUTES (Sanity and State)
    // ----------------------------------------------------
    private int sanity = 100; // Sanidade inicial (100% - Seção 6)
    private final int MAX_SANITY = 100;

    private OfficeView currentView = OfficeView.FRONT_VIEW; // Começa olhando para frente

    // Estados interativos.
    private boolean isLightOn = true; // Luz da sala (Toggle)
    private boolean isHoldingDoor = false; // Porta lateral segurada (Seção 4)
    private boolean isCameraActive = false; // Monitor de câmeras ativo
    private boolean isPhotoActive = false; // Olhando para a foto da filha

    // ----------------------------------------------------
    // CONSTRUCTOR
    // ----------------------------------------------------
    public Player() {
        // Inicialização padrão
    }

    // ----------------------------------------------------
    // ACTIONS AND VIEW CONTROL
    // ----------------------------------------------------

    /**
     * Changes the player's perspective in the office.
     */
    public void changeView(OfficeView newView) {
        // Se a câmera estiver ativa, desliga-a antes de mudar a visão
        if (this.isCameraActive) {
            toggleCameras();
        }

        // Se sair de debaixo da mesa, desativa o estado de esconder.
        if (this.currentView == OfficeView.UNDER_DESK && newView != OfficeView.UNDER_DESK) {
            System.out.println("ACTION: Leaving hiding spot.");
        }

        this.currentView = newView;
        System.out.println("VIEW: Changing to " + newView.name());
    }

    /**
     * Toggles the camera monitor.
     */
    public void toggleCameras() {
        // Não pode usar câmeras se estiver escondido
        if (currentView == OfficeView.UNDER_DESK) {
            System.out.println("PLAYER: Cannot use cameras while hiding.");
            return;
        }

        this.isCameraActive = !this.isCameraActive;

        if (this.isCameraActive) {
            this.currentView = OfficeView.CAMERA_MONITOR;
            System.out.println("ACTION: Camera monitor ON.");
        } else {
            // Volta para a vista frontal ao desligar
            this.currentView = OfficeView.FRONT_VIEW;
            System.out.println("ACTION: Camera monitor OFF.");
        }
    }

    /**
     * Toggles the office light.
     */
    public void toggleLight(boolean turnOn) {
        this.isLightOn = turnOn;
        System.out.println("ACTION: Office Light is " + (turnOn ? "ON" : "OFF") + ".");
    }

    /**
     * Toggles the hiding state.
     */
    public void toggleHide(boolean hide) {
        // Se a câmera estiver ativa, primeiro desliga
        if (this.isCameraActive) {
            toggleCameras();
        }

        if (hide) {
            this.currentView = OfficeView.UNDER_DESK;
            System.out.println("ACTION: Hiding under the desk.");
        } else {
            this.currentView = OfficeView.FRONT_VIEW;
            System.out.println("ACTION: Leaving hiding spot.");
        }
    }

    /**
     * Toggles holding the left door.
     */
    public void holdDoor(boolean hold) {
        this.isHoldingDoor = hold;
        System.out.println("ACTION: Left Door is being " + (hold ? "HELD." : "RELEASED.") + ".");
    }

    /**
     * Toggles looking at the daughter's photo.
     */
    public void lookAtPhoto(boolean look) {
        this.isPhotoActive = look;
        System.out.println("ACTION: Looking at photo: " + (look ? "RECOVERING SANITY." : "STOPPED.") + ".");
    }

    // ----------------------------------------------------
    // SANITY CONTROL (Seção 6 e 7)
    // ----------------------------------------------------

    /**
     * Alters sanity (positive for gain, negative for loss)
     */
    public void alterSanity(int amount) {
        int newSanity = this.sanity + amount;

        if (newSanity > MAX_SANITY) {
            newSanity = MAX_SANITY;
        } else if (newSanity < 0) {
            newSanity = 0;
        }

        if (newSanity != this.sanity) {
            this.sanity = newSanity;
            System.out.println("SANITY: " + (amount > 0 ? "+" : "") + amount + " -> " + this.sanity + "%");
        }

        // CRÍTICO: Checagem de Colapso Mental
        if (this.sanity <= 0) {
            System.out.println("SANITY ALERT: MENTAL COLLAPSE IMMINENT (Sanity Zero!)");
            // A lógica de Game Over será ativada pelo GameEngine.
        }
    }

    // ----------------------------------------------------
    // GETTERS
    // ----------------------------------------------------

    public int getSanity() { return sanity; }
    public OfficeView getCurrentView() { return currentView; }
    public boolean isLightOn() { return isLightOn; }
    public boolean isHoldingDoor() { return isHoldingDoor; }
    public boolean isCameraActive() { return isCameraActive; }
    public boolean isPhotoActive() { return isPhotoActive; }
}