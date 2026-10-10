class Twitter {
    int timestamp = 0;
    HashMap<Integer, Set<Integer>> following = new HashMap<>();
    HashMap<Integer, List<int[]>> tweets = new HashMap<>();

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{timestamp++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        // add user's own tweets
        if(tweets.containsKey(userId))
            heap.addAll(tweets.get(userId));

        // add followed users' tweets
        if(following.containsKey(userId)){
            for(int followee : following.get(userId)){
                if(tweets.containsKey(followee))
                    heap.addAll(tweets.get(followee));
            }
        }

        List<Integer> feed = new ArrayList<>();
        int count = 0;
        while(!heap.isEmpty() && count < 10){
            feed.add(heap.poll()[1]);
            count++;
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId))
            following.get(followerId).remove(followeeId);
    }
}

