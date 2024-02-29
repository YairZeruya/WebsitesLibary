## My Websites Library

My Websites Library is an Android library that provides functionality to fetch websites data from a server and display it in an Android application.

## Features

- **Fetch Websites**: Fetch websites data from a server based on country and category. ![Fetch Websites](images/fetch_websites.png)
- **Display Websites**: Display the fetched websites in a ListView. ![Display Websites](images/display_websites.png)
- **Navigate**: Navigate through countries, categories, and websites. ![Navigate](images/navigate.png)


Certainly! Here's the updated README with options to add pictures for every feature:

markdown
Copy code
# My Websites Library

My Websites Library is an Android library that provides functionality to fetch websites data from a server and display it in an Android application.

## Features

- **Fetch Websites**: Fetch websites data from a server based on country and category. ![Fetch Websites](images/fetch_websites.png)
- **Display Websites**: Display the fetched websites in a ListView. ![Display Websites](images/display_websites.png)
- **Navigate**: Navigate through countries, categories, and websites. ![Navigate](images/navigate.png)

## Installation

# Usage
To use this library in your Android project, follow these steps:

1. Add the library to your project's dependencies.
2. Ensure that your AndroidManifest.xml includes the necessary permissions, such as internet access.

```xml
<uses-permission android:name="android.permission.INTERNET" />

Usage
1. MainActivity
Launches the app.
Displays buttons for different countries.
Clicking on a country button navigates to the CategoriesActivity. 
2. CategoriesActivity
Displays buttons for different categories (news, economy, sports).
Receives the country name from MainActivity.
Clicking on a category button navigates to the WebsitesActivity with both country and category names. 
3. WebsitesActivity
Displays a list of websites for a specific country and category.
Receives the country and category names from CategoriesActivity.
Fetches websites data from the server using WebsitesController.
Displays the fetched websites in a ListView using WebsiteAdapter. 
Dependencies
Retrofit: For making network requests.
Gson: For JSON serialization/deserialization.
RecyclerView: For displaying lists efficiently.

## Installation

To use this library in your Android project, follow these steps:

1. Add the library to your project's dependencies.
2. Ensure that your AndroidManifest.xml includes the necessary permissions, such as internet access.

```xml
<uses-permission android:name="android.permission.INTERNET" />
