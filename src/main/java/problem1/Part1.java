package problem1;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Part1 {

    public boolean sharesCharacters(String one, String two) {
        Set<Integer> lettersSet;
        String longerWord;

        if (one.length() > two.length()) {
            lettersSet = convertToLettersSet(two);
            longerWord = one;
        } else {
            lettersSet = convertToLettersSet(one);
            longerWord = two;
        }

        return longerWord.chars().anyMatch(lettersSet::contains);
    }

    private Set<Integer> convertToLettersSet(String word) {
        return word.chars().boxed().collect(toSet());
    }
}
