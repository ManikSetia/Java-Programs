import java.util.*;

public class CollectionFramework {

    public static void main(String[] args) {
//        ArrayList<String> list=new ArrayList<>();
//        System.out.println(list.size());
//        list.add("1");
//        list.add("12");
//        list.add("14");
//        list.add("11");
//        list.add("16");
//        System.out.println(list.get(3));
//
//        Iterator itr=list.iterator();
//        System.out.println("In asc: ");
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }
//
//        System.out.println("In desc: ");
//        ListIterator litr=list.listIterator(list.size());
//        while(litr.hasPrevious()){
//            System.out.println(litr.previous());
//        }
//        System.out.println("Desc2: ");
//        Iterator itr2=list.descendingIterator();
//        while(itr2.hasNext()){
//            System.out.println(itr2.next());
//        }


        //array to list
//        String[] array={"Java","Python","PHP","C++"};
//        List<String> list=new ArrayList<>(array.length);
//        System.out.println(Arrays.toString(array));
//        for(String language: array){
//            list.add(language);
//        }
//        System.out.println(list);
//
//        //list to array
//        String[] newArray=new String[list.size()];
//        for(int i=0; i<newArray.length; i++){
//            newArray[i]=list.get(i);
//        }
//        System.out.println(Arrays.toString(newArray));
//
//        String[] newArr=list.toArray(new String[list.size()]);
//        System.out.println(Arrays.toString(newArr));


//        PriorityQueue<String> queue=new PriorityQueue<String>();
//        queue.add("Amit");
//        queue.add("Vijay");
//        queue.add("Karan");
//        queue.add("Jai");
//        queue.add("Rahul");
//        queue.add("manik");
//        queue.add("priya");
//        queue.add("iris");
//        queue.add("ingrid");
//        queue.add("pierina");
//        queue.add("milla");
//        System.out.println("head:"+queue.element());
//        System.out.println("head:"+queue.peek());
//        System.out.println("iterating the queue elements:");
//        Iterator itr=queue.iterator();
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }
//        queue.remove();
//        queue.poll();
//        System.out.println("after removing two elements:");
//        Iterator<String> itr2=queue.iterator();
//        while(itr2.hasNext()){
//            System.out.println(itr2.next());
//        }
//        System.out.println("head:"+queue.element());
//        System.out.println("head:"+queue.peek());
//
//        Queue<String> newQueue=new PriorityQueue<>();
//        System.out.println(newQueue.peek());
////        System.out.println(newQueue.element());//exception
////        newQueue.remove();//exception
//        System.out.println("newQueue.poll() = " + newQueue.poll());
//
//
//        Deque<String> dq=new ArrayDeque<>();
//        dq.offer


//        HashMap<Integer,String> map=new HashMap<Integer,String>();
//        map.put(100,"Amit");
//        map.put(101,"Vijay");
//        map.put(102,"Rahul");
//        map.put(103, "Gaurav");
//        System.out.println("Initial list of elements: "+map);
//        //key-based removal
//        map.remove(100);
//        System.out.println("Updated list of elements: "+map);
//        //value-based removal
//        map.remove("Gaurav");
//        System.out.println("Updated list of elements: "+map);
//        //key-value pair based removal
//        map.remove(102, "Rahul");
//        System.out.println("Updated list of elements: "+map);

        ArrayList<String> al=new ArrayList<String>();
        al.add("Viru");
        al.add("Saurav");
        al.add("Mukesh");
        al.add("Tahir");

        Collections.sort(al,Collections.reverseOrder());
        Iterator i=al.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
    }
}
