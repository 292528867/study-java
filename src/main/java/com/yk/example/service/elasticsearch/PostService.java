package com.yk.example.service.elasticsearch;

import com.yk.example.entity.elasticsearch.Post;
import com.yk.example.repository.elasticsearch.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

/**
 * Created by yk on 16/3/18.
 */
@Component
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post save(Post post) {
        postRepository.save(post);
        return post;
    }

    public Post findOne(String id) {
        return postRepository.findOne(id);
    }

    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    public Page<Post> findByTagsName(String tagName, PageRequest pageRequest) {
        return postRepository.findByTagsName(tagName, pageRequest);
    }
}
