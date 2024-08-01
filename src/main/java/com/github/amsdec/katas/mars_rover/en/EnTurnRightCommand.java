package com.github.amsdec.katas.mars_rover.en;

import com.github.amsdec.katas.mars_rover.Command;
import com.github.amsdec.katas.mars_rover.RoverStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EnTurnRightCommand implements Command {

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
