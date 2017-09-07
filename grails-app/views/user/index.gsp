
<%@ page import="com.rxlogix.twitter.User" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>All Users</title>
</head>
<body>

<div id="list-person">
<div class="flash">
    ${flash.message}
</div>
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
                <div class="col-sm-6">

                    <g:link action="show" id="${user.id}">${fieldValue(bean: user, field: "username")}</g:link>
                </div>

                <div class="col-sm-6">
                    <g:link action="makeFriend" id="${user.id}">Follow</g:link>
                </div>

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
