package hu.petert.aoc.d14;

public class Reindeer {

    int speed;
    int time;
    int rest;
    int points;

    public Reindeer(int speed, int time, int rest) {
        this.speed = speed;
        this.time = time;
        this.rest = rest;
    }

    public int getDistance(int seconds){
        return (seconds / (time + rest)) * speed * time + Math.min(time, seconds % (time + rest)) * speed;
    }

}
