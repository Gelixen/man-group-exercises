package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part1Test {

    private Part1 part1;

    @BeforeEach
    void setUp() {
        part1 = new Part1();
    }

    private static Stream<Arguments> sharesCharacters() {
        return Stream.of(
                Arguments.of("y", "y", true),
                Arguments.of("y", "z", false),
                Arguments.of("abc", "z", false),
                Arguments.of("abcdefg", "z", false),
                Arguments.of("abcdefghi", "e", true),
                Arguments.of("abcdefghi", "bcdefgh", true),
                Arguments.of("abcdfe".repeat(50_000_000), "e", true),
                Arguments.of("abcdfe", "e".repeat(100_000_000), true)
        );
    }

    @ParameterizedTest
    @MethodSource
    void sharesCharacters(String firstWord, String secondWord, boolean expectedResult) {
        boolean actualResult = part1.sharesCharacters(firstWord, secondWord);

        assertEquals(expectedResult, actualResult);
    }
}