import company.Main;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TestLettersCount {
    @Test
    public void testLettersCount() throws IOException {
        HashMap<Character, Integer> chars = Main.readFile("src\\test\\resources\\sample.txt");
        int actual = chars.get('i');
        assertEquals(3, actual);
        actual = chars.get('t');
        assertEquals(5, actual);
    }
}