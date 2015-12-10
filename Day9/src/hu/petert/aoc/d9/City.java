package hu.petert.aoc.d9;

import java.util.*;

public class City {

    private Map<City, Integer> connections;

    final String name;

    public City(String name){
        this.name = name;
        connections = new HashMap<>();
    }

    public void addConnection(City city, int distance){
       connections.put(city, distance);
    }

    public int getShortestRoute(List<City> parents, int distance){
        List<Integer> distances = new ArrayList<>();
        parents.add(this);

        for (City c : connections.keySet()){
            if(!parents.contains(c)){
                List<City> newParents = new ArrayList<>();
                newParents.addAll(parents);
                distances.add(c.getShortestRoute(newParents, distance + connections.get(c)));
            }
        }

        if(distances.isEmpty()) return distance;

        return Collections.min(distances);
    }

    public int getLongestRoute(List<City> parents, int distance){
        List<Integer> distances = new ArrayList<>();
        parents.add(this);

        for (City c : connections.keySet()){
            if(!parents.contains(c)){
                List<City> newParents = new ArrayList<>();
                newParents.addAll(parents);
                distances.add(c.getLongestRoute(newParents, distance + connections.get(c)));
            }
        }

        if(distances.isEmpty()) return distance;

        return Collections.max(distances);
    }

}
