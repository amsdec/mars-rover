package com.github.amsdec.katas.mars_rover;

public class Rover {

    private RoverStatus status;

    private final Planet planet;

    private final CommandFactory commandFactory;

    public Rover(final RoverStatus status, final Planet planet, final CommandFactory commandFactory) {
        this.status = status;
        this.planet = planet;
        this.commandFactory = commandFactory;
    }

    public RoverStatus execute(final String commandsString) {
        try {
            for (final char c : commandsString.toCharArray()) {
                final Command command = this.commandFactory.make(this.status, this.planet, c);
                this.status = command.execute();
            }
        } catch (final ObstacleFoundException e) {
            System.out.println("Obstacle found... last status will be returned");
        }

        return this.status;
    }

}
