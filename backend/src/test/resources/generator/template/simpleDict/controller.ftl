package ${modulePackage}.web.controller.${moduleName};

import ${modulePackage}.${moduleName}.domain.${modelNameUpperCamel};
import ${modulePackage}.${moduleName}.service.${modelNameUpperCamel}Service;
import ${basePackage}.common.restResult.RestResult;
import ${basePackage}.common.restResult.ResultGenerator;
import ${basePackage}.common.restResult.PageParam;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
/**
*
* @author ${author}
* @Description:
* @date ${date}
*/
@Slf4j
@RestController
@RequestMapping("${baseRequestMapping}")
@Api(basePath = "${baseRequestMapping}", tags = "XX模块管理")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping
    @ApiOperation(value = "新增XX", notes = "单个新增", produces = "application/json")
    public RestResult add(@ApiParam(name = "XX信息", required = true) @RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}.setCreateTime(new Date());
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult().setMessage("保存成功");
    }

    @DeleteMapping
    @ApiOperation(value = "删除XX", notes = "单个删除", produces = "application/json")
    public RestResult delete(@ApiParam(name = "XX信息", required = true) Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return ResultGenerator.genSuccessResult().setMessage("删除成功");
    }

    @PutMapping
    @ApiOperation(value = "修改XX", notes = "单个修改" , produces = "application/json")
    public RestResult update(@ApiParam(name = "XX信息", required = true) @RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}.setModifyTime(new Date());
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult().setMessage("修改成功");
    }

    @GetMapping
    @ApiOperation(value = "获取XX信息", notes = "单个获取", produces = "application/json")
    public RestResult detail(@ApiParam(value = "主键ID") @RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    /**
     * 用于分页查询,默认可以不用传分页信息
     * 默认值：page=1,size=10,sortField="id",sortOrder="ASC"
     */
    @GetMapping(value = "/list")
    @ApiOperation(value = "XX列表分页查询", notes = "分页列表", produces = "application/json")
    public RestResult list(@ApiParam(value = "分页信息") PageParam pageParam,
                           @ApiParam(value = "查询条件") @RequestParam(required = false, defaultValue = "") String query) {
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.list(pageParam, query);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 下拉框查询所有
     */
    @ApiOperation(value = "XX列表查询所有", notes = "下拉框列表", produces = "application/json")
    @GetMapping(value = "/all")
    public RestResult listAll() {
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        return ResultGenerator.genSuccessResult(list);
    }

    @ApiOperation(value = "XX字段校验", notes = "参数字段校验", produces = "application/json")
    @GetMapping(value = "/check")
    public RestResult keyIsExist(String domainField, String value) {
        Integer integer = ${modelNameLowerCamel}Service.keyIsExist(domainField, value);
        return ResultGenerator.genSuccessResult(integer);
    }

}
