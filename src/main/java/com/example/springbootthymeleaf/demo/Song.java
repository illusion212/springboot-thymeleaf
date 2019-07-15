package com.example.springbootthymeleaf.demo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Song {

    //String类型的校验: @NotEmpty -- 不能为空  max=16 -- 最大长度为16
    @NotEmpty(message = "songName不能为空")
    @Size(max = 16 , message = "songName长度不能超过16")
    private String songName;

    @NotEmpty(message = "singer不能为空")
    @Size(max = 12 , message = "singer长度不能超过12")
    private String singer;

    //int类型的校验: @NotNull -- 不能为空 min=1 max=127 -- 值在1~127之间
    @Range(min = 1, max = 127, message = "age的范围在1~127")
    @NotNull(message = "age不能为空")
    private Integer age;

}
