package com.yk.example.repository.elasticsearch;

import com.yk.example.entity.elasticsearch.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;


/**
 * Created by yk on 16/3/18.
 */
public interface PostRepository extends ElasticsearchCrudRepository<Post,String> {

    Page<Post> findByTagsName(String name, Pageable pageable);
}
