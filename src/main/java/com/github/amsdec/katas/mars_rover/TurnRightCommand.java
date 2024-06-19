package com.github.amsdec.katas.mars_rover;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TurnRightCommand implements Command {

    private final RoverStatus status;

    @Override
    public RoverStatus execute() {
        String nextOrientation = null;
        if ("N".equals(this.status.getOrientation())) {
            nextOrientation = "E";
        }
        if ("S".equals(this.status.getOrientation())) {
            nextOrientation = "W";
        }
        if ("E".equals(this.status.getOrientation())) {
            nextOrientation = "S";
        }
        if ("W".equals(this.status.getOrientation())) {
            nextOrientation = "N";
        }
        return new RoverStatus(this.status.getPosition(), nextOrientation);
    }

}
