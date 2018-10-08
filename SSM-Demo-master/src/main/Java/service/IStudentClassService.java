package service;

import java.util.List;

import vo.StudentClassVO;

public interface IStudentClassService {
    //查询学生明细
    List<StudentClassVO> queryStudentDetail();
}
