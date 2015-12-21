package com.reflect;

class Demo{
    //other codes...
}
 
public class Hello{
    public static void main(String[] args) {
        Demo demo=new Demo();
        System.out.println(demo.getClass().getName());
    }
}