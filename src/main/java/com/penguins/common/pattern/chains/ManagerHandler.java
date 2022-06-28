package com.penguins.common.pattern.chains;

import java.math.BigDecimal;

/**
 * @author zhengbing
 */
public class ManagerHandler implements Handler {

    private final DirectorHandler next = new DirectorHandler();

    @Override
    public Boolean process(ChainRequest request) {
        if (request.getPrice().compareTo(BigDecimal.valueOf(1000)) > 0) {
            return next.process(request);
        }
        System.out.println(request + " " + "Approved by "
                + getClass().getSimpleName() + " " + request.getName());
        return true;
    }
}
