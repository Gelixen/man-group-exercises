package problem2;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

public class Part2 {

    private final Part1 part1;

    public Part2(Part1 part1) {
        this.part1 = part1;
    }

    public List<List<String>> removeFromListOfLists(List<List<String>> listOfLists,
                                                    Map<Integer, List<Integer>> elementsToRemoveIndicesMap) {

        List<List<String>> trimmedList = new LinkedList<>();

        for (int i = 0; i < listOfLists.size(); i++) {
            List<String> currentList = listOfLists.get(i);
            int[] currentElementsToRemoveIndices = getCurrentRemovalIndices(elementsToRemoveIndicesMap, i);
            List<String> listAfterRemoval = part1.removeFromList(currentList, currentElementsToRemoveIndices);
            trimmedList.add(i, listAfterRemoval);
        }

        return trimmedList;
    }

    private int[] getCurrentRemovalIndices(Map<Integer, List<Integer>> elementsToRemoveIndicesMap, int index) {
        return elementsToRemoveIndicesMap.getOrDefault(index, emptyList()).stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
