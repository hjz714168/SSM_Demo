package dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import entity.Student;

@Repository
public interface StudentDao {

    //添加一个学生信息
    int addStudent(@Param("student") Student student);

    //批量添加学生信息
    int addStudentList(@Param("studentList") List<Student> studentList);

    //选择性添加学生信息（非空字段）
    int addStudentSelective(@Param("student") Student student);

    //选择性更新学生信息（根据传入字段更新）
    int updateByPrimaryKeySelective(@Param("student") Student student);

    //更新学生信息（所有字段）
    int updateByPrimaryKey(@Param("student") Student student);

    //根据id删除一条数据
    int deleteByPrimaryKey(Long uid);

    //根据ids批量删除数据
    int deleteStudentListByIds(@Param("ids") List<Long>ids);

    //根据id查询数据
    Student selectByPrimaryKey(Long uid);


}