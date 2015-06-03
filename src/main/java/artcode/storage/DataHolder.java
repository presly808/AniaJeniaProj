package artcode.storage;

import artcode.model.User;

import java.util.Map;
import java.util.TreeMap;


public class DataHolder {

    private Map<Long, User> userMap  = new TreeMap<>();
    private long lastIndex;

    public DataHolder() {
        init();
        lastIndex = userMap.size();
    }

    private void init() {
        userMap.put(1L, new User(1L,"Oleg", "1234", 34));
        userMap.put(2L, new User(2L,"Ivan", "1234", 23));
        userMap.put(3L, new User(3L,"Yura", "1234", 25));
        userMap.put(4L, new User(4L,"Serhii", "1234", 30));
        userMap.put(5L, new User(5L, "Olia", "1234", 20));
    }

    public User add(User user){
        long key = lastIndex + 1;// think about delete
        user.setId(key);
        userMap.put(key, user);
        return user;
    }

    public Map<Long, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Long, User> userMap) {
        this.userMap = userMap;
    }
}
