package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class Part2Test {

    private final List<String> FIRST_LIST = asList("John", "Bob", "Charles");
    private final List<String> SECOND_LIST = asList("Trev", "Geoff");
    private final List<String> THIRD_LIST = asList("Bart", "Sue");
    private final List<String> FOURTH_LIST = asList("Steve", "Charly");
    private final Map<Integer, List<Integer>> INDICES_MAP = Map.of(
            0, asList(0, 2),
            1, singletonList(1),
            3, asList(1, 2)
    );

    private final Part1 part1 = mock(Part1.class);

    private Part2 part2;

    @BeforeEach
    void setUp() {
        part2 = new Part2(part1);
    }

    @Test
    void removesElementsInTheMiddle_returnsFirstAndLastElements() {
        List<List<String>> listOfLists = asList(FIRST_LIST, SECOND_LIST, THIRD_LIST, FOURTH_LIST);
        mockPart1Calls();

        List<List<String>> actualResult = part2.removeFromListOfLists(listOfLists, INDICES_MAP);

        List<List<String>> expectedResult = asList(
                singletonList(FIRST_LIST.get(1)),
                singletonList(SECOND_LIST.get(0)),
                THIRD_LIST,
                emptyList()
        );
        assertEquals(expectedResult, actualResult);
    }

    private void mockPart1Calls() {
        when(part1.removeFromList(FIRST_LIST, new int[]{0, 2}))
                .thenReturn(singletonList(FIRST_LIST.get(1)));
        when(part1.removeFromList(SECOND_LIST, new int[]{1}))
                .thenReturn(singletonList(SECOND_LIST.get(0)));
        when(part1.removeFromList(THIRD_LIST, new int[]{}))
                .thenReturn(THIRD_LIST);
    }
    
}