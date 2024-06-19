package com.focaltec.training.katas.mars_rover;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TurnLeftCommand implements Command {

    private final RoverStatus status;

    @Override
    public RoverStatus execute() {
        String nextOrientation = null;
        if ("N".equals(this.status.getOrientation())) {
            nextOrientation = "W";
        }
        if ("S".equals(this.status.getOrientation())) {
            nextOrientation = "E";
        }
        if ("E".equals(this.status.getOrientation())) {
            nextOrientation = "N";
        }
        if ("W".equals(this.status.getOrientation())) {
            nextOrientation = "S";
        }
        return new RoverStatus(this.status.getPosition(), nextOrientation);
    }
}
