package com.gayan.spring.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import javax.sql.DataSource;
 
import com.gayan.spring.domain.User;
 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
 
public class UserDaoImpl implements UserDao {//this section for inject the datasource to the project
    private DataSource dataSource;
     
    public UserDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
     
    @Override
    public List<User> list() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * from users";
        List<User> listUser = jdbcTemplate.query(sql, new RowMapper<User>() {
 
            @Override
            public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                return user;
            }
             
        });
        return listUser;
    }
 
}
