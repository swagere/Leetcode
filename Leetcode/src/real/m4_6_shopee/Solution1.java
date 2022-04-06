package real.m4_6_shopee;
import java.util.*;


 
public class Solution1 {
	
	public static void main(String[] args) {
		System.out.println(new Solution1().GetMinCalculateCount(1,2,4,6));
	}
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * 将 sourceX, sourceY 转换成 targetX, targetY 最少需要多少次计算
     * @param sourceX long长整型  x初始值
     * @param sourceY long长整型  y初始值
     * @param targetX long长整型  x目标值
     * @param targetY long长整型  y目标值
     * @return long长整型
     */
    public long GetMinCalculateCount(long sourceX, long sourceY, long targetX, long targetY) {
    	//bfs
    	Queue<long[]> queue = new LinkedList<>();
    	queue.add(new long[] {sourceX + 1, sourceY + 1});
    	queue.add(new long[] {sourceX * 2, sourceY * 2});
    	int times = 1;
    	
    	if (queue.size() > 0) {
    		Queue<long[]> next = new LinkedList<>();
    		while (queue.size() > 0) {
    			long[] cur = queue.poll();
    			if (cur[0] == targetX && cur[1] == targetY) {
    				return times;
    			}
    			//优化
    			if (cur[0] * 2 <= targetX) {
    				next.add(new long[] {cur[0] * 2, cur[1] * 2});
    			}
    			else {
    				next.add(new long[] {cur[0] + 1, cur[1] + 1});
    			}
    		}
    		times += 1;
    		queue = next;
    	}
    	return times;
    }
    
    //dfs
    int min = Integer.MAX_VALUE;
    public boolean getWay(long sourceX, long sourceY, long targetX, long targetY, int times) {
    	if (sourceX == targetX && sourceY == targetY) {
    		min = Math.min(min, times);
    		return true;
    	}
    	
    	boolean res = false;
    	if (targetX / sourceX >= 2) {
    		res = getWay(sourceX * 2, sourceY * 2, targetX, targetY, times + 1);
    	}
    	if (!res) res = getWay(sourceX + 1, sourceY + 1, targetX, targetY, times + 1);
    	return res;
    }
}
