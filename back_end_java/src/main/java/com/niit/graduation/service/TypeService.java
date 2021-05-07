package com.niit.graduation.service;

import java.util.List;
import java.util.Map;

/**
 * @Author Yan Lang
 * @Date 2020/12/2
 * explain:
 */
public interface TypeService {

    /**
     * 查找所有的type记录，Map中存储typeId 和 typeName
     * @return
     */
    List<Map<String,Object>> searchAllType();

}
