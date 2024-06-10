package com.gigi.demo;

public class Trial {
    public static void main(String[] args)  {

        try {
    System.out.println("The value is "+ Demo.grandParentMethod(7));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
