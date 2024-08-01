package com.github.amsdec.katas.mars_rover.es;

import com.github.amsdec.katas.mars_rover.Command;
import com.github.amsdec.katas.mars_rover.InvalidCommandException;
import com.github.amsdec.katas.mars_rover.Planet;
import com.github.amsdec.katas.mars_rover.Rover;
import com.github.amsdec.katas.mars_rover.RoverStatus;

public class EsRover extends Rover {

    public EsRover(final RoverStatus status, final Planet planet) {
        super(status, planet);
    }

    @Override
    protected Command make(final RoverStatus status, final Planet planet, final char command) {
        switch (command) {
            case 'I':
                return new EsTurnLeftCommand(status);
            case 'D':
                return new EsTurnRightCommand(status);
            case 'A':
                return new EsMoveCommand(status, planet);
            default:
                break;
        }

        throw new InvalidCommandException(String.format("Comando '%s' no reconocido", command));
    }

}
