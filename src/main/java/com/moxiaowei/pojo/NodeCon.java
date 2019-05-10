package com.moxiaowei.pojo;

import java.io.Serializable;
import java.util.HashMap;

public class NodeCon implements Serializable {

    public static final long serialVersionUID = -1L;

    private HashMap<String, Node> nodes;

    public HashMap<String, Node> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<String, Node> nodes) {
        this.nodes = nodes;
    }
}
