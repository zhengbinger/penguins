package com.penguins.common.pattern.chains;

/**
 * @author zhengbing
 */
public class HandlerChain {

//    private List<Handler> handlers = new ArrayList<>();
//
//    public void addHandler(Handler handler) {
//        handlers.add(handler);
//    }

    public Boolean process(ChainRequest request) {
//        for (Handler handler : handlers) {
        return handler.process(request);
//            if (process != null) {
//                System.out.println(request + " " + (process ? "Approved by " : "Denied by ")
//                        + handler.getClass().getSimpleName() + " " + request.getName());
//                return process;
//            }
//        }
//        throw new RuntimeException("Could not handle request: " + request);
    }

    public void setHandler(ManagerHandler handler) {
        this.handler = handler;
    }

    private Handler handler;
}
