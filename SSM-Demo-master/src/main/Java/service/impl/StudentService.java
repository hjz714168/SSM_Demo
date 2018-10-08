package service.impl;

import dao.StudentDao;
import entity.Student;
import service.IStudentService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

@Service
public class StudentService implements IStudentService {
    private static final Logger LOG = LogManager.getLogger(StudentService.class);
    @Resource
    private StudentDao studentDao;

    //添加一个学生信息
    @Override
    public int addStudent() {
        Student param = new Student();
        param.setUid(123L);
        param.setName("test");
        param.setAge(18);
        return studentDao.addStudent(param);
    }

    //批量添加学生信息
    @Override
    public int addStudentList() {
        List<Student> addStudentList = new ArrayList<Student>();
        Student oneParam = new Student();
        oneParam.setUid(456L);
        oneParam.setName("test1");
        oneParam.setAge(18);
        addStudentList.add(oneParam);

        Student twoParam = new Student();
        twoParam.setUid(789L);
        twoParam.setName("test2");
        twoParam.setAge(19);
        addStudentList.add(twoParam);
        return studentDao.addStudentList(addStudentList);
    }

    //选择性添加学生信息（非空字段）
    @Override
    public int addStudentSelective() {
        Student param = new Student();
        param.setUid(7L);
        param.setName("test3");
        param.setAge(20);
        param.setClassid(null);
        return studentDao.addStudentSelective(param);
    }

    //选择性更新学生信息（根据传入字段更新）
    @Override
    public int updateByPrimaryKeySelective(Student student) {
        if (null == student) return -1;
        return studentDao.updateByPrimaryKeySelective(student);
    }

    //更新学生信息（所有字段）
    @Override
    public int updateByPrimaryKey(Student student) {
        if (null == student) return -1;
        return studentDao.updateByPrimaryKey(student);
    }

    //根据id删除一条数据
    @Override
    public int deleteByPrimaryKey(Long uid) {
        if (null == uid) return -1;
        return studentDao.deleteByPrimaryKey(uid);
    }

    //根据ids批量删除数据
    @Override
    public int deleteStudentListByIds(List<Long> ids) {
        if (null == ids || ids.size() == 0)
            return -1;
        return studentDao.deleteStudentListByIds(ids);
    }

    //根据id查询数据
    @Override
    public Student selectByPrimaryKey(Long uid) {
        if (null == uid) return null;
        return studentDao.selectByPrimaryKey(uid);
    }
}
