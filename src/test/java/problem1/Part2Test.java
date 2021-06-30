package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class Part2Test {

    private final Part1 part1 = mock(Part1.class);

    private Part2 part2;

    @BeforeEach
    void setUp() {
        part2 = new Part2(part1);
    }

    @Test
    void doShareCharacters_scoreZero() {
        String firstWord = "first";
        String secondWord = "second";
        when(part1.sharesCharacters(firstWord, secondWord))
                .thenReturn(true);

        int actualResult = part2.scoreStrings(firstWord, secondWord);

        assertEquals(0, actualResult);
    }

    @Test
    void doNotShareCharacters_scoreThirty() {
        String firstWord = "first";
        String secondWord = "second";
        when(part1.sharesCharacters(firstWord, secondWord))
                .thenReturn(false);

        int actualResult = part2.scoreStrings(firstWord, secondWord);

        assertEquals(30, actualResult);
    }

    @Test
    void doNotShareCharacters_scoreNine() {
        String firstWord = "fir";
        String secondWord = "sec";
        when(part1.sharesCharacters(firstWord, secondWord))
                .thenReturn(false);

        int actualResult = part2.scoreStrings(firstWord, secondWord);

        assertEquals(9, actualResult);
    }
}