package br.edu.tasima.aw.marsrover.domain;

import javafx.util.Pair;

public class Mars {
    private Boolean[][] marsTerrain;
    private Rover rover;

    public Mars(Integer size) {
        this.marsTerrain = new Boolean[size][size];

        for(int i = 0; i < size; i++){
            for(int j= 0; j < size; j++) {
                this.marsTerrain[i][j] = false;
            }
        }
    }

    public Boolean[][] getMarsTerrain() {
        return marsTerrain;
    }

    public void setMarsTerrain(Boolean[][] marsTerrain) {
        this.marsTerrain = marsTerrain;
    }

    public Rover getRover() {
        return rover;
    }

    public void roverLanding(Rover rover, Pair<Integer,Integer> initialPosition) {
        rover.setPosition(initialPosition);
        this.rover =  rover;
        this.marsTerrain[initialPosition.getKey()][initialPosition.getValue()] = true;
    }


}
