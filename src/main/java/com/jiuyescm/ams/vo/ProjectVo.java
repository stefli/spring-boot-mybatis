/**
 * Copyright (c) 2016, Jiuye SCM and/or its affiliates. All rights reserved.
 *
 */
package com.jiuyescm.ams.vo;

import java.io.Serializable;

/**
 * @author jiuye
 *
 */
public class ProjectVo implements Serializable {

    private static final long serialVersionUID = 3892405427333805334L;

    private String id;
    private String name;
    private String description;

    public ProjectVo() {
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
