"use strict";

function pubSub() {

    const subscribers = {}; // the subscribers object will contain properties whose values are arrays
    // So each property is the channelName, and the array is composed of subscriber elements (callbacks)

    function publish(channelName, data) {
        if (!Array.isArray(subscribers[channelName])) {
            return;
        }

        subscribers[channelName].forEach((callback) => {
            callback(data);
        });
    }

    function subscribe(channelName, callback) {
        if(!Array.isArray(subscribers[channelName])) {
            subscribers[channelName] = [];
        }

        subscribers[channelName].push(callback);
    }

    // Making use of closures in this pubSub function
    return { subscribe, publish }
}

const ps = pubSub();
ps.subscribe('weather-news', (data) => {
    console.log(data);
});

ps.subscribe('weather-news', (data) => {
    console.log(data);
});

ps.publish('weather-news', 'Today is cloudy w/ a 50% chance of rain');

ps.subscribe('weather-news', (data) => {
    console.log(data);
});

ps.publish('weather-news', 'Today is sunny w/ a 0% chance of rain');