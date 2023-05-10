package com.penguins.vm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2023/1/29 09:11
 **/
public class HeapDemo {

    static class OOMObject {
    }

    public static void main(String[] args) {

        List<OOMObject> ooms = Lists.newArrayList();

        int i = 0;
        while (i < 100000000) {
            ++i;
            ooms.add(new OOMObject());
        }
    }
}
