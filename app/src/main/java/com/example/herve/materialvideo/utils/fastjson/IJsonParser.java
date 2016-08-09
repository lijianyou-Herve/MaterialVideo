package com.example.herve.materialvideo.utils.fastjson;


import java.util.List;
import java.util.Map;


/**
 * The interface Json parser.
 */
public interface IJsonParser {

    /**
     * From json t.
     *
     * @param <T>        the type parameter
     * @param jsonString the json string
     * @param object     the object
     * @return the t
     */
    <T> T fromJson(String jsonString, Class<T> object);

    /**
     * To json string.
     *
     * @param <T>    the type parameter
     * @param object the object
     * @return the string
     */
    <T> String toJson(T object);

    /**
     * List from json list.
     *
     * @param <T>        the type parameter
     * @param jsonString the json string
     * @param object     the object
     * @return the list
     */
    <T> List<T> listFromJson(String jsonString, Class<T> object);

    /**
     * Map from json map.
     *
     * @param <T>        the type parameter
     * @param jsonString the json string
     * @param object     the object
     * @return the map
     */
    <T> Map<String, T> mapFromJson(String jsonString, Class<T> object);
}

//{
//    T fromJson(String jsonString, Class<T> object);
//
//    String toJson(T object);
//
//    List<T> listFromJson(String jsonString, Class<T> object);
//
//    Map<String, T> mapFromJson(String jsonString, Class<T> object);
//}