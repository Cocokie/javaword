package com.lix.interFace;

import com.lix.domain.Apple;

@FunctionalInterface
public interface AppleHandler {
    boolean filterApple(Apple apple);
}
