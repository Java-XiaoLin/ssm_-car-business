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
        // 根据预约单的流水查出预约单信息
        Appointment appointment = appointmentMapper.selectByAno(ano);
        // 生成消费单
        Consumption consumption = new Consumption();
        // 设置消费单的流水号
       consumption.setCno(DateUtil.format(now,"yyyyMMdd")+ RandomUtil.randomNumbers(5));
       // 设置消费单的状态为待结算
        consumption.setStatus(ConsumptionEnum.CONSUME.getValue());
        // 设置顾客姓名
        consumption.setCustomerName(appointment.getContactName());
        // 设置顾客的电话
        consumption.setCustomerTel(appointment.getContactTel());
        // 关联预约单流水号
        consumption.setAppointmentAno(ano);
        // 设置进店时间
        consumption.setCheckinTime(appointment.getCreateTime());
        // 设置消费门店
      consumption.setBusinessId(appointment.getBusiness().getId());
        consumption.setBusiness(appointment.getBusiness());
        // 设置创建时间
        consumption.setCreateTime(now);
        // 设置当前登录用户为创建人
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        consumption.setCreateEmployee((Employee) attrs.getRequest().getSession().getAttribute("EMPLOYEE_IN_SESSION"));
        // 在将设置好的消费单存入数据库
        consumptionMapper.insert(consumption);
        // 返回1创建好的消费单
        return consumption;

    }

}
