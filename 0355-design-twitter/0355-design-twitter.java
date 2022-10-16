class Tweet {
    int createdBy;
    int tweetId;
    public Tweet(int c, int t) {
        this.createdBy = c;
        this.tweetId = t;
    }
}
class Twitter {
    Queue<Tweet> tweets;
    Map<Integer, Set<Integer>> map;
    
    public Twitter() {
        tweets = new LinkedList<>();
        map = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.offer(new Tweet(userId, tweetId));
        if (!map.containsKey(userId)) map.put(userId, new HashSet<>());
        map.get(userId).add(userId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        for (Tweet tweet: tweets) {
            if (map.get(userId).contains(tweet.createdBy)) res.add(tweet.tweetId);
        }
        Collections.reverse(res);
        List<Integer> d = new LinkedList<>();
        for (int s: res) {
            d.add(s);
            if (d.size()== 10 )break;
        }
        return d;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) map.put(followerId, new HashSet<>());
        map.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        map.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */