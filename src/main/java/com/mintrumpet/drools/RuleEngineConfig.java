package com.mintrumpet.drools;

import lombok.extern.slf4j.Slf4j;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.spring.KModuleBeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * <pre>
 *
 *
 * Created by david chow on 2020-08-09.
 * </pre>
 *
 * @author david chow
 **/
@Slf4j
@Configuration
public class RuleEngineConfig {

    //规则文件放置于classpath上的droolRule目录上
    private static final String RULES_PATH = "droolRule/";
    //KieServices单例，提供跟kie相关的服务
    private final KieServices kieServices = KieServices.Factory.get();

    /**
     * FileSystem，管理kie规则资源
     *
     * WARN：规则通过前缀查找相应规则
     *
     * @return
     */
    @Bean
    public KieFileSystem kieFileSystem() {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        try {
            ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
            Resource[] files = resourcePatternResolver.getResources("classpath*:" + RULES_PATH + "*.*");
            String path;
            //遍历资源，将文件写入到fileSystem上
            for (Resource file : files) {
                path = RULES_PATH + file.getFilename();
                kieFileSystem.write(ResourceFactory.newClassPathResource(path, "UTF-8"));
            }
        } catch (IOException e) {
            log.error("error", e);
        }

        return kieFileSystem;
    }

    /**
     * 给定keiModule的kieBases的容器
     *
     * @return
     */
    @Bean
    public KieContainer kieContainer() {
        KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(kieRepository::getDefaultReleaseId);

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem());
        kieBuilder.buildAll();

        return kieServices.newKieContainer(kieRepository.getDefaultReleaseId());
    }

    /**
     * 存储所有kie使用到的内容的对象
     *
     * @return
     */
    @Bean
    public KieBase kieBase() {
        return kieContainer().getKieBase();
    }

    /**
     * 有状态会话
     *
     * @return
     */
    @Bean
    public KieSession kieSession() {
        return kieContainer().newKieSession();
    }

    /**
     *
     *
     * @return
     */
    @Bean
    public static KModuleBeanFactoryPostProcessor kiePostProcessor() {
        return new KModuleBeanFactoryPostProcessor();
    }
}
