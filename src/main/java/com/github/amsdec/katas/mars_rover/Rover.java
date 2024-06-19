package com.github.amsdec.katas.mars_rover;

public class Rover {

    private RoverStatus status;

    private final Planet planet;

    public Rover(final RoverStatus status, final Planet planet) {
        this.status = status;
        this.planet = planet;
    }

    public RoverStatus execute(final String commandsString) {
        try {
            for (final char c : commandsString.toCharArray()) {
                Command command = CommandFactory.get(this.status, this.planet, c);
                this.status = command.execute();
            }
        } catch (final ObstacleFoundException e) {
            System.out.println("Obstacle found... last status will be returned");
        }

        return this.status;
    }

}
