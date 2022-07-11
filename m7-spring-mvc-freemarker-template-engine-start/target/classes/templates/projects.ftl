<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Learn Spring | FreeMarker Template Engine</title>
</head>
<body>
<div class="container">
    <div class="col-sm-5">
        <!-- projects go here -->
        <# list projects as project>
        <h1>${project.name}</h1>
        Tasks:
        <ol>
            <#list project.tasks as task>
                <li>${task.name} : ${task.description}</li>
            </#list>
        </ol>
    </div>
</div>
</body>
</html>