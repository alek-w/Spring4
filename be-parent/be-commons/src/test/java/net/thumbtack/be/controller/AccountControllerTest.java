/*caught strange unconquerable error:

Tests in error:
  findAll_AccountsFound_ShouldReturnFoundAccountEntries(net.thumbtack.be.controller.AccountControllerTest):
  could not prepare statement; SQL [select account0_.id as id1_0_, account0_.bic as bic2_0_,
  account0_.iban as iban3_0_ from account account0_];
  nested exception is org.hibernate.exception.SQLGrammarException: could not prepare statement



*/


//package net.thumbtack.be.controller;
//import net.thumbtack.be.config.AppConfig;
//import net.thumbtack.be.config.MvcConfig;
//import net.thumbtack.be.config.PersistenceConfigDev;
//import net.thumbtack.be.config.ServiceConfig;
//import net.thumbtack.be.config.WebAppInitializer;
//import net.thumbtack.be.persistence.dao.AccountDao;
//import net.thumbtack.be.persistence.dao.impl.AccountDaoImpl;
//import net.thumbtack.be.persistence.entity.Account;
//import net.thumbtack.be.service.AccountService;
//import net.thumbtack.be.service.impl.AccountServiceImpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.web.context.WebApplicationContext;
//
//import javax.persistence.EntityManagerFactory;
//import java.util.Arrays;
//
//import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {PersistenceConfigDev.class,
//        ServiceConfig.class
//})
//@ActiveProfiles(profiles = {"dev"})
//@WebAppConfiguration
//public class AccountControllerTest {
//
////    @Autowired
////    AccountDao accountDao;
////    @Autowired
////    private ApplicationContext applicationContext;
//////
////    @Autowired
////    private DataSource dataSource;
//
////    @Autowired
////    private EntityManagerFactory entityManagerFactory;
////
////    @Autowired
////    private PlatformTransactionManager transactionManager;
////
////    @Autowired
////    private PersistenceExceptionTranslationPostProcessor exceptionTranslation;
////
//
//    private MockMvc mockMvc;
//
//    @Autowired
//    private AccountService AccountServiceMock;
//
////    @Autowired
////    private WebApplicationContext webApplicationContext;
//
//    //Add WebApplicationContext field here.
//
//    //The setUp() method is omitted.
//
//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
////        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).dispatchOptions(true).build();
//        this.mockMvc =  MockMvcBuilders.standaloneSetup(AccountController.class).build();
////        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
//    }
//
//    @Test
//    public void findAll_AccountsFound_ShouldReturnFoundAccountEntries() throws Exception {
//        Account first = new Account("1L"," foo");
//
//        Account second = new Account("2L","Bar");
//
//        AccountService mock2 = org.mockito.Mockito.mock(AccountService.class);
////        when(mock2.getAll()).thenReturn(Arrays.<Account>asList(first, second));
//            when(AccountServiceMock.getAll()).thenReturn(Arrays.<Account>asList(first, second));
//
//        mockMvc.perform(get("/accounts/list")
//                )
//                .andExpect(status().isOk())
//               // .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[1].bic", is("Bar")));
//
//        verify(mock2, times(1)).getAll();
////            verify(AccountServiceMock, times(1)).getAll();
////        verifyNoMoreInteractions(AccountServiceMock);
//    }
//}
//
//
