// wrong approach
class Solution {
    public List<Integer> majorityElement(int[] a) {
        int n = a.length;
        List<Integer> res = new LinkedList<>();
        
        int king1 = a[0];
        int king1Power = 0;
        
        int king2 = a[0];
        int king2Power = 0;
        
        // if current is same as king1 increase it's power
        // else if current is same as king2 increase it's power
        // else if there is an empty throne (power = 0), new king
        // else means it's not an existing king and 
        // both throne are occupied, so damage (reduce power) of both kings
        
        for (int current: a) {
            if (current == king1) king1Power++;
            else if (current == king2) king2Power++;
            else if (king1Power == 0) {
                king1 = current;
                king1Power = 1;
            }
            else if (king2Power == 0) {
                king2 = current;
                king2Power = 1;
            }
            else {
                king1Power--; king2Power--;
            }
        }
        
        // finally we have 2 potential kings 
        // check if they have more than n/3 occurance 
        // and add to res if so
        int firstCount = 0;
        int secondCount = 0;
        for (int num: a) {
            if (num == king1) firstCount++;
            if (num == king2) secondCount++;
        }
        
        if (firstCount > (n/3)) res.add(king1);
        if (king2 != king1 && secondCount > (n/3)) res.add(king2);
        
        return res;
    }
}


// // wrong approach
// class Solution {
//     public List<Integer> majorityElement(int[] a) {
//         int n = a.length;
//         List<Integer> res = new LinkedList<>();
        
//         if (n == 1) {
//             res.add(a[0]); return res;
//         }
//         if (n == 2) {
//             res.add(a[0]); 
//             if (a[0] != a[1]) res.add(a[1]); 
//             return res;
//         }
        
//         int first = -123121;
//         int firstPower = 0;
        
//         int second = -123121;
//         int secondPower = 0;
    
//         for (int current: a) {
//             // if the thrones are occupied
//             // if current is the king of either of the thrones, 
//             // let it add to it's own power and damage the other king
//             if (current == first) {
//                 firstPower++;
//                 if (secondPower != 0) secondPower--;
//             }
//             else if (current == second) {
//                 secondPower++;
//                 if (firstPower != 0) firstPower--;
//             }
//             else {
//                 // if it can take an empty throne, let it take it 
//                 if (firstPower == 0 || secondPower == 0) {
//                     // let it take the throne which is empty (power = 0)
//                     // and do the damange on the other throne if it's not empty
//                     if (firstPower == 0) {
//                         first = current;
//                         firstPower = 1;
//                         // do damange on other 
//                         if (secondPower != 0) secondPower--;
//                     }
//                     else {
//                         // means secondPower == 0
//                         second = current;
//                         secondPower = 1;
//                         // do damange on other king
//                         if (firstPower != 0) firstPower--;
//                     }
//                 }
//                 else {
//                     // this means current is the not the king of first or second
//                     // its a third party. so it will damage both existing kings
//                     if (firstPower != 0)firstPower--;
//                     if (secondPower != 0)secondPower--;
//                 }
//             }
//         }
        
//         // finally we have 2 potential kings 
//         // check if they have more than n/3 occurance 
//         // and add to res if so
//         int firstCount = 0;
//         int secondCount = 0;
//         for (int num: a) {
//             if (num == first) firstCount++;
//             if (num == second) secondCount++;
//         }
        
//         if (firstCount > (n/3)) res.add(first);
//         if (secondCount > (n/3)) res.add(second);
        
//         return res;
//     }
// }