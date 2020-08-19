package com.ldh.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

/**
 * StdEmp
 */
@Entity // JPA
@Table(name = "std_emp") // JPA
public class StdEmp {

    @Id
    private BigDecimal id;
    @NotBlank(message = "姓名不能为空！")
    @Column(name = "name")
    private String name;
    @Range(min = 1, max = 130, message = "年龄超出范围！") // 被注释的元素必须在合适的范围内
    private Integer age;
    @NotBlank(message = "性别不能为空！")
    private String sexname;
    @NotBlank(message = "地址不能为空")
    private String address;
    @NotEmpty(message = "联系电话不能为空！") // 被注释的字符串必须非空
    private String phone;

    /**
     * @return the id
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the sexname
     */
    public String getSexname() {
        return sexname;
    }

    /**
     * @param sexname the sexname to set
     */
    public void setSexname(String sexname) {
        this.sexname = sexname;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", sexname=").append(sexname);
        sb.append(", address=").append(address);
        sb.append(", phone=").append(phone);
        sb.append("]");
        return sb.toString();
    }



}