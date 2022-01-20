package repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;


import static org.mockito.ArgumentMatchers.any;

class DefaultRepositoryTest {

    private static final Object OBJECT = new Object();
    private HibernateUtil util = Mockito.mock(HibernateUtil.class);


    @Test
    void save_calls_runWithTransaction() {

        // GIVEN
        try(MockedStatic<HibernateUtil> utilStatic = Mockito.mockStatic(HibernateUtil.class)) {
            utilStatic.when(HibernateUtil::getInstance).thenReturn(util);
            DefaultRepository<Object> defaultRepository = new DefaultRepository<>();
            // WHEN
            defaultRepository.save(OBJECT);

            // THEN
            Mockito.verify(util).runWithTransaction(any());
        }



    }
}