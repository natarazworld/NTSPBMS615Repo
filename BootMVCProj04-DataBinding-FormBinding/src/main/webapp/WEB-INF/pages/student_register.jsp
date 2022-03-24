<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

    <h1 style="color:red;text-aling:center">student registration page</h1>
    
     <form  method="POST">
        <table align="center" bgcolor="cyan">
           <tr>
              <td>student number  </td>
              <td><input type="text"  name="sno">  </td>
           </tr>
           <tr>
              <td>student name  </td>
              <td><input type="text"  name="sname">  </td>
           </tr>
           <tr>
              <td>student address  </td>
              <td><input type="text"  name="sadd">  </td>
           </tr>
           <tr>
              <td>student avg  </td>
              <td><input type="text"  name="avg">  </td>
           </tr>
           <tr>
              <td colspan="2"><input type="submit" value="Register"></td>
           </tr>
        </table>
     </form>