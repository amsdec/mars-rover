package com.github.amsdec.katas.mars_rover.es;

import com.github.amsdec.katas.mars_rover.Command;
import com.github.amsdec.katas.mars_rover.RoverStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EsTurnRightCommand implements Command {

    private final RoverStatus status;

    @Override
    public RoverStatus execute() {
        String nextOrientation = null;
        if ("N".equals(this.status.getOrientation())) {
            nextOrientation = "E";
        }
        if ("S".equals(this.status.getOrientation())) {
            nextOrientation = "O";
        }
        if ("E".equals(this.status.getOrientation())) {
            nextOrientation = "S";
        }
        if ("O".equals(this.status.getOrientation())) {
            nextOrientation = "N";
        }
        return new RoverStatus(this.status.getPosition(), nextOrientation);
    }

}
