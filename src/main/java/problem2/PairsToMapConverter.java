package problem2;

import java.util.*;

import static java.util.Collections.singleton;

public class PairsToMapConverter {

    private Map<Integer, List<Integer>> elementsToRemoveIndicesMap;

    public Map<Integer, List<Integer>> convert(int[][] indicesPairs) {
        elementsToRemoveIndicesMap = new HashMap<>();

        fillMapFromIndicesPairs(indicesPairs);

        return elementsToRemoveIndicesMap;
    }

    private void fillMapFromIndicesPairs(int[][] indicesPairs) {
        for (int[] pair : indicesPairs) {
            int rowIndex = pair[0];
            int columnIndex = pair[1];

            elementsToRemoveIndicesMap.computeIfPresent(rowIndex, (__, value) -> {
                value.add(columnIndex);
                return value;
            });

            elementsToRemoveIndicesMap.computeIfAbsent(rowIndex, __ -> new ArrayList<>(singleton(columnIndex)));

        }
    }
}
