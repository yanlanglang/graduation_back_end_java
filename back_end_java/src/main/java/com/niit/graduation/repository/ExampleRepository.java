package com.niit.graduation.repository;

import com.niit.graduation.entity.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/9
 * explain:
 */
public interface ExampleRepository extends JpaRepository<Example, Long> {

    /**
     * 通过isBlockly查找Example的集合
     * @param isBlockly
     * @return
     */
    @Query("select e from Example e where e.isBlockly = ?1 order by e.createTime desc ")
    List<Example> findExamplesByBlockly(Boolean isBlockly);


    /**
     * 查找blockly/j最新的几篇案例
     * @param pageable
     * @return
     */
    @Query("select e from Example e where e.isBlockly = true")
    List<Example> findTopWithBlockly(Pageable pageable);

    /**
     * 查找blockly/j最新的几篇案例
     * @param pageable
     * @return
     */
    @Query("select e from Example e where e.isBlockly = false")
    List<Example> findTopWithJ5(Pageable pageable);


}
