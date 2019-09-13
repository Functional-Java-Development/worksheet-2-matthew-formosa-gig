import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;

public class Booter {

    public static void main(final String[] args) {
        // 1
        Stream.iterate(0, number -> number + 1)
                .map(number -> (number * (number + 1)) / 2)
                .limit(10)
                .forEach(System.out::println);

        // 2
        final var stopWords = List.of("a", "an", "the", "so", "it", "do", "did", "for", "by", "of", "to");
        final var scanner = new Scanner(System.in);
        final var entries = new LinkedList<String>();
        String userEntry;

        while (true) {
            userEntry = scanner.nextLine();
            if (userEntry.isEmpty()) {
                break;
            }
            entries.add(userEntry);
        }

        entries.stream()
                .filter(entry -> !stopWords.contains(entry))
                .distinct()
                .sorted(reverseOrder())
                .forEach(System.out::println);
    }
}