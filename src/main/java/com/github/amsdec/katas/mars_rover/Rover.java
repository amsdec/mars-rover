package com.github.amsdec.katas.mars_rover;

public class Rover {

    private RoverStatus status;

    private final Planet planet;

    private final CommandFactory commandFactory;

    public Rover(final RoverStatus status, final Planet planet) {
        this.status = status;
        this.planet = planet;
        this.commandFactory = new CommandFactory();
    }

    public RoverStatus execute(final String commandsString) {
        try {
            for (final char c : commandsString.toCharArray()) {
                final Command command = this.commandFactory.get(this.status, this.planet, c);
                this.status = command.execute();
            }
        } catch (final ObstacleFoundException e) {
            System.out.println("Obstacle found... last status will be returned");
        }

        return this.status;
    }

}
