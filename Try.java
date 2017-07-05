class A {
    public A() {
        System.out.println("A");
    }
}

class B extends A {
    public B() {
        //System.out.print("B");
        super();
    }
}

public class Try {
    public static void main(String[] args) {
        new B();

        try{
            int i= 1/0;

        }catch(Exception e){
            System.out.println("E");
        }finally{
            System.out.println("F");
        }
    }
}