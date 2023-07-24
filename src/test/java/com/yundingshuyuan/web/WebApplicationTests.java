package com.yundingshuyuan.web;

import com.yundingshuyuan.web.utils.YMALUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

@SpringBootTest
class WebApplicationTests {



    @Test
    void test() throws IOException {
        YMALUtil ymalUtil = new YMALUtil();
        ymalUtil.appendParamValue("bucket-name","rhgdvjxosb");
    }

}
