package com.yundingshuyuan.web.common.enums;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 支持的文件后缀
 *
 * @Author cr
 * @Date 2023/7/22 12:41
 */
public enum UploadFilePrefixEnum {

    /**
     * 压缩文件
     */
    ZIP(".zip",UploadTypeEnum.ZIP),
    RAR(".rar",UploadTypeEnum.RAR),

    /**
     * WORD
     */
    DOC(".doc",UploadTypeEnum.WORD),
    DOCX(".docx",UploadTypeEnum.WORD),

    /**
     * .md
     */
    MD(".md",UploadTypeEnum.MD),

    /**
     * 图片
     */
    JPG(".jpg",UploadTypeEnum.IMAGE),
    PNG(".png",UploadTypeEnum.IMAGE);




    private String prefix;
    private UploadTypeEnum typeEnum;
    private static Map<String,UploadFilePrefixEnum> prefixEnumMap;  //将当前所有支持的后缀放进这个map中，下面判断的时候使用

    public String getPrefix() {
        return prefix;
    }

    public UploadTypeEnum getTypeEnum() {
        return typeEnum;
    }

    /**
     * 构造器
     * @param prefix
     * @param typeEnum
     */
    private UploadFilePrefixEnum(String prefix,UploadTypeEnum typeEnum){
        this.prefix = prefix;
        this.typeEnum = typeEnum;
        init(prefix,this);
    }

    /**
     * 将enums装入map中
     * @param prefix
     * @param uploadFilePrefixEnum
     */
    private void init(String prefix,UploadFilePrefixEnum uploadFilePrefixEnum){
        if (UploadFilePrefixEnum.prefixEnumMap == null){
            UploadFilePrefixEnum.prefixEnumMap = new HashMap<>();
        }
        UploadFilePrefixEnum.prefixEnumMap.put(prefix,uploadFilePrefixEnum);
    }

    /**
     * 传入prefix，判断支不支持
     * @param prefix
     * @return
     */
    public static UploadTypeEnum judge(String prefix){
        if (prefixEnumMap.containsKey(prefix)){
            return prefixEnumMap.get(prefix).getTypeEnum();
        }else {
            return UploadTypeEnum.EXTRA;
        }
    }

    /**
     * 解析传来的fileName
     * @param fileName
     * @return
     */
    public static UploadTypeEnum SupportCheck(String fileName){
        if (fileName == null || "".equals(fileName)){
            //抛出异常
        }
        String prefix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();    //文件后缀
        if ("".equals(prefix)){
            //抛出异常
        }
        return judge(prefix.toLowerCase());
    }
}
