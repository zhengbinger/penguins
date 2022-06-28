package com.penguins.common.pattern.chains;

import java.math.BigDecimal;

/**
 * @author zhengbing
 */
public class ChainRequest {

    public ChainRequest(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    private String name;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
