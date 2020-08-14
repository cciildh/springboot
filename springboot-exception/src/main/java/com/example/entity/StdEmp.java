package com.example.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Emp
 */
public class StdEmp {

    @NotNull( message="empId不能为空！")
    @Min(value=1,message="必须大于1")
    //注意最好不要使用int 
    private Integer empId;
    @NotBlank(message="姓名不能为空")
    private String empName;
    @NotBlank(message="性别不能为空")
    private String empSex;

    /**
     * @return the empId    
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * @return the empSex
     */
    public String getEmpSex() {
        return empSex;
    }

    /**
     * @param empSex the empSex to set
     */
    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    /**
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }


    
}