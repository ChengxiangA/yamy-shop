package com.yamy.shop.common.serializer.json;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.emoji.EmojiUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.SneakyThrows;

/**
 * @author 程祥
 * @date 2022/8/31 15:35
 */
public class EmojiJsonSerializer extends JsonSerializer<String> {
    @Override
    @SneakyThrows
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.writeString(EmojiUtil.toUnicode(StrUtil.isBlank(value) ? "" : value));
    }
}
