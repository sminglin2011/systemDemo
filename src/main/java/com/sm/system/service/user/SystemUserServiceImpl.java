package com.sm.system.service.user;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sm.system.domain.user.SystemUser;
import com.sm.system.domain.user.UserRepository;
import com.sm.system.exception.MyException;
import com.sm.system.util.SystemUtil;

@Service("SystemUserServiceImpl")
public class SystemUserServiceImpl implements SystemUserService{
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name="UserRepository")
	private UserRepository repository;

	@Override
	public SystemUser findByUsername(String username) {
		log.debug("findByUsername=" + username);
		return repository.findByUsername(username);
	}

	@Override
	public List<SystemUser> findAll() {
		return repository.findAll();
	}

	@Override
	public SystemUser findOne(String id) {
		SystemUser user = repository.findOne(Integer.valueOf(id));
		if (user == null) user = new SystemUser();
		return user;
	}

	@Override
	public SystemUser saveUser(SystemUser user) throws MyException {
		if (user.getId() == null || user.getId() == 0) {
			try {
				if(user.getUsername().equals("sming")) {
					throw new MyException("Duplicate UserName");
				}
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_YEAR, 1);
				user.setExpired(SystemUtil.desEncrypt(SystemUtil.formatDate(calendar.getTime())));
				user = repository.save(user);
			} catch (RuntimeException e) {
				log.error(e.getLocalizedMessage());
				e.printStackTrace();
				if(e.getMessage().indexOf("[UK_") > 0) {
					throw new MyException("Duplicate UserName");
				} else {
					throw new MyException(e.getLocalizedMessage());
				}
			} catch (Exception e){
				throw new MyException(e.getLocalizedMessage());
			}
		}
		return user;
	}

}
