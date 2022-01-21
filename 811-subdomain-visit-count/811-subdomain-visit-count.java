class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain: cpdomains) {
            String[] sep = cpdomain.split(" ");
            int count = Integer.parseInt(sep[0]);
            String domain = sep[1];
            
            String[] singleDomains = domain.split("\\.");
            // System.out.println(singleDomains.length);
            for (int i = 0; i < singleDomains.length; i++) {
                StringBuilder domainHit = new StringBuilder(); 
                for (int j = i; j < singleDomains.length; j++) {
                    domainHit.append(singleDomains[j]);
                    // append "." at the end if it's not the last sub-domain
                    if (j != singleDomains.length-1) {
                        domainHit.append(".");
                    }
                }
                String domainHitString = domainHit.toString();
                // update it's count
                map.put(domainHitString, map.getOrDefault(domainHitString, 0) + count);
            }
        }
        // System.out.println(map.size());
        
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            String cpRecord = "";
            cpRecord += entry.getValue();
            cpRecord += " ";
            cpRecord += entry.getKey();
            res.add(cpRecord);
        }
        
        return res;
    }
}