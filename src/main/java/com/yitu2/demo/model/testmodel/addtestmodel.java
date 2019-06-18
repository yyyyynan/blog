package com.yitu2.demo.model.testmodel;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class addtestmodel {
    int pid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    String personid;

    public addtestmodel(String personid){
        this.personid = personid;
    }
}
