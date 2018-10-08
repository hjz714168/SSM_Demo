package service;

import java.util.List;

import entity.Student;

public interface IStudentService {
    //添加一个学生信息
    int addStudent();

    //批量添加学生信息
    int addStudentList();

    //选择性添加学生信息（非空字段）
    int addStudentSelective();

    //选择性更新学生信息（根据传入字段更新）
    int updateByPrimaryKeySelective(Student record);

    //更新学生信息（所有字段）
    int updateByPrimaryKey(Student record);

    //根据id删除一条数据
    int deleteByPrimaryKey(Long uid);

    //根据ids批量删除数据
    int deleteStudentListByIds(List<Long>ids);

    //根据id查询数据
    Student selectByPrimaryKey(Long uid);
}
