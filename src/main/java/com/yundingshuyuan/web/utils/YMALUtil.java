package com.yundingshuyuan.web.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cr
 * @Date 2023/7/23 13:11
 */
@Component
public class YMALUtil {
    /**
     * 追加YAML配置文件中指定参数的值
     *
     * @throws IOException
     */
    public void appendParamValue(String paramName,Object paramValue) {

        //将yml中所有配置信息装入map中
        Yaml yaml1 = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("application.yml");
        Map<String, Object> objectMap = yaml1.load(inputStream);
        //System.out.println(objectMap.toString());
        for (Map.Entry<String,Object> entry: objectMap.entrySet()
             ) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        //修改map中的信息
        objectMap.put(paramName,paramValue);

        //将map再转回yml
        Yaml yaml2 = new Yaml();
        String dump = yaml2.dump(objectMap);
        FileWriter writer = null;
        try {
            writer = new FileWriter("src/main/resources/application.yml");
            writer.write(dump);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
