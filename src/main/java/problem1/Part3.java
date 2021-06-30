package problem1;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class Part3 {

    private final Part2 part2;

    private int maxScore;
    private Pair<String, String> maxScoreWordsPair;

    public Part3(Part2 part2) {
        this.part2 = part2;
    }

    // Implied words list is already fully validated and size of >= 2
    Pair<String, String> maxWordPair(List<String> words) {
        maxScore = -1;
        maxScoreWordsPair = null;

        loopWordPairsWhileCheckingScore(words);

        return maxScoreWordsPair;
    }

    private void loopWordPairsWhileCheckingScore(List<String> words) {
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {
                checkScore(words.get(i), words.get(j));
            }
        }
    }

    private void checkScore(String firstWord, String secondWord) {
        int currentScore = part2.scoreStrings(firstWord, secondWord);

        if (isGreaterOrEqualMaxScore(currentScore)) {
            updateMaxScoreValues(firstWord, secondWord, currentScore);
        }
    }

    private boolean isGreaterOrEqualMaxScore(int score) {
        return score >= maxScore;
    }

    private void updateMaxScoreValues(String firstWord, String secondWord, int score) {
        maxScore = score;
        maxScoreWordsPair = new ImmutablePair<>(firstWord, secondWord);
    }
}
