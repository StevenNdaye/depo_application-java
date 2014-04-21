<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><tiles:getAsString name="pageTitle"/></title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>
<body>
    <main class="container-fluid">
        <tiles:insertAttribute name="body" />
    </main>
</body>
</html>