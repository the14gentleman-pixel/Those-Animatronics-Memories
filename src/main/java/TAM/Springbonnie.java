package TAM;

@SuppressWarnings("all")
// Springbonnie herda todas as características de Animatronic
public class Springbonnie extends Animatronic {

    // Adiciona características ÚNICAS
    private boolean isHoldingDoor = false;

    // Construtor: Chama o construtor da Superclasse (Animatronic)
    public Springbonnie(int initialPosition) {
        super("Springbonnie", initialPosition); // Define o nome e a posição inicial
    }

    // Implementa o método abstrato 'move'
    @Override
    public void move() {
        if (isActive() && !isCounterized()) {
            System.out.println(getName() + " está se movendo pelo corredor.");
            // Lógica de movimento de Springbonnie...
            // this.position++;
        }
    }

    // Adiciona um método de ação ÚNICA
    public void attemptDoorHold() {
        if (getPosition() == 5) { // Exemplo: Posição da porta
            isHoldingDoor = true;
            System.out.println("Springbonnie chegou e está forçando a porta!");
        }
    }

    public boolean isHoldingDoor() {
        return isHoldingDoor;
    }
}
