package nlpir.lucene.cn.ictclas;

import com.sun.jna.Library;

/**
 * @author Debbie Qiu
 */
public interface CLibrary extends Library {

    public int NLPIR_AddUserWord(String sWord);
    //删除单条用户词典
    public int NLPIR_DelUsrWord(String sWord);
    //从TXT文件中导入用户词典
    public int NLPIR_ImportUserDict(String sFilename);

}
