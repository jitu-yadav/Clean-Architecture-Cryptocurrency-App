# Clean Architecture Cryptocurrency App

This is a simple Android application built to demonstrate modern Android development practices. It fetches and displays a list of cryptocurrencies and their details from a 
public API, following the principles of Clean Architecture.

## Features

-   **Cryptocurrency Listing:** Displays a list of cryptocurrencies fetched from a remote source.
-   **Cryptocurrency Details:** Allows users to tap on a cryptocurrency to view more detailed information.
-   **Modern UI:** The entire user interface is built 
with **Jetpack Compose**, using Material 3 components for a clean and modern look.
-   **Robust Architecture:** The project is structured using **Clean Architecture**, separating the code into three distinct layers:
    -   **Presentation:** Handles the UI and user interactions using Jetpack Compose and ViewModels.
    -   
**Domain:** Contains the core business logic, use cases, and models.
    -   **Data:** Manages data retrieval from remote sources.
-   **Dependency Injection:** **Hilt** is used for managing dependencies, making the code more modular and testable.
-   **Navigation:** In-app navigation is handled using 
**Navigation for Compose**, allowing for a seamless single-activity architecture.

## Tech Stack & APIs

-   **Language:** [Kotlin](https://kotlinlang.org/)
-   **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose)
    -   
**Material 3:** For UI components like `Scaffold` and `CenterAlignedTopAppBar`.
    -   **Navigation Compose:** For navigating between composable screens.
-   **Architecture:**
    -   [Clean 
Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
    -   [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) (ViewModel)
-   **Dependency Injection:** [Hilt](https://dagger.dev/hilt/)
-   **Networking:**
    -   
[Retrofit](https://square.github.io/retrofit/): For making HTTP requests to the API.
    -   [Gson](https://github.com/google/gson): For parsing JSON data.
-   **Remote Data Source:** The application fetches data from the [**CoinPaprika 
API**](https://api.coinpaprika.com/).

## How to Build

1.  Clone this repository.
2.  Open the project in Android Studio.
3.  Let Gradle sync and download the required dependencies.
4.  Run the app on an Android emulator or a physical 
device.