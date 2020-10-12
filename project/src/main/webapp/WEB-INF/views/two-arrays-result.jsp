<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>TwoArraysResult</title>
        <link rel="stylesheet" href="/static/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <p>Your first array:</p>
                    <p>
                        <c:forEach var="word" items="${form.getArray_1()}">
                            ${word}
                        </c:forEach>
                    </p>
                </div>
                <div class="col-md-6">
                    <p>Your second array:</p>
                    <p>
                        <c:forEach var="word" items="${form.getArray_2()}">
                            ${word}
                        </c:forEach>
                    </p>
                </div>
                <div class="col-md-12">
                    <p>Result:</p>
                    <p>
                        <c:forEach var="word" items="${result}">
                            ${word}
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