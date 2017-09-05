<html>
<head>
    <meta name="layout" content="main" />
    <title>User Tweets</title>
</head>
<body>
<h1 class="header">What Are You Upto??</h1>


<div class="panel panel-default panel-primary panelTweets">
    <div class="panel-heading">
        Add Tweets
    </div>

    <div class="panel-body ">
        <g:form name="updateTweetForm" id="updateTweetForm" class="form-horizontal" update="messageLists" controller="tweet" action="updateTweets">
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
        </g:form>
            </div>
    </div>
</body>
</html>








