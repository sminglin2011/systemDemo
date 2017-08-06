//package com.sm.system.util;
//
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//import javax.annotation.Resource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import com.sm.system.domain.NumberCtrl;
//import com.sm.system.domain.NumberCtrlRepository;
//import com.sm.system.domain.number.SystemSerialNumberRepository;
//import com.sm.system.exception.MyException;
//@Component
//public class NumberUtil {
//	
//	private final Logger log = LoggerFactory.getLogger(getClass());
//	
//	@Resource(name="NumberCtrlRepository")
//	private NumberCtrlRepository repository; 
//	
//	/** 生成器锁 */
//    private final ReentrantLock lock = new ReentrantLock();
//	
//	public String getNextNumber(String prefix, String pattern) throws MyException{
//		String documentNumber = "";
//		lock.lock();
//		try {
//			NumberCtrl numberCtrl = repository.findByPrefixAndPattern(prefix, pattern);
//			if(numberCtrl == null) {
//				numberCtrl = new NumberCtrl();
//				numberCtrl.setCurrentNumber(0);
//				numberCtrl.setLength(6);
//				numberCtrl.setPrefix(prefix);
//				numberCtrl.setPattern(pattern);
//				numberCtrl = repository .save(numberCtrl);
//			}
//			numberCtrl.setCurrentNumber(numberCtrl.getCurrentNumber()+1);
//			numberCtrl = repository.save(numberCtrl);
//			documentNumber = prefix + pattern + String.format("%0"+numberCtrl.getLength()+"d", numberCtrl.getCurrentNumber());
//			log.debug("............getNextNumber=" + documentNumber + "......................");
//		} finally {
//			lock.unlock();
//		}
//		return documentNumber;
//	}
//
//	public int updateAndGetCurrentSeq(int numberId) {
//		  StringBuffer updateHql = new StringBuffer(
//		    "update Sys_Seq_Max set "
//		      + "max_No = (case when to_char(last_Date,'yyyyMMdd')=to_char(sysdate,'yyyyMMdd') then max_No + 1 "
//		      + "else 1 end ),last_date = sysdate where 1=1 and number_Id = :numberId");
//		  // 更新SysSeqMax表中的相关记录
//		  Query query = this.getSession().createSQLQuery(updateHql.toString());
//		  query.setParameter("numberId", new Integer(numberId));
//		  int updateRows = query.executeUpdate();
//		  /* 得到当前的序列号 start */
//		  SysSeqMax sysSeqMax = (SysSeqMax) this.get(SysSeqMax.class,
//		    new Integer(numberId));
//		  int currentNumb = -1;
//		  if (sysSeqMax == null) {
//		   // 表中没有相应记录，则生成一条，序列号为1
//		   currentNumb = 1;
//		   sysSeqMax = new SysSeqMax();
//		   sysSeqMax.setNumberId(numberId);
//		   sysSeqMax.setMaxNo(currentNumb);
//		   sysSeqMax.setLastDate(new Date());
//		   this.save(sysSeqMax);
//		  } else {
//		   if (updateRows == 0) {// 更新的行数为0,表示序列号没有更新
//		    currentNumb = 1;
//		    sysSeqMax.setNumberId(numberId);
//		    sysSeqMax.setMaxNo(currentNumb);
//		    sysSeqMax.setLastDate(new Date());
//		    this.save(sysSeqMax);
//		   }
//		   // 表中有记录，就得到序列号
//		   currentNumb = sysSeqMax.getMaxNo();
//		  }
//		  // 不加这段的话在同一session中调用该方法批量生成同类序列号时会返回一样的序列号
//		  this.getHibernateTemplate().flush();
//		  this.getHibernateTemplate().evict(sysSeqMax);
//		  if (currentNumb == -1) {
//		   throw new DAOException("错误的顺序号");
//		  }
//		  /* 得到当前的序列号 end */
//		  return currentNumb;
//		 }
//}
