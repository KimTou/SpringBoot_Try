package com.cjt.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cjt
 */
@ApiModel("报名用户实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("用户姓名")
    private String userName;
    @ApiModelProperty("用户学号")
    private String uId;
    @ApiModelProperty("用户专业")
    private String major;
    @ApiModelProperty("用户个人介绍")
    private String resume;
    @ApiModelProperty("招新结果")
    private String result;

}
