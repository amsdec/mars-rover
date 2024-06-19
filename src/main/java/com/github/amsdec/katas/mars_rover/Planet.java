package com.github.amsdec.katas.mars_rover;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lombok.Getter;

public class Planet {

    @Getter
    private final int alto;

    @Getter
    private final int ancho;

    private final List<Position> obstacles;

    public Planet(final int alto, final int ancho, final List<Position> obstacles) {
        this.alto = alto;
        this.ancho = ancho;
        this.obstacles = Optional.ofNullable(obstacles).orElse(Collections.emptyList());
    }

    public boolean hasObstacleAt(final Position position) {
        return this.obstacles.stream().anyMatch(o -> o.getX() == position.getX() && o.getY() == position.getY());
    }
}
