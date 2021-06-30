package problem1;

public class Part2 {

    private final Part1 part1;

    public Part2(Part1 part1) {
        this.part1 = part1;
    }

    int scoreStrings(String one, String two) {
        if (part1.sharesCharacters(one, two)) {
            return 0;
        }

        return one.length() * two.length();
    }
}
