package cn.linstudy.service;

import cn.linstudy.domain.MessageBoard;
import cn.linstudy.qo.MessageReplyObject;
import com.github.pagehelper.PageInfo;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/22 9:15
 */

public interface MessageBoardService {


  int deleteByPrimaryKey(Long id);

  int insert(MessageBoard record);

  int insertSelective(MessageBoard record);

  MessageBoard selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(MessageBoard record);

  int updateByPrimaryKey(MessageBoard record);

  PageInfo<MessageBoard> selectForPage(MessageReplyObject qo);

  MessageBoard selectForBoardId(MessageReplyObject qo);
}
