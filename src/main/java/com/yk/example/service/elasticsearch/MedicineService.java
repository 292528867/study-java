package com.yk.example.service.elasticsearch;

import com.yk.example.entity.elasticsearch.Medicine;
import com.yk.example.repository.elasticsearch.MedicineRepository;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yk on 16/5/16.
 */
@Component
public class MedicineService {


    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private Client client;

    public void testAnalyzeResponse(String text) {
        AnalyzeResponse analyzeResponse = client.admin().indices().prepareAnalyze(text)
                .setAnalyzer("ik").execute().actionGet();
        System.out.println(analyzeResponse.getTokens().size());
        List<AnalyzeResponse.AnalyzeToken> list = analyzeResponse.getTokens();
        for (AnalyzeResponse.AnalyzeToken token : list) {
            System.out.println(token.getTerm());
        }
    }

    public  void testAnalyzeRequestBuilder(String text){
        AnalyzeRequestBuilder builder = client.admin().indices().prepareAnalyze("medicine", text);
        builder.setField("name");
        AnalyzeResponse analyzeTokens = builder.setAnalyzer("pinyin_analyzer").execute().actionGet();
        List<AnalyzeResponse.AnalyzeToken> tokens = analyzeTokens.getTokens();
        for (AnalyzeResponse.AnalyzeToken token : tokens) {
            System.out.println(token.getTerm());
        }
    }

    public void queryAllByName(String name) {
        SearchResponse searchResponse = client.prepareSearch("medicine").setTypes("folks")
                .setSearchType(SearchType.DEFAULT)
                .setQuery(QueryBuilders.termQuery("name",name))
                .execute().actionGet();

        SearchHit[] hits = searchResponse.getHits().getHits();
        for (SearchHit hit : hits) {
            String s = hit.getSource().get("name").toString();
            System.out.println(s);
        }
    }


    public List<Medicine> queryByName(String name) {
       return   medicineRepository.findByName(name);
    }
}
