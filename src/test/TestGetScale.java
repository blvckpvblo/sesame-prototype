package test;

import main.*;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class TestGetScale {

    @Test
    public void testGetScale1() {
        String[] notes = { "C", "D", "E", "F", "G", "A", "B" };
        ArrayList<String> actual = Sesame.getScale(notes);
        ArrayList<String> expected = new ArrayList<String>(List.of("C Major", "A Minor"));
        assertEquals(expected, actual);
    }

    @Test
    public void testGetScale2() {
        String[] notes = { "C", "D", "Y" };
        ArrayList<String> actual = Sesame.getScale(notes);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetScale3() {
        String[] notes = { "Ab", "Bb", "C", "Gb" };
        ArrayList<String> actual = Sesame.getScale(notes);
        ArrayList<String> expected = new ArrayList<String>(List.of("C# Major", "A# Minor"));
        assertEquals(expected, actual);
    }

    @Test
    public void testGetScale4() {
        String[] notes = { "1", "14" };
        ArrayList<String> actual = Sesame.getScale(notes);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetScale5() {
        String[] notes = { "AB", "Aa", "G#" };
        ArrayList<String> actual = Sesame.getScale(notes);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetScale6() {
        String[] notes = { "G#" };
        ArrayList<String> actual = Sesame.getScale(notes);
        ArrayList<String> expected = new ArrayList<String>(
                List.of("E Major", "A Major", "B Major", "C# Major", "D# Major", "F# Major", "G# Major", "A# Minor",
                        "C Minor", "C# Minor", "D# Minor", "F Minor", "F# Minor", "G# Minor"));
        assertEquals(expected, actual);
    }

    @Test
    public void testGetScale7() {
        String[] notes = { "#" };
        ArrayList<String> actual = Sesame.getScale(notes);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetScale8() {
        String[] notes = { "Ba" };
        ArrayList<String> actual = Sesame.getScale(notes);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetScale9() {
        String[] notes = { "C", "D", "D#", "F", "G", "G#", "A#", "B" };
        ArrayList<String> actual = Sesame.getScale(notes);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetScale10() {
        String[] notes = { "C", "D", "D#", "F", "G", "G#", "A#", "An" };
        ArrayList<String> actual = Sesame.getScale(notes);
        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected, actual);
    }
}
