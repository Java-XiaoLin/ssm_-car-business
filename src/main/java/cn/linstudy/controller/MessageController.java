package cn.linstudy.controller;

import cn.linstudy.domain.MessageBoard;
import cn.linstudy.qo.MessageReplyObject;
import cn.linstudy.service.MessageBoardService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/22 9:26
 */
@Controller
@RequestMapping("message")
public class MessageController {

  @Autowired
  MessageBoardService messageBoardService;

  @RequestMapping("list")
  public String list(MessageReplyObject qo, Model model) {
    PageInfo<MessageBoard> messageBoardPageInfo = messageBoardService.selectForPage(qo);
    model.addAttribute("pageInfo", messageBoardPageInfo);
    return "message/list";
  }

  @RequestMapping("messageForBoardId")
  public String messageBoardId(MessageReplyObject qo, Model model) {
    MessageBoard messageBoardInfo = messageBoardService.selectForBoardId(qo);
    model.addAttribute("messageBoardInfo", messageBoardInfo);
    return "message/show";
  }
}
