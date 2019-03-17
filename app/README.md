- Application is developed in MVVM Architecture and because of it is being a simple application only Activities is used.
In the architecture View Models decide view logic and Views update UI according to this logic. Model layers which are repositories
in this application is used for business logic and making network requests. Databing is used to be able to leave views as dummy as possible.
LiveData is also used to observe ui and repository changes.
- Retrofit is used network requests
- Fresco is used to load user avatars

