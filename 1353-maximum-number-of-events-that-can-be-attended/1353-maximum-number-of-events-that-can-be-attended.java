/*
Greedy
For each day, there are a set of events attendable, and let's think about

Which one shall we attend among attendable events for a day?
Among the open events for a day, the one ends earliest should be attended.

How shall we tell which open event ends earliest?
We may maintain a min heap of open events sorted by end time for each day.

What are attendable events?
For day t, an event (start, end) is attendable if start <= t <= end and not attended yet

To promise start <= t <= end, we can add an event to the min heap when we are at day start; and remove events with end < t at day t.

To achieve not attended yet, we might sort events by start time at the beginning, and loop through sorted events using i, where events before i are either attended or not attendable.

This approach's time complexity is O(nlogn) where n is the number of events.
O(NlogN)
*/
class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);

        int currentDay = 1;
        int totalEventsAttended = 0;
        PriorityQueue<Integer> eventEndDayPQ = new PriorityQueue<Integer>();
        int i = 0;
        
        while (i < n || !eventEndDayPQ.isEmpty()) {
            // if events in pq are done, jump to the day of next event's start in the list
            if (eventEndDayPQ.isEmpty()) {
                currentDay = events[i][0];
            }
            
            // Candidate events for current day
            while (i < n && events[i][0] == currentDay) {
                eventEndDayPQ.add(events[i][1]);
                i++;
            }
            
            // remove and attend the event that's ending earliest
            eventEndDayPQ.poll();
            totalEventsAttended++;
            
            // attended an event today so increment current day
            currentDay++;
            
            // remove all the events that can't be attended anymore, 
            // cos they were ending today
            while (!eventEndDayPQ.isEmpty() && eventEndDayPQ.peek() < currentDay) {
                eventEndDayPQ.poll();
            }
        }
        return totalEventsAttended;
    }
}

// wrong approach
// class Solution {
//     public int maxEvents(int[][] events) {
//         int n = events.length;
//         Arrays.sort(events, (a,b)->a[0]==b[0]?a[0]-b[0]:a[0]-b[0]);

//         int availableDay = 1;
//         int res = 0;
//         for (int[] e: events) {
//             if (e[1] < availableDay) {
//                 continue;
//             }
//             if (e[0] > availableDay) {
//                 availableDay = e[0]+1;
//                 res++;
//             }
//             else {
//                 availableDay++;
//                 res++;
//             }
//         }
//         return res;
//     }
// }