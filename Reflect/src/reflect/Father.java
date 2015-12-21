package reflect;

import java.lang.reflect.Field;

public class Father {

       private String fname = "father";

       private int fage = 40;

       public static void main(String[] args) {

              try {

                     Class<Son> class1 = (Class<Son>) Class.forName("reflect.Son");

                     Son son = class1.newInstance();

                     Field[] fields = son.getClass().getDeclaredFields();   //getFields() 只能获得非private 以外的成员变量

                     for (Field field : fields) {

                            System.out.println(field.getName());

                     }

                     Field[] fields1 = son.getClass().getSuperclass().getDeclaredFields(); 

                     for (Field field : fields1) {

                            System.out.println(field.getName());

                     }

              } catch (ClassNotFoundException e) {

                     // TODO Auto-generated catch block

                     e.printStackTrace();

              } catch (InstantiationException e) {

                     // TODO Auto-generated catch block

                     e.printStackTrace();

              } catch (IllegalAccessException e) {

                     // TODO Auto-generated catch block

                     e.printStackTrace();

              }

               

       }

       public String getFname() {

              return fname;

       }

       public void setFname(String fname) {

              this.fname = fname;

       }

       public int getFage() {

              return fage;

       }

       public void setFage(int fage) {

              this.fage = fage;

       }

}

class Son extends Father{

       private String sname = "son";

       private int sage = 20;

       public String getSname() {

              return sname;

       }

       public void setSname(String sname) {

              this.sname = sname;

       }

       public int getSage() {

              return sage;

       }

       public void setSage(int sage) {

              this.sage = sage;

       }

}