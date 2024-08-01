package com.github.amsdec.katas.mars_rover;

import lombok.Setter;

public class MoveCommand implements Command {

    @Setter
    private RoverStatus status;

    @Setter
    private Planet planet;

    @Override
    public RoverStatus execute() {

        int x = this.status.getX();
        int y = this.status.getY();

        if ("N".equals(this.status.getOrientation())) {
            y = this.status.getY() + 1 < this.planet.getAlto() ? this.status.getY() + 1 : 0;
        }

        if ("S".equals(this.status.getOrientation())) {
            y = this.status.getY() - 1 >= 0 ? this.status.getY() - 1 : this.planet.getAlto() - 1;
        }

        if ("E".equals(this.status.getOrientation())) {
            x = this.status.getX() + 1 < this.planet.getAncho() ? this.status.getX() + 1 : 0;
        }

        if ("W".equals(this.status.getOrientation())) {
            x = this.status.getX() - 1 >= 0 ? this.status.getX() - 1 : this.planet.getAncho() - 1;
        }

        final Position nextPosition = new Position(x, y);
        this.validateObstacle(nextPosition);
        return new RoverStatus(nextPosition, this.status.getOrientation());
    }

    private void validateObstacle(final Position nextPosition) {
        if (this.planet.hasObstacleAt(nextPosition)) {
            throw new ObstacleFoundException();
        }
    }

    @Override
    public CommandPrototype cloneCommand() {
        return new MoveCommand();
    }

}
