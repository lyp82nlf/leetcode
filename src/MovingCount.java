import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MovingCount {
    public static void main(String[] args) {
        int i = new MovingCount().movingCount(3, 2, 17);
        System.out.println(i);
    }


    /*
    地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
    它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
    例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
    请问该机器人能够到达多少个格子？
    示例 1：
    输入：m = 2, n = 3, k = 1
    输出：3
    */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int res = 0;
        while (queue.size() > 0) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int x2 = poll[1];
            if (x1 < m && x2 < n && isSmallerThanNumber(x1, x2, k) && !visited[x1][x2]) {
                res++;
                queue.add(new int[]{x1 + 1, x2});
                queue.add(new int[]{x1, x2 + 1});
                visited[x1][x2] = true;
            }
        }
        return res;
    }

    public boolean isSmallerThanNumber(int m, int n, int k) {
        int result = 0;
        while (m != 0 || n != 0) {
            result += m % 10;
            m /= 10;
            result += n % 10;
            n /= 10;
        }
        return result <= k;
    }


}
