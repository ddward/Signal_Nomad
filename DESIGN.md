# Design Notes for Signal_Nomad

The project has 4 distinct components/functionalities:
1. A Google Maps based UI
2. A database implementation
3. Retrieval of location data
4. Retrieval of Network Information

Google makes their Maps API quite intuitive and implementation of the UI is based on stock code from Google with some basic button functionality overplayed.

The database uses the basic functionality of the Room Persistence library, the Google recommended abstraction layer above SQLite. Code in my app was adapted from the Room tutorial here: https://developer.android.com/training/data-storage/room/

Retrieval of location services is well documented and was implemented in line with the requirements of the Android API. 

My app displays Network Type as opposed to Signal Strength (as you would see measured by "bars" on your phone) the latter proved to be very difficult to extract from the Android API for me. From research it appears that others have had similar difficulty retrieving this data. The goal of the app is to allow an individual to track the locations that they had data service. Using Network Type is at least as good for this purpose.

The App combines all components in a main activity allowing the user to pull down location and network on a button click, subsequently displaying the information in the form of a map marker. The Google Maps API by default allows for navigation to markers.

Features I plan to add in the future are: 1. Ability to delete individual markers, 2. Ability to input markers from the GUI given latitude, longitude, and network type. Ability to copy latitude, longitude, and network type from a marker.
