package cn.linstudy.service;

import cn.linstudy.domain.Notice;
import cn.linstudy.domain.NoticeEmployee;
import cn.linstudy.qo.NoticeQueryObject;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/20 14:16
 */

public interface NoticeService{


    int deleteByPrimaryKey(Long id);

    int insert(Notice notice);

    void insertSelective(Long employeeId,Notice notice);

    Notice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Notice notice);

    int updateByPrimaryKey(Notice notice);

    PageInfo<Notice> selectForPage(Long LoginEmployeeId,NoticeQueryObject qo);

    void updateStatus(Long noticeId, Integer status);

    void insertRelationship(Long noticeId,Long employeeId);

    List<NoticeEmployee> checkClick(Long noticeId, Long employeeId);

    Notice readNotice(Long noticeId);

    int unReadNumber(Long employeeId);

    List<Notice> unReadNotice(Long employeeId);
}
