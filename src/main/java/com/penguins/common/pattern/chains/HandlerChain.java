package com.penguins.common.pattern.chains;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengbing
 */
public class HandlerChain {

    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        handlers.add(handler);
    }

    public Boolean process(ChainRequest request) {
        for (Handler handler : handlers) {
            Boolean process = handler.process(request);
            if (process != null) {
                System.out.println(request + " " + (process ? "Approved by " : "Denied by ")
                        + handler.getClass().getSimpleName() + " " + request.getName());
                return process;
            }
        }
        throw new RuntimeException("Could not handle request: " + request);
    }

}
