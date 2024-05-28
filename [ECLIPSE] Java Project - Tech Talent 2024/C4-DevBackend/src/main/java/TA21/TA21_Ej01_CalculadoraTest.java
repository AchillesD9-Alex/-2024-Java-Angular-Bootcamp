package TA21;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TA21_Ej01_CalculadoraTest {

    @Test
    public void testSuma() {
        LogicCalculadora calc = new LogicCalculadora();
        assertEquals(5, calc.suma(2, 3));
    }

    @Test
    public void testResta() {
        LogicCalculadora calc = new LogicCalculadora();
        assertEquals(1, calc.resta(5, 4));
    }

    @Test
    public void testMultiplicacion() {
        LogicCalculadora calc = new LogicCalculadora();
        assertEquals(6, calc.multiplicacion(2, 3));
    }

    @Test
    public void testDivision() {
        LogicCalculadora calc = new LogicCalculadora();
        assertEquals(2, calc.division(6, 3));
    }

    @Test
    public void testDivisionPorCero() {
        LogicCalculadora calc = new LogicCalculadora();
        assertThrows(IllegalArgumentException.class, () -> calc.division(1, 0));
    }
}
