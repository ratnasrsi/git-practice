package com.redistest.repository;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {
        User user1 = new User(1,"zhangsan","test@test.com");
        User user2 = new User(2,"test2","test2@test2.com");
        User user3 = new User(3,"test3","test3@test2.com");
        User user4 = new User(4,"test4","test4@test2.com");
        User user5 = new User(5,"test2","test2@test2.com");
        User user6 = new User(6,"zhangsan","test@test.com");


        List<User> users = Arrays.asList(
                new User(1,"zhangsan","test@test.com"),
                new User(2,"test2","test2@test2.com"),
                new User(3,"test3","test3@test2.com"),
                new User(4,"test4","test4@test2.com"),
                new User(5,"test2","test2@test2.com"),
                new User(6,"zhangsan","test@test.com")

        );

        List<String> names = Arrays.asList("Alice", "Bob", "Adam", "Charlie", "Amanda");
        List<String> names1 = names.stream().filter(name-> name.startsWith("A")).collect(Collectors.toList());
        names1.forEach(System.out::println);

        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "date");
        List<Map.Entry<String, Long>>  words1 = words.stream().collect(Collectors.groupingBy(s->s, Collectors.counting())).entrySet().stream()
                .filter(entry-> entry.getValue()>1).collect(Collectors.toList());
        System.out.println(words1);

        List<String> duplictaes = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "date");
        List<Map.Entry<String, Long>>  dups =duplictaes.stream().collect(Collectors.groupingBy(s->s, Collectors.counting())).entrySet().stream()
                .filter(entry-> entry.getValue() ==1)
                .collect(Collectors.toList());
        dups.forEach(System.out::println);

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
         Map<Boolean, List<Integer>> partioned = nums.stream().collect(Collectors.partitioningBy(n-> n%2 ==0));

        System.out.println(partioned.get(true));

      List<Map.Entry<String, Long>> distinctUser = users.stream()
               .collect(Collectors.groupingBy(
                       user -> user.getName() + "_"+ user.getEmail(),
                       Collectors.counting()
               )).entrySet().stream()
                      .collect(Collectors.toList());

        //distinctUser.forEach(System.out::println);
       // System.out.println("uniqueUsersCount :" + uniqueUsersCount);


        String str = new String("ratnakumari");
        char firstUnique = findFirstUnique(str);
        System.out.println("firstUnique :" + firstUnique);
    }

    public static char findFirstUnique(String str){

        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for(char c : str.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        System.out.println(countMap);

        for(char c : str.toCharArray()){
            if(countMap.get(c) == 1){
                return c;
            }

        }
        return '0';
    }
}

class User{

    private Integer id;
    private String name;

    private String email;
    public User(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}


