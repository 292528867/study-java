package com.yk.example.entity.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by yk on 16/5/12.
 */
@Document(indexName = "medicine", type = "folks", shards = 1, replicas = 0)
public class Medicine {
    @Id
    private String id;

    private String name;

    private String company;

    private String dosageForm;

    private String doseSpecification;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getDoseSpecification() {
        return doseSpecification;
    }

    public void setDoseSpecification(String doseSpecification) {
        this.doseSpecification = doseSpecification;
    }
}
