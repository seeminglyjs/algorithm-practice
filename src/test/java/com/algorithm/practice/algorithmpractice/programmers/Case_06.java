package com.algorithm.practice.algorithmpractice.programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Case_06 { // 다리를 지나는 트럭 스택 큐 /트리맵 /객체
//    다리를 지나는 트럭
//    문제 설명
//    트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
//
//    예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
//
//    경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
//0	[]	[]	[7,4,5,6]
//        1~2	[]	[7]	[4,5,6]
//        3	[7]	[4]	[5,6]
//        4	[7]	[4,5]	[6]
//        5	[7,4]	[5]	[6]
//        6~7	[7,4,5]	[6]	[]
//        8	[7,4,5,6]	[]	[]
//    따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
//
//    solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
//
//    제한 조건
//    bridge_length는 1 이상 10,000 이하입니다.
//            weight는 1 이상 10,000 이하입니다.
//    truck_weights의 길이는 1 이상 10,000 이하입니다.
//    모든 트럭의 무게는 1 이상 weight 이하입니다.
//            입출력 예
//    bridge_length	weight	truck_weights	return
//            2	10	[7,4,5,6]	8
//            100	100	[10]	101
//            100	100	[10,10,10,10,10,10,10,10,10,10]	110

    @Test
    public void test1() {
        int answer = 0;
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        answer = solution3(bridge_length, weight, truck_weights);
        System.out.println(answer);
    }
    class Truck {
        int weight;
        int move_distance;

        public Truck(int weight) {
            this.weight = weight;
            this.move_distance = 1;
        }

        public void moving() {
            move_distance++;
        }

        @Override
        public String toString() {
            return "Truck{" +
                    "weight=" + weight +
                    ", move_distance=" + move_distance +
                    '}';
        }
    }
    public int solution3(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truck_weights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            //이동중인 트럭이 없다면
            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight; //다리로 이동후 하중 더하기
                moveQ.offer(t);
                continue;
            }

            //Queue를 순회하면 트럭들을 한번씩 이동시킨다.
            for (Truck t : moveQ) {
                t.moving();
            }

            //가장 앞에 있는트럭이 다리를 지났다면
            if (Objects.requireNonNull(moveQ.peek()).move_distance > bridge_length) {
                Truck t = moveQ.poll();
                System.out.println(t.toString());
                curWeight -= t.weight; //현재트럭 무게 빼기
            }
            //가장 앞에서 대기중인 트럭의 무게가 추가되어도 하중을 초과하지 않으면
            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight; //현재 무게에 트럭무게 더하기
                moveQ.offer(t); //트럭 이동 시작
            }
        }

        return answer;
    }

    public int solution2(int bridge_length, int weight, int[] truck_weights) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int now = 0, sec = 1;
        for(int truck_weight : truck_weights)
        {
            if(!map.isEmpty() && map.firstKey() == sec){//맵이 비어있지않고 첫번째 키가 시간과 같을 경우
                now -= map.remove(map.firstKey()); //현재 무게에서 맵에 첫번째 값 차감
            }

            while(truck_weight + now > weight) //전체 무게보다 클 경우
            {
                sec = map.firstKey();
                now -= map.remove(map.firstKey());
            }

            map.put(sec + bridge_length, truck_weight);
            now += truck_weight;

            sec++;
            System.out.println("시간=" + sec + "초 / 무게=" + now);
        }

        return map.lastKey();
    }

//    public int solution(int bridge_length, int weight, int[] truck_weights) {
//        int max = weight;
//        int sec = 0;
//        int index = 0;
//        for (int i = 0; i < truck_weights.length; i++) {
//            if (max - truck_weights[i] >= 0) {
//                max -= truck_weights[i];
//                sec++;
//            } else{
//                sec += bridge_length;
//                while (max -  truck_weights[i] >  truck_weights[i]){
//                    max += truck_weights[index];
//                    index++;
//                }
//                sec ++;
//            }
//        }
//        return sec;
//    }

}
