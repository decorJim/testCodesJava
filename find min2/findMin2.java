import java.util.ArrayList;

public class findMin2 {
    static ArrayList<Integer> array=new ArrayList<Integer>();
    

    public static void main(String[] args) {
        array.add(3);
        array.add(4);
        array.add(9);
        array.add(10);
        array.add(1);
        array.add(5);
        array.add(2);

        for(int i=0;i<array.size();i++) {
            System.out.print(array.get(i)+" ");
        }
        System.out.println();

        int min=1000;
        int min2=1000;

        for(int i=0;i<array.size();i++) {
            if(array.get(i)<min) {
                min=array.get(i);
            }
            if(array.get(i)<min2 && array.get(i)>min) {
                min2=array.get(i);
            }
            
        } 
        

        System.out.println("the minimal element is "+min);
        System.out.println("the second minimal element is "+min2);
    }
}