package net.thumbtack.be;

import net.thumbtack.be.config.PersistenceConfigDev;
import net.thumbtack.be.config.ServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {PersistenceConfigDev.class, ServiceConfig.class})
//@ActiveProfiles(profiles = {"dev"})
public class ApplicationContextTest {

//    private final static Logger LOG = LoggerFactory.getLogger(ApplicationContextTest.class);
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private EntityManagerFactory entityManagerFactory;
//
//    @Autowired
//    private PlatformTransactionManager transactionManager;
//
//    @Autowired
//    private PersistenceExceptionTranslationPostProcessor exceptionTranslation;
//
//    @Test
//    public void testContextBeans() {
//        LOG.info("initialization test");
//        assertNotNull(applicationContext);
//        assertNotNull(dataSource);
//        assertNotNull(transactionManager);
//        assertNotNull(entityManagerFactory);
//        assertNotNull(exceptionTranslation);
//    }


    @Test
    public void test() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream()
//                .map((cost) -> cost + 0.12 * cost)
                .reduce(1, (sum, cost) -> (sum + cost) );
//                .get();
        System.out.println("Total : " + bill);
    }
}
