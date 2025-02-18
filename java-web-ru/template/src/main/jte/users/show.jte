@import exercise.dto.users.UserPage
@param UserPage page

<html>
    <head>
        <title>Хекслет</title>
    </head>
    <body>
          <div>
               <h2>${page.getUser().getFirstName()}</h2>
               <p>${page.getUser().getLastName()}</p>
          </div>
    </body>
</html>