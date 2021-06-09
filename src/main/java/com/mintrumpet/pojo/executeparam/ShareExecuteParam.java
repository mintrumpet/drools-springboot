package com.mintrumpet.pojo.executeparam;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <pre>
 *
 *
 * Created by david chow on 2020-08-12.
 * </pre>
 *
 * @author david chow
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ShareExecuteParam extends AbstractExecuteParam {

    /**
     * 传递的分享次数
     */
    private Integer shareCount;

    /**
     * tag类型，使用权重表示，例如低分享为0，中度分享为1
     */
    private Integer tagTypeSign;
}
