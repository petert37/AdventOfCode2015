package hu.petert.aoc.d6;

public class Light {

    private boolean on;
    private int brightness;

    public Light(){
        on = false;
        brightness = 0;
    }

    public boolean toggle(){
        on = !on;
        brightness += 2;
        return on;
    }

    public void off(){
        on = false;
        brightness = Math.max(brightness - 1, 0);
    }

    public void on(){
        on = true;
        brightness++;
    }

    public boolean isOn() {
        return on;
    }

    public int getBrightness() {
        return brightness;
    }
}
