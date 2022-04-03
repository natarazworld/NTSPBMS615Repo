<%@ page isELIgnored="false"  %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<noscript>
    <h1 style="color:red;text-align:center">Please enable java script </h1>
</noscript>

<style media = "all">
         body {
            background-color: pink;
         }
         span {
            color: red;
         }
      </style>
      
      <script language="JavaScript"  src="js/validations.js">
      </script>

 <h1 style="color:red;text-align:center"> Register Employee </h1>
 <form:form modelAttribute="emp" onsubmit="return validation(this)">
   <%-- <p style="color:red;text-align:center">
      <form:errors  path="*"/>
   </p>
    --%>
   <table border="1" bgcolor="cyan"  align="center">
     
      <tr>
         <td> employee name ::  </td>
         <td> <form:input path="ename"/>    <form:errors  path="ename"/>  <span id="enameErr"></span></td>
      </tr>
     
       
      <tr>
         <td> employee desg ::  </td>
         <td> <form:input path="job"/>  <form:errors  path="job"/> <span id="jobErr"></span></td>
      </tr>
      
      <tr>
         <td> employee salary ::  </td>
         <td> <form:input path="sal"/>   <form:errors  path="sal"/><span id="salErr"></span></td>
      </tr>
      
      <tr>
         <td colspan="2" align="center"><input type="submit" value="register Employee"/></td>
      </tr>
   </table>
     <form:hidden path="vflag" />
 </form:form> 
     
