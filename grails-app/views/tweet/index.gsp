<html>
<head>
    <meta name="layout" content="main"/>
    <title>User Tweets</title>
</head>
<body>
<h1 class="header">What Are You Upto??</h1>


<div class="panel panel-default panel-primary panelTweets">
    <div class="panel-heading">
        Add Tweets
    </div>

    <div class="panel-body">
        <g:formRemote name="updateTweetForm" id="updateTweetForm" class="form-horizontal" url="[action:'updateTweets']"
        update="messages">
            <div class="form-group row">
                <label for="message" class="col-sm-4 form-control-label">Your Tweet</label>

                <div class="col-sm-8">
                    <g:textArea name="message" class="form-control" id="message"/>
                </div>
            </div>

                <div class="col-sm-offset-3 col-sm-4 pull-right">
                    <g:submitButton name="submit" value="Update" type="submit"
                                    class="btn btn-primary btn-block"/>
                </div>
        </g:formRemote>
            </div>
    </div>

<div class="panel panel-default panel-primary panelTweets">
    <div class="panel-heading">
        My Tweets
    </div>

    <div class="panel-body" id="messages"">
    <g:render template="messages" collection="${messages}" var="message" model="likes:${likes}"/>
</div>
</div>
</body>
</html>








