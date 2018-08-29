package com.neuedu.controller;

import com.neuedu.entity.Dept;
import com.neuedu.entity.Emp;
import com.neuedu.service.DeptService;
import com.neuedu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/emp")
public class EmpController {
    @Autowired
    EmpService empService;
    @Autowired
    DeptService deptService;

    @RequestMapping(value = "/find")
    public ModelAndView findEmp(ModelAndView modelAndView){
        List<Emp> emps = empService.selectAll();
        modelAndView.addObject("empList",emps);
        modelAndView.setViewName("emp");
        return modelAndView;
    }
    /*将JSON字符串传到前端*/
    @RequestMapping(value = "/findjson")
    public @ResponseBody List<Emp> findJson(){
        List<Emp> emps = empService.selectAll();
        return emps;
    }

    @RequestMapping(value = "/add",method=RequestMethod.GET)
    public ModelAndView addEMp(ModelAndView modelAndView){

        List<Dept> depts = deptService.selectAll();
        List<Emp> emps = empService.selectAll();
        modelAndView.addObject("depts",depts);
        modelAndView.addObject("empList",emps);
        modelAndView.addObject("emp",new Emp());
        modelAndView.setViewName("addemp");

        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addEMp(@Valid Emp emp, BindingResult bindingResult, MultipartFile upload) {

        if(bindingResult.hasErrors()){
            return "addemp";
        }
        //处理图片
        //原始名称
       String originalFilename = upload.getOriginalFilename();
        String url=null;
        //上传图片
        if (upload != null && originalFilename != null && originalFilename.length() > 0) {
            //存储图片的物理路径
            String pic_path = "F:/img/";
            //新的图片名称
            String newFileName = UUID.randomUUID() +
                    originalFilename.substring(originalFilename.lastIndexOf("."));
            //新图片
            File newFile = new File(pic_path + newFileName);
            //将内存中的数据写入磁盘
            try {
                upload.transferTo(newFile);
                //图片路径
                url = "http://localhost:8080/uploadpic/" + newFileName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        emp.setUrl(url);
        empService.insert(emp);
        return "forward:/emp/find";

    }


    /*删除*/
    @RequestMapping(value = "delete/{empno}")
    public String deleteEmp(@PathVariable("empno") Integer empno){
        empService.deleteByPrimaryKey(empno);
        return "redirect:/emp/find";
    }

    /*修改*/
    @RequestMapping(value = "update/{empno}",method = RequestMethod.GET)
    public String update(Model model,@PathVariable("empno") Integer empno){
        Emp emp = empService.selectByPrimaryKey(empno);
        List<Emp> emps = empService.selectAll();
        List<Dept> depts = deptService.selectAll();
        model.addAttribute("emp",emp);
        model.addAttribute("empList",emps);
        model.addAttribute("depts",depts);
        return "update";
    }


    @RequestMapping(value = "update/{empno}",method = RequestMethod.POST)
    public String update(@PathVariable("empno") Integer empno,@Valid Emp emp,MultipartFile upload) {

        //处理图片
        //原始名称
        String originalFilename = upload.getOriginalFilename();
        String url=null;
        //上传图片
        if (upload != null && originalFilename != null &&
                originalFilename.length() > 0) {
            //存储图片的物理路径
            String pic_path = "F:/img/";
            //新的图片名称
            String newFileName = UUID.randomUUID() +
                    originalFilename.substring(originalFilename.lastIndexOf("."));
            //新图片
            File newFile = new File(pic_path + newFileName);
            //将内存中的数据写入磁盘
            try {
                upload.transferTo(newFile);
                //图片路径
                url = "http://localhost:8080/uploadpic/" + newFileName;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            emp.setEmpno(empno);
            emp.setUrl(url);
            empService.update(emp);

            return "redirect:/emp/find";


    }


}
