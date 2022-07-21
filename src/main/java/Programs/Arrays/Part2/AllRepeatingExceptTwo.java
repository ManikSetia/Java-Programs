package Programs.Arrays.Part2;

public class AllRepeatingExceptTwo {

    public static void findTwoUniqueElements(int[] arr){
        int xor=0;

        //xor all the elements. At the end,  we'll left with xor of two unique elements
        for(int val: arr){
            xor ^= val;
        }

        //To separate two unique elements, we've to find right most set bit mask.
        int rsb=xor & -xor;

        int firstElement=0, secondElement=0;
        // Now again do xor with all the elements of the array
        for(int val: arr){
            if((rsb & val) == 0){
                //means the rsb is set of current element
                firstElement ^= val;
            }
            else{
                secondElement ^= val;
            }
        }

        System.out.println(firstElement);
        System.out.println(secondElement);
    }

    public static void main(String[] args) {
        int[] arr={23, 17, 17,27, 37,27};
        findTwoUniqueElements(arr);
    }
}
