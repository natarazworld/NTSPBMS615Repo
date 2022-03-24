
<%@page  isELIgnored="false" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <b>Model data(Array,collections)  is :: </b><br>
    favourite colors(arary)::
    <c:if test="${!empty  favColors}">
        <c:forEach var="color" items="${favColors}">
                ${color},
        </c:forEach>
    </c:if>
   <br> 
   Nicknames(List Collection)::
    <c:if test="${!empty  nickNames}">
        <c:forEach var="name" items="${nickNames}">
                ${name},
        </c:forEach>
    </c:if>
   <br> 
    PhoneNumber(Set Collection)::
    <c:if test="${!empty  phoneNumbers}">
        <c:forEach var="phone" items="${phoneNumbers}">
                ${phone},
        </c:forEach>
    </c:if>
    
       <br> 
    IdDetails(Map Collection -->gives only values by taking keys)::
    <c:if test="${!empty  idDetails}">
                ${idDetails.aadhar},
                ${idDetails.panNo},
                ${idDetails.voterId}<br>
    </c:if>
    <br>
    IdDetails(Map Collection (gives both keys and values))::
    <c:if test="${!empty  idDetails}">
            <c:forEach  var="id"  items="${idDetails}">
                  ${id.key}<----> ${id.value} <br>
            </c:forEach>
    </c:if> --%>
    
    <%-- <b>Model  data  is <b> <br>
    <c:if test="${!empty prodData}">
         product id ::  ${prodData.pid} <br>
         product name ::  ${prodData.pname} <br>
         product price ::  ${prodData.price} <br>
         product qty ::  ${prodData.qty} <br>
    </c:if>
      --%>
      
      <c:choose>
         <c:when test="${!empty prodList}">
            <table align="center" bgcolor="cyan" border="1">
                <tr>
                  <th>PID </th> <th>PNAME </th> <th>PRICE </th> <th>QTY</th>
                </tr>
                <c:forEach var="prod"  items="${prodList}">
                  <tr>
                     <td>${prod.pid} </td>
                     <td>${prod.pname} </td>
                     <td>${prod.price} </td>
                     <td>${prod.qty} </td>
                  </tr>
                </c:forEach>
            </table>
         </c:when>
         <c:otherwise>
                  <h1 style="color:red;text-align:center"> No Records found </h1>
         </c:otherwise>
      </c:choose>
    

  <%-- <b>model data  is </b><br>
     
     <b> name:: ${name}</b> <br>
     <b> age:: ${age}</b> <br>    
     <b> addrs:: ${addrs}</b> <br>    
<br><br>
 --%>
 
 
    
    
     
     
