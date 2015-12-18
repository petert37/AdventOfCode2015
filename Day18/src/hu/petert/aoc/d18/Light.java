package hu.petert.aoc.d18;

public class Light {

    private boolean on;
    private boolean nextOn;
    private boolean stuck;

    public Light(boolean on){
        this.on = on;
    }

    public boolean isOn() {
        return stuck || on;
    }

    public void update(){
        on = nextOn;
    }

    public void setNextState(int onCount) {
        nextOn = on && (onCount == 2 || onCount == 3) || !on && onCount == 3;
    }

    public void setStuck(boolean stuck) {
        this.stuck = stuck;
    }
}
