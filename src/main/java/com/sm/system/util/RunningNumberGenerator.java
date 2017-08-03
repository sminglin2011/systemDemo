package com.sm.system.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunningNumberGenerator implements IdentifierGenerator {

    private static Logger log = LoggerFactory.getLogger(RunningNumberGenerator.class);

    public Serializable generate(SessionImplementor session, Object object)
            throws HibernateException {

        String prefix = "M";
        Connection connection = session.connection();
        try {

            PreparedStatement ps = connection
                    .prepareStatement("SELECT nextval ('seq_stock_code') as nextval");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("nextval");
                String code = prefix; // + StringUtils.leftPad("" + id,3, '0');
                log.debug("Generated Stock Code: " + code);
                return code;
            }

        } catch (SQLException e) {
            log.error(e.getLocalizedMessage());
            throw new HibernateException(
                    "Unable to generate Runing Number");
        }
        return null;
    }
}