package cn.linstudy.service;

import cn.linstudy.domain.Appointment;
import cn.linstudy.qo.AppointmentQueryObject;
import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/14 14:42
 */

public interface AppointmentService{


    int deleteByPrimaryKey(Long id);

    int insert(Appointment record);

    int insertSelective(Appointment record);

    Appointment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Appointment record);

    int updateByPrimaryKey(Appointment record);

    PageInfo<Appointment> selectForPage(AppointmentQueryObject qo);

    /**
        * @Description:根据id修改为想要修改的状态
        * @author XiaoLin
        * @date 2021/3/16
        * @Param: [appointmentId, status]
        * @return void
        */
    void updateStatus(Long appointmentId, Integer status);
}
