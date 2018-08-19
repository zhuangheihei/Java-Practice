/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i<n; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int res=0, endIdx=0;
        for(int i=0; i<n; i++){
            if(start[i]<end[endIdx]){
                res++;
            }else{
                endIdx++;
            }
        }
        return res;
    }
}

/*
[0, 30], [5, 10], [15, 20] 按开始时间sort之后，只要后面的开始时间小于前面的end时间，那么就
需要新的meeting room。换言之，如果前一个的end time比后面的start time小，那么就不需要新的房间。
所以要看的就是，end最早的meeting，前面有几个已经start的meeting。有1个，那么就需要1个meeting room，
有2个start，那么就需要2个meeting room。当一个start大于end时，此时不必用新的meeting room。换言之，
我们不需要关心它们配不配对，只需要关注同时有几个meeting在进行即可。
*/