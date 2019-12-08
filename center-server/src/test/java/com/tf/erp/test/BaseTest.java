package com.tf.erp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;


/**
 * Created with IntelliJ IDEA.
 * description:
 *
 * @author: kongxiangke
 * Date: 18/5/26
 * Time: 16:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class BaseTest {


    @Before
    public void setup() {
        
    }
}
