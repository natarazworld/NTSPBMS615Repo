<%@ page language="java"  isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>


<frm:form modelAttribute="js" enctype="multipart/form-data">
  <table border="0"  bgcolor="cyan" align="center">
    <tr>
        <td> Name :: </td>
       <td><frm:input path="jsName"/>  </td>
    </tr>
    <tr>
        <td> Address :: </td>
       <td><frm:input path="jsAddrs"/>  </td>
    </tr>
    <tr>
        <td> Select Resume :: </td>
       <td><frm:input type="file" path="resume"/>  </td>
    </tr>
    <tr>
        <td> Select  Photo :: </td>
       <td><frm:input type="file" path="photo"/>  </td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="register">  </td>
    </tr>
 </table>
</frm:form>  

