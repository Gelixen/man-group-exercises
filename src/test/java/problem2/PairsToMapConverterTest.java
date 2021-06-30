package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;
import static org.junit.jupiter.api.Assertions.*;

class PairsToMapConverterTest {

    private PairsToMapConverter pairsToMapConverter;

    @BeforeEach
    void setUp() {
        pairsToMapConverter = new PairsToMapConverter();
    }

    @Test
    void convert_singleMapEntry() {
        Map<Integer, List<Integer>> actualResult = pairsToMapConverter.convert(new int[][]{
                {1, 2}
        });

        Map<Integer, Object> expectedResult = singletonMap(
                1, singletonList(2)
        );

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void convert_multipleDifferentMapEntries() {
        Map<Integer, List<Integer>> actualResult = pairsToMapConverter.convert(new int[][]{
                {1, 2},
                {2, 1},
                {3, 1}
        });

        Map<Integer, Object> expectedResult = Map.of(
                1, singletonList(2),
                2, singletonList(1),
                3, singletonList(1)
        );
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void convert_multipleValuesForSingleMapEntry() {
        Map<Integer, List<Integer>> actualResult = pairsToMapConverter.convert(new int[][]{
                {1, 2},
                {1, 3},
                {1, 5}
        });

        Map<Integer, Object> expectedResult = singletonMap(
                1, asList(2, 3, 5)
        );
        assertEquals(expectedResult, actualResult);
    }
}