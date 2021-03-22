package cn.linstudy.service;

import cn.linstudy.domain.MessageReply;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/22 9:21
 */

public interface MessageReplyService {


  int deleteByPrimaryKey(Long id);

  int insert(MessageReply record);

  int insertSelective(MessageReply record);

  MessageReply selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(MessageReply record);

  int updateByPrimaryKey(MessageReply record);

}
