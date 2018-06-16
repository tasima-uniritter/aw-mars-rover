package br.edu.tasima.aw.marsrover.service;

import br.edu.tasima.aw.marsrover.domain.Rover;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DiscoverMarsTest {

    @Test
    public void test_roverLand() {
        Rover rover = new Rover("PathFinder");
        Integer positionX = 1;
        Integer positionY = 1;
        DiscoverMars discoverMars = new DiscoverMars(10);

        discoverMars.landRover(rover, positionX, positionY);

        assertEquals(rover, discoverMars.getMars().getRover());

        assertEquals(positionX, rover.getPosition().getKey());
        assertEquals(positionY, rover.getPosition().getValue());

        assertTrue(discoverMars.getMars().getMarsTerrain()[positionX][positionY]);
    }

    @Test
    public void test_roverMoveN() {
        Rover rover = new Rover("PathFinder");
        Integer positionX = 1;
        Integer positionY = 5;
        DiscoverMars discoverMars = new DiscoverMars(10);

        discoverMars.landRover(rover, positionX, positionY);
        discoverMars.moveRoverN();

        Integer newPositionY = positionY - 1;

        assertEquals(positionX, rover.getPosition().getKey());
        assertEquals(newPositionY, rover.getPosition().getValue());

        assertTrue(discoverMars.getMars().getMarsTerrain()[positionX][positionY - 1]);
    }

    @Test
    public void test_roverMoveS() {
        Rover rover = new Rover("PathFinder");
        Integer positionX = 5;
        Integer positionY = 5;
        DiscoverMars discoverMars = new DiscoverMars(10);

        discoverMars.landRover(rover, positionX, positionY);
        discoverMars.moveRoverS();

        Integer newPositionY = positionY + 1;

        assertEquals(positionX, rover.getPosition().getKey());
        assertEquals(newPositionY, rover.getPosition().getValue());

        assertTrue(discoverMars.getMars().getMarsTerrain()[positionX][newPositionY]);
    }

    @Test
    public void test_roverMoveL() {
        Rover rover = new Rover("PathFinder");
        Integer positionX = 5;
        Integer positionY = 5;
        DiscoverMars discoverMars = new DiscoverMars(10);

        discoverMars.landRover(rover, positionX, positionY);
        discoverMars.moveRoverL();

        Integer newPositionX = positionX + 1;

        assertEquals(newPositionX, rover.getPosition().getKey());
        assertEquals(positionY, rover.getPosition().getValue());

        assertTrue(discoverMars.getMars().getMarsTerrain()[newPositionX][positionY]);
    }

    @Test
    public void test_roverMoveO() {
        Rover rover = new Rover("PathFinder");
        Integer positionX = 5;
        Integer positionY = 5;
        DiscoverMars discoverMars = new DiscoverMars(10);

        discoverMars.landRover(rover, positionX, positionY);
        discoverMars.moveRoverO();

        Integer newPositionX = positionX - 1;

        assertEquals(newPositionX, rover.getPosition().getKey());
        assertEquals(positionY, rover.getPosition().getValue());

        assertTrue(discoverMars.getMars().getMarsTerrain()[newPositionX][positionY]);
    }

    @Test
    public void test_InstructionMoveRover() {
        Rover rover = new Rover("PathFinder");
        Integer positionX = 5;
        Integer positionY = 5;
        DiscoverMars discoverMars = new DiscoverMars(10);

        discoverMars.landRover(rover, positionX, positionY);

        String instructions = "L,L,N,N,L,L";

        for(String instruction : instructions.split(",")){
            discoverMars.moveRover(instruction);
        }

        assertTrue(discoverMars.getMars().getMarsTerrain()[9][3]);
    }
}
