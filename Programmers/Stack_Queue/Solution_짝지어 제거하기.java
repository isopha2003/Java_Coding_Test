class Solution
{
    public int solution(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        boolean isContinuous = false;
        while(true) {
            isContinuous = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    isContinuous = true;
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                }
            }
            if (sb.length() == 0) {
                return 1;
            }
            if (isContinuous == false) {
                return 0;
            }
        }
    }
}