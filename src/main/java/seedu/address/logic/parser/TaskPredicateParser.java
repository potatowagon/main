package seedu.address.logic.parser;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import seedu.address.commons.util.SubstringRange;
import seedu.address.model.ReadOnlyModel;
import seedu.address.model.filter.TaskFinishedPredicate;
import seedu.address.model.filter.TaskPredicate;
import seedu.address.model.filter.TaskUnfinishedPredicate;

/**
 * Parses a task predicate name, and returns the corresponding task predicate.
 */
public class TaskPredicateParser implements Parser<TaskPredicate> {

    private static final List<String> KEYWORDS = Arrays.asList("all", "fin", "unfin");

    private final LocalDateTime referenceDateTime;

    public TaskPredicateParser(LocalDateTime referenceDateTime) {
        assert referenceDateTime != null;
        this.referenceDateTime = referenceDateTime;
    }

    @Override
    public TaskPredicate parse(String str) throws ParseException {
        switch (str.trim()) {
        case "":
        case "all":
            return null;
        case "fin":
            return new TaskFinishedPredicate(referenceDateTime);
        case "unfin":
            return new TaskUnfinishedPredicate(referenceDateTime);
        default:
            throw new ParseException("unknown predicate: " + str, SubstringRange.of(str));
        }
    }

    @Override
    public List<String> autocomplete(ReadOnlyModel model, String input, int pos) {
        final String trimInput = input.trim();
        if (pos != trimInput.length()) {
            return Collections.emptyList();
        }
        return KEYWORDS.stream()
                        .filter(keyword -> keyword.startsWith(trimInput))
                        .map(keyword -> keyword.substring(trimInput.length()))
                        .collect(Collectors.toList());
    }

}
