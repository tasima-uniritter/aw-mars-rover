package br.edu.tasima.aw.marsrover.service;

import br.edu.tasima.aw.marsrover.domain.Mars;
import br.edu.tasima.aw.marsrover.domain.Rover;
import br.edu.tasima.aw.marsrover.domain.enums.MovementInstructionEnum;
import javafx.util.Pair;

public class DiscoverMars {
    private Mars mars;

    DiscoverMars(Integer marsSize) {
        this.mars = new Mars(marsSize);
    }

    public Mars getMars() {
        return mars;
    }

    public void landRover(Rover rover, Integer positionX, Integer positionY) {
        this.mars.roverLanding(rover, new Pair<>(positionX, positionY));
    }

    public void moveRover(String instruction) {
        if (instruction.equals(MovementInstructionEnum.L.name())) {
            moveRoverL();
        } else if (instruction.equals(MovementInstructionEnum.O.name())) {
            moveRoverO();
        } else if (instruction.equals(MovementInstructionEnum.N.name())) {
            moveRoverN();
        } else if (instruction.equals(MovementInstructionEnum.S.name())) {
            moveRoverS();
        }
    }

    public void moveRoverN() {
        Pair<Integer, Integer> lastPosition = this.mars.getRover().getPosition();
        this.mars.getMarsTerrain()[lastPosition.getKey()][lastPosition.getValue()] = false;

        Pair<Integer, Integer> newPosition = new Pair<>(lastPosition.getKey(), lastPosition.getValue() - 1);
        this.mars.getMarsTerrain()[newPosition.getKey()][newPosition.getValue()] = true;

        this.mars.getRover().setPosition(newPosition);
    }


    public void moveRoverS() {
        Pair<Integer, Integer> lastPosition = this.mars.getRover().getPosition();
        this.mars.getMarsTerrain()[lastPosition.getKey()][lastPosition.getValue()] = false;

        Pair<Integer, Integer> newPosition = new Pair<>(lastPosition.getKey(), lastPosition.getValue() + 1);
        this.mars.getMarsTerrain()[newPosition.getKey()][newPosition.getValue()] = true;

        this.mars.getRover().setPosition(newPosition);
    }


    public void moveRoverO() {
        Pair<Integer, Integer> lastPosition = this.mars.getRover().getPosition();
        this.mars.getMarsTerrain()[lastPosition.getKey()][lastPosition.getValue()] = false;

        Pair<Integer, Integer> newPosition = new Pair<>(lastPosition.getKey() - 1, lastPosition.getValue());
        this.mars.getMarsTerrain()[newPosition.getKey()][newPosition.getValue()] = true;

        this.mars.getRover().setPosition(newPosition);
    }


    public void moveRoverL() {
        Pair<Integer, Integer> lastPosition = this.mars.getRover().getPosition();
        this.mars.getMarsTerrain()[lastPosition.getKey()][lastPosition.getValue()] = false;

        Pair<Integer, Integer> newPosition = new Pair<>(lastPosition.getKey() + 1, lastPosition.getValue());
        this.mars.getMarsTerrain()[newPosition.getKey()][newPosition.getValue()] = true;

        this.mars.getRover().setPosition(newPosition);
    }
}
