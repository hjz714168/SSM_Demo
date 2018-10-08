package vo;

import java.util.List;

import entity.Student;
import entity.StudentClass;

/**
 * 一对多VO类
 */
public class StudentClassVO extends StudentClass {
   private Long Uid; //学生表id
   private String Name;//学生昵称
   private int Age;//学生年龄
   private Long classIds;//学生对应的班级

    public Long getUid() {
        return Uid;
    }

    public void setUid(Long uid) {
        Uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Long getClassIds() {
        return classIds;
    }

    public void setClassIds(Long classIds) {
        this.classIds = classIds;
    }
}
