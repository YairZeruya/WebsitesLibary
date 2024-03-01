# Websites Libary

**My Websites Library** is an Android library designed to simplify the fetching and display of website data in Android applications. Leveraging the power of Retrofit and Gson, it communicates with a server-side API to retrieve website information based on country and category.

## Components

### 1. WebsitesController

**WebsitesController** acts as the intermediary between the Android application and the server. It manages network requests and responses, making it easy to fetch website data and handle errors effectively.

### Usage:

**Initialization:** 
Create an instance of WebsitesController and provide a callback handler to manage successful responses and errors.

```java
WebsitesController.CallBack_Websites callBackWebsites = new WebsitesController.CallBack_Websites() {
    @Override
    public void success(List<WebsitesPerCategory> websitesPerCategory) {
        // Handle successful response
    }
    @Override
    public void error(String error) {
        // Handle error
    }
};
WebsitesController websitesController = new WebsitesController(callBackWebsites);
```
 
**Fetch Websites:** 
Use the getWebsitesByCountryAndCategory method to request website data based on a specific country and category.
```java
websitesController.getWebsitesByCountryAndCategory("country", "category");
```

### 2. WebsitesAPI
WebsitesAPI defines the API endpoints used to interact with the server. It specifies the HTTP request methods and parameters required to fetch website data.
Methods
getWebsitesByCountryAndCategory(String country, String category): Fetches website data based on the provided country and category.

### 3. WebsitesPerCategory
WebsitesPerCategory represents an individual website within a specific category. It encapsulates website data attributes and provides methods for easy retrieval and manipulation.
Usage.

**Create Instance:** Instantiate a WebsitesPerCategory object and set its URL attribute.
```java
WebsitesPerCategory website = new WebsitesPerCategory();
website.setUrl("https://example.com");
```
**Retrieve URL:** Get the URL of the website using the getUrl method.
```java
String url = website.getUrl();
```

## App for Using The Libary

## Features

- *Fetch Websites*: Fetch websites data from a server based on country and category.
- *Display Websites*: Display the fetched websites in a ListView.
- *Navigate*: Navigate through countries, categories, and websites.

## Activities

<img src="https://github.com/AdiFinkelman/WebsitesLibary/assets/126038641/4cc03379-b725-48f5-bf2e-05a12d54082e" width="250" height="500">
<img src="https://github.com/AdiFinkelman/WebsitesLibary/assets/126038641/5e26887a-b203-4714-921c-ab7672827a11" width="250" height="500">
<img src="https://github.com/AdiFinkelman/WebsitesLibary/assets/126038641/d71f7e7c-0ce2-45fe-ba04-9b68463a19d5" width="250" height="500">

### MainActivity

Launches the app.
Displays buttons for different countries.
Clicking on a country button navigates to the CategoriesActivity.

### CategoriesActivity

Displays buttons for different categories (news, economy, sports).
Receives the country name from MainActivity.
Clicking on a category button navigates to the WebsitesActivity with both country and category names.

### WebsitesActivity

Displays a list of websites for a specific country and category.
Receives the country and category names from CategoriesActivity.
Fetches websites data from the server using WebsitesController.
Displays the fetched websites in a ListView using WebsiteAdapter.

## Dependencies
**Retrofit**: For making network requests.

**Gson:** For JSON serialization/deserialization.

**RecyclerView:** For displaying lists efficiently.

## Installation

To use this library in your Android project, follow these steps:

1. Add the library to your project's dependencies.
2. Ensure that your AndroidManifest.xml includes the necessary permissions, such as internet access.

```xml
<uses-permission android:name="android.permission.INTERNET" />
