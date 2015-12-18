package hu.petert.aoc.d18;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int SIZE = 100;

    private Light[][] lights;

    public Board(){
        lights = new Light[SIZE][SIZE];
    }

    public void addLight(int x, int y, boolean on){
        lights[x][y] = new Light(on);

        //Part 2
        if((x == 0 && (y == 0 || y == SIZE - 1)) || (x == SIZE - 1 && (y == 0 || y == SIZE - 1)))
            lights[x][y].setStuck(true);

    }

    private void updateLights(){
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                lights[x][y].update();
            }
        }
    }

    public void nextFrame(){
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                lights[x][y].setNextState(getSurroundingOnCount(x, y));
            }
        }
        updateLights();
    }

    public int getOnCount(){
        int on = 0;
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if(lights[x][y].isOn()) on++;
            }
        }
        return on;
    }

    public List<Light> getSurroundingLights(int x, int y){

        List<Light> list = new ArrayList<>();

        for(int ix = x - 1; ix <= x + 1; ix++){
            if(ix < 0 || ix >= SIZE) continue;
            for(int iy = y - 1; iy <= y + 1; iy++){
                if(iy < 0 || iy >= SIZE) continue;
                if(ix == x && iy == y) continue;
                if(lights[ix][iy] != null) list.add(lights[ix][iy]);
            }
        }

        return list;
    }

    public int getSurroundingOnCount(int x, int y){
        List<Light> list = getSurroundingLights(x, y);
        int on = 0;
        for (Light l : list)
            if(l.isOn()) on++;
        return on;
    }

}
