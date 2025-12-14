package TAM;

@SuppressWarnings("all")

public abstract class Animatronic {
    private String name; // Nome do animatrônico (FredBear, Springbonnie)
    private int position; // Posição (usaremos int por enquanto, mas logo trocamos para String/enum)
    private boolean active = false; // Inicialmente desativado
    private int agressivity = 0; // Nível de agressividade
    private boolean attacking = false;
    private boolean counterized = false;


    // Construtor obrigatório para todas as subclasses
    public Animatronic(String name, int initialPosition) {
        this.name = name;
        this.position = initialPosition;
        System.out.println(name + " foi inicializado na posição " + initialPosition);
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getAgressivity() {
        return agressivity;
    }

    public void setAgressivity(int agressivity) {
        this.agressivity = agressivity;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isCounterized() {
        return counterized;
    }

    public void setCounterized(boolean counterized) {
        this.counterized = counterized;
    }


    public void move() {
        System.out.println("moving to x position");
    }

    public void attack() {
        System.out.println("attacking player");
    }

    public void counterized() {
        System.out.println("counterized by the player");
    }
}
