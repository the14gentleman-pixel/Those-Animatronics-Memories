package TAM;

@SuppressWarnings("all")

public class Camera {
    private boolean state; //closed or opened
    private int cam; //what cam is selected


    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getCam() {
        return cam;
    }

    public void setCam(int cam) {
        this.cam = cam;
    }


    public void swtichcam(){
        System.out.println("swtich cam");
    }

    public void gettinopened(){
        System.out.println("gettin opened");
    }

    public void gettinclosed(){
        System.out.println("gettinclosed");
    }

    public void gettincrash(){
        System.out.println("gettincrash");
    }
}
