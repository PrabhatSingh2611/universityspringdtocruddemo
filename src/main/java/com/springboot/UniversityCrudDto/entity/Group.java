package com.springboot.UniversityCrudDto.entity;



import javax.persistence.*;

@Entity
@Table(name ="group")
public class Group {
    @Id
    @Column(name = "grp_id", nullable = false)
    private Long groupId;

    @Column(name = "grp_name")
    private String groupName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id_fk", referencedColumnName = "dept_id", nullable = false)
    private Department department;

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
        this.department = department;
    }

    public Group(Long groupIdToUpdate, String groupName) {
    }

    public Group(String groupName, Department department) {
    }


    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }



    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", department=" + department +
                '}';
    }
}