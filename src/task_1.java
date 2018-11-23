/*
    1. Разбиваем на два множества, найти минимальную разницу
    2. Выяснить, мижно ли добиться нулевой разницы
    3. Выяснить, мижно ли добиться разницы, равной какому-то числу
    4. ...
 */

import java.util.stream.IntStream;

public class task_1 {
    public static void main(String[] args) {
//        ArrayList<Integer> _originHeap = new ArrayList<>(Arrays.asList(5,1,1,1,1));
        int[] list = {5,1,1,1,1,1, -5 };
        int heap2 = 0;
        int heap1 = IntStream.of(list).sum();
        System.out.println(solve1(heap1,heap2,0, list));
        System.out.println(solve2(heap1,heap2,0,list));
        System.out.println(solve2_1(heap1,heap2,0,list));
        System.out.println(solve3(heap1,heap2,0,list, 10));
    }

    public static int solve1(int heap1, int heap2, int index, int[] list) {
        if (index == list.length -1) {
            return Math.abs(heap1-heap2-heap2);
        } else {
            return (Math.min(solve1(heap1, heap2 + list[index], index +1, list),
            solve1(heap1,heap2,index+1, list)));
        }
    }

    public static boolean solve2(int heap1, int heap2, int index, int[] list) {
        return 0 == solve1(heap1,heap2,index,list);
    }

    public static boolean solve2_1(int heap1, int heap2, int index, int[] list) {
        if (index == list.length -1) {
            return Math.abs(heap1-heap2-heap2) == 0;
        } else {
            return ((solve2_1(heap1, heap2 + list[index], index +1, list)||
                    solve2_1(heap1,heap2,index+1, list)));
        }
    }

    public static boolean solve3(int heap1, int heap2, int index, int[] list, int Num) {
        if (index == list.length -1) {
            return heap2 == Num;
        } else {
            return ((solve3(heap1, heap2 + list[index], index +1, list, Num)||
                    solve3(heap1,heap2,index+1, list, Num)));
        }
    }

}

