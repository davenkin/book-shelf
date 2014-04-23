<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Display all books</title>
</head>
<body>
<h1>There are ${fn:length(books)} books:</h1>
<div>
<c:forEach var="book" items="${books}" varStatus="index">
<div>
<div>No.${index.index+1} </div>
<div>Book ISBN: ${book.isbn}</div>
<div>Book Name: ${book.name}</div>
<div>Book Price: ${book.price}</div>
<div>Book Author: ${book.author}</div>
</div>
</p>
</c:forEach>
</div>
</body>
</html>