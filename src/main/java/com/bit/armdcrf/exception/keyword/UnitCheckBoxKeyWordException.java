package com.bit.armdcrf.exception.keyword;

/**
 * <p>多余的未处理的单位和选项卡关键字异常.</p>
 * 解释：每一次顶层遍历得到的应该是关键字内容，而不应该选项卡内容或单位内容.
 * 如果出现，则说明二层循环处理不到位或者出现Word文档关键字文件不合理.
 * @author Debbie Qiu
 *
 */
public class UnitCheckBoxKeyWordException extends Exception{


    public UnitCheckBoxKeyWordException() {
    }

    public UnitCheckBoxKeyWordException(String message) {
        super(message);
    }

    public UnitCheckBoxKeyWordException(String message, Throwable cause) {
        super(message, cause);
    }
}
