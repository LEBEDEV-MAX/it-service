<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Project</title>
        <link rel="stylesheet" href="/static/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <label>Select task</label>
                    <select>
                      <option value="twoArrays" selected>Two arrays</option>
                      <option value="expandedForm">Expanded form</option>
                    </select>
                    <button id="saveButton">Save</button>
                    <form:form method="post" enctype="multipart/form-data" modelAttribute="file" action="/load">
                        <table>
                            <tr>
                                <td>Upload File:</td>
                                <td><input type="file" name="file" /></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Upload" /></td>
                                <td></td>
                            </tr>
                        </table>
                    </form:form>
                </div>
            </div>
            <div class="row">
                <div class="twoArrayBlock">
                    <form:form action="/two-arrays" method="post" modelAttribute="twoArraysForm">
                        <div class="twoArrayBlock col-md-6">
                            <form:label path="array_1">The first array</form:label>
                            <form:textarea id="array_1" path="array_1" placeholder="Write words through a space" cols="50" rows="5"/>
                        </div>
                        <div class="twoArrayBlock col-md-6">
                            <form:label path="array_2">The second array</form:label>
                            <form:textarea id="array_2" path="array_2" placeholder="Write words through a space" cols="50" rows="5"/>
                        </div>
                        </br>
                        <div class="twoArrayBlock col-md-12">
                            <button type="submit" name="twoArrayButton">Submit</button>
                        </div>
                    </form:form>
                </div>
                <div class="expandedFormBlock col-md-12" style="display:none">
                    <form:form action="/expanded-form" method="post" modelAttribute="expandedForm">
                        <form:label path="numberAsString">Your number</form:label>
                        <form:input id="number" path="numberAsString" placeholder="Whole numbers greater than 0"/>
                        <button type="submit" name="expandedFormButton">Submit</button>
                    </form:form>
                </div>
            </div>
        </div>

        <script src="/static/js/jquery-3.5.1.min.js"></script>
        <script src="/static/js/bootstrap.min.js"></script>
        <script src="/static/js/main.js"></script>
    </body>
</html>