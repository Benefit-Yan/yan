package com.generics;

import java.lang.reflect.InvocationTargetException;  
import java.lang.reflect.Method;  
import java.util.ArrayList;  
import java.util.List;  
  
public class ReflectDemo{  
    public static void main(String... args) throws Exception{  
        test_1();  
        test_2();  
    }  
    private static void test_2(){  
        //未使用泛型限制，虽然元素都能存储和取出，但是安全性却大大降低了！  
        List list = new ArrayList();  
        list.add("string ...");  
        list.add(123);  
        list.add(true);  
        Object o1 = list.get(0);  
        Object o2 = list.get(1);  
        Object o3 = list.get(2);  
        System.out.println(o1);  
        System.out.println(o2);  
        System.out.println(o3);  
    }  
    private static void test_1() throws NoSuchMethodException,  
            IllegalAccessException, InvocationTargetException {  
        //使用泛型限制了元素类型  
        List<String> list = new ArrayList<String>();  
        Class<?> clazz = list.getClass();  
        System.out.println(clazz.getName());  
        //使用反射绕开编译器  
        Method method = clazz.getMethod("add", Object.class);  
        method.invoke(list, new Integer(20));  
        //这里的get函数，编译器认为取出的是String类型  
        Object o = list.get(0);  
        System.out.println(o);  
    }  
}  