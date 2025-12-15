package TAM;

@SuppressWarnings("all")

public class Player {
    private boolean ongame; //if it is on the game or menu
    private boolean state;//alive or dead
    private int position; //it its on the door, table, cameras
    private boolean checkcam; //it's on or off the cameras
    private boolean holdindoor; //if it is holdin the door against Springbonnie
    private boolean undertable; //if it is under the table against FredBear
    private int sanity; //see how is the sanity of the player


    public Player(boolean ongame, boolean checkcam, boolean state, boolean holdindoor, boolean undertable, int sanity) {
        this.ongame = false;
        this.checkcam = false;
        this.state = true;
        this.holdindoor = false;
        this.undertable = false;
        this.sanity = 100;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isOngame() {
        return ongame;
    }

    public void setOngame(boolean ongame) {
        this.ongame = ongame;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isHoldindoor() {
        return holdindoor;
    }

    public void setHoldindoor(boolean holdindoor) {
        this.holdindoor = holdindoor;
    }

    public boolean isCheckcam() {
        return checkcam;
    }

    public void setCheckcam(boolean checkcam) {
        this.checkcam = checkcam;
    }

    public boolean isUndertable() {
        return undertable;
    }

    public void setUndertable(boolean undertable) {
        this.undertable = undertable;
    }

    public int getSanity() {
        return sanity;
    }

    public void setSanity(int sanity) {
        this.sanity = sanity;
    }


    public void opencam() {
        System.out.println("opening cameras");
    }

    public void selectcam() {
        System.out.println("selecting camera");
    }

    public void closecam(){
        System.out.println("closing cameras");
    }

    public void gotodoor() {
        System.out.println("going to the door");
    }

    public void holdoor() {
        System.out.println("holding to the door");
    }

    public void dropdoor() {
        System.out.println("dropping to the door");
    }

    public void back(){
        System.out.println("Going back");
    }

    public void gototable() {
        System.out.println("going to the table");
    }

    public void getdown() {
        System.out.println("getting down");
    }

    public void getup() {
        System.out.println("leaving under the table");
    }
}
