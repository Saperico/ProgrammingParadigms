package Labs.List7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex1 {
    private static class Pair<T, U> {
        public T _1;
        public U _2;
        public Pair(T _1, U _2) {
            this._1 = _1;
            this._2 = _2;
        }
    }
    public static Pair splitListEvenOdd(List<Integer> list)//imperative way
    {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        Iterator it = list.iterator();
        while(it.hasNext()) {
            odd.add((Integer)it.next());
            if(it.hasNext()) {
                even.add((Integer)it.next());
            }
        }
        return new Pair(odd, even);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        List<Integer> list = new ArrayList<>();
        for(int i : arr) {
            list.add(i);
        }
        Pair<List<Integer>, List<Integer>> pair = splitListEvenOdd(list);
        System.out.println(pair._1);//[1,3,5,7]
        System.out.println(pair._2);//[2,4,6]
    }
}
