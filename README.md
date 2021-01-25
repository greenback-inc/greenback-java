# Greenback Kit for Java

[![Maven Central](https://img.shields.io/maven-central/v/com.greenback/greenback-java)](https://mvnrepository.com/artifact/com.greenback/greenback-java)
[![Build Status](https://travis-ci.org/greenback-inc/greenback-java.svg?branch=master)](https://travis-ci.org/greenback-inc/greenback-java)

![Greenback Logo](https://www.greenback.com/assets/f/blogs/github-greenback-java/greenback-logo-badge.png)

The official [Greenback](https://www.greenback.com) open source Kit for Java! Quickly build your JVM or Android application by leveraging our modular implementation in Java. Compatible with Java 8+, Android, and other JVM languages such as Scala, Kotlin, Groovy, and more.

The [Greenback Platform](https://www.greenback.com/platform) consists of APIs to build modern applications with high-def itemized financial data.  You can read more about our REST-based APIs and data models on the [Greenback Developer Portal](https://developer.greenback.com).

High-def itemized financial data includes all the details of a transaction that are missing on a typical credit card or bank feed.  Rather than just an amount of money and a brief description, high-def itemized data includes the line items, vendor/supplier information, postal addresses, tax (sales, VAT, GST), payment instrument details, transaction type, invoice number, and more. In a nutshell, the fully detailed data that represents a GAAP-compliant financial transaction. Greenback provides a common data model and developer-friendly method to sync or extract data using various methods:

## Vision API

Advanced AI, OCR (Optical Character Recognition), and NLP (Natural Language Processing) to extract structured transaction data from real world photos and documents in near real-time. You can quickly and easily build web or mobile applications that can convert images (PNG/JPEG) or documents (Microsoft Word/HTML/PDF) that contain receipts, bills, invoices, statements, and other types into structured and annotated data.

![Greenback Kit on Android Demo](https://www.greenback.com/assets/f/blogs/github-greenback-java/greenback-vision-demo.gif)

## Mailbox API

Convert RFC822 emails, including attachments and embedded links, into structured transaction data. You can quickly convert original or forwarded RFC822 emails, including attachments and embedded URLs, into structured transaction data.

![Greenback Mailbox API](https://www.greenback.com/assets/f/blogs/github-greenback-java/mailbox-markup-min.png)

## Mailbox Connect API

Fetch itemized receipts & invoices from Gmail, Microsoft 365 & Yahoo Mail email accounts.

## Connect API

Connect, authenticate and acquire transaction data directly from top retailers,  marketplaces, platforms such as Amazon, Home Depot, Walmart, and more.

![Greenback Connect API](https://www.greenback.com/assets/f/blogs/github-greenback-java/connect-phones-min.png)


## Installation

### Requirements

- [Greenback Platform Account (free to register here)](https://www.greenback.com/platform/enroll)
- Java 1.8 or later
- Compatible with Android (Level 16+)

### Dependencies and Modularity

The Greenback Kit for Java was designed to be flexible about what dependencies we require to run. Most functionality is in the `greenback-kit-core` module, which has just a single, tiny external dependency to simplify URL handling. Since parsing JSON and executing HTTP calls can bring in dependencies you may not want, the kit was designed to implement each of these as separate modules (jars) so you can choose which ones you want to use, or possibly even implement your own.  For example, if you don't want to use Jackson for Json, you could easily swap in an implementation in Gson instead.

### Gradle users

Add this dependency to your project's build file:

```groovy
implementation "com.greenback:greenback-kit-jackson:1.0.5"
implementation "com.greenback:greenback-kit-okhttp:1.0.5"
```

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.greenback</groupId>
  <artifactId>greenback-kit-jackson</artifactId>
  <version>1.0.5</version>
</dependency>
<dependency>
  <groupId>com.greenback</groupId>
  <artifactId>greenback-kit-okhttp</artifactId>
  <version>1.0.5</version>
</dependency>
```


## Usage

### Vision

A demo of using the Greenback Vision API to extract a receipt from a photo (PNG/JPEG) is here: [greenback-kit-okhttp/src/test/java/com/greenback/kit/demo](greenback-kit-okhttp/src/test/java/com/greenback/kit/demo)

```java
// build httpClient, pick baseUrl, and set accessToken...

final GreenbackClient client = new OkHttpGreenbackClient(
    httpClient,
    baseUrl,
    new JacksonGreenbackCodec(),
    accessToken);

Vision vision = client.createVision(new VisionRequest()
    .setAsync(true)
    .setDocument(new File("../samples/7eleven_sample.jpg")));

log.debug("Vision: id={}, name={}, status={}, updated={}",
    vision.getId(), vision.getName(), vision.getStatus(), vision.getUpdatedAt());
            
// poll every 500 ms for processing status
while (!vision.getStatus().isTerminal()) {
    vision = client.getVisionById(vision.getId());
                
    log.debug("Vision: id={}, name={}, status={}, updated={}",
        vision.getId(), vision.getName(), vision.getStatus(), vision.getUpdatedAt());
                
    Thread.sleep(500L);
}
```

You may also want to check out our sample [Android application for Vision](https://github.com/greenback-inc/greenback-android-demo).


### Mailbox

A demo of using the Greenback Mailbox API to extract a receipt from an RFC822 mime email message is here: [greenback-kit-okhttp/src/test/java/com/greenback/kit/demo](greenback-kit-okhttp/src/test/java/com/greenback/kit/demo)

```java
// build httpClient, pick baseUrl, and set accessToken...

final GreenbackClient client = new OkHttpGreenbackClient(
    httpClient,
    baseUrl,
    new JacksonGreenbackCodec(),
    accessToken);

Message message = client.createMessage(new MessageRequest()
    .setAsync(true)
    .setDocument(new File("../samples/disney_sample.msg")));

log.debug("Message: id={}, name={}, status={}, updated={}",
    message.getId(), message.getName(), message.getStatus(), message.getUpdatedAt());

// poll every 500 ms for processing status
while (!message.getStatus().isTerminal()) {
    message = client.getMessageById(message.getId());

    log.debug("Message: id={}, name={}, status={}, updated={}",
        message.getId(), message.getName(), message.getStatus(), message.getUpdatedAt());

    Thread.sleep(500L);
}
```

## License

This project and source code is licensed with Apache License 2.0.

## Questions and Support

Please contact [Greenback Support or Sales](https://www.greenback.com/contact) if you have any additional questions.
