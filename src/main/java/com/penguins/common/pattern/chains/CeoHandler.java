package com.penguins.common.pattern.chains;

/**
 * @author zhengbing
 */
public class CeoHandler implements Handler {

    @Override
    public Boolean process(ChainRequest request) {
        System.out.println(request + " " + "Approved by "
                + getClass().getSimpleName() + " " + request.getName());
        return true;
    }
}
