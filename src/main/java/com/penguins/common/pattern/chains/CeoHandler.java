package com.penguins.common.pattern.chains;

import java.math.BigDecimal;

/**
 * @author zhengbing
 */
public class CeoHandler implements Handler {

    @Override
    public Boolean process(ChainRequest request) {
        if (request.getPrice().compareTo(BigDecimal.valueOf(1000000)) > 0) {
            return null;
        }
        return true;
    }
}
