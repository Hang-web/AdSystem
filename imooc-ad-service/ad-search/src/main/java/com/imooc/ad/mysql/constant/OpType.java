package com.imooc.ad.mysql.constant;

import com.github.shyiko.mysql.binlog.event.EventType;

public enum OpType {
    ADD,
    UPDATE,
    DELETE,
    OTHER;

    //将EventType转化为自定义的OpType
    public static OpType to(EventType eventType) {
        switch (eventType) {
            case EXT_WRITE_ROWS:
                return ADD;
            case EXT_UPDATE_ROWS:
                return UPDATE;
            case EXT_DELETE_ROWS:
                return DELETE;

                default:
                    return OTHER;
        }
    }
}
