package ru.digitalhabbits.homework2.filelettercounter;

import lombok.extern.slf4j.Slf4j;
import ru.digitalhabbits.homework2.lettercounter.LetterCounter;
import ru.digitalhabbits.homework2.lettercounter.LetterCounterImpl;
import ru.digitalhabbits.homework2.merger.LetterCountMerger;
import ru.digitalhabbits.homework2.merger.LetterCountMergerImpl;
import ru.digitalhabbits.homework2.reader.FileReader;
import ru.digitalhabbits.homework2.reader.FileReaderImpl;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
public class AsyncFileLetterCounter implements FileLetterCounter {

    private final FileReader fileReader;
    private final LetterCounter counter;
    private final LetterCountMerger merger;
    private final ExecutorService executorService;

    public AsyncFileLetterCounter() {
        this.fileReader = new FileReaderImpl();
        this.counter = new LetterCounterImpl();
        this.merger = new LetterCountMergerImpl();
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    @Override
    public Map<Character, Long> count(@Nonnull File input) {
        Map<Character, Long> resultMap = new HashMap<>();

        try {
            List<String> lines = fileReader.readLines(input).collect(Collectors.toList());

            for (String line : lines) {
                Map<Character, Long> tempMap = resultMap;
                Map<Character, Long> letterCountMap = CompletableFuture.supplyAsync(() -> counter.count(line), executorService).get();
                resultMap = CompletableFuture.supplyAsync(() -> merger.merge(tempMap, letterCountMap), executorService).get();
            }
        } catch (Exception e) {
            log.error("Fatal error while processing file. Cause: { }", e.getCause());
            return Collections.emptyMap();
        }

        log.info("File processed. resultMap = {}", resultMap);

        return resultMap;
    }

}
