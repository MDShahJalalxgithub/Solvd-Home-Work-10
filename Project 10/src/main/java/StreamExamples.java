import java.util.*;
import java.util.stream.Collectors;
import java.util.logging.Logger;

public class StreamExamples {
    private static final Logger LOGGER = Logger.getLogger(StreamExamples.class.getName());

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // 1. Map
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        LOGGER.info("Name Lengths: " + nameLengths);

        // 2. Filter
        List<String> filteredNames = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());
        LOGGER.info("Filtered Names: " + filteredNames);

        // 3. ForEach
        names.forEach(name -> LOGGER.info("Name: " + name));

        // 4. Reduce
        Optional<String> concatenatedNames = names.stream()
                .reduce((name1, name2) -> name1 + ", " + name2);
        concatenatedNames.ifPresent(s -> LOGGER.info("Concatenated Names: " + s));

        // 5. Sorted
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        LOGGER.info("Sorted Names: " + sortedNames);

        // 6. Distinct
        List<String> distinctNames = names.stream()
                .distinct()
                .collect(Collectors.toList());
        LOGGER.info("Distinct Names: " + distinctNames);

        // 7. Limit
        List<String> limitedNames = names.stream()
                .limit(3)
                .collect(Collectors.toList());
        LOGGER.info("Limited Names: " + limitedNames);
    }
}