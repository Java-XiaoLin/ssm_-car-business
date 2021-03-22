package cn.linstudy.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * notice_employee实体类
 * 
 * @author 
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeEmployee {
	/**用户id*/
	private Employee employeeId;
	/**通知id*/
	private Notice noticeId;
	/**是否阅读*/
	private Boolean read;

	
}
