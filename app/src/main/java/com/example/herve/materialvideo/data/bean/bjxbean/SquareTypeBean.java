package com.example.herve.materialvideo.data.bean.bjxbean;

public class SquareTypeBean {
    private String squareTypeId;
    private String squareTypeName;

    public String getSquareTypeId() {
        return squareTypeId;
    }

    public void setSquareTypeId(String squareTypeId) {
        this.squareTypeId = squareTypeId;
    }

    public String getSquareTypeName() {
        return squareTypeName;
    }

    public void setSquareTypeName(String squareTypeName) {
        this.squareTypeName = squareTypeName;
    }

    @Override
    public String toString() {
        return "SquareTypeBean{" +
                "squareTypeId='" + squareTypeId + '\'' +
                ", squareTypeName='" + squareTypeName + '\'' +
                '}';
    }
}