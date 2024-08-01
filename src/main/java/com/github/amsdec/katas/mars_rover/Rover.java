package com.github.amsdec.katas.mars_rover;

public abstract class Rover {

    private RoverStatus status;

    private final Planet planet;

    protected Rover(final RoverStatus status, final Planet planet) {
        this.status = status;
        this.planet = planet;
    }

    public RoverStatus execute(final String commandsString) {
        try {
            for (final char c : commandsString.toCharArray()) {
                final Command command = this.make(this.status, this.planet, c);
                this.status = command.execute();
            }
        } catch (final ObstacleFoundException e) {
            System.out.println("Obstacle found... last status will be returned");
        }

        return this.status;
    }

    protected abstract Command make(final RoverStatus status, final Planet planet, final char command);

}
