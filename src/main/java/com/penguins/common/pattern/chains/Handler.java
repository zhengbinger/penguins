package com.penguins.common.pattern.chains;

/**
 * @author zhengbing
 */
public interface Handler {

    Boolean process(ChainRequest request);
}
