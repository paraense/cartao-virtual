import com.jid.conf.AppWebConfiguration;
import com.jid.daos.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by igor on 28/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring/spring-*-context.xml"})
@ContextConfiguration(classes=AppWebConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class Gogo {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void goog() throws Exception {
        System.out.println(usuarioRepository);
    }
}
