package com.yamy.shop.common.serializer.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.yamy.shop.common.bean.Qiniu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @author 程祥
 * @date 2022/8/18 19:55
 */
public class ImgJsonSerializer extends JsonSerializer<String> {
    @Autowired
    private Qiniu qiniu;

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(StringUtils.isEmpty(value)) {
            jsonGenerator.writeString("");
            return;
        }
        String[] imgs = value.split(",");
        StringBuilder sb = new StringBuilder();
        for(String img: imgs) {
            sb.append(qiniu.getResourcesUrl()).append(img).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        jsonGenerator.writeString(sb.toString());
    }
}
