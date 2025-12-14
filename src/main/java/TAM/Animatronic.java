package TAM;

@SuppressWarnings("all")

public class Animatronic {
    private int position; //in what position is the animatronic are?
    private boolean active; //it is active or not
    private int agressivity; //level of the agressivity of the animatronic
    private boolean attacking; //it is attacking the player or not
    private boolean counterized; //the animatronic got counterized by the player?


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
