package ru.digitalhabbits.homework2.lettercounter;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LetterCounterImpl implements LetterCounter {

    @Override
    public Map<Character, Long> count(@Nonnull String input) {
        log.info("Counting letters. input = {}", input);

        Map<Character, Long> letterCountMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Long current = letterCountMap.get(input.charAt(i));

            if (current == null) {
                letterCountMap.put(input.charAt(i), 1L);
            } else {
                letterCountMap.put(input.charAt(i), ++current);
            }
        }

        log.info("Letters counted. letterCountMap = {}", letterCountMap);

        return letterCountMap;
    }

}
