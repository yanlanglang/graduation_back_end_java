package com.niit.graduation.service;

import com.niit.graduation.entity.Example;

import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/9
 * explain:
 */
public interface ExampleService {

    /**
     * 添加一条example实例
     * @param example
     */
    void addExample(Example example);


    /**
     * 获取blockly/johnny5的所有集合
     * @param isBlockly
     * @return
     */
    List<Example> searchExamples(Boolean isBlockly);


    /**
     * 删除指定的example
     * @param id
     */
    void deleteExample(Long id);

    /**
     * 获取blockly最新的5条集合
     * @return
     */
    List<Example> searchBlocklyExamples();

    /**
     * 获取j5最新的5条集合
     * @return
     */
    List<Example> searchJ5Examples();

    /**
     * 获取所有集合
     * @return
     */
    List<Example> searchExamples();

}
