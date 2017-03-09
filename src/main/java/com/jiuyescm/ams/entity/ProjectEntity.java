/**
 * Copyright (c) 2016, Jiuye SCM and/or its affiliates. All rights reserved.
 *
 */
package com.jiuyescm.ams.entity;

/**
 * @author jiuye
 *
 */
public class ProjectEntity extends BaseEntity<ProjectEntity> {

    private static final long serialVersionUID = 1973218017087707495L;

    private String id;
    private String name;
    private String description;

    public ProjectEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
