package com.bit.armdcrf;

import com.bit.armdcrf.service.IndexHandler.IndexSearch.IndexSearchImpl;
import com.bit.armdcrf.service.Interface.IndexSearch;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Debbie Qiu
 */
public class QueryParseTest {

    //@Autowired
    IndexSearchImpl indexSearch =new IndexSearchImpl();

    @Test
    public void test(){
        //String a = "姓名:debbie AND 病例编号:0";
        String a = "姓名:debbie AND 年龄:[0 TO 900]";
       //String a= "姓名:debbie AND 年龄:[0 TO 200] AND 纳入日期:[0 TO 99999999] AND 术前US检查:有 AND 术前实验室检查:有";
        //String a = "姓名:debbie AND 年龄:[0 TO 200] AND 纳入日期:[0 TO 99999999]";

        indexSearch.queryPrase(a);


    }
}
