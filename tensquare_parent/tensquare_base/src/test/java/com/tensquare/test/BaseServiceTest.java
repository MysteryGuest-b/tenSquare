package com.tensquare.test;

import com.tensquare.base.BaseApplication;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Irving.Lu
 * @create 2018-12-02 21:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BaseApplication.class)
public class BaseServiceTest {
    @Autowired
    private LabelService labelService;

    @Test
    public void save(){
        Label label = new Label();
        label.setlabelname("JAVA");
        labelService.save(label);
    }

    @Test
    public void findById(){
        System.out.println(labelService.findById("1069228071061663744"));
    }

    @Test
    public void delete(){
        labelService.delete("1069217085894176768");
    }

}
