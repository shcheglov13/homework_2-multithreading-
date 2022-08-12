package ru.digitalhabbits.homework2.merger;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class LetterCountMergerImplTest {

    private final LetterCountMerger letterCountMerger;

    public LetterCountMergerImplTest() {
        this.letterCountMerger = new LetterCountMergerImpl();
    }

    @Test
    public void should_merge_two_maps_with_sum_value() {
        Map<Character, Long> map1 = Map.of(
                'a', 3L,
                't', 5L,
                'l', 1L
        );
        Map<Character, Long> map2 = Map.of(
                'a', 12L,
                't', 19L
        );

        assertThat(letterCountMerger.merge(map1, map2)).containsOnly(
                entry('a', 15L),
                entry('t', 24L),
                entry('l', 1L)
        );
        assertThat(letterCountMerger.merge(map1, Collections.emptyMap())).containsOnly(
                entry('a', 3L),
                entry('t', 5L),
                entry('l', 1L)
        );
    }
}