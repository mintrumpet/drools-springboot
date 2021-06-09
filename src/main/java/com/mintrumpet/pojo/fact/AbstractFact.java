package com.mintrumpet.pojo.fact;

import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 *
 * 抽象的fact类
 *
 * Created by david chow on 2020-08-11.
 * </pre>
 *
 * @author david chow
 **/
@Data
public class AbstractFact implements Serializable {

    private static final long serialVersionUID = 1L;

    private String user;
}
