package ru.digitalhabbits.homework2.lettercounter;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class LetterCounterImplTest {

    private final LetterCounter letterCounter;

    public LetterCounterImplTest() {
        this.letterCounter = new LetterCounterImpl();
    }

    @Test
    public void should_count_letters_in_string() {
        String testData = "aaabbbbccccc";
        Map<Character, Long> result = letterCounter.count(testData);

        assertThat(result).containsOnly(
                entry('a', 3L),
                entry('b', 4L),
                entry('c', 5L)
        );
    }
}