package com.moxiaowei.pojo;

import com.moxiaowei.util.IdUtils;

import java.io.Serializable;

public class Node implements Serializable {

    public static final long serialVersionUID = -1L;

    private Object value;
    private boolean point;
    private String pointName;

    public Node() {

    }

    public String hash(){
        int i = this.value.hashCode();
        return IdUtils.getId() + "" + i;
    }

    public Node(Object value, boolean point, String pointName) {
        this.value = value;
        this.point = point;
        this.pointName = pointName;
    }

    public boolean isPoint() {
        return point;
    }

    public void setPoint(boolean point) {
        this.point = point;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                '}';
    }
}
