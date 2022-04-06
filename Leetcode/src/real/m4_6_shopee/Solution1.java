package real.m4_6_shopee;
import java.util.*;


 
public class Solution1 {
	
	public static void main(String[] args) {
		System.out.println(new Solution1().GetMinCalculateCount(1,2,4,6));
	}
    /**
     * Note: ���������������������Ѿ�ָ���������޸�
     *
     *
     * �� sourceX, sourceY ת���� targetX, targetY ������Ҫ���ٴμ���
     * @param sourceX long������  x��ʼֵ
     * @param sourceY long������  y��ʼֵ
     * @param targetX long������  xĿ��ֵ
     * @param targetY long������  yĿ��ֵ
     * @return long������
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
    			//�Ż�
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
