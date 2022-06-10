package com.delkabo;

public class RestApiGroovy {
    public static void main(String[] args) {
        String s = "one";
        System.out.println("Hello world");

        MyTest myTest = new MyTest();
        myTest.test1();
        System.out.println(s);
        s = "two";
        System.out.println(s);
    }

    // Groovy
    /*
def list = [1,2,3, 4]
println list.findAll{it > 2}
    */

}
