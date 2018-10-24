package com.qbk.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qbk.entity.TestInfo;
import com.qbk.service.TestService;
import com.qbk.util.BaseResult;
import com.qbk.util.BaseResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 @Api:注解controller，

 @ApiOperation:注解方法，value为简要描述,notes为全面描述,hidden=true Swagger将不显示该方法，默认为false

 @ApiParam:注解参数,hidden=true Swagger参数列表将不显示该参数,name对应参数名，value为注释，defaultValue设置默认值,allowableValues设置范围值,required设置参数是否必须，默认为false

 */
@Api(tags = {"测试控制器"})
@Log4j2
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestService testService ;

    @ApiOperation(value = "获取测试",notes="详细描述获取测试列表")
    @GetMapping("/getTest/{name}")
    public BaseResult<PageInfo<TestInfo>> getTest(@ApiParam(name = "name",value = "名称",required = true)@PathVariable String name,
                              @ApiParam(name = "pageNum",value = "页码")@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                              @ApiParam(name = "pageSize",value = "条数")@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){

        TestInfo testInfo = TestInfo.builder().name(name).build();
        log.info("builder测试"+testInfo);

        List<TestInfo> list = testService.getTest();
        if (pageNum != -1) {
            PageHelper.startPage(pageNum, pageSize);
        }
        PageInfo<TestInfo> pageInfo = new PageInfo<>(list);
        return BaseResultGenerator.success("成功",pageInfo);
    }

    @ApiOperation(value = "添加测试",notes="详细描述一个实体的添加")
    @PostMapping("/add")
    public BaseResult addTest(TestInfo testInfo){
       int result = testService.addTest(testInfo);
        if (result > 0) {
            log.error("添加成功");
            return BaseResultGenerator.success("添加成功");
        } else {
            log.error("添加失败");
            return BaseResultGenerator.error("添加失败");
        }
    }

    @ApiOperation(value = "删除测试",notes="详细描述一个实体的删除")
    @DeleteMapping("/delete/{id}")
    public BaseResult deleteTest(@ApiParam(name = "id",value = "主键",required = true)@PathVariable Integer id){
        int result = testService.deleteTest(id);
        if (result > 0) {
            log.error("删除成功");
            return BaseResultGenerator.success("删除成功");
        } else {
            log.error("删除失败");
            return BaseResultGenerator.error("删除失败");
        }
    }

}
