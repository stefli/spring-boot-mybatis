/**
 * Copyright (c) 2016, Jiuye SCM and/or its affiliates. All rights reserved.
 *
 */
package com.jiuyescm.ams.mapper;

/**
 * @author jiuye
 *
 */

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.jiuyescm.ams.core.exception.AppException;
import com.jiuyescm.ams.entity.ProjectEntity;

public interface ProjectMapper {

    /**
     * Get all projects
     * 
     * @return
     * @throws AppException
     */
    List<ProjectEntity> findAllProjects() throws DataAccessException;

    /**
     * Create a new project
     * 
     * @param project
     * @throws AppException
     */
    ProjectEntity createProject(ProjectEntity project) throws DataAccessException;

    /**
     * Update the project
     * 
     * @param project
     * @return
     * @throws AppException
     */
    ProjectEntity updateProject(ProjectEntity project) throws DataAccessException;

    /**
     * Delete the project
     * 
     * @param project
     * @throws AppException
     */
    void deleteProject(String id) throws DataAccessException;

}
