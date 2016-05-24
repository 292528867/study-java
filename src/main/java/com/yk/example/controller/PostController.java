package com.yk.example.controller;

import com.yk.example.entity.elasticsearch.Post;
import com.yk.example.entity.elasticsearch.Tag;
import com.yk.example.service.elasticsearch.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by yk on 16/5/10.
 */
@RestController
@RequestMapping("elasticsearch")
public class PostController  {

    @Autowired
    private PostService postService;


    /**
     *  保存到elasticsearch
     * @return
     */
    @RequestMapping(value = "savePost",method = RequestMethod.POST)
    public Object savePost() {
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
       return   postService.save(post);
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping(value = "queryByTagName",method = RequestMethod.GET)
    public Object queryByTagName(String tagName) {
       return postService.findByTagsName(tagName, new PageRequest(0, 10));
    }

        @RequestMapping(value = "queryById/{id}",method = RequestMethod.GET)
    public Object queryById(@PathVariable long id) {
        return postService.findOne(String.valueOf(id));
    }
}
