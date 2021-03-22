package cn.linstudy.mapper;

import cn.linstudy.domain.Notice;
import cn.linstudy.domain.NoticeEmployee;
import cn.linstudy.qo.NoticeQueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/20 14:16
 */

@Mapper
public interface NoticeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    List<Notice> selectForPage(@Param("LoginEmployeeId") Long LoginEmployeeId,
        @Param("qo") NoticeQueryObject qo);

    void insertRelative(Long CreateEmployeeId);

    void updateStatus(@Param("noticeId") Long noticeId, @Param("status") Integer status);

    void insertRelationship(@Param("noticeId") Long noticeId, @Param("employeeId") Long employeeId);

    List<NoticeEmployee> checkClick(@Param("noticeId") Long noticeId,
        @Param("employeeId") Long employeeId);

    int unReadNumber(Long employeeId);

    List<Notice> unReadNotice(Long employeeId);
}