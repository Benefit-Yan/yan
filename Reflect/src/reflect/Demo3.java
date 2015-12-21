package reflect;

import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.Method;

public class Demo3 {

       public void show() {

              System.out.println("show method");

       }

       public void show(int i) {

              System.out.println("show method with param :" + i);

       }

       public int showReturn() {

              return 1;

       }

       public static void main(String[] args) {

              try {

                     Class<?> class1 = Class.forName("reflect.Demo3");

                     Demo3 demo3 = (Demo3) class1.newInstance();

                     Method method1 = demo3.getClass().getDeclaredMethod("show");

                     Method method2 = demo3.getClass().getDeclaredMethod("show", int.class);

                     Method method3 = demo3.getClass().getDeclaredMethod("showReturn");

                     method1.invoke(demo3);

                     method2.invoke(demo3, 2);

                     Integer i = (Integer)method3.invoke(demo3);

                     System.out.println(i);

              } catch (ClassNotFoundException e) {

                     // TODO Auto-generated catch block

                     e.printStackTrace();

              } catch (InstantiationException e) {

                     // TODO Auto-generated catch block

                     e.printStackTrace();

              } catch (IllegalAccessException e) {

                     // TODO Auto-generated catch block

                     e.printStackTrace();

              } catch (SecurityException e) {

                     // TODO Auto-generated catch block

                     e.printStackTrace();

              } catch (NoSuchMethodException e) {

                     // TODO Auto-generated catch block

                     e.printStackTrace();

              } catch (IllegalArgumentException e) {

                     // TODO Auto-generated catch block

                     e.printStackTrace();

              } catch (InvocationTargetException e) {

                     // TODO Auto-generated catch block

                     e.printStackTrace();

              }

       }

}