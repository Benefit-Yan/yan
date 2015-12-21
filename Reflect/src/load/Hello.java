package load;

class test{
    
}
public class Hello{
    public static void main(String[] args) {
        test t=new test();
        System.out.println("类加载器  "+t.getClass().getClassLoader().getClass().getName());
    }
}