import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class EhancedInsertionSort_ThresholdSwapping {

	public static void main(String[] args) throws IOException {
	
		//*** Generate random array
	
		int[] arr_test1= new int[500];
		int[] arr_test2= new int[500];
		int[] arr_test3= new int[500];
	    for (int i=0; i<500; i++){
	        int n = (int)(Math.random()*500 + 1);
	      
	        arr_test1[i] = n;
	        arr_test2[i] = n;
	        arr_test3[i] = n;
	    }

	    long start = System.currentTimeMillis(); // Get Time
		   int[] arr2 = doWInsertionSort(arr_test1);
		   long end = System.currentTimeMillis();
		    long elapsed = end - start; 
		    	System.out.println(elapsed);
		    	
		    	// Code 2 ************8
		    	 long start2 = System.currentTimeMillis(); // Get Time
				   int[] arr3 = doEncWInsertionSort(arr_test2);
				   long end2 = System.currentTimeMillis();
				    long elapsed2 = end2 - start2; 
				    	System.out.println(elapsed2);
		    	//*************8  
				    	// Code 2 ************8
				    	 long start3 = System.currentTimeMillis(); // Get Time
						   int[] arr4 = doEncWQInsertionSort(arr_test3);
						   long end3 = System.currentTimeMillis();
						    long elapsed3 = end3 - start3; 
						    	System.out.println(elapsed3);
				    	//*************8
				    	
		    	try {
		    		PrintWriter outputfile = new PrintWriter(new FileWriter("C:/Users/shoshozozo/Desktop/results.txt", true));
		    		//PrintWriter outputfile = new PrintWriter("C:/Users/shosho&zozo/Desktop/results.txt");
					outputfile.print(elapsed + "\t");
					outputfile.print(elapsed2 + "\t");
		    		outputfile.println(elapsed3);
			    	    outputfile.close(); 
		    	} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	 
		 /*  for(int i:arr2){
	            System.out.print(i);
	            System.out.print(",");
	        }
	        System.out.println(", ");
	       */ 
	    
    	
	}

	public static int[] doEncInsertionSort(int[] input){
        int t=0;
        int temp;
        for (int i = 1; i < input.length; i++) {
        	if (input[i] >= input[i/2]){ // If larger than half
        		
        		for(int j = i ; j > 0 ; j--){
                    if(input[i] >= input[j-1] && input[i]<input[j]){
                  	  t = j;
                  	  temp = input[i];
                        input[i] = input[j];
                        input[j] = temp;
                        
                        break;
                    }
                    }
      		for(int j = i ; j > t ; j--){     			 
      	                if(input[j] < input[j-1]){
      	                    temp = input[j];
      	                    input[j] = input[j-1];
      	                    input[j-1] = temp;
      	                }
      		}
      		}
        else{
        	   for(int j = i ; j > 0 ; j--){
	                if(input[j] < input[j-1]){
	                    temp = input[j];
	                    input[j] = input[j-1];
	                    input[j-1] = temp;
	                }
	            }
        }
        }
        return input;
    
    }
	 public static int[] doInsertionSort(int[] input){
         
	        int temp;
	        for (int i = 1; i < input.length; i++) {
	            for(int j = i ; j > 0 ; j--){
	                if(input[j] < input[j-1]){
	                    temp = input[j];
	                    input[j] = input[j-1];
	                    input[j-1] = temp;
	                }
	            }
	        }
	        return input;
	    }
	 
	 public static int[] doWInsertionSort(int[] input){
         
	        int temp;
	        int j;
	        for (int i = 1; i < input.length; i++) {
	        	temp = input[i];
	        	j = i -1;
	            while (j>=0 && input[j]>temp){
	                input[j+1]=input[j];
	                j=j-1;
	            }
	            input[j+1]= temp;
	        }
	        return input;
	    }
	 public static int[] doEncWInsertionSort(int[] input){
	        int t=0;
	        int temp;
	        for (int i = 1; i < input.length; i++) {
	        	if (input[i] <= input[i/3]){ // If larger than half
	        		
	        		for(int j = i/3 ; j > 0 ; j--){
	                    if(input[i] >= input[j-1] && input[i]<input[j]){
	                  	  t = j;
	                  	  temp = input[i];
	                        input[i] = input[j];
	                        input[j] = temp;
	                        
	                        break;
	                        
	                    }
	                    }
	        		t=0;
	      		for(int j = i ; j > t ; j--){     			 
	      	                if(input[j] < input[j-1]){
	      	                    temp = input[j];
	      	                    input[j] = input[j-1];
	      	                    input[j-1] = temp;
	      	                }
	      		}
	      		}
	        else{
	        	int j;
	        	temp = input[i];
	        	j = i -1;
	            while (j>=0 && input[j]>temp){
	                input[j+1]=input[j];
	                j=j-1;
	            }
	            input[j+1]= temp;
	        }
	        }
	        return input;
	    
	    }

	 
	 public static int[] doEncWQInsertionSort(int[] input){
	        int t=0;
	        int temp;
	        for (int i = 1; i < input.length; i++) {
	        	if (input[i] <= input[i/3]){ // If larger than half
	        		
	        		for(int j = i/4 ; j > 0 ; j--){
	                    if(input[i] >= input[j-1] && input[i]<input[j]){
	                  	  t = j;
	                  	  temp = input[i];
	                        input[i] = input[j];
	                        input[j] = temp;
	                        
	                        break;
	                        
	                    }
	                    }
	        		t=0;
	      		for(int j = i ; j > t ; j--){     			 
	      	                if(input[j] < input[j-1]){
	      	                    temp = input[j];
	      	                    input[j] = input[j-1];
	      	                    input[j-1] = temp;
	      	                }
	      		}
	      		}
	        else{
	        	int j;
	        	temp = input[i];
	        	j = i -1;
	            while (j>=0 && input[j]>temp){
	                input[j+1]=input[j];
	                j=j-1;
	            }
	            input[j+1]= temp;
	        }
	        }
	        return input;
	    
	    }

}


