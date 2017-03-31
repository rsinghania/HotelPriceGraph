package com.markit.cds.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @author anurag.arya
 *
 */
@Service
public abstract class ModifiableCommonJDBCDao {

    protected abstract NamedParameterJdbcTemplate getJdbcTemplate();

    public static final String ASOF = "asof";

    /**
     * Executes the given query
     * 
     * @param query
     */
    protected int update(String query, Map<String, String> params) {
	return getJdbcTemplate().update(query, params);
    }
    
    protected List<Map<String, Object>> queryForList(String query) {
	return getJdbcTemplate().queryForList(query, new HashMap<>());
	
    }

    /**
     * @param rs
     * @return
     * @throws SQLException
     */
    protected Double getValueOrNull(ResultSet rs, String column) throws SQLException {
	return rs.getObject(column) != null ? rs.getDouble(column) : null;
    }

    /**
     * @param rs
     * @return
     * @throws SQLException
     */
    protected Integer getIntegerOrNull(ResultSet rs, String column) throws SQLException {
	return rs.getObject(column) != null ? rs.getInt(column) : null;
    }

    /**
     * @param rs
     * @return
     * @throws SQLException
     */
    protected Long getLongOrNull(ResultSet rs, String column) throws SQLException {
	return rs.getObject(column) != null ? rs.getLong(column) : null;
    }
}
