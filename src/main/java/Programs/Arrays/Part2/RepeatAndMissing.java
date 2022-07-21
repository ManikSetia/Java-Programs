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
        int duplicateNumber=-1, repeatedNumber=-1;
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
            else if(entry.getValue()==0) repeatedNumber=entry.getKey();
        }

        result.add(duplicateNumber);
        result.add(repeatedNumber);
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
        ArrayList<Integer> list=repeatedNumberBetter(input);
        System.out.println(list);
    }
}
