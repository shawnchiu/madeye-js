package cn.rejoicy.madeyecore;

import cn.rejoicy.madeyejs.core.CoreApplication;
import cn.rejoicy.madeyejs.core.application.business.BusinessManager;
import cn.rejoicy.madeyejs.core.application.log.LogManager;
import cn.rejoicy.madeyejs.core.domain.log.enums.LogLevelEnum;
import cn.rejoicy.madeyejs.core.viewmodel.BusinessDTO;
import cn.rejoicy.madeyejs.core.viewmodel.LogDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class)
@EnableAsync
public class LogApplication {

    @Autowired
    private LogManager logManager;

    @Test
    public void create() throws Exception {
        LogDTO logDTO = new LogDTO();
        logDTO.setLevel(LogLevelEnum.INFO);
        logDTO.setUrl("url");
        logDTO.setMessage("url");
        logDTO.setPage("url");
        logDTO.setEnv("url");
        logDTO.setApiToken("3ed5c75ca0dd4f95b67e5ae2faa019bc");
        logDTO.setHostName("url");
        int i = 0;
        while(i < 1000000){
            logManager.create(logDTO);
            i++;
            System.err.println(i);
        }
    }


}
