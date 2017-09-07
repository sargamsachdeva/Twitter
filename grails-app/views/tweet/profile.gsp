<html>
<head>
    <meta name="layout" content="main"/>
    <title>Profile</title>
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


<div class="pageBody">
    <div class="column sideboard">
        <div id="profile" class="panel">
            <div>

                %{--<h2>${user.username}</h2>--}%
            </div>
            <div id="userStats">
                <dl>
                    <dt>Total Count</dt><dd>${totalStatusCount}</dd>
                    <dt>People following you </dt><dd>${following.size()}</dd>
                    <dt>People you followed </dt><dd>${followers.size()}</dd>
                </dl>
            </div>
        </div>
        <div id="following" class="panel">
            <h2>Following list</h2>
            <g:render template="/tweet/peopleList" model="[people: following]" />
        </div>
        <div id="followers" class="panel">
            <h2>Followers List</h2>
            <g:render template="/tweet/peopleList" model="[people: followers]" />
        </div>
        <div id="otherUsers" class="panel">
            <h2>More Users </h2>
            <g:render template="/tweet/peopleList" model="[people: otherUsers]" />
        </div>
    </div>
</div>

</body>
</html>
