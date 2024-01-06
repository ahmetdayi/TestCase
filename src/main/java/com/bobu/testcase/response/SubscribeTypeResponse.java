package com.bobu.testcase.response;

import java.math.BigDecimal;

public record SubscribeTypeResponse(
        String id,
        String name,
        String description,
        BigDecimal price
) {
}
