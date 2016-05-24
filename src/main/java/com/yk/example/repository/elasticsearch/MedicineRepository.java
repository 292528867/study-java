package com.yk.example.repository.elasticsearch;

import com.yk.example.entity.elasticsearch.Medicine;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

/**
 * Created by yk on 16/5/12.
 */
public interface MedicineRepository extends ElasticsearchCrudRepository<Medicine, String> {

    List<Medicine> findByName(String name);
}
