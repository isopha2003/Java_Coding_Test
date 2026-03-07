import java.util.Vector;
class Friend {
    private String name;
    private int index;
    private int gives[];
    private int score = 0;
    private int receive = 0;
    public Friend(String name, int index, int size) {
        this.name = name;
        this.index = index;
        gives = new int[size];
        for (int i = 0; i < size; i++) {
            gives[i] = 0;
        }
    }
    public String getName() {
        return name;
    }
    public int getIndex() {
        return index;
    }
    public void plusGives(int index) {
        gives[index]++;
    }
    public void minusGives(int index) {
        gives[index]--;
    }
    public int getScore() {
        score = 0;
        for (int i = 0; i < gives.length; i++) {
            score += gives[i];
        }
        return score;
    }
    public int getReceive(Vector<Friend> v) {
        for (int i = 0; i < gives.length; i++) {
            if (i == index) {
                continue;
            }
            if (gives[i] > 0) {
                receive++;
            }
            else if (gives[i] == 0) {
                if(compare(v, i)) {
                    receive++;
                }
            }
        }
        return receive;
    }
    public boolean compare(Vector<Friend> v, int index) {
        score = getScore();
        if (score > v.get(index).getScore()) {
            return true;
        }
        return false;
    }
}
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Vector<Friend> v = new Vector<Friend>();
        // 벡터에 클래스 저장
        for (int i = 0; i < friends.length; i++) {
            v.add(new Friend(friends[i], i, friends.length));
        }
        for (int i = 0; i < gifts.length; i++) {
            String list[] = gifts[i].split(" ");
            int give = findIndex(v, list[0]);
            int receive = findIndex(v, list[1]);
            v.get(give).plusGives(receive);
            v.get(receive).minusGives(give);
        }
        for (int i = 0; i < v.size(); i++) {
            int receive = v.get(i).getReceive(v);
            if (receive > answer) {
                answer = receive;
            }   
        }
        return answer;
    }
    public int findIndex(Vector<Friend> f, String name) {
        for (int i = 0; i < f.size(); i++) {
            if (name.equals(f.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }
}