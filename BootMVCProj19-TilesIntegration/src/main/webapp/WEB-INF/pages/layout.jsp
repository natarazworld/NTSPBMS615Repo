<%@ page isELIgnored="false" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>

<head>
  <title><tiles:insertAttribute name="title" /></title>
</head>
<table  border="0"  width="100%" height="100%">
   <tr width="100%" height="30%"  bgcolor="cyan">
     <td colspan="2"><tiles:insertAttribute name="header"/>  </td>
   </tr>
   <tr width="100%" height="70%">
     <td width="40%" bgcolor="lightblue" ><tiles:insertAttribute name="menu"/>  </td>
     <td width="60%" bgcolor="yellow" ><tiles:insertAttribute name="body"/>  </td>
   </tr>
   <tr width="100%" height="10%">
     <td colspan="2" bgcolor="pink"><tiles:insertAttribute name="footer"/>  </td>
   </tr>
</table>