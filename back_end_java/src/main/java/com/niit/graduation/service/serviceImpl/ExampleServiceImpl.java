package com.niit.graduation.service.serviceImpl;

import com.niit.graduation.entity.Example;
import com.niit.graduation.repository.ExampleRepository;
import com.niit.graduation.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/9
 * explain:
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleRepository exampleRepository;

    @Override
    public void addExample(Example example) {
        example.setCreateTime(new Date());
        exampleRepository.save(example);
    }

    @Override
    public List<Example> searchExamples(Boolean isBlockly) {
        return exampleRepository.findExamplesByBlockly(isBlockly);
    }

    @Override
    public void deleteExample(Long id) {
        exampleRepository.deleteById(id);
    }

    @Override
    public List<Example> searchBlocklyExamples() {

        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");

        /*
            param1:当前查询的页数
            param2:每页查询的数量
            param3:Sort实例
         */
        Pageable pageable = PageRequest.of(0, 5, sort);

        return exampleRepository.findTopWithBlockly(pageable);
    }

    @Override
    public List<Example> searchJ5Examples() {

        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");

        /*
            param1:当前查询的页数
            param2:每页查询的数量
            param3:Sort实例
         */
        Pageable pageable = PageRequest.of(0, 5, sort);


        return exampleRepository.findTopWithJ5(pageable);
    }

    @Override
    public List<Example> searchExamples() {

        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");
        return exampleRepository.findAll(sort);
    }


}
