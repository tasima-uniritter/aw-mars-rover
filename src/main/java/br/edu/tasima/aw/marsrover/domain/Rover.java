package br.edu.tasima.aw.marsrover.domain;

import javafx.util.Pair;

public class Rover {
    private String roverCode;
    private Pair<Integer, Integer> position;

    public Rover(String roverCode) {
        this.roverCode = roverCode;
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    public String getRoverCode() {
        return roverCode;
    }

    public void setPosition(Pair<Integer, Integer> position) {
        this.position = position;
    }
}
