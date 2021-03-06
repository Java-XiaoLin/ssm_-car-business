package cn.linstudy.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.linstudy.domain.Appointment;
import cn.linstudy.domain.Employee;
import cn.linstudy.enums.ConsumptionEnum;
import cn.linstudy.mapper.AppointmentMapper;
import cn.linstudy.qo.ConsumptionQueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.sql.Connection;
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.linstudy.domain.Consumption;
import cn.linstudy.mapper.ConsumptionMapper;
import cn.linstudy.service.ConsumptionService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Description 
 * @Author  XiaoLin
 * @Date  2021/3/16 11:26
 */

@Service
public class ConsumptionServiceImpl implements ConsumptionService{

    @Autowired
    private ConsumptionMapper consumptionMapper;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return consumptionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Consumption record) {
        return consumptionMapper.insert(record);
    }

    @Override
    public int insertSelective(Consumption record) {
        return consumptionMapper.insertSelective(record);
    }

    @Override
    public Consumption selectByPrimaryKey(Long consumptionId) {
        return consumptionMapper.selectByPrimaryKey(consumptionId);
    }

    @Override
    public int updateByPrimaryKeySelective(Consumption record) {
        return consumptionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Consumption record) {
        return consumptionMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Consumption> selectForPage(ConsumptionQueryObject qo) {
        PageHelper.startPage(qo.getCurrentPage(),qo.getPageSize());
        return new PageInfo<Consumption>(consumptionMapper.selectForPage(qo));
    }

    @Override
    public Consumption createConsumption(String ano) {
        Date now = new Date();
        // ?????????????????????????????????????????????
        Appointment appointment = appointmentMapper.selectByAno(ano);
        // ???????????????
        Consumption consumption = new Consumption();
        // ???????????????????????????
       consumption.setCno(DateUtil.format(now,"yyyyMMdd")+ RandomUtil.randomNumbers(5));
       // ????????????????????????????????????
        consumption.setStatus(ConsumptionEnum.CONSUME.getValue());
        // ??????????????????
        consumption.setCustomerName(appointment.getContactName());
        // ?????????????????????
        consumption.setCustomerTel(appointment.getContactTel());
        // ????????????????????????
        consumption.setAppointmentAno(ano);
        // ??????????????????
        consumption.setCheckinTime(appointment.getCreateTime());
        // ??????????????????
      consumption.setBusinessId(appointment.getBusiness().getId());
        consumption.setBusiness(appointment.getBusiness());
        // ??????????????????
        consumption.setCreateTime(now);
        // ????????????????????????????????????
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        consumption.setCreateEmployee((Employee) attrs.getRequest().getSession().getAttribute("EMPLOYEE_IN_SESSION"));
        // ??????????????????????????????????????????
        consumptionMapper.insert(consumption);
        // ??????1?????????????????????
        return consumption;

    }

}
