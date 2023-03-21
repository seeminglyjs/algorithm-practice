package com.algorithm.practice.algorithmpractice.programmers;

import org.junit.jupiter.api.Test;

public class Case_15 {


//    혼자서 하는 틱택토
//    문제 설명
//    틱택토는 두 사람이 하는 게임으로 처음에 3x3의 빈칸으로 이루어진 게임판에 선공이 "O", 후공이 "X"를 번갈아가면서 빈칸에 표시하는 게임입니다. 가로, 세로, 대각선으로 3개가 같은 표시가 만들어지면 같은 표시를 만든 사람이 승리하고 게임이 종료되며 9칸이 모두 차서 더 이상 표시를 할 수 없는 경우에는 무승부로 게임이 종료됩니다.
//
//    할 일이 없어 한가한 머쓱이는 두 사람이 하는 게임인 틱택토를 다음과 같이 혼자서 하려고 합니다.
//
//    혼자서 선공과 후공을 둘 다 맡는다.
//    틱택토 게임을 시작한 후 "O"와 "X"를 혼자서 번갈아 가면서 표시를 하면서 진행한다.
//    틱택토는 단순한 규칙으로 게임이 금방 끝나기에 머쓱이는 한 게임이 종료되면 다시 3x3 빈칸을 그린 뒤 다시 게임을 반복했습니다. 그렇게 틱택토 수 십 판을 했더니 머쓱이는 게임 도중에 다음과 같이 규칙을 어기는 실수를 했을 수도 있습니다.
//
//"O"를 표시할 차례인데 "X"를 표시하거나 반대로 "X"를 표시할 차례인데 "O"를 표시한다.
//    선공이나 후공이 승리해서 게임이 종료되었음에도 그 게임을 진행한다.
//    게임 도중 게임판을 본 어느 순간 머쓱이는 본인이 실수를 했는지 의문이 생겼습니다. 혼자서 틱택토를 했기에 게임하는 과정을 지켜본 사람이 없어 이를 알 수는 없습니다. 그러나 게임판만 봤을 때 실제로 틱택토 규칙을 지켜서 진행했을 때 나올 수 있는 상황인지는 판단할 수 있을 것 같고 문제가 없다면 게임을 이어서 하려고 합니다.
//
//    머쓱이가 혼자서 게임을 진행하다 의문이 생긴 틱택토 게임판의 정보를 담고 있는 문자열 배열 board가 매개변수로 주어질 때, 이 게임판이 규칙을 지켜서 틱택토를 진행했을 때 나올 수 있는 게임 상황이면 1을 아니라면 0을 return 하는 solution 함수를 작성해 주세요.
//
//            제한사항
//    board의 길이 = board[i]의 길이 = 3
//    board의 원소는 모두 "O", "X", "."으로만 이루어져 있습니다.
//            board[i][j]는 i + 1행 j + 1열에 해당하는 칸의 상태를 나타냅니다.
//"."은 빈칸을, "O"와 "X"는 해당 문자로 칸이 표시되어 있다는 의미입니다.
//            입출력 예
//    board	result
//["O.X", ".O.", "..X"]	1
//        ["OOO", "...", "XXX"]	0
//        ["...", ".X.", "..."]	0
//        ["...", "...", "..."]	1
//    입출력 예 설명
//    입출력 예 #1
//
//    예제 1번의 게임판은 다음과 같습니다.
//
//    O.X
//            .O.
//..X
//    선공 후공이 번갈아가면서 다음과 같이 놓았을 때 이러한 게임판이 나올 수 있습니다.
//
//            1행 1열 → 1행 3열 → 2행 2열 → 3행 3열
//1행 1열 → 3행 3열 → 2행 2열 → 1행 3열
//2행 2열 → 1행 3열 → 1행 1열 → 3행 3열
//2행 2열 → 3행 3열 → 1행 1열 → 1행 3열
//    물론 위와 다르게 머쓱이가 2행 2열에 O, 3행 3열에 X, 1행 3열에 X, 1행 1열에 O 순서로 표시를 해서 실수를 했을 가능성도 있지만 "실수를 했을 가능성이 있는가"를 묻는 게 아닌 "이 게임판이 규칙을 지켜서 진행한 틱택토에서 나올 수 있는 상황인가"를 묻는 문제라는 것에 유의해주세요. 따라서 1을 return 합니다.
//
//    입출력 예 #2
//
//    예제 2번의 게임판은 다음과 같습니다.
//
//    OOO
//...
//    XXX
//    규칙을 지켜서 진행한 틱택토라면 선공과 후공이 번갈아가면서 각각 1행, 3행 중 두 칸씩에 표시를 한 뒤 5번째 차례에 선공이 1행에 가로로 3개의 O를 완성했을 때 종료되므로 적어도 머쓱이가 게임이 종료된 후에도 계속 진행하는 실수를 했다는 것을 추론해 볼 수 있고, 정상적인 틱택토에서는 이러한 상황이 나올 수 없습니다. 따라서 0을 return 합니다.
//
//    입출력 예 #3
//
//    예제 3번은 2행 2열에만 X가 표시가 되어있습니다. 선공 O 표시가 없이 X만 있으므로 머쓱이가 O를 표시해야 할 때 X를 표시하는 실수를 했다는 것을 추론해 볼 수 있고, 규칙을 지켜서 진행했을 때는 이러한 상황이 나올 수 없습니다. 따라서 0을 return 합니다.
//    입출력 예 #4
//
//    예제 4번은 빈 3x3 게임판입니다. 선공이 아직 빈칸에 표시하기 전에 이러한 상황이 나올 수 있습니다. 따라서 1을 return 합니다.
//

