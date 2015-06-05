package artcode.service;

import artcode.model.Post;

import java.util.List;

/**
 * Created by serhii on 05.06.15.
 */
public interface PostService {

    List<Post> getUserPosts(long id);

}
