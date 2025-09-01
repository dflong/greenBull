package com.dflong.greenbull.jvm;

import com.dflong.greenbull.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class JVMRun {

    String name = "ma";

    public static void main(String[] args) {


        String s = new String("a") + new String("b");
        s.intern();
        String s2 = "ab";
        System.out.println(s == s2);
//        JVMRun jvmRun = new JVMRun();
//        jvmRun.say();
//        System.out.println();
//
//        Runtime runtime = Runtime.getRuntime();
//        long m = runtime.maxMemory() / 1024 / 1024;
//        System.out.println(m);
//
//        List<User> list = new ArrayList<>();
//
//        while (true) {
//            User user = new User();
//            user.setNickname("11");
//            list.add(user);
//        }
    }

    public void show() {
        double i = 10;
        int j = 20;
        int[] num = new int[10];
        say();
    }

    private int say() {
        int k = 30, l = 40;
        int x = k ++;
        int y = ++ l;
        int z = k + l;

        return k;
    }

    public String add() {
        String a = "a";
        String b = "b";

        String c = "a" + b;
        return c;
    }

    public void to() {
        // 创建几个对象
        // 1. StringBuilder
        // 2. new String()
        // 3. 常量池a
        // 4. new String()
        // 5. 常量池b
        String s = new String("a") + new String("b");

    }
}
