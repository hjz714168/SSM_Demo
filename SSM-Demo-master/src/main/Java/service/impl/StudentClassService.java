package service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

import dao.StudentClassDao;
import service.IStudentClassService;
import vo.StudentClassVO;


@Service
public class StudentClassService implements IStudentClassService {
    private static final Logger LOG = LogManager.getLogger(StudentClassService.class);
    @Resource
    private StudentClassDao studentClassDao;

    @Override
    public List<StudentClassVO> queryStudentDetail() {
        return studentClassDao.queryStudentDetail();
    }
}
