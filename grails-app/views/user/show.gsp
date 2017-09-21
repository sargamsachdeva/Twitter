<html>
<head>
    <meta name="layout" content="main" />
    <title>Show User</title>
</head>
<body>
<nav class="navbar navbar-inverse bg-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">TWITTER</a>
        </div>

        <ul class="nav navbar-nav">
            <li><a href="${createLink(uri: '/tweet/index')}">HOME</a></li>
            <li><a href="${createLink(uri: '/tweet/profile')}">PROFILE</a></li>
            <li><g:link controller='logout'>Logout</g:link></li>
        </ul>
    </div>
</nav>

<div class="panel panel-default panel-primary panelTweets">
    <div class="panel-heading">
        PROFILE
    </div>

    <div class="panel-body">
        <div class="form-group row">
            <h1>${user.username}</h1>
        </div>
        <div class="form-group row">
            <h1>Following </h1>
            <g:if test="${!user.followers}">No friends Yet..</g:if>
            <f:table collection="${user.followers}" properties="['username']"/>

        </div>
    </div>
</div>
</body>
</html>
