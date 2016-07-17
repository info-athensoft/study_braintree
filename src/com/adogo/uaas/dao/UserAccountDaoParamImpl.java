package com.adogo.uaas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.adogo.uaas.entity.UserAccount;

@Component
@Qualifier("userAccountDaoParamImpl")
public class UserAccountDaoParamImpl implements UserAccountDao {

	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public List<UserAccount> find() {
		String sql = "select * from user_account";		
		return jdbc.query(sql, new UserAccountRowMapper());
	}

	@Override
	public UserAccount findById(long acctId) {
		String sql = "select * from user_account where acct_id =:acctId";
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("acctId", acctId);
		return jdbc.queryForObject(sql, paramSource, new UserAccountRowMapper());
	}

	@Override
	public long create() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}
	
	private static class UserAccountRowMapper implements RowMapper<UserAccount>{
		public UserAccount mapRow(ResultSet rs, int rowNumber) throws SQLException {
			UserAccount x = new UserAccount();
			x.setAcctId(rs.getLong("acct_id"));
			x.setAcctName(rs.getString("acct_name"));
			x.setPassword(rs.getString("password"));
			x.setPrimaryEmail(rs.getString("primary_email"));
			x.setSecureEmail(rs.getString("secure_email"));
				Timestamp ts = rs.getTimestamp("create_date");			
			x.setCreateDate(new Date(ts.getTime()));
				ts = rs.getTimestamp("last_mod_date");
			x.setLastModDate(new Date(ts.getTime()));
				ts = null;
			x.setAcctStatus(rs.getInt("acct_status"));
            return x;
		}		
	} 

}
