package com.mintrumpet.pojo.fact;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <pre>
 *
 * 业务相关的fact，这里列举的是分享这个业务
 *
 * Created by david chow on 2020-08-12.
 * </pre>
 *
 * @author david chow
 **/
@Data
@Accessors(chain = true)
public class ShareFact extends AbstractFact {

    /**
     * 分享次数总和
     */
    private Integer shareCount;
}
