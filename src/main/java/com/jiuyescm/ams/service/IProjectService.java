/**
 * Copyright (c) 2016, Jiuye SCM and/or its affiliates. All rights reserved.
 *
 */
package com.jiuyescm.ams.service;

import com.github.pagehelper.PageInfo;
import com.jiuyescm.ams.core.exception.AppException;
import com.jiuyescm.ams.entity.ProjectEntity;
import com.jiuyescm.ams.vo.ProjectVo;

/**
 * @author jiuye
 *
 */
public interface IProjectService {

    /**
     * Get all projects
     * 
     * @return
     * @throws AppException
     */
    PageInfo<ProjectVo> findAllProjects() throws AppException;

    /**
     * Create a new project
     * 
     * @param project
     * @throws AppException
     */
    ProjectVo createProject(ProjectEntity project) throws AppException;

    /**
     * Update the project
     * 
     * @param project
     * @return
     * @throws AppException
     */
    ProjectEntity updateProject(ProjectEntity project) throws AppException;

    /**
     * Delete the project
     * 
     * @param project
     * @throws AppException
     */
    void deleteProject(ProjectEntity project) throws AppException;

}
