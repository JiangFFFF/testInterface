package com.jiang.testinterface.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiang
 * @create 2022-01-30-5:10 下午
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HeduException extends RuntimeException{
//    static final long serialVersionUID = -7034897190745762139L;

    private Integer code; //状态码

    private String msg; //异常信息
}
