package TA21;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GeometriaTest {

    @Test
    public void testAreaCuadrado() {
        Geometria geo = new Geometria();
        assertEquals(25, geo.areacuadrado(5)); // Prueba con un cuadrado de lado 5
    }

    @Test
    public void testAreaCirculo() {
        Geometria geo = new Geometria();
        assertEquals(78.54, geo.areaCirculo(5), 0.01); // Prueba con un círculo de radio 5
    }

    @Test
    public void testAreaTriangulo() {
        Geometria geo = new Geometria();
        assertEquals(10, geo.areatriangulo(4, 5)); // Prueba con un triángulo de base 4 y altura 5
    }
}
