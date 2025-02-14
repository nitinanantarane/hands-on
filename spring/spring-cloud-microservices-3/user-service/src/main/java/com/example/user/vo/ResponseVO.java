package com.example.user.vo;

import com.example.user.entity.SimpleUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO {
    private SimpleUser simpleUser;
    private Department department;
}
