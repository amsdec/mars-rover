package com.github.amsdec.katas.mars_rover.en;

import com.github.amsdec.katas.mars_rover.Command;
import com.github.amsdec.katas.mars_rover.CommandFactory;
import com.github.amsdec.katas.mars_rover.InvalidCommandException;
import com.github.amsdec.katas.mars_rover.Planet;
import com.github.amsdec.katas.mars_rover.RoverStatus;

public class EnCommandFactory implements CommandFactory {

    @Override
    public Command make(final RoverStatus status, final Planet planet, final char command) {
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
