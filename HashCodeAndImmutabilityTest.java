/**
 * Created by jmishra on 20-07-2017.
 */

import java.util.HashMap;
import java.util.Map;

class Person{
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int hashCode(){
        int prime = 31;
        int result = 1;
        result *=prime;
        result +=this.getAge() + this.getName().hashCode();
        return result;
    }
    public boolean equals(Object obj){
        //boolean isEqual = false;
        if(obj.getClass() != Person.class)
            return false;
        if(obj == null)
            return false;
        Person otherPerson =(Person)obj;
        if(this.getName().equals(otherPerson.getName()) && this.getAge() == otherPerson.getAge())
            return true;
        return false;
    }
    public String toString(){
        return "Person details: \n \tname: "+this.getName()+"\n\t age: "+this.getAge();
    }
}
public class HashCodeAndImmutabilityTest {
    public static void main(String args[]) throws Exception{
        //HashMap hashMap = new HashMap(); --Although this line won't give compilation error
        // but as casting issue may rise while retrieving the Objects, it is highly discouraged.
        HashMap<Person, Integer> hashMap = new HashMap<Person, Integer>();
        Person obj1 = new Person("Abhiram", 29);
        Person obj2 = new Person("Chandu", 26);
        Person obj3 = new Person("Abhiram", 29);

        System.out.println("Calling out Person details");
        System.out.println("==========================");
        System.out.println("Person obj1 details:");
        System.out.println(obj1.toString());
        System.out.println("\nPerson obj2 details:");
        System.out.println(obj2.toString());
        System.out.println("\nPerson obj3 details:");
        System.out.println(obj3.toString());

        System.out.println("Calling equality check and hashCode before any change");
        System.out.println("obj1.equals(obj2):"+obj1.equals(obj2));
        System.out.println("obj2.equals(obj3):"+obj2.equals(obj3));
        System.out.println("obj3.equals(obj1):"+obj3.equals(obj1));
        System.out.println("\nobj1.hashCode(): "+obj1.hashCode()+" || obj1.getName().hashCode():"
                                +obj1.getName().hashCode()+" || obj1.getAge().hashCode():"
                +"as its a primitive datatype it could not be dereferenced: and its an error");
        System.out.println("obj2.hashCode(): "+obj2.hashCode()+" || obj2.getName().hashCode():"
                +obj2.getName().hashCode()+" || obj2.getAge().hashCode():"
                +"as its a primitive datatype it could not be dereferenced: and its an error");
        System.out.println("obj3.hashCode(): "+obj3.hashCode()+" || obj3.getName().hashCode():"
                +obj3.getName().hashCode()+" || obj3.getAge().hashCode():"
                +"as its a primitive datatype it could not be dereferenced: and its an error");


        hashMap.put(obj1, 1);
        hashMap.put(obj2, 2);
        hashMap.put(obj3, 3);

        System.out.println("HashMap entries");

        /**
         * Now since we do have called put on two meaningfully equaivalent objects obj1, and obj3
         * , and we might be expecting calling hashMap.put(obj3, 3) would update hashMap.put(obj1, 1)
         * because hashMap calls equals to check for meaningfully equivalent objects while calling put.
         * and we have successfully implemented equals function as well
         * So we are right in out expectation. But the important thing to remember here is that HashMap
         * calls equals in put(K, V) operation when it gets into hashCollision while calling hash(k.hashCode())
         * Now since, JVM treats each and every object as separate identities and never checks on equals
         * method before creating space on heap and hence assigns separate hashCode() although they are meaningfully
         * equivalent.
         * Since our Person does not have a hashCode() logic, the hash(...) of hashMap would receive JVM's hashCode
         * which will definitely be different and there might not be hash Collision at all,
         * and equals would never be called, so would three different entries in hashMap.
         * That's why it is advisable that if there's equals override, override hashCode() as well.


         */

        /**
         * Entry class is a static inner class in HashMap and its implementation is as follows:
         *  static class Entry<K ,V> implements Map.Entry<K ,V>
            {
                final K key;
                V value;
                Entry<K ,V> next;
                final int hash;
                ...//More code goes here
            }
         * you can see here key object is final, and entry objects are kind of LinkedList nodes
         * HashMap maintains these entry objects in an Array of Entry type
         *
         * transient Entry[] table; // The table, resized as necessary. Length MUST Always be a power of two.
         *
         * see Map.put(K, V)
         *
         * public V put(K key, V value) {
            if (key == null)
            return putForNullKey(value);
            int hash = hash(key.hashCode());
            int i = indexFor(hash, table.length);
            for (Entry<K , V> e = table[i]; e != null; e = e.next) {
                Object k;
                if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                    V oldValue = e.value;
                    e.value = value;
                    e.recordAccess(this);
                    return oldValue;
                }
            }

            modCount++;
            addEntry(hash, key, value, i);
            return null;
         }


         and get(Key K) implementation:

            public V get(Object key) {
                    if (key == null)
                        return getForNullKey();
                    int hash = hash(key.hashCode());
                    for (Entry<K , V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
                            Object k;
                            if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
                            return e.value;
                    }
                    return null;
            }

         For more information you may read:
         http://howtodoinjava.com/core-java/collections/how-hashmap-works-in-java/
         
         */
        for(Map.Entry<Person, Integer> entry: hashMap.entrySet()){
            System.out.println("Key: "+entry.getKey()+"\nValue: "+entry.getValue()+"\n");

        }

        System.out.println("Lets change the obj2's states :");
        System.out.println("obj2.setName(\"Pratima\")");
        System.out.println("obj2.setAge(26)");
        obj2.setName("Pratima");
        obj2.setAge(26);
        System.out.println("recalculating obj2.hashCode():" +obj2.hashCode());

        System.out.println("obj2.hashCode(): "+obj2.hashCode()+" || obj2.getName().hashCode():"
                +obj2.getName().hashCode()+" || obj2.getAge().hashCode():"
                +"as its a primitive datatype it could not be dereferenced: and its an error");

        /**
         * You might have observevd that although the statest of Object2 has been changed, the obj2.hashCode()
         * is still returning the same value.
         * Now as we have used Person class objects as key, hashMap's hash function would
         * be called like: hash((Person)obj2.hashCode()) and would return the same bucket location as
         * of previous obj2 with different hashValue and thus calling hashMap.get(obj2)
         * would return the value which was stored with an object with completely different state
         * So, basically we have granted an unauthorized access. That's why we prefer using
         * Immutable classes as Key in hashedCollections.
         */

        System.out.println("hashMap.get(obj2): "+hashMap.get(obj2));

        /**
         * We are not allowed to call hashCode() on primitive datatypes
         * because hashCode needs to dereference the elements on which it is called
         * but as primitives are alltogetherly part of a different memory segment,
         * stack, where dereferncing is not possible

         */
        /*try{
            obj2.getAge().hashCode();
        }catch(Exception e){
            System.out.println("Printing stacktrace");
        }*/

    }
}
