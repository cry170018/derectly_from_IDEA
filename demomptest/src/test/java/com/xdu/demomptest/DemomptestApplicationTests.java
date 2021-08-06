package com.xdu.demomptest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xdu.demomptest.entity.User;
import com.xdu.demomptest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class DemomptestApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);

        System.out.println(users);
    }

    /*
     * 添加操作
     * */
    @Test
    public void testAdd() {
        User user = new User();
        user.setName("宋怡颖");
        user.setAge(20);
        user.setEmail("3387@qq.com");
        //返回影响行数
        int insert = userMapper.insert(user);

    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1383768606551904257L);
        user.setName("lucymary");
        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    /*
     *
     * 测试乐观锁
     * */
    @Test
    public void testOptimisticLocker() {
        User user = userMapper.selectById(1383787718715936770L);
        user.setName("崔带到");
        userMapper.updateById(user);

    }

    /*
     * 批量查询，通过id
     * */
    @Test
    public void testSelect1() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }

    /*
     * 简单的条件查询
     * */
    @Test
    public void testSelect2() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", "Jack");
        columnMap.put("age", 20);
        //查询名字为jack年龄为20的
        //SELECT id,name,age,email,create_time,update_time,version FROM user WHERE name = ? AND age = ?
        //==> Parameters: Jack(String), 20(Integer)
        List<User> users = userMapper.selectByMap(columnMap);
        System.out.println(users);
    }

    /*
     * 分页查询
     * */
    @Test
    public void testSelectPage() {
        Page<User> page = new Page(1, 3);//以三个元素为一页，展示出第一页
        Page<User> userPage = userMapper.selectPage(page, null);
        //返回对象得到分页所有数据
        long pages = userPage.getPages(); //总页数
        long current = userPage.getCurrent(); //当前页
        List<User> records = userPage.getRecords(); //查询数据集合
        long total = userPage.getTotal(); //总记录数
        boolean hasNext = userPage.hasNext();  //下一页
        boolean hasPrevious = userPage.hasPrevious(); //上一页

        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);
    }

    /*
    Id删除
    */
    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById(5L);
        System.out.println(result);
    }

    /*
     * 批量删除
     * */
    @Test
    public void testDeleteBatchIds() {
        int result = userMapper.deleteBatchIds(Arrays.asList(8, 9, 10));
        System.out.println(result);
    }

    /*
     * 条件删除
     * */
    @Test
    public void testDeleteByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "宋怡颖");
        map.put("age", 20);
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    /*
     * 复杂的查询操作
     * */
    @Test
    public void testSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //ge\gt\le\lt
        queryWrapper.ge("age", 21);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /*
     * 条件模糊查询
     * */
    @Test
    public void testSelectMaps() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .select("name", "age")
                .like("name", "崔")
                .likeRight("email", "3");
        /*
        * ==>  Preparing: SELECT name,age FROM user WHERE deleted=0 AND (name LIKE ? AND email LIKE ?)
            ==> Parameters: %e%(String), 5%(String)

            <==    Columns: name, age
<==                 Row: 崔云囿, 20
<==                 Row: 崔带到, 20

        * */
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);//返回值是Map列表
        maps.forEach(System.out::println);
    }
    /*
    * 结果排列
    * */
    @Test
    public void testSelectListOrderBy() {
        QueryWrapper<User>queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age", "id");//按age降序排列，age一样的按id排
        List<User>users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }



}
