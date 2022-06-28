package com.penguins.common.pattern.chains;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CeoHandler());

        chain.process(new ChainRequest("Bob", new BigDecimal("123.45")));
        chain.process(new ChainRequest("Alice", new BigDecimal("1234.56")));
        chain.process(new ChainRequest("Bill", new BigDecimal("12345.67")));
        chain.process(new ChainRequest("John", new BigDecimal("123456.78")));

    }
}
