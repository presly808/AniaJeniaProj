package artcode.service;

import artcode.dao.PostDao;
import artcode.model.Post;

import java.util.List;

/**
 * Created by serhii on 05.06.15.
 */
public class PostServiceImpl implements PostService {

    private PostDao postDao;

    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<Post> getUserPosts(long id) {
        return postDao.getUserPosts(id);
    }
}
