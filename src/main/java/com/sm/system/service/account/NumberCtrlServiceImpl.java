package com.sm.system.service.account;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sm.system.constant.StaticParams;
import com.sm.system.domain.NumberCtrl;
import com.sm.system.domain.NumberCtrlRepository;
import com.sm.system.exception.MyException;
import com.sm.system.util.SystemUtil;
@Service("NumberCtrlService")
public class NumberCtrlServiceImpl implements NumberCtrlService{
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	private final ReentrantLock lock = new ReentrantLock();

	@Resource(name="NumberCtrlRepository")
	private NumberCtrlRepository repository;
	
	@Override
	public String getNextNo(String voucherType, Date voucherDate) throws MyException {
		String nextId = "";
		NumberCtrl ctrl = null;
		lock.lock();
		try {
			String pattern = SystemUtil.formatDate(voucherDate, StaticParams.DATEFORMAT_YYYY);
			ctrl = repository.findByPrefixAndPattern(voucherType, pattern);
			if (ctrl == null) {
				ctrl = new NumberCtrl();
				ctrl.setPrefix(voucherType);
				ctrl.setPattern(pattern);
				ctrl.setLength(4);
				ctrl.setCurrentNumber(0);
				repository.save(ctrl);
			}
			ctrl.setCurrentNumber(ctrl.getCurrentNumber()+1);
			repository.save(ctrl);
			nextId = voucherType.toUpperCase() + pattern + String.valueOf((ctrl.getCurrentNumber()));
			return nextId;
		} catch (ParseException e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
			throw new MyException(e.getMessage());
		} finally {
			lock.unlock();
		}
	}

}
