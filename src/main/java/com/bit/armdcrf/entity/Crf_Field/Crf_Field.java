package com.bit.armdcrf.entity.Crf_Field;

import java.util.List;

/**
 * @author Debbie Qiu
 */
public interface Crf_Field {


    public List<String> getNormalAtom();

    public List<String> getNormalNoAtom() ;

    public List<String> getStoreAtom() ;

    public List<String> getIntStore();

    public List<String> getFLOAT_STORE();

}
