package cn.rejoicy.madeyecore;

import cn.rejoicy.madeyejs.core.CoreApplication;
import cn.rejoicy.madeyejs.core.application.business.BusinessManager;
import cn.rejoicy.madeyejs.core.viewmodel.BusinessDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
public class BusinessApplication {

    @Autowired
    private BusinessManager businessManager;

    @Test
    public void addBusiness() throws Exception {
        BusinessDTO business = new BusinessDTO();
        business.setBusinessName("微信会员");
        businessManager.add(business);
    }



}
