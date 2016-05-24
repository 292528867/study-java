package com.yk.example.controller;

import com.yk.example.entity.elasticsearch.Medicine;
import com.yk.example.repository.elasticsearch.MedicineRepository;
import org.apache.lucene.search.highlight.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

/**
 * Created by yk on 16/5/12.
 */
@RestController
@RequestMapping("medicine")
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Object save() {
        Medicine medicine = new Medicine();
        medicine.setCompany("成都地奥制药");
        medicine.setName("贝那普利片（洛汀新）");
        medicine.setDosageForm("片剂");
        medicine.setDoseSpecification("10mg*10片/盒");
        return medicineRepository.save(medicine);
    }

    @RequestMapping(value = "queryByName", method = RequestMethod.GET)
    public Object queryByName(String name) {
        return medicineRepository.findByName(URLEncoder.encode(name));
    }
}
