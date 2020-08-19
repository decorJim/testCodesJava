import java.util.HashMap;
import java.lang.Integer;
import java.util.*;

public class hashmap {

    static HashMap<Integer,LinkedList<String>> names=new HashMap<Integer,LinkedList<String>>();

    public static int findHashKey(String name) 
    {
        char firstLetter=name.charAt(0);
        int correspondingNum=firstLetter;
        int key=(correspondingNum)%20;
        return key;
    }

    public static boolean positionEmpty(int key) 
    {
       if(names.get(key)==null) 
       {
           return true;
       }
       else 
       {
           return false;
       }
    }
    

    public static void putElement(String name) 
    {
       LinkedList<String> listToAdd=new LinkedList<String>();
       int key=findHashKey(name);

       if(positionEmpty(key)==true) {
           listToAdd.add(name);
           names.put(key,listToAdd);    
       }
       else {
           Iterator it=names.get(key).iterator();

           for(String item:names.get(key)) 
           {
               listToAdd.add(item);
           }
           listToAdd.add(name);

           names.put(key,listToAdd);
       }
    }
    
    public static void main(String[] args) 
    {

        for(int i=0;i<names.size();i++) 
        {
            names.put(i,new LinkedList<String>());
        }

        String name1=new String("crown");
        String name2=new String("cirk");
        String name3=new String("Anos");
        String name4=new String("jasjb");   
        String name5=new String("Avos");        

        int key1=findHashKey(name1);
        int key2=findHashKey(name2);
        int key3=findHashKey(name3);
        int key4=findHashKey(name4);        
        int key5=findHashKey(name5);    
        
        System.out.println("the key is "+key1);
        System.out.println("the key is "+key2);
        System.out.println("the key is "+key3);
        System.out.println("the key is "+key4);

        putElement(name1);                                     
        putElement(name2);                      
        putElement(name3);
        putElement(name4);  
        putElement(name5);

        System.out.println(names.keySet());   
        
        for(Map.Entry<Integer,LinkedList<String>> it:names.entrySet()) 
        {
            for(int i=0;i<it.getValue().size();i++) 
            {
                System.out.println(it.getValue().get(i));
            }
        }


        Set<Integer> set1=names.keySet();

        Integer[] keys=set1.toArray(new Integer[ set1.size() ] );

        for(int i=0;i<names.entrySet().size();i++)
        {
            for(int j=0;j<names.get(keys[i]).size();j++) 
            {
                System.out.println(names.get(keys[i]).get(j));
            }
        }

        





        

    }
}