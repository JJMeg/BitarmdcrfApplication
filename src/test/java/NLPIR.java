import com.sun.jna.Native;
import nlpir.lucene.cn.ictclas.CLibrary;
import org.junit.Test;

/**
 * @author Debbie Qiu
 */
public class NLPIR {
    @Test
    public void test(){
        CLibrary instance = (CLibrary) Native.loadLibrary(System.getProperty("user.dir")+"\\source\\NLPIR", CLibrary.class);
        instance.NLPIR_AddUserWord("金刚圈");

    }

}
