package com.github.amsdec.katas.mars_rover.en;

import com.github.amsdec.katas.mars_rover.Command;
import com.github.amsdec.katas.mars_rover.InvalidCommandException;
import com.github.amsdec.katas.mars_rover.Planet;
import com.github.amsdec.katas.mars_rover.Rover;
import com.github.amsdec.katas.mars_rover.RoverStatus;

public class EnRover extends Rover {

    public EnRover(final RoverStatus status, final Planet planet) {
        super(status, planet);
    }

    @Override
    protected Command make(final RoverStatus status, final Planet planet, final char command) {
        switch (command) {
            case 'L':
                return new EnTurnLeftCommand(status);
            case 'R':
                return new EnTurnRightCommand(status);
            case 'M':
                return new EnMoveCommand(status, planet);
            default:
                throw new InvalidCommandException(String.format("Invalid command %s", command));
        }
    }

}
