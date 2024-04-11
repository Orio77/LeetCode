import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Twitter {
    private HashMap<Integer, Set<Integer>> followers;
    private List<int[]> newsFeed;  // int[]{userId, tweetId}

    public Twitter() {
        followers = new HashMap<>();
        newsFeed = new LinkedList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        newsFeed.add(new int[]{userId, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        for (int i = newsFeed.size()-1; i >= 0 && res.size() < 10; i--) {
            int[] tweet = newsFeed.get(i);

            if (tweet[0] == userId || (followers.get(userId) != null && followers.get(userId).contains(tweet[0]))) {
                res.add(tweet[1]);
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followersSet = followers.get(followerId);
        if (followersSet != null) {
            followersSet.remove(followeeId);
        }
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