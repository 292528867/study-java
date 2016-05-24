package com.yk.example.service.elasticsearch;

import com.yk.example.ApplicationTest;
import com.yk.example.entity.elasticsearch.Medicine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yk on 16/5/16.
 */
public class MedicineServiceTest extends ApplicationTest{

    @Autowired
    private MedicineService medicineService;

    @Test
    public void testIk() throws Exception {
        String text = "李克强说，中巴是全天候战略合作伙伴。我今年5月访巴时，总理先生作为候任总理热情参与接待";
//        medicineService.testIk(text);
    }

    @Test
    public void testAnalyzeRequestBuilder() throws Exception {
        String text = "阿莫西林";
        medicineService.testAnalyzeRequestBuilder(text);
    }

    @Test
    public void queryAllByName() throws Exception {
       medicineService.queryAllByName("阿托伐他汀钙片（立普妥）");
    }


    @Test
    public void queryByName() throws Exception {
        List<Medicine> medicineList = medicineService.queryByName("阿");
        for (Medicine medicine : medicineList) {
            System.out.println(medicine.getName());
        }
    }
}