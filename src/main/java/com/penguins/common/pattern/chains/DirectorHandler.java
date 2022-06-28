package com.penguins.common.pattern.chains;

import java.math.BigDecimal;

/**
 * @author zhengbing
 */
public class DirectorHandler implements Handler {

    private CeoHandler next = new CeoHandler();

    @Override
    public Boolean process(ChainRequest request) {
        if (request.getPrice().compareTo(BigDecimal.valueOf(10000)) > 0) {
            return next.process(request);
        }
        System.out.println(request + " " + "Approved by "
                + getClass().getSimpleName() + " " + request.getName());
        return true;
    }
}
