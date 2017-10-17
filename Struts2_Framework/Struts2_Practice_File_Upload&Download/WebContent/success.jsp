<body>
  <%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>

<h1>upload succeed!</h1><br/>

file name:<s:property value="+ uploadsFileName[0]"/><br/>
file type:<s:property value="+ uploadsContentType[0]"/><br/>
file address:  <%=basePath %><s:property value="'uploadMultiFiles/'   
        + uploadsFileName[0]"/>  <a href="download.action?filename=<s:property value="+ uploadsFileName[0]"/>">download</a> <br/> 
 <br/>
 <br/>
file name:<s:property value="+ uploadsFileName[1]"/><br/>
file type:<s:property value="+ uploadsContentType[1]"/><br/>
file address: <%=basePath %><s:property value="'uploadMultiFiles/'   
        + uploadsFileName[1]"/> <a href="download.action?filename=<s:property value="+ uploadsFileName[1]"/>">download</a> <br/> 
 <br/>
 <br/>        
file name:<s:property value="+ uploadsFileName[2]"/><br/>
file type:<s:property value="+ uploadsContentType[2]"/><br/>
file address: <%=basePath %><s:property value="'uploadMultiFiles/'   
        + uploadsFileName[2]"/>  <a href="download.action?filename=<s:property value="+ uploadsFileName[2]"/>">download</a> <br/> 

  </body>