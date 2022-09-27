class Solution {
    public String pushDominoes(String dominoes) {
        char[] ch = dominoes.toCharArray();
        int len = ch.length;
        int[] time = new int[len];


        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < len; i ++){
            if(ch[i] == '.')
                continue;
            int dir = (ch[i] == 'L') ? -1 : 1;
            queue.offer(new int[]{i, dir, 1});
            time[i] = 1;
        }

        while(! queue.isEmpty()){
            int[] info = queue.poll();
            int pos = info[0];
            int dir = info[1];
            int hour = info[2];

            int npos = pos + dir;
            if(npos < 0 || npos > len - 1)
               continue;

            if(time[npos] == 0){
                time[npos] = hour + 1;
                ch[npos] = ((dir == -1) ? 'L' : 'R');
                queue.offer(new int[]{npos, dir, hour + 1});
            }else if(time[npos] == hour + 1){
                ch[npos] = '.';
            }
            
        }

        return String.valueOf(ch);
    }
}