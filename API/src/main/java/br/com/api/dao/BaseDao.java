package br.com.api.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class BaseDao {

	protected final static String LOOKUP = "java:comp/env/jdbc/api";
	protected DataSource dataSource;

	protected Statement openStatement;
	protected Connection openConnection;
	protected PreparedStatement openPreparedStatement;

	public BaseDao() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup(BaseDao.LOOKUP);
	}

	protected Connection openConnection() throws SQLException {
		openConnection = dataSource.getConnection();
		return openConnection;
	}

	protected Statement createStatement() throws SQLException {
		openStatement = dataSource.getConnection().createStatement();
		return openStatement;
	}

	protected PreparedStatement prepareStatement(String sql) throws SQLException {
		openPreparedStatement = dataSource.getConnection().prepareStatement(sql);
		return openPreparedStatement;
	}

	protected PreparedStatement prepareStatementKey(String sql, String[] colunResult) throws SQLException { //
		openPreparedStatement = dataSource.getConnection().prepareStatement(sql, colunResult);
		return openPreparedStatement;
	}

	protected void close(ResultSet r) throws SQLException {
		if (r != null) {
			Connection c = null;
			Statement s = null;
			if (r.getStatement() != null) {
				s = r.getStatement();
			}
			if (s != null && s.getConnection() != null) {
				c = s.getConnection();
			}
			close(c, s, r);
		} else {
			Connection c = null;
			Statement s = null;
			if (openStatement != null && !openStatement.isClosed()) {
				s = openStatement;
			}
			if (openPreparedStatement != null && !openPreparedStatement.isClosed()) {
				s = openPreparedStatement;
			}
			if (openConnection != null && !openConnection.isClosed()) {
				c = openConnection;
			}
			close(c, s, r);
		}
	}

	protected void close(CallableStatement s) throws SQLException {
		if (s != null) {
			Connection c = null;
			if (s != null && s.getConnection() != null) {
				c = s.getConnection();
			}
			close(c, s, null);
		} else {
			Connection c = null;
			if (openConnection != null && !openConnection.isClosed()) {
				c = openConnection;
			}
			close(c, null, null);
		}
	}

	protected void close(Statement s) throws SQLException {
		if (s != null) {
			Connection c = null;
			if (s != null && s.getConnection() != null) {
				c = s.getConnection();
			}
			close(c, s, null);
		} else {
			Connection c = null;
			if (openConnection != null && !openConnection.isClosed()) {
				c = openConnection;
			}
			close(c, null, null);
		}
	}

	protected void close(Connection c, Statement s, ResultSet r) throws SQLException {

		if (s != null && s.getConnection() != null && !s.getConnection().isClosed()) {
			s.getConnection().close();
		}

		if (r != null && !r.isClosed()) {
			r.close();
		}
		if (s != null && !s.isClosed()) {
			s.close();
		}
		if (c != null && !c.isClosed()) {
			c.close();
		}

	}
}