package cn.linstudy.service.impl;

import cn.linstudy.domain.MessageBoard;
import cn.linstudy.mapper.MessageBoardMapper;
import cn.linstudy.qo.MessageReplyObject;
import cn.linstudy.service.MessageBoardService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/22 9:15
 */

@Service
public class MessageBoardServiceImpl implements MessageBoardService {

  @Autowired
  private MessageBoardMapper messageBoardMapper;

  @Override
  public int deleteByPrimaryKey(Long id) {
    return messageBoardMapper.deleteByPrimaryKey(id);
  }

  @Override
  public int insert(MessageBoard record) {
    return messageBoardMapper.insert(record);
  }

  @Override
  public int insertSelective(MessageBoard record) {
    return messageBoardMapper.insertSelective(record);
  }

  @Override
  public MessageBoard selectByPrimaryKey(Long id) {
    return messageBoardMapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateByPrimaryKeySelective(MessageBoard record) {
    return messageBoardMapper.updateByPrimaryKeySelective(record);
  }

  @Override
  public int updateByPrimaryKey(MessageBoard record) {
    return messageBoardMapper.updateByPrimaryKey(record);
  }

  @Override
  public PageInfo<MessageBoard> selectForPage(MessageReplyObject qo) {
    PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());
    return new PageInfo<MessageBoard>(messageBoardMapper.selectForPage(qo));
  }

  @Override
  public MessageBoard selectForBoardId(MessageReplyObject qo) {
    return messageBoardMapper.selectForBoardId(qo);
  }

}
