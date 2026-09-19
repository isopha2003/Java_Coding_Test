class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = 0; // 연속으로 공격 성공한 시간
        int healthLimit = health;
        int tLimit = bandage[0]; // 최대 공격 시간
        int healPerSec = bandage[1]; // 초당 회복 시간
        int additionalHeal = bandage[2]; // 추가 회복 시간
        boolean isAttacked = false; // 공격 여부 판단
        for (int sec = 1; sec <= attacks[attacks.length - 1][0]; sec++) { // 공격 최대 시간 만큼 반복
            isAttacked = false;    
            for (int i = 0; i < attacks.length; i++) {
                if (sec == attacks[i][0]) {
                    isAttacked = true; // 공격받음 표시
                    t = 0; // 연속 공격 횟수 초기화
                    health -= attacks[i][1]; // 공격만큼 현재 체력 하락
                    if (health <= 0) { // 체력이 0 이하로 떨어졌을 때
                        return -1; // 현재 체력 반환
                    }
                    break;
                }
            }
            if (isAttacked == false) { // 공격 받지 않았을 때
                t++; // 연속 공격 성공 횟수 증가
                if (t >= tLimit) { // 연속 공격 횟수가 최대치일 때
                    t = 0; // 연속 공격 횟수 초기화
                    health += additionalHeal; // 추가 체력만큼 체력 회복
                }
                health += healPerSec; // 체력 회복
                if (health > healthLimit) { // 최대 체력을 초과할 때
                    health = healthLimit; // 최대 체력과 같게 조정
                }
            }
        }       
        return health;
    }
}