package artcode.dao;

import artcode.model.Post;

import java.util.List;

/**
 * Created by serhii on 05.06.15.
 */
public interface PostDao {

    List<Post> getUserPosts(long id);


}
