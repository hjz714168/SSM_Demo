package dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import vo.StudentClassVO;

@Repository
public interface StudentClassDao {

    //查询学生明细
    List<StudentClassVO> queryStudentDetail();
}