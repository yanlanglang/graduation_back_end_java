package com.niit.graduation.service.serviceImpl;

import com.niit.graduation.entity.Type;
import com.niit.graduation.repository.TypeRepository;
import com.niit.graduation.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Yan Lang
 * @Date 2020/12/2
 * explain:
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<Map<String, Object>> searchAllType() {
        //查找数据库中的数据
        List<Type> all = typeRepository.findAll();

        //返回值
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        for (Type type : all) {
            map.put("id",type.getId());
            map.put("name",type.getName());
            list.add(map);
            map = new HashMap<>();
        }

        return list;
    }
}
