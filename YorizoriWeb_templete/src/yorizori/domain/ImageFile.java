package yorizori.domain;

import java.io.Serializable;

public class ImageFile implements Serializable {

    /** */
    private static final long serialVersionUID = -2501957981552571528L;
    
    private String contentType;
    private String fileName;
    
    //--------------------------------------------------------------------------
    
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
