package com.penguins.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/7/25 09:55
 **/
public class TestUtils {

    public static void main(String[] args) {
        List<Test> tests = new ArrayList<>();
        Test test = new Test(2);
        Test test1 = new Test(2);
        Test test2 = new Test(3);
        Test test3 = new Test(4);
        Test test4 = new Test(5);
        tests.add(test);
        tests.add(test1);
        tests.add(test2);
        tests.add(test3);
        tests.add(test4);
        Optional<Test> any = tests.stream().sorted((o1, o2) -> {
            if (o1.getTester() == o2.getTester()) {
                return 0;
            }
            return 0;
        }).findAny();
        System.out.println(any.isPresent());
    }
}

@Data
class Test {

    public Test(int tester) {
        this.tester = tester;
    }

    private int tester;
}
