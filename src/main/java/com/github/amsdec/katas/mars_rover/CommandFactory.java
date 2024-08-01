package com.github.amsdec.katas.mars_rover;

public class CommandFactory {

    private final Command turnLeftCommand;

    private final Command turnRightCommand;

    private final Command moveCommand;

    public CommandFactory() {
        this.turnLeftCommand = new TurnLeftCommand();
        this.turnRightCommand = new TurnRightCommand();
        this.moveCommand = new MoveCommand();
    }

    public Command get(final RoverStatus status, final Planet planet, final char command) {
        switch (command) {
            case 'L':
                final CommandPrototype turnLeft = this.turnLeftCommand.cloneCommand();
                ((TurnLeftCommand) turnLeft).setStatus(status);
                return (Command) turnLeft;
            case 'R':
                final CommandPrototype turnRight = this.turnRightCommand.cloneCommand();
                ((TurnRightCommand) turnRight).setStatus(status);
                return (Command) turnRight;
            case 'M':
                final CommandPrototype move = this.moveCommand.cloneCommand();
                ((MoveCommand) move).setStatus(status);
                ((MoveCommand) move).setPlanet(planet);
                return (Command) move;
            default:
                throw new InvalidCommandException(String.format("Invalid command %s", command));
        }
    }

}
