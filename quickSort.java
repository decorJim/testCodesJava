public class quickSort {
     /*static int[] array=new int[]{1,1,2,49,90,43,19,6}; */
      static int[] array=new int[]{24,2,45,20,56,75,2,56,99,53,12}; 

     public static void printArray(int a[]) {
         for (int i = 0; i < a.length; i++) {
             System.out.print(a[i] + " ");
         }
         System.out.println("");
     }

     
    
     public static void quickSortfunc(int table[], int begin, int end) {

         int i = begin;
         int j = end;

         int middle = begin+((end - begin) / 2);
         
       //  i<middle && j>middle
      while(i<j) {

        if (table[i] > table[middle]) {
                 int tmp = table[i];
                 table[i] = table[middle];
                 table[middle] = tmp;    
                
        }
        if (table[j] < table[middle]) {
                 int tmp = table[middle];
                 table[middle] = table[j];
                 table[j] = tmp;
                 
        }
        if(table[i]>table[j]) {
                int tmp = table[i];
                table[i] = table[j];
                table[j] = tmp;
               
        }

        while(table[middle]>=table[i] && table[middle]<=table[j]) {
            i++;
            j--;
        }

        quickSortfunc(table,begin,middle);
        quickSortfunc(table,middle+1,end); 

     } 
     
     
        
    }

    
     
     

     public static void main(String[] args)
     {  
        printArray(array);
        quickSortfunc(array,0,array.length-1);
        
        printArray(array);

     }
}