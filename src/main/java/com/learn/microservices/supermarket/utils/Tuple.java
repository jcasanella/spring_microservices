package com.learn.microservices.supermarket.utils;

import lombok.*;

@Getter @Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Tuple<S, T> {

    private final S left;
    private final T right;
}
