Overview
=========================================================== 
Demo news app that consume data from newsapi.org![https://newsapi.org/]
### Feature
#Headline 
#SearchNew
#Bookmark

### Architecture
This demo follows the Google official architecture guidance.
MVVM Architecture (Model - View - ViewModel)

### Testing
covered for unit test and some instrumentation test.

### Tech stacks 
* Kotlin based, Coroutines + Flow for asynchronous.
* Jetpack Compose: User Interface
* StateFlow: handles UI states upon the lifecycle changes.
* ViewModel: Manages UI-related data holder and lifecycle awareness. Allows data to survive configuration changes such as screen rotations.
* Room: Constructs Database by providing an abstraction layer over SQLite to allow fluent database access.
* Hilt: for dependency injection.
* Retrofit2: the REST APIs.
* Moshi: A modern JSON library for Kotlin and Java.
* Material-Components: Material design components.
* Coil: An image loading library for Android backed by Kotlin Coroutines.
