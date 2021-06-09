package com.mintrumpet.pojo.executeparam;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <pre>
 *
 * 抽象的执行参数结构
 *
 * Created by david chow on 2020-08-11.
 * </pre>
 *
 * @author david chow
 **/
@Data
public class AbstractExecuteParam implements Serializable {

    private static final long serialVersionUID = 1L;

    private String user;

    private LocalDateTime executeTime;
}
