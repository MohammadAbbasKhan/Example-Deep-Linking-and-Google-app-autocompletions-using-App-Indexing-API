# Example-Deep-Linking-and-Google-app-autocompletions-using-App-Indexing-API
This Example demonstrates a simple implementation of Deep Linking and Google app autocompletions using App Indexing API

What is Deep Linking?
Deep Linking connects content on the web to the content in your android app.You are supposed to define the "host","path","pathPattern" and "scheme" in the Manifest file for the activity whose content you want to link to the web as shown below

 <activity android:name="com.example.example.SecondActivity">
             <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />

                <data
                    android:host="com.example.com"
                    android:path="/path-seperator1/path-seperator2"
                    android:pathPattern="/path-seperator1/path-seperator2/.*"
                    android:scheme="http" />
                <data
                    android:host="com.example.com"
                    android:path="/path-seperator1/path-seperator2"
                    android:pathPattern="/path-seperator1/path-seperator2/.*"
                    android:scheme="https" />
            </intent-filter>
        </activity>
  
  Whenever the user tries to open the URL as mentioned above through the android device contaning our app then he/she can see "Complete action using" Dailog with our app too and click on our app will show the requisite content in our app with much more optimized UI for the device than opening a web page.
  
  A possible URL can be com.example.com/path-seperator1/path-seperator2/aaa for above mentioned parametrs.
  
  DeepLinking then opens com.example.example.SecondActivity and on the OnCreate method we can get the hit URL through getIntent.getDataString() and perform requisite manipulations in com.example.example.SecondActivity to show the data from our app whose web URL was hit the the user.
  

