package com.sm.system.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.exception.spi.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunningNumberGenerator implements IdentifierGenerator, Configurable {

	@Override
	public void configure(Properties properties) throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}