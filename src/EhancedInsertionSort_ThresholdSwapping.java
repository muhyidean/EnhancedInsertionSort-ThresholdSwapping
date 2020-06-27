

public abstract class EhancedInsertionSort_ThresholdSwapping {

    public static void main(String[] args) {

        //*** Generate random array

        int val = 500;  // assign number of dataset here
        int[] arr_test = new int[val];
        for (int i = 0; i < val; i++) {
            int n = (int) (Math.random() * val + 1);
            arr_test[i] = n;
        }

        int[] arr = doEncWInsertionSort(arr_test);


    }

        public static int[] doEncWInsertionSort ( int[] input){
            int t = 0;
            int temp;
            for (int i = 1; i < input.length; i++) {
                if (input[i] <= input[i / 3]) { // If larger than half

                    for (int j = i / 3; j > 0; j--) {
                        if (input[i] >= input[j - 1] && input[i] < input[j]) {
                            t = j;
                            temp = input[i];
                            input[i] = input[j];
                            input[j] = temp;
                            break;
                        }
                    }
                    t = 0;
                    for (int j = i; j > t; j--) {
                        if (input[j] < input[j - 1]) {
                            temp = input[j];
                            input[j] = input[j - 1];
                            input[j - 1] = temp;
                        }
                    }
                } else {
                    int j;
                    temp = input[i];
                    j = i - 1;
                    while (j >= 0 && input[j] > temp) {
                        input[j + 1] = input[j];
                        j = j - 1;
                    }
                    input[j + 1] = temp;
                }
            }
            return input;

        }

    }
