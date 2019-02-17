import cn.itcast.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {
    @Test
    public void save(){
        // 获取EntityManagerFactory
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        // 获取实体管理类
        EntityManager em = factory.createEntityManager();
        // 获取事务对象
        EntityTransaction transaction = em.getTransaction();
        // 开启事务
        transaction.begin();
        // 准备数据
        Customer customer = new Customer();
        customer.setCustName("传智播客");
        customer.setCustIndustry("it教育");
        // 保存操作
        em.persist(customer);
        // 提交事务
        transaction.commit();
        // 释放资源
        em.close();
        factory.close();

    }
}
