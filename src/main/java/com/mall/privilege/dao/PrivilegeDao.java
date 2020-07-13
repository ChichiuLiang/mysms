package com.mall.privilege.dao;

import com.mall.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Chichiu
 * @date 2020/7/4 10:11
 */
public class PrivilegeDao {

    // role 角色名称
    // pname 权限名称
    public boolean checkPrivilege(String role, String pname) {
        //查询数据库中的
        String sql = "SELECT privileges.name FROM PRIVILEGES,role,userprivilege WHERE privileges.id=userprivilege.privilege_id AND role.role=userprivilege.role AND role.role=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        List<Object> pnames = null;
        try {
            pnames = (List<Object>) runner.query(sql, new ColumnListHandler(), role);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("当前用户角色是:" + role + "  需要的权限是:" + pname);
        System.out.println("当前角色具有的权限是:" + pnames);
        return (pnames.contains(pname));
    }
}

