package Programs.Arrays.Part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatAndMissing {

    //T.C. : O(n2)
    //S.C. : O(1)
    public static ArrayList<Integer> repeatedNumber(List<Integer> list){
        ArrayList<Integer> result=new ArrayList<>();
        for(int number=0; number<list.size(); number++){
            for(int number2=number+1; number2<list.size(); number2++){
                if(list.get(number)==list.get(number2)) {
                    result.add(list.get(number));
                    break;
                }
            }
        }
        for(Integer number=1; number<list.size(); number++){
            boolean check=false;
            for(Integer no: list){
                if(number==no) {
                    check=true;
                    break;
                }
            }
            if(!check) result.add(number);
        }

        return result;
    }

    //T.C. : O(n)
    //S.C. : O(n)
    public static ArrayList<Integer> repeatedNumberBetter(List<Integer> list){
        int duplicateNumber=-1, missingNumber=-1;
        ArrayList<Integer> result=new ArrayList<>();
        Map<Integer, Integer> map=new HashMap<>(list.size());
        for(int i=1; i<=list.size(); i++){
            map.put(i, 0);
        }

        for(int i=0; i<list.size(); i++){
            map.put(list.get(i), map.getOrDefault(list.get(i), 0)+1);
        }

        //Now iterate over the map to find the repeated and the missing number
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()>=2) duplicateNumber=entry.getKey();
            else if(entry.getValue()==0) missingNumber=entry.getKey();
        }

        result.add(duplicateNumber);
        result.add(missingNumber);
        return result;
    }

    //XOR method
    //T.C. : O(n)
    //S.C. : O(1)
    public static ArrayList<Integer> repeatedNumberOptimal(List<Integer> list){
        ArrayList<Integer> result=new ArrayList<>();
        int xor=0;
        for(Integer number: list) xor ^= number;
        for(int i=1; i<=list.size(); i++) xor ^= i;

        //Now we're left with xor of repeated and missing number. To separate these two, we need to find rsb
        int rsb=xor & -xor;

        int firstElement=0, secondElement=0;

        //Now we've to perform AND operation of each element with rsb
        for(Integer val: list){
            if((rsb & val) == 0){
                //means rsb of current element is set
                firstElement ^= val;
            }
            else{
                secondElement ^= val;
            }
        }

        //We've to perform XOR with [1, n] as well because initially we got xor of two required numbers by using [1,n]
        for(int i=1; i<=list.size(); i++){
            if((rsb & i) == 0){
                //means rsb of current element is set
                firstElement ^= i;
            }
            else{
                secondElement ^= i;
            }
        }

        //Now task is to find which one is repeating and which one is missing
        for(Integer val: list){
            if(val==firstElement){
                //duplicated is firstElement
                result.add(firstElement);
                result.add(secondElement);
                break;
            }
        }

        result.add(secondElement);
        result.add(firstElement);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> input=new ArrayList<>();
        input.add(3);
        input.add(1);
        input.add(2);
        input.add(5);
        input.add(3);
//        ArrayList<Integer> list=repeatedNumber(input);
//        ArrayList<Integer> list=repeatedNumberBetter(input);
        ArrayList<Integer> list=repeatedNumberOptimal(input);
        System.out.println(list);
    }
}
