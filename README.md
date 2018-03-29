# GiphyDev

![alt text](https://giphy.com/static/img/labs.gif)

A simple application developed to learn Kotlin using the public Giphy API.
https://developers.giphy.com/

## Giphy API Documentation

GIPHY's API makes it dead simple for developers to incorporate GIPHY's vast library right inside of their apps. Use it across all types of apps: messaging, chat, dating, creation, community, and more!

## API Highlights

    HOST
    http://api.giphy.com

### Search Endpoint
The GIPHY Search Endpoint is the granddaddy of them all, allowing your project or app to leverage the powerful GIF search found on giphy.com to your liking. GIPHY Search enables your users to instantly find the exact GIF they're looking for and discover new favorites. They'll never want to leave.

###### PATH

    GET /v1/gifs/search
    
###### DESCRIPTION
 
    Search all GIPHY GIFs for a word or phrase. Punctuation will be stripped and ignored. 
    Use a plus or url encode for phrases. Example paul+rudd, ryan+gosling or american+psycho.

### Trending Endpoint
GIPHY's Trending Endpoint provides a collection of up-to-the-minute memes, tropes, and touchstones of pop culture, editorialized by real humans. Your users will have instant access to all of it.

###### PATH

    GET /v1/gifs/trending
    
###### DESCRIPTION

    Fetch GIFs currently trending online. Hand curated by the GIPHY editorial team. 
    The data returned mirrors the GIFs showcased on the GIPHY homepage. Returns 25 results by default.


### Random Endpoint
Need a random GIF on the fly? Say no more. The Random Endpoint returns a random GIF, limited by tag. Tell us what kind of GIF you're looking for by keyword, and we'll spin the wheel to deliver you something special and new every time. You never know what you're going to get, but we know you you're going to like it.

###### PATH

    GET /v1/gifs/random
    
###### DESCRIPTION

    Returns a random GIF, limited by tag. Excluding the tag parameter will 
    return a random GIF from the GIPHY catalog.

NOTE: The data returned mirrors the GIFs showcased on the GIPHY homepage. Returns 25 results by default.

## Dependencies used:

* RxJava -> Reactive Programming (https://github.com/ReactiveX/RxJava)
* Dagger -> Inject dependencies (https://google.github.io/dagger/)
* Retrofit 2 -> Request/Response API. (http://square.github.io/retrofit/)
* OkHttp -> An HTTP & HTTP/2 client for Android and Java applications. (https://github.com/square/okhttp)
* GSON -> Parse JSON to Java POJOs (https://github.com/google/gson)

