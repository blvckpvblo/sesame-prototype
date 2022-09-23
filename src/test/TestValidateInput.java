package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Sesame;

public class TestValidateInput {
    @Test
    public void testValidateInput1() {
        String input = "C D E F G A B C";
        assertTrue(Sesame.validateInput(input));
    }

    @Test
    public void testValidateInput2() {
        String input = "C D F# Bb Ab E";
        assertTrue(Sesame.validateInput(input));
    }

    @Test
    public void testValidateInput3() {
        String input = "E";
        assertTrue(Sesame.validateInput(input));
    }

    @Test
    public void testValidateInput4() {
        String input = "C#";
        assertTrue(Sesame.validateInput(input));
    }

    @Test
    public void testValidateInput5() {
        String input = "Ab";
        assertTrue(Sesame.validateInput(input));
    }

    @Test
    public void testValidateInput6() {
        String input = "AB";
        assertFalse(Sesame.validateInput(input));
    }

    @Test
    public void testValidateInput7() {
        String input = "C D E F A K";
        assertFalse(Sesame.validateInput(input));
    }

    @Test
    public void testValidateInput8() {
        String input = "T#";
        assertFalse(Sesame.validateInput(input));
    }

    @Test
    public void testValidateInput9() {
        String input = "Ab GB C B C#";
        assertFalse(Sesame.validateInput(input));
    }

    @Test
    public void testValidateInput10() {
        String input = "ABBBBBB C D E F";
        assertFalse(Sesame.validateInput(input));
    }
}
