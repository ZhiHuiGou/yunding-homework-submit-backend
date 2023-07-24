package com.yundingshuyuan.web.web.authentication.domain;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xieyaoxuan
 * @since 2023-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private String user_id;

    /**
     * 学号
     */
    private Integer number;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 方向
     */
    private String direction;

    /**
     * qq号
     */
    private String QQnum;

    /**
     * 注册状态 只有0和1两种状态 0表示注册申请通过可以正常使用
     */
    private Integer status;

    /**
     * 组别
     */
    private String group;

    /**
     * 记录提交次数
     */
    private Integer submission_count;

    /**
     * 本周是否提交
     */
    private Integer is_submitted_this_week;

    private String created_at;

    private String update_at;

    @Version
    private Integer version;

    @TableLogic
    private Integer deleted;


}
