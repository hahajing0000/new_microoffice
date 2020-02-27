package com.zy.microoffice.config;

/**
 * 消息类型
 */
public enum MsgType {
    TXT(0),IMG(1),AUDIO(2),VIDEO(3),LOCATION(4),FACE(5);

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    MsgType(int index) {
        this.index = index;
    }
}
