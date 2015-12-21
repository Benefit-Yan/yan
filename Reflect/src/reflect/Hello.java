package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

interface China{
    public static final String name="Rollen";
    public static  int age=20;
    public void sayChina();
    public void sayHello(String name, int age);
}
 
class Person implements China{
    public Person() {
         
    }
    public Person(String sex){
        this.sex=sex;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public void sayChina(){
        System.out.println("hello ,china");
    }
    @Override
    public void sayHello(String name, int age){
        System.out.println(name+"  "+age);
    }
    private String sex;
}

public class Hello {
    public static void main(String[] args) throws Exception {
        Class<?> demo = null;
        Object obj = null;
 
        demo = Class.forName("reflect.Person");
        obj = demo.newInstance();
 
        Field field = demo.getDeclaredField("sex");
        field.setAccessible(true);
        field.set(obj, "男");
        System.out.println(field.get(obj));
    }
}// end class


//public class Hello {
//    public static void main(String[] args) {
//        Class<?> demo = null;
//        Object obj=null;
//        try {
//            demo = Class.forName("reflect.Person");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try{
//         obj=demo.newInstance();
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        setter(obj,"Sex","男",String.class);
//        getter(obj,"Sex");
//    }
// 
//    /**
//     * @param obj
//     *            操作的对象
//     * @param att
//     *            操作的属性
//     * */
//    public static void getter(Object obj, String att) {
//        try {
//            Method method = obj.getClass().getMethod("get" + att);
//            System.out.println(method.invoke(obj));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
// 
//    /**
//     * @param obj
//     *            操作的对象
//     * @param att
//     *            操作的属性
//     * @param value
//     *            设置的值
//     * @param type
//     *            参数的属性
//     * */
//    public static void setter(Object obj, String att, Object value,
//            Class<?> type) {
//        try {
//            Method method = obj.getClass().getMethod("set" + att, type);
//            method.invoke(obj, value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}// end class


//public class Hello {
//    public static void main(String[] args) {
//        Class<?> demo = null;
//        try {
//            demo = Class.forName("reflect.Person");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try{
//            //调用Person类中的sayChina方法
//            Method method=demo.getMethod("sayChina");
//            method.invoke(demo.newInstance());
//            //调用Person的sayHello方法
//            method=demo.getMethod("sayHello", String.class,int.class);
//            method.invoke(demo.newInstance(),"Rollen",20);
//             
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}


//public class Hello {
//    public static void main(String[] args) {
//        Class<?> demo = null;
//        try {
//            demo = Class.forName("reflect.Person");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("===============本类属性========================");
//        // 取得本类的全部属性
//        Field[] field = demo.getDeclaredFields();
//        for (int i = 0; i < field.length; i++) {
//            // 权限修饰符
//            int mo = field[i].getModifiers();
//            String priv = Modifier.toString(mo);
//            // 属性类型
//            Class<?> type = field[i].getType();
//            System.out.println(priv + " " + type.getName() + " "
//                    + field[i].getName() + ";");
//        }
//        System.out.println("===============实现的接口或者父类的属性========================");
//        // 取得实现的接口或者父类的属性
//        Field[] filed1 = demo.getFields();
//        for (int j = 0; j < filed1.length; j++) {
//            // 权限修饰符
//            int mo = filed1[j].getModifiers();
//            String priv = Modifier.toString(mo);
//            // 属性类型
//            Class<?> type = filed1[j].getType();
//            System.out.println(priv + " " + type.getName() + " "
//                    + filed1[j].getName() + ";");
//        }
//    }
//}

//public class Hello{
//    public static void main(String[] args) {
//        Class<?> demo=null;
//        try{
//            demo=Class.forName("reflect.Person");
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        //取得父类
//        Class<?> temp=demo.getSuperclass();
//        System.out.println("继承的父类为：   "+temp.getName());
//    }
//}


//public class Hello{
//    public static void main(String[] args) {
//        Class<?> demo=null;
//        try{
//            demo=Class.forName("reflect.Person");
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        Constructor<?>cons[]=demo.getConstructors();
//        for (int i = 0; i < cons.length; i++) {
//            Class<?> p[]=cons[i].getParameterTypes();
//            System.out.print("构造方法：  ");
//            int mo=cons[i].getModifiers();
//            System.out.print(Modifier.toString(mo)+" ");
//            System.out.print(cons[i].getName());
//            System.out.print("(");
//            for(int j=0;j<p.length;++j){
//                System.out.print(p[j].getName()+" arg"+i);
//                if(j<p.length-1){
//                    System.out.print(",");
//                }
//            }
//            System.out.println("){}");
//        }
//    }
//}

 
//public class Hello{
//    public static void main(String[] args) {
//        Class<?> demo=null;
//        try{
//            demo=Class.forName("reflect.Person");
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        //保存所有的接口
//        Class<?> intes[]=demo.getInterfaces();
//        for (int i = 0; i < intes.length; i++) {
//            System.out.println("实现的接口   "+intes[i].getName());
//        }
//    }
//}