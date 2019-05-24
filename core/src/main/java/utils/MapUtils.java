package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import core.others.TengXunMapAddressCoding;
import core.others.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sxy
 * @version 1.0
 * @date 2019/4/18 19:35
 **/
@Component
@Slf4j
public class MapUtils {
    private final static String TENG_XUN_MAP_ADDRESS_CODING_URL = "https://apis.map.qq.com/ws/geocoder/v1/";
    private final static String TENG_XUN_MAP_KEY = "JEOBZ-4V4CU-22NVQ-45OTB-VNUTZ-CTFJA";

    private static ObjectMapper objectMapper;

    public MapUtils(ObjectMapper objectMapper) {
        MapUtils.objectMapper = objectMapper;
    }

    public static TengXunMapAddressCoding tengXunAddressCoding(String address) {
        if (OthersUtils.isEmpty(address)) {
            throw new ValidateException("地址不能为空");
        }
        Map<String, Object> params = new HashMap<>(2);
        params.put("address", address);
        params.put("key", TENG_XUN_MAP_KEY);
        String result = HttpUtils.get(TENG_XUN_MAP_ADDRESS_CODING_URL, params);
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(result);
        } catch (IOException e) {
            log.warn("地址编码失败，异常信息:{} 返回结果:{} 地址信息:{}", e.getMessage(), result, address);
            throw new ValidateException("地址编码失败:" + e.getMessage());
        }
        if (jsonNode.findValue("status").intValue() == 0) {
            TengXunMapAddressCoding location = new TengXunMapAddressCoding();
            location.setAdCode(jsonNode.findValue("adcode").textValue());
            location.setLng(jsonNode.findValue("lng").doubleValue());
            location.setLat(jsonNode.findValue("lat").doubleValue());
            location.setProvince(jsonNode.findValue("province").textValue());
            location.setCity(jsonNode.findValue("city").textValue());
            location.setDistrict(jsonNode.findValue("district").textValue());
            location.setStreet(jsonNode.findValue("street").textValue());
            return location;
        } else {
            log.warn(jsonNode.findValue("status").textValue(), " ", jsonNode.findValue("message").textValue());
            throw new ValidateException("地址编码失败:" + jsonNode.findValue("message").textValue());
        }
    }
}
