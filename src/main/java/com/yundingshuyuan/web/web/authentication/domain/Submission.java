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
public class Submission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 提交记录id
     */
    private String commit_id;

    /**
     * 用户id
     */
    private String user_id;

    /**
     * 第几周
     */
    private Integer weeks;

    /**
     * 作业链接
     */
    private String file_url;

    /**
     * 提交备注
     */
    private String comments;

    /**
     * 提交时间
     */
    private String submit_time;

    private String created_at;

    private String update_at;

    @Version
    private Integer version;

    @TableLogic
    private Integer deleted;


}
