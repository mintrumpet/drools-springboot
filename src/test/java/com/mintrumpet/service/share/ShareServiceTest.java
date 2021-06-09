package com.mintrumpet.service.share;

import com.mintrumpet.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <pre>
 *
 *
 * Created by david chow on 6/9/21.
 * </pre>
 *
 * @author david chow
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ShareServiceTest {

    @Autowired
    private ShareService shareService;

    @Test
    public void dealWithShareAction() {
        for (int i = 0; i < 20; i++) {
            shareService.dealWithShareAction("david");
        }

    }
}