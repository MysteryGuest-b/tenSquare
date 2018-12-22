package com.tensquare.base.controller;

import com.tensquare.base.bean.LabelSearchBean;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Irving Lu
 * @create 2018-12-02 21:23
 */
@RestController
@RequestMapping("/label")
@CrossOrigin//表示支持跨域访问
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 查询全部
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        List<Label> all = labelService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", all);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        Label byId = labelService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", byId);
    }

    /**
     * 保存
     *
     * @param label
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        labelService.save(label);
        return new Result(true, StatusCode.OK, "新增成功");
    }

    /**
     * 更新
     *
     * @param id
     * @param label
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable String id, @RequestBody Label label) {
        label.setId(id);
        labelService.save(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        labelService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 根据条件查询
     *
     * @param label
     * @return
     */
    @RequestMapping(value = "/searchByConditions", method = RequestMethod.POST)
    public Result searchByConditions(@RequestBody Label label) {
        List<Label> labels = labelService.searchByConditions(label);
        return new Result(true, StatusCode.OK, "条件查询成功", labels);
    }

    /**
     * 根据条件分页查询
     *
     * @param labelSearchBean
     * @return
     */
    @RequestMapping(value = "/searchByConditionsForPage", method = RequestMethod.POST)
    public Result searchByConditionsForPage(@RequestBody LabelSearchBean labelSearchBean) {
        Page<Label> page = labelService.searchByConditionsForPage(labelSearchBean);
        PageResult<Label> pageResult = new PageResult<>(page.getTotalElements(), page.getContent());
        return new Result(true, StatusCode.OK, "分页查询成功", pageResult);
    }
}
