package com.github.amsdec.katas.mars_rover;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class RoverStatus {

    private final Position position;

    private final String orientation;

    public int getX() {
        return this.position.getX();
    }

    public int getY() {
        return this.position.getY();
    }

}
