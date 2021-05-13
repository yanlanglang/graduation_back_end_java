package com.niit.graduation.web.admin;

import com.niit.graduation.entity.Example;
import com.niit.graduation.service.ExampleService;
import com.niit.graduation.util.MathRandomUtils;
import com.niit.graduation.util.PathUtils;
import com.niit.graduation.util.ResultJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author Yan Lang
 * @Date 2021/5/4
 * explain:
 */
@Controller
@RequestMapping("/admin")
@CrossOrigin(origins = "*",allowCredentials="true",allowedHeaders = "*",methods = {})
public class AdminExampleController {

    @Autowired
    private ExampleService exampleService;

    /**
     * @param file 上传的文件
     * @param example 实例，含content、isBlockly
     * @return
     */
    @PostMapping("/publishExample")
    @ResponseBody
    public ResultJsonUtils saveExample(MultipartFile file,
                                       Example example){

        //判断是否上传图片
        if (file.isEmpty()) {
            //即没有修改头像
            return ResultJsonUtils.error("文件为空");

        } else {
            //设置前缀
            String prefix = "";
            if (example.getBlockly()){
                prefix = "blockly_file_";
            }else {
                prefix = "j5_file_";
            }

            //文件名
            String fileName = prefix + MathRandomUtils.getRandom(0) + ".xml";

            //图片路径(映射后的)
            String fileMapPath = PathUtils.getMapExampleFilePath(fileName);
            example.setFileMapPath(fileMapPath);

            //生成文件(实际路径)
            File dest = new File(PathUtils.getExampleFilePath(fileName));
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //保存example实例
            exampleService.addExample(example);

            return ResultJsonUtils.ok("保存案例成功！");
        }
    }


    /**
     * 通过参数获取案例
     * @param isBlockly true：blockly; false：johnny-five
     * @return
     */
    @GetMapping("/examples")
    @ResponseBody
    public ResultJsonUtils getExamplesByParam(@RequestParam Boolean isBlockly){

        List<Example> examples = exampleService.searchExamples(isBlockly);
        return ResultJsonUtils.ok("获取案例集合",examples);
    }


    /**
     * 通过id删除example
     * @param id
     * @return
     */
    @DeleteMapping("/example")
    @ResponseBody
    public ResultJsonUtils delExample(@RequestParam Long id){
        exampleService.deleteExample(id);

        return ResultJsonUtils.ok("删除案例成功！");
    }

}
