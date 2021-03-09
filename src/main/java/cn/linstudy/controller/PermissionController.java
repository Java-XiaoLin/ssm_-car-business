package cn.linstudy.controller;


import cn.linstudy.domain.Permission;
import cn.linstudy.qo.PermissionQueryObject;
import cn.linstudy.qo.response.ResponseResult;
import cn.linstudy.service.PermissionService;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/8 21:31
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

  @Autowired
  PermissionService permissionService;

  @RequestMapping("list")
  public String listAll(PermissionQueryObject qo, Model model){
    PageInfo<Permission> pageInfo = permissionService.selectForPage(qo);
    model.addAttribute("pageInfo",pageInfo);
    return "permission/list";
  }

  @RequestMapping("reload")
  @ResponseBody
  public ResponseResult reload(){
    // 加载所有权限
    permissionService.reload();
    return new ResponseResult(true,"加载成功");
  }
}
