package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import entity.Student;
import service.IStudentClassService;
import service.IStudentService;
import vo.StudentClassVO;

@RestController
public class StudentController {
  private static final Logger LOG =LogManager.getLogger(StudentController.class);

    @Resource
    private IStudentService studentService;

    @Resource
    private IStudentClassService studentClassService;

  @Description("添加一个学生")
  @PostMapping("/addStudent")
  public int student(){
     return studentService.addStudent();
  }

  @Description("批量添加学生")
  @PostMapping("/addStudentList")
  public int studentList(){
   return studentService.addStudentList();
  }

  @Description("选择性添加学生信息（非空字段）")
  @PostMapping("/selective")
  public int addStudentSelective(){
      return studentService.addStudentSelective();
  }

  /**
  * 2018/8/8 20:57
  * url : localhost:8080/updateStudent
   * body:
   * {
   * 	"uid":123,
   * 	"age":8,
   * 	"name":"测试更新"
   * }
  */
    @Description("选择性更新学生信息（根据传入字段更新）")
    @PostMapping("/updateStudent")
    public int updateByPrimaryKeySelective(@RequestBody Student student) {
        if (null == student) return -1;
        return studentService.updateByPrimaryKeySelective(student);
    }


    /**
    *  url: localhost:8080/updateStudentById
     * body:
     * {
     * 	"uid":123,
     * 	"age":23,
     * 	"name":"测试更新2",
     * 	"classid":666
     * }
    */
    @Description("更新学生信息（所有字段")
    @PostMapping("/updateStudentById")
    public int updateByPrimaryKey(@RequestBody Student student) {
        if (null == student) return -1;
        return studentService.updateByPrimaryKey(student);
    }


    /**
    * url : localhost:8080/deleteStudentById/123
    */
    @Description("根据id删除数据")
    @DeleteMapping("/deleteStudentById/{uid}")
    public int deleteByPrimaryKey(@PathVariable("uid") Long uid) {
        if (null == uid) return -1;
        return studentService.deleteByPrimaryKey(uid);
    }

    /**
    * localhost:8080/deleteStudentListByIds?ids=789&ids=7
    */
    @Description("根据ids批量删除数据")
    @DeleteMapping("/deleteStudentListByIds")
    public int deleteStudentListByIds(@RequestParam("ids")List<Long>ids){
        return studentService.deleteStudentListByIds(ids);
    }


    @Description("根据id查询数据")
    @GetMapping("/findStudentById")
    public Student selectByPrimaryKey(@RequestParam("uid") Long uid) {
        if (null == uid) return null;
        return studentService.selectByPrimaryKey(uid);
    }

    @Description("一对多查询班级下的学生信息")
    @GetMapping("/query")
    public List<StudentClassVO>studentDetailList(){
       LOG.info("调用查询接口");
        return studentClassService.queryStudentDetail();
    }
}
