import java.util.Vector;

class Solution {
    public int solution(int[] cards) {
        Vector<Integer> answers = new Vector<Integer>();
        Vector<Integer> selectedIndex = new Vector<Integer>();
        Vector<Integer> selectedIndex2 = new Vector<Integer>();
        
        int answer = 0;
        int index = 0;
        int count1 = 1;
        int count2 = 1;
        
        boolean fin = false;
        
        for (index = 0; index < cards.length; index++) {
            count1 = 1;
            fin = false;
            selectedIndex.clear();
            // 1번 상자 그룹 개수
            while (true) {
                selectedIndex.add(index); // 선택된 인덱스 저장
                index = cards[index] - 1; // 인덱스를 카드 번호로 저장
                for (int i = 0; i < selectedIndex.size(); i++) {
                    if (index == selectedIndex.get(i)) {
                        fin = true;
                        break;
                    }
                }
                if (fin) {
                    break;
                }
                count1++;
            }
            // 1번 상자 그룹 개수 끝
            
            // 1번 상자에서 모두 가져갔다면 곱은 0
            if (selectedIndex.size() == cards.length) {
                answers.add(0);
                continue;
            }
            // 2번 상자 그룹 개수
            for (int index2 = 0; index2 < cards.length; index2++) {
                count2 = 1;
                fin = true;
                selectedIndex2.clear();
                selectedIndex2.addAll(selectedIndex);
                
                for (int j = 0; j < selectedIndex.size(); j++) {
                    if (index2 == selectedIndex.get(j)) {
                        fin = false;
                        break;
                    }
                }
                // 1번 상자에 속하지 않는 인덱스라면 선택
                if (fin) {
                    fin = false;
                    while (true) {
                        selectedIndex2.add(index2); // 선택된 인덱스 저장
                        index2 = cards[index2] - 1; // 인덱스를 카드 번호로 저장
                        for (int i = 0; i < selectedIndex2.size(); i++) {
                            if (index2 == selectedIndex2.get(i)) {
                                fin = true;
                                break;
                            }
                        }
                        if (fin) {
                            break;
                        }
                        count2++;
                    }
                    answers.add(count1 * count2);
                }
            }
        }
        
        // 최고 점수 구하기
        answer = answers.get(0);
        for (int i = 1; i < answers.size(); i++) {
            if (answer < answers.get(i)) {
                answer = answers.get(i);
            }
        }
        return answer;
    }
}