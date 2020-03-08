package org.tjh.MyBatisPlus.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :     CDHONG.IT
 * @description :
 * @date :    2020/2/27 09:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVo {
    private int code;
    private long count;
    private String msg;
    private Object data;

    public static ResponseVo page(long count,Object data){
        return new ResponseVo(200,count,null,data);
    }


}
