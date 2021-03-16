package cn.linstudy.service.impl;

import cn.linstudy.qo.AppointmentQueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.linstudy.mapper.AppointmentMapper;
import cn.linstudy.domain.Appointment;
import cn.linstudy.service.AppointmentService;
/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/14 14:42
 */

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return appointmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Appointment record) {
        return appointmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Appointment record) {
        return appointmentMapper.insertSelective(record);
    }

    @Override
    public Appointment selectByPrimaryKey(Long id) {
        return appointmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Appointment record) {
        return appointmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Appointment record) {
        return appointmentMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Appointment> selectForPage(AppointmentQueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        return new PageInfo<Appointment>(appointmentMapper.selectForPage(qo));
    }

    /**
        * @Description:根据id修改为想要修改的状态
        * @author XiaoLin
        * @date 2021/3/16
        * @Param: [appointmentId, status]
        * @return void
        */
    @Override
    public void updateStatus(Long appointmentId, Integer status) {
        appointmentMapper.updateStatus(appointmentId,status);
    }

}
