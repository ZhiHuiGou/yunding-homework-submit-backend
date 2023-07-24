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
public class Homework implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 作业id
     */
    private Integer homework_id;

    /**
     * 开始时间
     */
    private String start_time;

    /**
     * 截止时间
     */
    private String end_time;

    /**
     * 作业内容
     */
    private String homework_url;

    /**
     * 备注
     */
    private String notice;

    /**
     * 第几周的作业
     */
    private String weeks;

    /**
     * 方向
     */
    private String direction;

    private String created_at;

    private String update_at;

    @Version
    private String version;

    @TableLogic
    private String deleted;


}
