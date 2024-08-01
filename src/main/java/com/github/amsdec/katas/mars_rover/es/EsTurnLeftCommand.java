package com.github.amsdec.katas.mars_rover.es;

import com.github.amsdec.katas.mars_rover.Command;
import com.github.amsdec.katas.mars_rover.RoverStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EsTurnLeftCommand implements Command {

    private final RoverStatus status;

    @Override
    public RoverStatus execute() {
        String nextOrientation = null;
        if ("N".equals(this.status.getOrientation())) {
            nextOrientation = "O";
        }
        if ("S".equals(this.status.getOrientation())) {
            nextOrientation = "E";
        }
        if ("E".equals(this.status.getOrientation())) {
            nextOrientation = "N";
        }
        if ("O".equals(this.status.getOrientation())) {
            nextOrientation = "S";
        }
        return new RoverStatus(this.status.getPosition(), nextOrientation);
    }
}
