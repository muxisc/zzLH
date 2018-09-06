package com.lh.blog.system.dto;

import java.io.Serializable;

/**
 * 权限树的节点
 * @author hzhb
 *
 */
public class PermisionTreeNode implements Serializable {
    private static final long serialVersionUID = -4238023960294120354L;

    /**
     * 主键
     */
    private String id;

    /**
     * 父ID
     */
    private String pId;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态  默认关闭状态
     */
    private boolean open = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
