Fetaure: create user using Post

    Sceanrio: Create user using post method with JsonFile body content
    Given i have post body JsonFile
    When i post in to the url
    Then i should get success response 200
