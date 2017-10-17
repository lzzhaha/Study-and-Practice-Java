package struts_practice;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class DownloadAction extends ActionSupport {  


    private static final long serialVersionUID = 1L;


    
    private String downloadPath;  

    
    private String filename;  

    public String getFilename() {  
           return filename;  
    }  

    public void setFilename(String filename) {  
           this.filename = filename;  
    }  

    public void setDownloadPath(String downloadPath){  
           this.downloadPath = downloadPath;  
    }  


public InputStream getTargetFile() throws FileNotFoundException  
{  
    //Get the path of the files to download
    String realPath = downloadPath + "/" + getFilename();

     
    return ServletActionContext.getServletContext().getResourceAsStream(realPath);
}  

public String execute()  
{  
    return "success";  
}  

}
