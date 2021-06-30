package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Part1Test {
    
    private Part1 part1;

    @BeforeEach
    void setUp() {
        part1 = new Part1();
    }

    @Test
    void removesElementsInTheMiddle_returnsFirstAndLastElements() {
        List<String> list = asList("John", "Bob", "Charles", "Trev");
        int[] indices = new int[]{1, 2};

        List<String> actualResult = part1.removeFromList(list, indices);

        assertEquals(asList("John", "Trev"), actualResult);
    }

    @Test
    void removesEverything_returnsEmptyList() {
        List<String> list = asList("John", "Bob", "Charles", "Trev");
        int[] indices = new int[]{0, 1, 2, 3};

        List<String> actualResult = part1.removeFromList(list, indices);

        assertEquals(emptyList(), actualResult);
    }

    @Test
    void negativeIndex_throwsException() {
        List<String> list = asList("John", "Bob", "Charles", "Trev");
        int[] indices = new int[]{-1};

        assertThrows(IndexOutOfBoundsException.class, () -> part1.removeFromList(list, indices));
    }

    @Test
    void tooBigIndex_throwsException() {
        List<String> list = asList("John", "Bob", "Charles", "Trev");
        int[] indices = new int[]{10};

        assertThrows(IndexOutOfBoundsException.class, () -> part1.removeFromList(list, indices));
    }
}