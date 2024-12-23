package com.jtf.xueyou.util;

import org.springframework.data.util.Pair;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class GenUtil {
    public static String genUUID() {
        return LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + "-" + UUID.randomUUID();
    }

    public static Pair<Double, Double> genPosition() {
        return Pair.of(Math.random() * 10, Math.random() * 10);
    }
}
