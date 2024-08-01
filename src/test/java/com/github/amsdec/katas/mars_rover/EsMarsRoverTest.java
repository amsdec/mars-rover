package com.github.amsdec.katas.mars_rover;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.amsdec.katas.mars_rover.es.EsCommandFactory;

public class EsMarsRoverTest {

    private final CommandFactory commandFactory = new EsCommandFactory();

    @Test(expected = InvalidCommandException.class)
    public void comandoDesconocido() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "N"), new Planet(5, 5, null),
                this.commandFactory);
        rover.execute("P");
    }

    @Test
    public void girarAlOesteEstandoOrientadoAlNorte() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "N"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("I");

        Assert.assertEquals(new RoverStatus(new Position(0, 0), "O"), status);
    }

    @Test
    public void girarAlEsteEstandoOrientadoAlNorte() {
        final Rover rover = new Rover(new RoverStatus(new Position(1, 1), "N"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("D");

        Assert.assertEquals(new RoverStatus(new Position(1, 1), "E"), status);
    }

    @Test
    public void girarAlEsteEstandoOrientadoAlSur() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "S"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("I");

        Assert.assertEquals(new RoverStatus(new Position(0, 0), "E"), status);
    }

    @Test
    public void girarAlOesteEstandoOrientadoAlSur() {
        final Rover rover = new Rover(new RoverStatus(new Position(1, 1), "S"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("D");

        Assert.assertEquals(new RoverStatus(new Position(1, 1), "O"), status);
    }

    @Test
    public void girarAlNorteEstandoOrientadoAlEste() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "E"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("I");

        Assert.assertEquals(new RoverStatus(new Position(0, 0), "N"), status);
    }

    @Test
    public void girarAlSurEstandoOrientadoAlEste() {
        final Rover rover = new Rover(new RoverStatus(new Position(1, 1), "E"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("D");

        Assert.assertEquals(new RoverStatus(new Position(1, 1), "S"), status);
    }

    @Test
    public void girarAlSurEstandoOrientadoAlOeste() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "O"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("I");

        Assert.assertEquals(new RoverStatus(new Position(0, 0), "S"), status);
    }

    @Test
    public void girarAlNorteEstandoOrientadoAlOeste() {
        final Rover rover = new Rover(new RoverStatus(new Position(1, 1), "O"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("D");

        Assert.assertEquals(new RoverStatus(new Position(1, 1), "N"), status);
    }

    @Test
    public void girarALaDerecha180Grados() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "N"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("DD");

        Assert.assertEquals(new RoverStatus(new Position(0, 0), "S"), status);
    }

    @Test
    public void girarALaIzquierda360Grados() {
        final Rover rover = new Rover(new RoverStatus(new Position(1, 1), "N"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("IIII");

        Assert.assertEquals(new RoverStatus(new Position(1, 1), "N"), status);
    }

    @Test
    public void caminarUnaCasillaEstandoOrientadoAlNorte() {
        final Rover rover = new Rover(new RoverStatus(new Position(3, 3), "N"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("A");

        Assert.assertEquals(new RoverStatus(new Position(3, 4), "N"), status);
    }

    @Test
    public void caminarUnaCasillaEstandoOrientadoAlSur() {
        final Rover rover = new Rover(new RoverStatus(new Position(3, 3), "S"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("A");

        Assert.assertEquals(new RoverStatus(new Position(3, 2), "S"), status);
    }

    @Test
    public void caminarUnaCasillaEstandoOrientadoAlEste() {
        final Rover rover = new Rover(new RoverStatus(new Position(3, 3), "E"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("A");

        Assert.assertEquals(new RoverStatus(new Position(4, 3), "E"), status);
    }

    @Test
    public void caminarUnaCasillaEstandoOrientadoAlOeste() {
        final Rover rover = new Rover(new RoverStatus(new Position(3, 3), "O"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("A");

        Assert.assertEquals(new RoverStatus(new Position(2, 3), "O"), status);
    }

    @Test
    public void caminarDosCasillaEstandoOrientadoAlOeste() {
        final Rover rover = new Rover(new RoverStatus(new Position(3, 3), "O"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("AA");

        Assert.assertEquals(new RoverStatus(new Position(1, 3), "O"), status);
    }

    @Test
    public void darLaVueltaAlPlanetaHaciaElNorte() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "N"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("AAAAA");

        Assert.assertEquals(new RoverStatus(new Position(0, 0), "N"), status);
    }

    @Test
    public void darLaVueltaAlPlanetaYDarUnPasoMasHaciaElNorte() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "N"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("AAAAAA");

        Assert.assertEquals(new RoverStatus(new Position(0, 1), "N"), status);
    }

    @Test
    public void justoAntesDeDarLaVueltaAlPlanetaHaciaElNorte() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "N"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("AAAA");

        Assert.assertEquals(new RoverStatus(new Position(0, 4), "N"), status);
    }

    @Test
    public void darLaVueltaAlPlanetaHaciaElSur() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "S"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("AAAAA");

        Assert.assertEquals(new RoverStatus(new Position(0, 0), "S"), status);
    }

    @Test
    public void darLaVueltaAlPlanetaYDarUnPasoMasHaciaElSur() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "S"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("AAAAAA");

        Assert.assertEquals(new RoverStatus(new Position(0, 4), "S"), status);
    }

    @Test
    public void justoAntesDeDarLaVueltaAlPlanetaHaciaElSur() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "S"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("AAAA");

        Assert.assertEquals(new RoverStatus(new Position(0, 1), "S"), status);
    }

    @Test
    public void darLaVueltaAlPlanetaHaciaElEste() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "E"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("AAAAA");

        Assert.assertEquals(new RoverStatus(new Position(0, 0), "E"), status);
    }

    @Test
    public void darLaVueltaAlPlanetaYDarUnPasoMasHaciaElEste() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "E"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("AAAAAA");

        Assert.assertEquals(new RoverStatus(new Position(1, 0), "E"), status);
    }

    @Test
    public void justoAntesDeDarLaVueltaAlPlanetaHaciaElEste() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "E"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("AAAA");

        Assert.assertEquals(new RoverStatus(new Position(4, 0), "E"), status);
    }

    @Test
    public void darLaVueltaAlPlanetaHaciaElOeste() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "O"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("AAAAA");

        Assert.assertEquals(new RoverStatus(new Position(0, 0), "O"), status);
    }

    @Test
    public void darLaVueltaAlPlanetaYDarUnPasoMasHaciaElOeste() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "O"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("AAAAAA");

        Assert.assertEquals(new RoverStatus(new Position(4, 0), "O"), status);
    }

    @Test
    public void justoAntesDeDarLaVueltaAlPlanetaHaciaElOeste() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "O"), new Planet(5, 5, null),
                this.commandFactory);
        final RoverStatus status = rover.execute("AAAA");

        Assert.assertEquals(new RoverStatus(new Position(1, 0), "O"), status);
    }

    @Test
    public void pararAlTenerUnObstaculoLlendoAlNorte() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "N"),
                new Planet(5, 5, Arrays.asList(new Position(0, 2))), this.commandFactory);
        final RoverStatus status = rover.execute("AAAAAA");

        Assert.assertEquals(new RoverStatus(new Position(0, 1), "N"), status);
    }

    @Test
    public void pararAlTenerUnObstaculoLlendoAlSur() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "S"),
                new Planet(5, 5, Arrays.asList(new Position(0, 2))), this.commandFactory);
        final RoverStatus status = rover.execute("AAAAAA");

        Assert.assertEquals(new RoverStatus(new Position(0, 3), "S"), status);
    }

    @Test
    public void pararAlTenerUnObstaculoLlendoAlEste() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "E"),
                new Planet(5, 5, Arrays.asList(new Position(3, 0))), this.commandFactory);
        final RoverStatus status = rover.execute("AAAAAA");

        Assert.assertEquals(new RoverStatus(new Position(2, 0), "E"), status);
    }

    @Test
    public void pararAlTenerUnObstaculoLlendoAlOeste() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "O"),
                new Planet(5, 5, Arrays.asList(new Position(2, 0))), this.commandFactory);
        final RoverStatus status = rover.execute("AAAAAA");

        Assert.assertEquals(new RoverStatus(new Position(3, 0), "O"), status);
    }

    @Test
    public void pararAlTenerUnObstaculoLlendoAlNorte2() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 2), "N"),
                new Planet(5, 5, Arrays.asList(new Position(0, 0))), this.commandFactory);
        final RoverStatus status = rover.execute("AAAAAA");

        Assert.assertEquals(new RoverStatus(new Position(0, 4), "N"), status);
    }

    @Test
    public void navegarEnPlanetaJulio() {
        final Rover rover = new Rover(new RoverStatus(new Position(0, 0), "N"),
                new Planet(10, 10, Arrays.asList(new Position(1, 1))), this.commandFactory);
        final RoverStatus status = rover.execute("AAAAADAIAAAAAAA");

        Assert.assertEquals(new RoverStatus(new Position(1, 0), "N"), status);
    }
}
