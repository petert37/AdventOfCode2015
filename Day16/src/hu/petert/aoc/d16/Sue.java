package hu.petert.aoc.d16;

import java.util.HashMap;
import java.util.Map;

public class Sue {

    private Map<String, Integer> properties;
    int index;

    public Sue(int index){
        properties = new HashMap<>();
        this.index = index;
    }

    public void addProperty(String name, int value){
        properties.put(name, value);
    }

    public int getProperty(String name){
        if(properties.containsKey(name)) return properties.get(name);
        return -1;
    }

    public boolean hasProperty(String name){
        return properties.containsKey(name);
    }

    public boolean isPropertyInRange(String name, int value){
        if(!hasProperty(name)) return false;
        if(name.equals("cats") || name.equals("trees"))
            return properties.get(name) > value;
        if(name.equals("pomeranians") || name.equals("goldfish"))
            return properties.get(name) < value;
        return properties.get(name) == value;
    }

}
