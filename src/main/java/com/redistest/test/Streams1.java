package com.redistest.test;

import com.redistest.model.User;

import java.util.Arrays;

public class Streams1 {

    public static void main(String args[]){

        int[] ints = {20,23,22,88};
        Arrays.stream(ints)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Array is Empty"));

        User[] users = {new User(Long.valueOf(10),"Ratna","ss@cc.com"),
        new User(Long.valueOf(2),"2222","22@22.com"),
                new User(Long.valueOf("9"),"33","33@33.com")};

        /*Arrays.stream(users)
                .filter(user -> user.getEmail().contains("cc"))
                .findFirst()
                .orElseThrow(() ->new RuntimeException("User not found"))           ;*/

 Arrays.sort(users,
                (u1,u2) -> Integer.compare(u1.getId().intValue(), u2.getId().intValue())                    );
        System.out.println(Arrays.toString(users));
        String[] strings = {"Alice", "Bob", "Charlie", "David"};
        Arrays.sort(strings, (s1,s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(Arrays.toString(strings));

        int[] intss = {10, 5, 20, 8, 25};

        int max = Arrays.stream(intss).max().orElseThrow();
        int nextmax = Arrays.stream(intss)
                .filter(num -> num< max)
                .max()
                .orElseThrow(() -> new RuntimeException("No element less than max"));

        System.out.println(nextmax);



    }




}
