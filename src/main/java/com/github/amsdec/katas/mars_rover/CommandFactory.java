package com.github.amsdec.katas.mars_rover;

public interface CommandFactory {

    Command make(final RoverStatus status, final Planet planet, final char command);

}
