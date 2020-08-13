package com.ldh.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

/**
 * StdEmp
 */
public class StdEmp {

    private Integer id;
    @NotBlank(message = "姓名不能为空！")
    private String name;
    @Range(min = 1, max = 130, message = "年龄超出范围！") // 被注释的元素必须在合适的范围内
    private Integer age;
    @NotBlank(message = "性别不能为空！")
    private String sexname;
    @NotBlank(message = "地址不能为空")
    private String address;
    @NotEmpty(message = "联系电话不能为空！") // 被注释的字符串必须非空
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSexname() {
        return sexname;
    }

    public void setSexname(String sexname) {
        this.sexname = sexname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

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