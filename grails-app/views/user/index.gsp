
<%@ page import="com.rxlogix.twitter.User" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>All Users</title>
</head>
<body>

<div id="list-person">

<div class="panel panel-default panel-primary panelTweets">
    <div class="panel-heading">
        User List
    </div>

    <div class="panel-body">
        <div class="form-group row">
            Users
        </div>
        <div class="form-group row">
            <g:each in="${userList}" status="i" var="user">

                    <g:link action="show" id="${user.id}">${fieldValue(bean: user, field: "username")}</g:link>

            </g:each>

        </div>
    </div>
</div>

<div class="pagination">
    <g:paginate total="${userCount ?: 0}" />
</div>

</div>
</body>
</html>
