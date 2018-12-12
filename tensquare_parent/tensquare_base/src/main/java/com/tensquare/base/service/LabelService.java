package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.IdWorker;

import java.util.List;

/**
 * @author Irving.Lu
 * @create 2018-12-02 20:32
 */
@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    //查询所有
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    //根据id查询
    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    //新增
    public void save(Label label){
        label.setId(String.valueOf(idWorker.nextId()));
        labelDao.save(label);
    }

    //更新
    public void update(Label label){
        labelDao.save(label);
    }

    //删除
    public void delete(String id){
        labelDao.deleteById(id);
    }

}
