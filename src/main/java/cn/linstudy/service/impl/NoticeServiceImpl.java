package cn.linstudy.service.impl;

import cn.linstudy.domain.NoticeEmployee;
import cn.linstudy.qo.NoticeQueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.linstudy.domain.Notice;
import cn.linstudy.mapper.NoticeMapper;
import cn.linstudy.service.NoticeService;
/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/20 14:16
 */

@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Notice record) {
        return noticeMapper.insert(record);
    }

    @Override
    public void insertSelective(Long employeeId,Notice notice) {
        noticeMapper.insertSelective(notice);
//        noticeMapper.insertRelative(employeeId);
    }

    @Override
    public Notice selectByPrimaryKey(Long id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Notice record) {
        return noticeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Notice record) {
        return noticeMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Notice> selectForPage(Long LoginEmployeeId,NoticeQueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        return new PageInfo<Notice>(noticeMapper.selectForPage(LoginEmployeeId,qo));
    }

    @Override
    public void updateStatus(Long noticeId, Integer status) {
        noticeMapper.updateStatus(noticeId,status);
    }

    @Override
    public void insertRelationship(Long noticeId, Long employeeId) {
        noticeMapper.insertRelationship( noticeId,employeeId);
    }

    @Override
    public List<NoticeEmployee> checkClick(Long noticeId, Long employeeId) {
        return noticeMapper.checkClick(noticeId,employeeId);
    }

    @Override
    public Notice readNotice(Long noticeId) {
        return noticeMapper.selectByPrimaryKey(noticeId);
    }

    @Override
    public int unReadNumber(Long employeeId) {
        return noticeMapper.unReadNumber(employeeId);
    }

    @Override
    public List<Notice> unReadNotice(Long employeeId) {
        return noticeMapper.unReadNotice(employeeId);
    }

}
