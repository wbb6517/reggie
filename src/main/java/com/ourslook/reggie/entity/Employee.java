package com.ourslook.reggie.entity;

/**
 * ClassName: Employee
 * Package: com.ourslook.reggie.entity
 * Description:
 *
 * @Author 王犇犇
 * @Create 2023/4/10 16:09
 * @Version 1.0
 */

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 员工实体
 */
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String name;

    private String password;

    private String phone;

    private String sex;

    private String idNumber;//身份证号码

    private Integer status;

    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    /**
     * @TableField(fill = FieldFill.INSERT) 是 MyBatis-Plus 框架中的注解，
     * 用于标记实体类属性对应数据库表中的字段，并指定该字段在插入数据时应该如何填充。
     *
     * 具体来说，@TableField 注解有一个 fill 属性，可以设置成如下四种值之一：
     *
     * FieldFill.DEFAULT：默认值，不进行任何填充；
     * FieldFill.INSERT：在插入数据时填充该字段；
     * FieldFill.UPDATE：在更新数据时填充该字段；
     * FieldFill.INSERT_UPDATE：在插入和更新数据时都填充该字段。
     * 通常情况下，我们将主键 ID 字段标记为 FieldFill.INSERT，表示在插入数据时自动生成 ID。
     * 而对于一些需要记录数据修改时间和修改人的字段，我们可以将它们标记为 FieldFill.INSERT_UPDATE，表示在插入和更新数据时自动填充。
     */
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT) //插入时填充字段
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE) //插入和更新时填充字段
    private Long updateUser;

}
