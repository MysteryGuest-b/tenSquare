package com.tensquare.base.service;

import com.tensquare.base.bean.LabelSearchBean;
import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import constant.PageConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import utils.IdWorker;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Irving Lu
 * @create 2018-12-02 20:32
 */
@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;


    public List<Label> findAll() {
        return labelDao.findAll();
    }

    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    public void save(Label label) {
        label.setId(String.valueOf(idWorker.nextId()));
        labelDao.save(label);
    }

    public void update(Label label) {
        labelDao.save(label);
    }

    public void delete(String id) {
        labelDao.deleteById(id);
    }

    public List<Label> searchByConditions(Label label) {
        Specification<Label> specification = createSpecification(label);
        return labelDao.findAll(specification);
    }

    private Specification<Label> createSpecification(Label label) {
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(label.getlabelname())) {
                    predicates.add(criteriaBuilder.like(root.get("labelname"), "%" + label.getlabelname() + "%"));
                }
                if (label.getState() != null && !"".equals(label.getState())) {
                    predicates.add(criteriaBuilder.equal(root.get("state"), label.getState()));
                }
                if (label.getRecommend() != null && !"".equals(label.getRecommend())) {
                    predicates.add(criteriaBuilder.equal(root.get("recommend"), label.getRecommend()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

    public Page<Label> searchByConditionsForPage(LabelSearchBean labelSearchBean) {
        Specification<Label> specification = createSpecification(labelSearchBean);
        PageRequest pageRequest = PageRequest.of(labelSearchBean.getPageNumber() == null || labelSearchBean.getPageNumber() <= 0 ? PageConstant.PAGENUMBER - 1 : labelSearchBean.getPageNumber() - 1,
                labelSearchBean.getPageSize() == null || labelSearchBean.getPageSize() <= 0 ? PageConstant.PAGESIZE : labelSearchBean.getPageSize());
        return labelDao.findAll(specification, pageRequest);
    }

    private Specification<Label> createSpecification(LabelSearchBean labelSearchBean) {
        return new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(labelSearchBean.getLabelname())) {
                    predicates.add(criteriaBuilder.like(root.get("labelname"), "%" + labelSearchBean.getLabelname() + "%"));
                }
                if (labelSearchBean.getState() != null && !"".equals(labelSearchBean.getState())) {
                    predicates.add(criteriaBuilder.equal(root.get("state"), labelSearchBean.getState()));
                }
                if (labelSearchBean.getRecommend() != null && !"".equals(labelSearchBean.getRecommend())) {
                    predicates.add(criteriaBuilder.equal(root.get("recommend"), labelSearchBean.getRecommend()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
