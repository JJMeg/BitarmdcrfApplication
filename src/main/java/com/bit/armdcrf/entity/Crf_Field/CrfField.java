package com.bit.armdcrf.entity.Crf_Field;

import java.util.Arrays;
import java.util.List;

/**
 * @author Debbie Qiu
 */
public class CrfField  implements Crf_Field{

    protected List<String> STORE_ATOM = Arrays.asList("");
    protected List<String> NORMAL_ATOM = Arrays.asList("") ;
    protected List<String> NORMAL_NO_ATOM = Arrays.asList("") ;
    protected List<String> INT_STORE = Arrays.asList("") ;
    protected List<String> FLOAT_STORE = Arrays.asList("");


    @Override
    public List<String> getNormalAtom() {
        return NORMAL_ATOM;
    }

    @Override
    public List<String> getNormalNoAtom() {
        return NORMAL_NO_ATOM;
    }

    @Override
    public List<String> getStoreAtom() { return STORE_ATOM; }

    @Override
    public List<String> getIntStore() {
        return INT_STORE;
    }

    @Override
    public List<String> getFLOAT_STORE() { return FLOAT_STORE; }
}
