package com.yk.example.service.elasticsearch;

import com.yk.example.ApplicationTest;
import com.yk.example.entity.elasticsearch.Post;
import com.yk.example.entity.elasticsearch.Tag;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PostServiceTest extends ApplicationTest {

    @Autowired
    private PostService postService;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void testSave() throws Exception {
        Tag tag = new Tag();
        tag.setId("1");
        tag.setName("tech");
        Tag tag2 = new Tag();
        tag2.setId("2");
        tag2.setName("elasticsearch");

        Post post = new Post();
        post.setId("1");
        post.setTitle("Bigining with spring boot application and elasticsearch");
        post.setTags(Arrays.asList(tag, tag2));
        postService.save(post);

        System.out.println(post.getId());

        Post post2 = new Post();
        post2.setId("1");
        post2.setTitle("Bigining with spring boot application");
        post2.setTags(Arrays.asList(tag));
        postService.save(post);
        System.out.println(post2.getId());
    }

    @Test
    public void testFindOne() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testFindByTagsName() throws Exception {
        Tag tag = new Tag();
        tag.setId("1");
        tag.setName("tech");
        Tag tag2 = new Tag();
        tag2.setId("2");
        tag2.setName("elasticsearch");

        Post post = new Post();
        post.setId("1");
        post.setTitle("Bigining with spring boot application and elasticsearch");
        post.setTags(Arrays.asList(tag, tag2));
        postService.save(post);



        Post post2 = new Post();
        post2.setId("1");
        post2.setTitle("Bigining with spring boot application");
        post2.setTags(Arrays.asList(tag));
        postService.save(post);

        Page<Post> posts  = postService.findByTagsName("tech", new PageRequest(0,10));
        Page<Post> posts2  = postService.findByTagsName("tech", new PageRequest(0,10));
        Page<Post> posts3  = postService.findByTagsName("maz", new PageRequest(0,10));
        System.out.println(posts.getTotalElements());
        System.out.println(posts2.getTotalElements());
        System.out.println(posts3.getTotalElements());

    }
}