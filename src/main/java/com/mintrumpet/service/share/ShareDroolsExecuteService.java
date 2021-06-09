package com.mintrumpet.service.share;

import com.mintrumpet.pojo.executeparam.ShareExecuteParam;
import com.mintrumpet.service.AbstractDroolsExecuteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *
 * 具体业务的处理类，这里列举的业务是分享
 *
 * Created by david chow on 2020-08-12.
 * </pre>
 *
 * @author david chow
 **/
@Slf4j
@Service
public class ShareDroolsExecuteService extends AbstractDroolsExecuteService {

    /**
     * 具体处理逻辑
     *
     * @param param
     */
    public void addTag(ShareExecuteParam param) {
        Integer tagTypeSign = param.getTagTypeSign();
        String user = param.getUser();

        log.info("user [{}] add shareTag [{}]", user, tagTypeSign);

        //user匹配某个分享类型，做相关处理
    }
}
