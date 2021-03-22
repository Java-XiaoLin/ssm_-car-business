package cn.linstudy.mapper;

import cn.linstudy.domain.MessageBoard;
import cn.linstudy.qo.MessageReplyObject;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/22 9:15
 */

@Mapper
public interface MessageBoardMapper {

  int deleteByPrimaryKey(Long id);

  int insert(MessageBoard record);

  int insertSelective(MessageBoard record);

  MessageBoard selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(MessageBoard record);

  int updateByPrimaryKey(MessageBoard record);

  List<MessageBoard> selectForPage(MessageReplyObject qo);

  MessageBoard selectForBoardId(MessageReplyObject qo);
}