class Solution {
    public int countDays(int days, int[][] meetings) {
         List<int[]> events = new ArrayList<>();

        // Convert meetings into events
        for (int[] meeting : meetings) {
            events.add(new int[]{meeting[0], 1});  
            events.add(new int[]{meeting[1] + 1, -1}); 
        }

    
        events.sort((a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        
        int occupiedDays = 0, ongoing = 0, prevDay = 1;
        for (int[] event : events) {
            int currDay = event[0];

            
            if (ongoing == 0) {
                occupiedDays += (currDay - prevDay);
            }

            ongoing += event[1];
            prevDay = currDay;
        }

        if (prevDay <= days) {
            occupiedDays += (days - prevDay + 1);
        }

        return occupiedDays;
    }

}