package com.focaltec.training.katas.mars_rover;

public final class CommandFactory {

    private CommandFactory() {

    }

    public static Command get(final RoverStatus status, final Planet planet, final char command) {
        switch (command) {
            case 'L':
                return new TurnLeftCommand(status);
            case 'R':
                return new TurnRightCommand(status);
            case 'M':
                return new MoveCommand(status, planet);
            default:
                throw new InvalidCommandException(String.format("Invalid command %s", command));
        }
    }

}
