package cn.linstudy.controller;

import cn.linstudy.domain.Business;
import cn.linstudy.qo.BusinessQueryObject;
import cn.linstudy.service.BusinessService;
import cn.linstudy.utils.FileUploadUtil;
import com.github.pagehelper.PageInfo;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 门店管理控制器
 * @Author XiaoLin
 * @Date 2021/3/13 14:02
 */
@Controller
@RequestMapping("/business")
public class BusinessController {

  @Autowired
  BusinessService businessService;

  /**
      * @Description:查询所有门店
      * @author XiaoLin
      * @date 2021/3/14
      * @Param: [qo, model]
      * @return java.lang.String
      */
  @RequestMapping("list")
  public String listAll(@ModelAttribute("qo") BusinessQueryObject qo, Model model){
    PageInfo<Business> businessPageInfo = businessService.selectForPage(qo);
    model.addAttribute("pageInfo",businessPageInfo);
    return "/business/list";
  }

/**
    * @Description:增加或者删除门店
    * @author XiaoLin
    * @date 2021/3/14
    * @Param: [id, model]
    * @return java.lang.String
    */
  @RequestMapping("saveOrUpdate")
  public String saveOrUpdate(Long id,Model model){
    // id不为空说明是编辑，根据id查询门店，放进model对象中
    if (id != null){
      model.addAttribute("business",businessService.selectByPrimaryKey(id));
    }
    // 否则就直接跳转
    return "/business/input";
  }

  // 为获取真实路径用
  @Autowired
  ServletContext servletContext;
    /**
        * @Description:修改/增加门店
        * @author XiaoLin
        * @date 2021/3/14
        * @Param: [business]
        * @return java.lang.String
        */
    @RequestMapping("updateAndSave")
    public String update(Business business , MultipartFile file) throws Exception {
      if (business.getId() != null){
        // 说明文件不为空，那么就上传营业执照
        if (file != null && file.getSize() >0){
          // 获得webapp的真实路径
          String realPath = servletContext.getRealPath("/");
          // 我们在编辑图片之前，要先看看该公司是否拥有过图片，如果有先删除
          if (StringUtils.hasText(business.getLicenseImg())){
            String deletePath = realPath + business.getLicenseImg();
            FileUploadUtil.deleteFile(deletePath);
          }
          String filePath = FileUploadUtil.uploadFile(file, realPath);
          business.setLicenseImg(filePath);
        }
        businessService.updateByPrimaryKeySelective(business);
        return "redirect:/business/list";
      }else {
        if (file != null && file.getSize()>0){
          String realPath = servletContext.getRealPath("/");
          String filePath = FileUploadUtil.uploadFile(file, realPath);
          business.setLicenseImg(filePath);
        }
        businessService.insertSelective(business);
        return "redirect:/business/list";
      }
    }

    @RequestMapping("toInput")
  public String toInput(){
      return "/business/input";
    }

}
