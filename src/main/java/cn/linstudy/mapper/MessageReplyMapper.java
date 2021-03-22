package cn.linstudy.mapper;

import cn.linstudy.domain.MessageReply;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/22 9:21
 */

@Mapper
public interface MessageReplyMapper {

  int deleteByPrimaryKey(Long id);

  int insert(MessageReply record);

  int insertSelective(MessageReply record);

  MessageReply selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(MessageReply record);

  int updateByPrimaryKey(MessageReply record);

}