/**
 * Copyright (c) 2016, Jiuye SCM and/or its affiliates. All rights reserved.
 *
 */
package com.jiuyescm.ams.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jiuyescm.ams.core.exception.AppException;
import com.jiuyescm.ams.entity.ProjectEntity;
import com.jiuyescm.ams.mapper.ProjectMapper;
import com.jiuyescm.ams.service.IProjectService;
import com.jiuyescm.ams.vo.ProjectVo;

/**
 * @author jiuye
 *
 */
@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    ProjectMapper projectMapper;

    public PageInfo<ProjectVo> findAllProjects() throws AppException {
        List<ProjectVo> projectVos = Lists.newArrayList();
        try {
            PageHelper.startPage(1, 2);
            List<ProjectEntity> projects = projectMapper.findAllProjects();
            for (ProjectEntity entity : projects) {
                ProjectVo vo = new ProjectVo();
                PropertyUtils.copyProperties(vo, entity);
                projectVos.add(vo);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return new PageInfo<ProjectVo>(projectVos);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ProjectVo createProject(ProjectEntity project) throws AppException {
        ProjectVo vo = new ProjectVo();
        try {
            ProjectEntity entity = projectMapper.createProject(project);
            PropertyUtils.copyProperties(vo, entity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return vo;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ProjectEntity updateProject(ProjectEntity project) throws AppException {
        return null;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteProject(ProjectEntity project) throws AppException {

    }

}
