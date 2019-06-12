package com.example.core.others;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author sxy
 * @version 1.0
 * @date 2019/4/18 19:39
 **/
@Data
@Accessors(chain = true)
public class TengXunMapAddressCoding {
    /**
     * 经度
     */
    private Double lng;
    /**
     * 纬度
     */
    private Double lat;
    /**
     * 地址编码
     */
    private String adCode;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区（县）
     */
    private String district;
    /**
     * 街道
     */
    private String street;
    /**
     *
     */
    private String streetNumber;
}
