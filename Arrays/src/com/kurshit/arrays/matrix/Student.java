package com.kurshit.arrays.matrix;

public class Student {



    public void test(String s) {
        System.out.println("String");
    }



    public void test(Object s) {
        System.out.println("Object");
    }

    public static void main(String[] args) {
        Student s = new Student();

        //s.test(null);

        //1. No CE
        //2. Object
    }



}

