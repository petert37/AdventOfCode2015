package hu.petert.aoc.d13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Person {

    String name;
    Map<String, Integer> happiness;

    public Person(String name){
        happiness = new HashMap<>();
        this.name = name;
    }

    public void addHappiness(String name, int value){
        happiness.put(name, value);
    }

    public void constructHappinessList(List<String> parents, int delta, List<Integer> happinesses){
        parents.add(this.name);
        List<String> children = happiness.keySet().stream().filter(name -> !parents.contains(name)).collect(Collectors.toList());

        if(parents.size() > 1)
        delta += happiness.get(parents.get(parents.size() - 2));

        if(children.isEmpty()){
            delta += happiness.get(parents.get(0)) + Main.people.get(parents.get(0)).happiness.get(name);
            happinesses.add(delta);
            return;
        }

        for(String s : children) {
            List<String> newParents = new ArrayList<>();
            newParents.addAll(parents);
            int d = delta + happiness.get(s);
            Main.people.get(s).constructHappinessList(newParents, d, happinesses);
        }
    }

}
