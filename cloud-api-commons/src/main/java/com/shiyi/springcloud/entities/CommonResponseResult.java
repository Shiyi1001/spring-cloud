package com.shiyi.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CommonResponseResult
 * @Description
 * @Author FengL
 * @Date 2021/11/03 9:33
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponseResult<T> {

    private Integer code;
    private String message;
    private T data;

    public static CommonResponseResult successResult(String message,Object data){
      return  CommonResponseResult.builder().code(200).message(message).data(data).build();
    }

    public static CommonResponseResult successResult(String message){
        return  successResult(message,null);
    }

    public static CommonResponseResult successResult(Object data){
        return  successResult(null,data);
    }

    public static CommonResponseResult failerResult(String message,Object data){
        return  CommonResponseResult.builder().code(0).message(message).data(data).build();
    }

    public static CommonResponseResult failerResult(String message){
        return  failerResult(message,null);
    }
}
