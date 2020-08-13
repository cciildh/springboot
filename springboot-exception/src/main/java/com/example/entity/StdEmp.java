package com.example.entity;

import javax.validation.constraints.NotBlank;

/**
 * Emp
 */
public class StdEmp {

    private int empId;
    @NotBlank(message="姓名不能为空")
    private String empName;
    @NotBlank(message="性别不能为空")
    private String empSex;

    /**
     * @return the empId
     */
    public int getEmpId() {
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
    public void setEmpId(int empId) {
        this.empId = empId;
    }


    
}