package problem1;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class Part3Test {

    private static final String SHORTEST = "shortest word";
    private static final String NORMAL = "normal word";
    private static final String LONGEST = "longest word";

    private final Part2 part2 = mock(Part2.class);

    private Part3 part3;

    @BeforeEach
    void setUp() {
        part3 = new Part3(part2);
    }

    private static Stream<Arguments> maxWordPair() {
        return Stream.of(
                Arguments.of(asList(NORMAL, NORMAL), Pair.of(NORMAL, NORMAL)),
                Arguments.of(asList(SHORTEST, LONGEST), Pair.of(SHORTEST, LONGEST)),
                Arguments.of(asList(LONGEST, LONGEST, LONGEST), Pair.of(LONGEST, LONGEST)),
                Arguments.of(asList(LONGEST, LONGEST, NORMAL), Pair.of(LONGEST, NORMAL)),
                Arguments.of(asList(LONGEST, LONGEST, SHORTEST), Pair.of(LONGEST, SHORTEST)),
                Arguments.of(asList(LONGEST, NORMAL, SHORTEST), Pair.of(LONGEST, NORMAL))
        );
    }

    @ParameterizedTest
    @MethodSource
    void maxWordPair(List<String> words, Pair<String, String> expectedResult) {
        mockScoreCalls();

        Pair<String, String> actualResult = part3.maxWordPair(words);

        assertEquals(expectedResult, actualResult);
    }

    private void mockScoreCalls() {
        when(part2.scoreStrings(anyString(), anyString()))
                .thenReturn(0);

        when(part2.scoreStrings(SHORTEST, NORMAL))
                .thenReturn(3);
        when(part2.scoreStrings(NORMAL, SHORTEST))
                .thenReturn(3);
        
        when(part2.scoreStrings(SHORTEST, LONGEST))
                .thenReturn(6);
        when(part2.scoreStrings(LONGEST, SHORTEST))
                .thenReturn(6);
        
        when(part2.scoreStrings(NORMAL, LONGEST))
                .thenReturn(9);
        when(part2.scoreStrings(LONGEST, NORMAL))
                .thenReturn(9);
    }
}