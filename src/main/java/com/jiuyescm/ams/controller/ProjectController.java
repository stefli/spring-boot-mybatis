/**
 * Copyright (c) 2016, Jiuye SCM and/or its affiliates. All rights reserved.
 *
 */
package com.jiuyescm.ams.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.jiuyescm.ams.core.exception.AppException;
import com.jiuyescm.ams.entity.ProjectEntity;
import com.jiuyescm.ams.service.IProjectService;
import com.jiuyescm.ams.vo.ProjectVo;

/**
 * @author litao
 *
 */
@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class.getName());

    @Autowired
    IProjectService projectService;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> ping() {
        return new ResponseEntity<String>("pong", HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<PageInfo<ProjectVo>> findAllProjects() {
        PageInfo<ProjectVo> projectVos = null;

        try {
            projectVos = projectService.findAllProjects();
        } catch (AppException e) {
            logger.error("Can't find all the projects, error: {}", e.getMessage(), e);
        }

        return new ResponseEntity<PageInfo<ProjectVo>>(projectVos, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> createProject(@RequestBody ProjectEntity project) {
        project.setId(UUID.randomUUID().toString());
        ProjectVo projectVo = null;

        try {
            projectVo = projectService.createProject(project);
        } catch (AppException e) {
            logger.error("Can't create the project, error: {}", e.getMessage(), e);
            return new ResponseEntity<String>("Can't create project with error " + e.getMessage(),
                    HttpStatus.SERVICE_UNAVAILABLE);
        }

        return new ResponseEntity<ProjectVo>(projectVo, HttpStatus.CREATED);
    }
}
