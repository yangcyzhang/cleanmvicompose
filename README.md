# Clean MVI Compose Project

This project is a modern Android application built using **Jetpack Compose**, following **Clean Architecture** principles and the **MVI (Model-View-Intent)** design pattern.

## 🏗 Project Architecture

The project is organized into three main layers to ensure separation of concerns, scalability, and testability.

### 1. Domain Layer
The core of the application, containing business logic. It is independent of any other layers.
- **Models**: Data classes representing business entities (e.g., `User`).
- **Repositories (Interfaces)**: Contract definitions for data operations.
- **Use Cases**: Specific business rules (e.g., `GetUserListUseCase`).

### 2. Data Layer
Handles data operations and provides data to the domain layer.
- **Remote**: API service definitions (e.g., `UserApiService`).
- **Repository Implementations**: Concrete implementations of domain repository interfaces (e.g., `UserRepositoryImpl`).

### 3. UI Layer (Presentation)
Handles the user interface and user interactions.
- **MVI Components**:
    - **Intent**: Represents user actions (e.g., `LoadUsers`).
    - **UiState**: Represents the state of the UI at any given time (e.g., `Loading`, `Success`, `Error`).
    - **ViewModel**: Manages the state and processes intents using Use Cases.
- **Compose UI**: Declarative UI components (e.g., `UserScreen`).

## 🛠 Tech Stack

- **UI**: Jetpack Compose
- **Dependency Injection**: Hilt
- **Asynchronous Programming**: Coroutines & Flow
- **Network**: (Simulated) Retrofit-ready structure
- **Architecture**: Clean Architecture + MVI

## 📂 Folder Structure

```text
com.example.cleanmvicompose
├── data           # Data Layer (Remote, Repository Impl)
├── di             # Dependency Injection (Hilt Modules)
├── domain         # Domain Layer (Models, Repositories, Use Cases)
├── ui             # UI Layer (MVI, Compose, Theme)
│   ├── user       # User Feature (Intent, State, ViewModel, Screen)
│   └── theme      # Compose Styling
├── MainActivity   # Entry Point
└── MyApplication  # Hilt Application Class
```

## 🚀 Getting Started

1.  Clone the repository.
2.  Open in Android Studio (Ladybug or newer).
3.  Build and Run.

## 📄 Key Features

- **Decoupled Architecture**: Easy to swap data sources or UI frameworks.
- **Reactive UI**: State-driven UI updates using Kotlin Flow.
- **Dependency Injection**: Fully managed by Hilt for easy testing and modularity.
