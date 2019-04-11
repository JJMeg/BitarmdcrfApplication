package com.bit.armdcrf.exception.keyword;

/**
 * 关键字重复异常
 * 原因：可能是程序异常，但是更多应该是Word文档格式问题
 * Created by Debbie 2018/2/1 9:43
 *
 */

public class KeyWordRepeatException extends Exception {


    public KeyWordRepeatException() {
    }

    public KeyWordRepeatException(String message) {
        super(message);
    }

    public KeyWordRepeatException(String message, Throwable cause) {
        super(message, cause);
    }
}
