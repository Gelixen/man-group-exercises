package problem2;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;

public class Part1 {

    public List<String> removeFromList(List<String> list, int[] elementsToRemoveIndices) {
        String[] initialArray = list.toArray(new String[0]);
        String[] arrayWithRemovedElements = ArrayUtils.removeAll(initialArray, elementsToRemoveIndices);
        return Arrays.asList(arrayWithRemovedElements);
    }
}
