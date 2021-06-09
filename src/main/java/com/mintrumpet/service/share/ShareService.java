package com.mintrumpet.service.share;

import com.mintrumpet.constants.BehaviorSignConstant;
import com.mintrumpet.pojo.fact.ShareFact;
import lombok.extern.slf4j.Slf4j;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *
 *
 * Created by david chow on 2020-08-12.
 * </pre>
 *
 * @author david chow
 **/
@Slf4j
@Service
public class ShareService {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private ShareDroolsExecuteService shareDroolsExecuteService;

    /**
     * 示范上的参数，实际需要根据情况做持久化
     */
    private static Integer shareCount = 0;

    /**
     * 处理分享事件
     * 将递增的分享次数作为fact，传入到事件处理逻辑中
     *
     * @param user
     */
    public void dealWithShareAction(String user) {

        //e.g. 处理具体的业务
        log.info("user is [{}] start share action", user);
        shareCount = shareCount + 1;
        log.info("shareCount is [{}]", shareCount);

        //
        ShareFact shareFact = new ShareFact();
        shareFact.setUser(user);
        shareFact.setShareCount(shareCount);

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("shareDroolsExecuteService", shareDroolsExecuteService);
        kieSession.insert(shareFact);
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter(BehaviorSignConstant.SHARE_PREFIX));
        kieSession.dispose();
    }
}
