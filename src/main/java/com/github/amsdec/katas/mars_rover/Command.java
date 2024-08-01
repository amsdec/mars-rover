package com.github.amsdec.katas.mars_rover;

public interface Command extends CommandPrototype {

    RoverStatus execute();

}
