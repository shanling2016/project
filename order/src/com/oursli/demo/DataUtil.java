package com.oursli.demo;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.*;

/**
 * Package:      com.oursli.demo
 * ClassName:    DataUtil
 * Description:  系统数据库操作类
 * Datetime:     2020/3/24   10:54 下午
 * Author:       子文i
 */
public class DataUtil {

    /**
     * 数据库连接对象
     */
    private static Connection c = null;

    /**
     * 初始化Sqlite3数据库
     */
    public static void InitSqlite()
    {
        // 记录集对象
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:order.db");
            // System.out.println("Opened database successfully");
            // 创建记录集
            stmt = c.createStatement();
            try {
                // 尝试读取记录
                stmt.executeQuery( "SELECT * FROM dish;" );
                stmt.executeQuery( "SELECT * FROM \"like\";" );
                stmt.executeQuery( "SELECT * FROM shop;" );
            }
            catch(Exception e)
            {
                // 执行到此，说明数据库为刚刚创建的
                // 在此创建数据表
                stmt.executeUpdate("CREATE TABLE dish (id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING (256), price DOUBLE, \"like\" INT);");
                stmt.executeUpdate("CREATE TABLE \"like\" (cid INT, name STRING (256));");
                stmt.executeUpdate("CREATE TABLE shop (id INTEGER PRIMARY KEY AUTOINCREMENT, name STRING (256), cid INT, number INT, price DOUBLE, del_time INT, del_address STRING (256), \"create\" INT, last INT, status BOOLEAN);");
                // System.out.println("Update database successfully");
                // 创建默认数据
                stmt.executeUpdate("INSERT INTO dish (name, price, 'like') VALUES ('红烧带鱼', 38.00, 0);");
                stmt.executeUpdate("INSERT INTO dish (name, price, 'like') VALUES ('鱼香肉丝', 20.00, 0);");
                stmt.executeUpdate("INSERT INTO dish (name, price, 'like') VALUES ('时令鲜蔬', 10.00, 0);");
            }
            // 关闭记录集
            stmt.close();
            // 关闭数据库连接
            // c.close();
        } catch ( Exception e ) {
            System.out.println("数据库打开或创建失败！");
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        // System.out.println("database connect close");
    }

    /**
     * 获取菜单信息
     * @return 成功返回对象，失败返回null
     */
    public static ResultSet getDish()
    {
        // 此处存在待改进的坑，对于菜单这种高频读低频写的数据，应当使用缓存
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            return stmt.executeQuery( "SELECT * FROM dish;" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断指定id的菜品是否存在
     * @param id 菜品id
     * @return 存在则返回true，失败返回false
     */
    public static Boolean dishExis(Integer id)
    {
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            return stmt.executeQuery("SELECT * FROM dish WHERE id=" + id.toString()).next();
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * 订餐并创建订单
     * @param cid 菜品的编号
     * @param n 份数
     * @param name 用户的姓名
     * @param time 配送时间
     * @param address 配送地址
     * @return 创建订单成功返回 true，失败返回 false
     */
    public static Boolean createOrder(Integer cid, Integer n, String name, Integer time, String address)
    {
        // 记录集对象
        Statement stmt = null;
        try
        {
            // 读取菜品id对应的菜品信息
            ResultSet res = getDishInfo(cid);
            // Sql语句
            String sql = "INSERT INTO shop (name, cid, number, price, del_time, del_address, \"create\", last, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, cid);
            ps.setInt(3, n);
            ps.setDouble(4, res.getDouble("price") * n);
            ps.setInt(5, time);
            ps.setString(6, address);
            ps.setInt(7,(int) (System.currentTimeMillis() / 1000));
            ps.setInt(8, 0);
            ps.setBoolean(9, false);
            // 提交更新
            return ps.executeUpdate() > 0;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * 读取餐袋信息
     * @return 成功返回对象，失败返回null
     */
    public static ResultSet getOrder()
    {
        // 此处存在待改进的坑，对于订单这种高频读低频写的数据，应当使用缓存
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            return stmt.executeQuery( "SELECT * FROM shop;" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断指定id的订单是否存在
     * @param id 订单id
     * @return 存在则返回true，失败返回false
     */
    public static Boolean orderExis(Integer id)
    {
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            return stmt.executeQuery("SELECT * FROM shop WHERE id=" + id.toString()).next();
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * 根据id获取菜品信息
     * @param id 菜品的id
     * @return 成功返回对象，失败返回null
     */
    public static ResultSet getDishInfo(Integer id)
    {
        try
        {
            return c.createStatement().executeQuery("SELECT * FROM dish WHERE id=" + id);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * 获取订单的签收状态
     * @param id 订单id
     * @return 签收返回true,未签收返回false
     */
    public static Boolean getOrderStatus(Integer id)
    {
        try
        {
            ResultSet rs = c.createStatement().executeQuery("SELECT * FROM shop WHERE id=" + id);
            rs.next();
            return rs.getBoolean("status");
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * 签收订单
     * @param id 订单id
     * @return 成功返回true, 失败返回false
     */
    public static Boolean signOrder(Integer id)
    {
        try
        {
            String sql = "UPDATE shop SET status=? WHERE id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * 删除订单
     * @param id 订单id
     * @return 成功删除返回true, 失败返回false
     */
    public static Boolean deleteOrder(Integer id)
    {
        try
        {
            String sql = "DELETE FROM shop WHERE id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     * 对指定菜品进行点赞
     * @param id 菜品id
     * @param name 用户姓名
     * @return 成功返回true，失败返回false
     */
    public static Boolean likeDish(Integer id, String name)
    {
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM dish WHERE id=" + id);
            if (!rs.next())
                return false;
            Integer like = rs.getInt("like") + 1;
            // 事务开始
            stmt.execute("BEGIN;");
            Boolean s1 = stmt.executeUpdate("UPDATE dish SET \"like\"=" + like + " WHERE id=" + id) > 0;
            Boolean s2 = stmt.executeUpdate("INSERT INTO \"like\" (cid, name) VALUES (" + id + ", '" + name + "');") > 0;
            if (s1 && s2)
            {
                // 提交事务
                stmt.execute("COMMIT;");
                return true;
            }
            else
            {
                // 回滚
                stmt.executeQuery("ROLLBACK;");
                return false;
            }
        } catch (Exception e) {
            // 回滚
            try {
                stmt.executeQuery("ROLLBACK;");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    /**
     * 判断用户是否已经点过赞了
     * @param id 菜品id
     * @param name 用户姓名
     * @return 已经点过赞返回true, 没有点过返回false
     */
    public static Boolean isLike(Integer id, String name)
    {
        try
        {
            String sql = "SELECT * FROM \"like\" WHERE cid=? AND name=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            return ps.executeQuery().next();
        }
        catch (Exception e)
        {
            return false;
        }
    }
}