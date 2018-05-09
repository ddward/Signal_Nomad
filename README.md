Pi# signal_nomad
##### CS50 Final Project
##### David Ward
##### Spring 2018

### Opening the Project in Android Studio

1. Download Android Studio for free here: https://developer.android.com/studio/
2. Open the downloaded file and follow the installation instructions, keeping the default settings when prompted. Make sure that you download the Android Virtual Machine if you don't have an Android phone available. This download is enabled by default. 
3. Download the app source code from the main page in this GitHub Repository.
4. Unzip the downloaded file, you should now have an unzipped folder called "signal_nomad-master"
5. Open Android Studio and select File->Open then select the signal_nomad-master folder from the location that you chose to download the files to.
6. Click open, the app may take a moment to open.  
  * If you receive an error that looks like "Failed to find target with hash string..." Simply click the adjacent "Install missing platform(s) and sync project" to install the needed files.
  * If you receive an error that looks like "Failed to find Build Tools..." Click the adjacent "Install Build Tools..." link to install the needed files and sync the project
7. In order for the app to work properly, you'll need to have a Google Maps API key. If you already have a Google account you can get an API key by following this link: https://console.developers.google.com/, create a new project, navigate to "Credentials using the sidebar, select "Create credentials" -> API key. Copy this API key. 
8. In Android Studio, in the file viewer on the left, navigate to the following file: app/res/values/google_maps_api.xml. Set the value of the "google_maps_key" variable to the API key you generated in step 7.
9. If you have an Android phone available, follow the steps in section A below (suggested). If not, follow the steps in section B.

### A. Running the app on an Android Phone
  1. Enable USB debugging. If unsure how to do this follow the steps here: https://www.howtogeek.com/129728/how-to-access-the-developer-options-menu-and-enable-usb-debugging-on-android-4.2/

  2. Plug your phone in to a USB port
  3. Press the green "run" arrow at the top of the Android Studio screen and select your device from the pop-up screen.
  4. After a moment the app should open on your screen.
  5. In order to run the app fully you'll need to enable location services. Exit the app, on your phone navigate to settings->apps->signal nomad and activate location services.
  6. Reopen the app, you should see a screen that resembles Google Maps
  7. Press the "Drop Pin" button to display a marker at your current location along with the network type you currently have - 4G, 3G, 2G, or Unknown. 
  8. Repeat as much as desired, press clear markers to remove all markers from the map (the data points are still stored and will display when the app re-opens.
  9. You can select a marker which allows a navigation option at the bottom right, that will open navigation in Google Maps.
  
### B. Running the app on the Android Studio Emulator
  1. Press the green "run" arrow at the top of the Android Studio Screen and select "Create New Virtual Device".
  2. Press next and select "download" on Android P. Install with default settings. Once installed a virtual machine will appear on your screen.
  3. In order to run the app fully you'll need to enable location services. Exit the app, on your phone navigate to settings->apps->signal nomad and activate location services.
  4. Reopen the app, you should see a screen that resembles Google Maps
  5. Press the "Drop Pin" button to display a marker at the default emulator California location along with the default emulator network type: 4G.
  6. You can select a marker which allows a navigation option at the bottom right, that will open navigation in Google Maps.


