package com.bit.armdcrf.service.Interface;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author Debbie Qiu
 */
public interface IndexWord {
    public void createWriter() throws IOException;
    public void closeWriter() throws IOException;
    public boolean fileIndexCreate(Path file) throws IOException;


}
