package com.github.amsdec.katas.mars_rover.en;

import com.github.amsdec.katas.mars_rover.Command;
import com.github.amsdec.katas.mars_rover.RoverStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EnTurnLeftCommand implements Command {

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
