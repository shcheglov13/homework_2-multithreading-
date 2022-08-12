package ru.digitalhabbits.homework2.merger;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class LetterCountMergerImpl implements LetterCountMerger {

    @Override
    public Map<Character, Long> merge(
            @Nonnull Map<Character, Long> firstMap,
            @Nonnull Map<Character, Long> secondMap
    ) {
        log.info("Merging maps. firstMap = {}, secondMap = {}", firstMap, secondMap);

        Map<Character, Long> resultMap = new HashMap<>();
        for (Map<Character, Long> map : List.of(firstMap, secondMap)) {
            for (Map.Entry<Character, Long> entry : map.entrySet()) {
                resultMap.merge(entry.getKey(), entry.getValue(), Long::sum);
            }
        }

        log.info("Maps are merged. resultMap = {}", resultMap);

        return resultMap;
    }

}
