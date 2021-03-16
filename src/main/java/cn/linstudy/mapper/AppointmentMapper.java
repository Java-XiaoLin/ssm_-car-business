package cn.linstudy.mapper;

import cn.linstudy.domain.Appointment;
import cn.linstudy.qo.AppointmentQueryObject;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author XiaoLin
 * @Date 2021/3/14 14:42
 */

@Mapper
public interface AppointmentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Appointment record);

    int insertSelective(Appointment record);

    Appointment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Appointment record);

    int updateByPrimaryKey(Appointment record);

    List<Appointment> selectForPage(AppointmentQueryObject qo);

    void updateStatus(@Param("appointmentId") Long appointmentId, @Param("status") Integer status);
}