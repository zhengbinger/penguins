package com.penguins.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.penguins.common.exception.SystemException;
import com.penguins.common.exception.SystemExceptionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * json, xml 转换器
 *
 * @author zhengbing
 */
public class Convertor {

    private static final Logger LOGGER = LoggerFactory.getLogger(Convertor.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        // 序列化时支持空对象
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 反序列化时忽略掉多余的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 默认从毫秒数转成Bean
        // 需要和 spring-mvc 日期参数转换类兼容 {@link com.xsili.context.transform.DateConverter}
        // mapper.setDateFormat(new SimpleDateFormat(DateUtil.FORMAT_YMDHMS));
    }

    /**
     * 将对象转换成json格式字符串
     *
     * @param object Object
     * @return
     * @throws JsonProcessingException
     */
    public static String toJson(Object object) throws SystemException {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new SystemException(SystemExceptionEnum.TO_JSON_CONVERT, e);
        }
    }

    /**
     * 从json格式字符串转换成对象
     *
     * @param json  String
     * @param clazz Class<T>
     * @return T
     * @throws SystemException
     */
    public static <T> T fromJson(String json, Class<T> clazz) throws SystemException {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new SystemException(SystemExceptionEnum.FROM_JSON_CONVERT, e);
        }
    }

    /**
     * 将json转换成list对象
     *
     * @param json  String
     * @param clazz Class<T>
     * @return List<T>
     */
    public static <T> List<T> fromJsonList(String json, Class<T> clazz) throws SystemException {
        JavaType t = mapper.getTypeFactory().constructParametricType(List.class, clazz);
        try {
            return mapper.readValue(json, t);
        } catch (Exception e) {
            throw new SystemException(SystemExceptionEnum.FROM_JSON_CONVERT, e);
        }
    }

    /**
     * 将json转换成Map对象
     *
     * @param json   String
     * @param clazzk Map中key的类型
     * @param clazzv Map中value的类型
     * @return Map<K, V>
     */
    public static <K, V> Map<K, V> fromJsonMap(String json, Class<K> clazzk, Class<V> clazzv) throws SystemException {
        JavaType t = mapper.getTypeFactory().constructParametricType(Map.class, clazzk, clazzv);
        try {
            return mapper.readValue(json, t);
        } catch (Exception e) {
            throw new SystemException(SystemExceptionEnum.FROM_JSON_CONVERT, e);
        }
    }

    public static String toXml(Object object) throws SystemException {
        StringWriter out = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(object, out);
        } catch (JAXBException e) {
            throw new SystemException("beanToXml转换失败", e);
        }
        return out.toString();
    }

    public static <T> T fromXml(String xml, Class<T> clazz) throws SystemException {
        InputStream is = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
            return (T) unmarshaller.unmarshal(is);
        } catch (JAXBException e) {
            throw new SystemException("xmlToBean转换失败", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("xmlToBean转换关闭流失败", e);
                }
            }
        }
    }

}
