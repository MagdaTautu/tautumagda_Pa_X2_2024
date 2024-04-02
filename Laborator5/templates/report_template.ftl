<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document Repository Report</title>
</head>
<body>
    <h1>Document Repository Report</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>ID</th>
        </tr>

         <#list employees as person>
             <#if person??>
                 <tr>
                     <td>${person.name}</td>
                     <td>${person.id}</td>
                 </tr>
             </#if>
         </#list>

    </table>
</body>
</html>