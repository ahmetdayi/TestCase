package com.bobu.testcase.request;

import java.util.List;

public record FindChildByParentsRequest(
        List<String> parentIdList
) {
}
