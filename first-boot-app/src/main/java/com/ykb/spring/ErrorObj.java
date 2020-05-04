package com.ykb.spring;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private String         domain;
    private String         desc;
    private int            errorCause;
    private List<ErrorObj> errorObjs;


    public ErrorObj() {
    }

    public void addError(final ErrorObj inner) {
        if (this.errorObjs == null) {
            this.errorObjs = new ArrayList<>();
        }
        this.errorObjs.add(inner);
    }

    public ErrorObj(final String domainParam,
                    final String descParam,
                    final int errorCauseParam) {
        super();
        this.domain = domainParam;
        this.desc = descParam;
        this.errorCause = errorCauseParam;
    }


    public String getDomain() {
        return this.domain;
    }

    public void setDomain(final String domainParam) {
        this.domain = domainParam;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String descParam) {
        this.desc = descParam;
    }

    public int getErrorCause() {
        return this.errorCause;
    }

    public void setErrorCause(final int errorCauseParam) {
        this.errorCause = errorCauseParam;
    }


    public List<ErrorObj> getErrorObjs() {
        return this.errorObjs;
    }


    public void setErrorObjs(final List<ErrorObj> errorObjsParam) {
        this.errorObjs = errorObjsParam;
    }

}