    @Test
    public void test() {
        String[] board = {"OOO", "OXX", "OXX"};
        System.out.println(solution(board));
    }

    public int solution(String[] board) {
        int answer = 1;
        int oCount = 0;
        int xCount = 0;

        //0,0 | 1,1 | 2,2
        //0,2 | 1,1 | 2,0

        String[][] realBoard = new String[3][3];
        for (int i = 0; i < board.length; i++) { //전체 카운트 체크
            String[] row = board[i].split("");
            for (int j = 0; j < row.length; j++) {
                if (row[j].equals("O")) oCount++;
                if (row[j].equals("X")) xCount++;
                realBoard[i][j] = row[j];
            }
        }
        if (oCount - xCount >= 2) return 0;
        if (oCount == 0 && xCount == 0) return 1;
        if (xCount > oCount) return 0;

        String temp = realBoard[0][0] + realBoard[1][1] + realBoard[2][2];
        if(getInteger(oCount, xCount, temp) == 0) return 0;

        temp = realBoard[0][2] + realBoard[1][1] + realBoard[2][0];
        if(getInteger(oCount, xCount, temp) == 0) return 0;

        temp = realBoard[0][0] + realBoard[0][1] + realBoard[0][2];
        if(getInteger(oCount, xCount, temp) == 0) return 0;

        temp = realBoard[1][0] + realBoard[1][1] + realBoard[1][2];
        if(getInteger(oCount, xCount, temp) == 0) return 0;

        temp = realBoard[2][0] + realBoard[2][1] + realBoard[2][2];
        if(getInteger(oCount, xCount, temp) == 0) return 0;

        temp = realBoard[0][0] + realBoard[1][0] + realBoard[2][0];
        if(getInteger(oCount, xCount, temp) == 0) return 0;

        temp = realBoard[0][1] + realBoard[1][1] + realBoard[2][1];
        if(getInteger(oCount, xCount, temp) == 0) return 0;

        temp = realBoard[0][2] + realBoard[1][2] + realBoard[2][2];
        if(getInteger(oCount, xCount, temp) == 0) return 0;

        return answer;
    }

    private static int getInteger(int oCount, int xCount, String temp) {
        if (temp.equals("OOO")) {
            if (oCount != xCount+1) {
                return 0;
            }
        } else if (temp.equals("XXX")) {
            if (oCount != xCount) {
                return 0;
            }
        }
        return 1;
    }
}
