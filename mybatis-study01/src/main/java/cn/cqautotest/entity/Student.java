package cn.cqautotest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("student")
public class Student implements Serializable {

    private Integer id;
    private String userName;
    private String password;
}
