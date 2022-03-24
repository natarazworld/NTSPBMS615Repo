<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

    <h1 style="color:red;text-align:center">student registration page</h1>
    
     <form:form    modelAttribute="stud">
        <table align="center" bgcolor="cyan">
           <tr>
              <td>student number  </td>
              <td><form:input path="sno"/> </td>
           </tr>
           <tr>
              <td>student name  </td>
              <td><form:input path="sname"/>  </td>
           </tr>
           <tr>
              <td>student address  </td>
              <td><form:input path="sadd"/>  </td>
           </tr>
           <tr>
              <td>student avg  </td>
              <td><form:input path="avg"/>  </td>
           </tr>
           <tr>
              <td colspan="2"><input type="submit" value="Register"></td>
           </tr>
        </table>
     </form:form>