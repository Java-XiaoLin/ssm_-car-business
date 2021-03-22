package cn.linstudy.service.impl;

import cn.linstudy.domain.MessageReply;
import cn.linstudy.mapper.MessageReplyMapper;
import cn.linstudy.service.MessageReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/22 9:21
 */

@Service
public class MessageReplyServiceImpl implements MessageReplyService {

  @Autowired
  private MessageReplyMapper messageReplyMapper;

  @Override
  public int deleteByPrimaryKey(Long id) {
    return messageReplyMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(MessageReply record) {
    return messageReplyMapper.insert(record);
  }

  @Override
  public int insertSelective(MessageReply record) {
    return messageReplyMapper.insertSelective(record);
  }

  @Override
  public MessageReply selectByPrimaryKey(Long id) {
    return messageReplyMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateByPrimaryKeySelective(MessageReply record) {
    return messageReplyMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByPrimaryKey(MessageReply record) {
    return messageReplyMapper.updateByPrimaryKey(record);
  }


}
