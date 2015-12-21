package com.hhf.reflect;

import java.lang.reflect.Constructor;  
import java.lang.reflect.Field;  
import java.lang.reflect.Method;  
  
public class Refect {  
  
    // JAVA反射机制是在   运行状态    中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。  
    // Java反射机制主要提供了以下功能：  
    // 在运行时判断任意一个对象所属的类；  
    // 在运行时构造任意一个类的对象；  
    // 在运行时判断任意一个类所具有的成员变量和方法；  
    // 在运行时调用任意一个对象的方法；生成动态代理。  
  
    // 使用反射机制的步骤：  
    // 导入java.lang.relfect 包  
    // 遵循三个步骤  
    // 第一步是获得你想操作的类的 java.lang.Class 对象  
    // 第二步是调用诸如 getDeclaredMethods 的方法  
    // 第三步使用 反射API 来操作这些信息  
    public static void main(String [] args){  
        Refect refect = new Refect();  
        System.out.println("-----------------------通过对象获得方法和属性------------------------");  
        refect.reflectInstance();  
        System.out.println("-----------------------通过类名获得方法与参数----------------------------");  
        refect.reflectClass();  
        System.out.println("-----------------------批量执行方法------------------------------");  
        refect.RunMethod();  
        System.out.println("-----------------------调用指定无参方法----------------------------");  
        refect.RunSepcMethod();  
        System.out.println("-----------------------调用有参数方法------------------------------");  
        refect.RunParmMethod();  
    }  
    /** 
     * 通过对象获得类的 方法和属性 
     */  
    public void reflectInstance() {  
        try {             
            DataFunc a = new DataFunc();  
            Class<?> cla = Class.forName(a.getClass().getName());// 根据类的全路径进行类加载，返回该类的Class对象  
            Method[] method = cla.getDeclaredMethods();// 利用得到的Class对象的自审，返回方法对象集合  
            System.out.println("********该类的所有方法********");  
            for (Method me : method) {// 遍历该类方法的集合  
                System.out.println(me.toString());// 打印方法信息  
            }  
            System.out.println("********该类的所有属性********");  
            Field[] field = cla.getDeclaredFields();// 利用得到的Class对象的自审，返回属性对象集合  
            for (Field me : field) { // 遍历该类属性的集合  
                System.out.println(me.toString());// 打印属性信息  
            }  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * 通过类的完整路径获得类的 方法和属性 
     */  
    public void reflectClass() {  
  
        try {             
            Class<?> cla = Class.forName("com.hhf.reflect.DataFunc");// 根据类的全路径进行类加载，返回该类的Class对象  
            Method[] method = cla.getDeclaredMethods();// 利用得到的Class对象的自审，返回方法对象集合  
            System.out.println("********该类的所有方法********");  
            for (Method me : method) {// 遍历该类方法的集合  
                System.out.println(me.toString());// 打印方法信息  
            }  
            System.out.println("********该类的所有属性********");  
            Field[] field = cla.getDeclaredFields();// 利用得到的Class对象的自审，返回属性对象集合  
            for (Field me : field) { // 遍历该类属性的集合  
                System.out.println(me.toString());// 打印属性信息  
            }  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 指定构造函数 
     * 可以另外的通过构造函数给函数属性传递参数 并调用方法 
     */  
    public void RunMethod() {  
        try {  
            // 获得指定字符串类对象  
            Class<?> cla = Class.forName("com.hhf.reflect.DataFunc");  
            // 设置Class对象数组，用于指定构造方法类型  
            Class<?>[] cl = new Class[] { int.class, int.class };  
            // 获得Constructor构造器对象。并指定构造方法类型  
            Constructor<?> con = cla.getConstructor(cl);  
            // 给传入参数赋初值  
            Object[] x = { new Integer(33), new Integer(67) };  
            // 得到实例  
            Object obj = con.newInstance(x);  
  
            Method[] method = cla.getDeclaredMethods();// 利用得到的Class对象的自审，返回方法对象集合  
            //批量调用方法（无参数的方法）  
            for (Method me : method) {// 遍历该类方法的集合  
                System.out.print("调用方法："+me.toString());// 打印方法信息  
                String str = me.invoke(obj).toString();  
                System.out.println("\t该方法执行结果"+str);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * 指定方法名的调用方法 
     */  
    public void RunSepcMethod() {  
        try {  
            // 获得指定字符串类对象  
            Class<?> cla = Class.forName("com.hhf.reflect.DataFunc");  
            // 设置Class对象数组，用于指定构造方法类型  
            Class<?>[] cl = new Class[] { int.class, int.class };  
            // 获得Constructor构造器对象。并指定构造方法类型  
            Constructor<?> con = cla.getConstructor(cl);  
            // 给传入参数赋初值  
            Object[] x = { new Integer(33), new Integer(67) };  
            // 得到实例  
            Object obj = con.newInstance(x);  
              
            Method specMethod = cla.getMethod("add");  
            String str = specMethod.invoke(obj).toString();  
            System.out.println("调用方法"+specMethod.getName()+"的结果\t"+str);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 调用有参数的方法 
     */  
    public void RunParmMethod() {  
        try {  
            // 获得指定字符串类对象  
            Class<?> cla = Class.forName("com.hhf.reflect.DataFunc2");  
            // 设置Class对象数组，用于指定构造方法类型  
            Class<?>[] cl = new Class[] { int.class, int.class };  
            // 获得Constructor构造器对象。并指定构造方法类型  
            Constructor<?> con = cla.getConstructor(cl);  
            // 给传入参数赋初值  
            Object[] x = { new Integer(33), new Integer(67) };  
            // 得到实例  
            Object obj = con.newInstance(x);      
  
//          Method specMethod1 = cla.getMethod("a", int.class, int.class);  
            Class<?>[] c2 = new Class[] { int.class, int.class, int.class};  
            Method parmMethod = cla.getMethod("add2", c2);  
            // 给传入参数赋初值  
            Object[] x2 = { new Integer(3), new Integer(6), new Integer(1)};  
            // 得到实例  
            String str = parmMethod.invoke(obj, x2).toString();  
            System.out.println("调用方法"+parmMethod.getName()+"的结果\t"+str);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
}  