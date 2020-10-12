<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>ExpandedFormResult</title>
        <link rel="stylesheet" href="/static/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <p>Your number:</p>
                    <p>${form.getNumberAsString()}</p>
                    <p>Result:</p>
                    <p>
                        <c:forEach var="addendum" items="${result}">
                            ${addendum}
                            <c:if test="${result.indexOf(addendum) < result.size()-1}"> + </c:if>
                        </c:forEach>
                    </p>
                </div>
                <a href="/">Back</a>
            </div>
        </div>

        <script src="/static/js/jquery-3.5.1.min.js"></script>
        <script src="/static/js/bootstrap.min.js"></script>
        <script src="/static/js/main.js"></script>
    </body>
</html>