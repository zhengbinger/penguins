package com.penguins.common.pattern.chains;

import java.math.BigDecimal;

/**
 * @author zhengbing
 */
public class DirectorHandler implements Handler {
    @Override
    public Boolean process(ChainRequest request) {
        if (request.getPrice().compareTo(BigDecimal.valueOf(10000)) > 0) {
            return null;
        }
        return true;
    }
}
