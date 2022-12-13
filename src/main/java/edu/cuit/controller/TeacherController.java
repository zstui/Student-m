package edu.cuit.controller;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Teacher;
import edu.cuit.service.LoginUserService;
import edu.cuit.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/teacher/addtask")
    public ModelAndView toaddtask(){

      /*  Teacher user=teacherService.findBytnum(tnum);*/


        ModelAndView modelAndView = new ModelAndView();


       /* modelAndView.addObject("teacher",user);*/


        modelAndView.setViewName("task-add");




        return modelAndView;
    }

    @RequestMapping(value = "/teacher/addtask.action")
    @ResponseBody
    public String addtaskAction(Pubtask pubtask , HttpServletResponse response,HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession(true);
        Teacher teacher= (Teacher) session.getAttribute("teacher");
        pubtask.setTid(teacher.getTid());
        teacherService.insertPubtask(pubtask);
        response.getWriter().write("<script>alert('pubTaskSuccessed!');window.location='../pages/task-add.jsp'; </script>");
        return null;



    }
    @RequestMapping(value = "/teacher/deletetask.action")
    @ResponseBody
    public String deletetaskAction(@RequestParam("id") Integer id , HttpServletResponse response) throws Exception{

        teacherService.deteletPubtaskById(id);
        response.getWriter().write("<script>alert('Delete it already!');window.location='tasklist'; </script>");
        return null;



    }


    @RequestMapping(value = "/teacher/tasklist")
    public ModelAndView taskList( HttpServletRequest request){

        /*  Teacher user=teacherService.findBytnum(tnum);*/
        HttpSession session = request.getSession(true);
        Teacher teacher= (Teacher) session.getAttribute("teacher");

        List<Pubtask> pubtaskList =teacherService.FindAllPubtaskByTnum(teacher.getTid());

        ModelAndView modelAndView = new ModelAndView();


        modelAndView.addObject("pubtaskList",pubtaskList);


        modelAndView.setViewName("pubtask-list");




        return modelAndView;
    }


    /*@Autowired
    private AccountService accountService;

    //保存
    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account){
        accountService.save(account);
        return "保存成功";
    }*/

}
