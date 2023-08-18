package com.algorithm.practice.algorithmpractice.programmers.Case_ver2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SpringBootTest
public class a20230819_신고_결과_받기 {

    @Test
    public void test(){
        String [] id_list = {"muzi", "frodo", "apeach", "neo"};
        String [] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        TestUtil.printArr(solution(id_list,report,k));
    }

    public Integer[] solution(String[] id_list, String[] report, int k) {
        Integer[] answer = new Integer [id_list.length];

        Map<String,Integer> countMap = new HashMap<String,Integer>();
        Map<String, Set<String>> userReportMap = new HashMap<String,Set<String>>();
        Set<String> stoppedUser = new HashSet<String>();
        for(String id : id_list) userReportMap.put(id, new HashSet<>()); //유저 정보 최초 셋팅

        for(int i = 0; i < report.length; i++){
            String user = report[i].split(" ")[0]; //신고한 유저
            String reportedUser = report[i].split(" ")[1]; //신고된 유저
            boolean duplicated = false; //중복 신고 체크

            //유저 아이디 객체 저장
            if(userReportMap.containsKey(user)) {
                Set<String> userReportsUserSet = userReportMap.get(user);
                if(!userReportsUserSet.contains(reportedUser)) {
                    userReportsUserSet.add(reportedUser);
                    userReportMap.put(user, userReportsUserSet);
                }else{//중복신고일 경우
                    duplicated = true;
                }
            }

            if(!duplicated) {
                //유저 신고 횟수 저장
                if(countMap.containsKey(reportedUser)) countMap.put(reportedUser, countMap.get(reportedUser) + 1);
                else countMap.put(reportedUser, 1);
                if(countMap.get(reportedUser) >= k){
                    stoppedUser.add(reportedUser);
                }
            }
        }

        for(int i = 0; i < id_list.length; i++){
            int sendCount = 0; //발송 메일 수
            Set<String> sendCheckMap = userReportMap.get(id_list[i]); //유저가 신고한 유저 정보 확인 객체
            if(sendCheckMap.size() > 0){
                for (String id : sendCheckMap){ //유저가 신고한 유저가 정지가 되었을 경우를 체크
                    if(stoppedUser.contains(id)){
                        sendCount+=1;
                    }
                }
            }
            answer[i] = sendCount; //발송 수를 담아 넣는다.
        }

        return answer;
    }
}
