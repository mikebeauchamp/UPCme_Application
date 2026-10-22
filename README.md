# UPCme

UPCme is an Android application that scans UPC-A barcodes and retrieves product information from online sources. The app validates supported barcode formats, looks up product details, and compares available pricing information to help shoppers make more informed purchasing decisions.

## Overview

This project was designed as a barcode-based shopping comparison app and served as the author’s capstone project during their Master of Science in Software Engineering at Penn State. It also represents one of the author’s first attempts at mobile development, created to explore Android app development, barcode scanning, API integration, and UI design in a practical, real-world use case.

When a shopper scans an item in a brick-and-mortar store, the app checks whether the UPC is supported, then retrieves product data and pricing information from external services so the user can compare the in-store item against online alternatives.

The app uses a two-call architecture:

1. A Barcode Lookup API call returns the product record and available online retailer pricing.
2. A separate RapidAPI Amazon call flow retrieves Amazon pricing, product details, and review data for the same item.

This allows users to compare a physical product they are holding with broader online market pricing and Amazon data.

## Features

- Camera-based barcode scanning
- UPC-A validation for supported barcode formats
- Product lookup and title/description retrieval
- Comparison of other online retailer pricing from the barcode lookup service
- Amazon product page, price, and Prime eligibility lookup
- Amazon review summaries for scanned products
- Error handling for unsupported barcode types and no-internet situations

## How the App Works

When a UPC is scanned, the app performs two primary API requests:

### 1) Barcode Lookup request

This call retrieves the product title, description, image, and online retailer pricing data such as stores and prices from the barcode lookup source.

The app filters the returned pricing data to U.S. stores that were updated within the last year, then displays those stores in the app UI.

### 2) Amazon RapidAPI request flow

This is a separate process that uses the barcode value to identify the ASIN, then requests Amazon pricing and review details.

The Amazon flow includes:

- UPC to ASIN lookup
- Amazon price and rating lookup
- Amazon review data lookup

This second flow is intentionally separate from the retailer comparison data so the app can show both general online pricing comparison and Amazon-specific information.

## Tech Stack

- Java
- Android SDK / AndroidX
- Material Components
- Retrofit + Gson for API calls
- Picasso for image loading
- Code Scanner library for barcode scanning
- Gradle for build management

## Project Structure

```text
UPCme_Application/
├── app/
│   ├── src/
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── README.md
```

## Prerequisites

Before building this project, make sure you have:

- Android Studio
- JDK 8 or newer
- Android SDK configured in Android Studio
- API keys for the barcode lookup and Amazon-related services

## Configuration

This app expects API keys to be available at build time. In Android Studio, create a `local.properties` file in the project root if it does not already exist and add your secret values:

```properties
barcodeAPI=YOUR_BARCODE_LOOKUP_API_KEY
rainforestAPI=YOUR_RAINFOREST_API_KEY
rapidAPI=YOUR_RAPIDAPI_KEY
```

The manifest references these values through the Gradle secrets plugin, so they must be available before running the app.

## Build and Run

### Option 1: Android Studio

1. Open the project in Android Studio.
2. Let Gradle sync the project.
3. Select an Android emulator or connected device.
4. Click Run.

### Option 2: Command Line

```bash
./gradlew assembleDebug
```

To install the debug build on a connected device:

```bash
./gradlew installDebug
```

## Permissions

The app requests:

- Camera permission to scan barcodes
- Internet access to retrieve product data from external APIs

## Notes

- The app currently supports UPC-A barcodes and intentionally filters out other barcode formats or unsupported UPC prefixes.
- The comparison experience is built around two separate API calls: product/retailer lookup and Amazon data lookup.
- API keys are required for the app to retrieve live product data.
- The repository does not include secret values in source control.

## License

This project does not currently include a license file. If you plan to publish or distribute it, add an appropriate open-source license before release.
