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
    public boolean canAttendMeetings(Interval[] intervals) {
        int n = intervals.length;
        if(n==1) return true;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i=0; i<n; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        for(int i = 1; i<n; i++){
            if(start[i]<end[i]){
                return false;
            }
        }
        return true;
    }
}