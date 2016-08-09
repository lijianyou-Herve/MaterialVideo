package com.example.herve.materialvideo.utils.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;


/**
 * The type Fast json parser.
 */
public class FastJsonParser implements IJsonParser {


    /**
     * Gets instance.
     *
     * @return the instance
     */

    private static class Init {
        private final static FastJsonParser fastJsonParser;

        static {
            fastJsonParser = new FastJsonParser();
        }
    }

    public static  FastJsonParser getInstance() {

        return Init.fastJsonParser;
    }

    /**
     * @param jsonString the json string
     * @param object     the object
     * @param <T>
     * @return
     */
    @Override
    public <T> T fromJson(String jsonString, Class<T> object) {
        T t = JSON.parseObject(jsonString, object);
        return t;
    }

    @Override
    public <T> String toJson(T object) {
        return JSON.toJSONString(object);
    }

    @Override
    public <T> List<T> listFromJson(String jsonString, Class<T> object) {
        List<T> list = JSON.parseArray(jsonString, object);
        return list;
    }

    @Override
    public <T> Map<String, T> mapFromJson(String jsonString, Class<T> object) {
        Map<String, T> tMap = JSON.parseObject(jsonString, new TypeReference<Map<String, T>>() {
        });
        return tMap;
    }


}
