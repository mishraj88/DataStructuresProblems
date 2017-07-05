package javaTestAppnomic;
class MyClass{
    int data;

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + data;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyClass other = (MyClass) obj;
        if (data != other.data)
            return false;
        return true;
    }

    public static  String m(MyClass o1, MyClass o2){
        String s1= o1 == o2 ? "T":"F";
        String s2=o1.equals(o2) ? "T" : "F";
        String s3= o1.hashCode() == o2.hashCode() ? "T" : "F";
        return s1+s2+s3;
    }

}
public class PerfTest {

    public static void main(String a[]){
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();
        System.out.println(MyClass.m(obj1, obj2));
    }
}
