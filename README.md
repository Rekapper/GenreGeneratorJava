# Genre Generator
Android App @ https://play.google.com/store/apps/details?id=com.rekapper.genregenerator
Discover new music genres, listen to music and share or tweet them to your friends. Built in tools to tweet directly with hashtags. Easy to use Youtube links to the genre by search with the top results for that genre listing. With over 5000 different generated combinations and more to arrive in the future with demand. Try to generate normal genres like Surf-Rock or try to even find obscure never tried before genres like Sunshine-Trance and challenge your friends to make a song in that genre.
## Java Source ##
The [Main Activity file path is located at: GenreGeneratorJava/app/src/main/java/com/rekapper/genregenerator/MainActivity.java](https://github.com/Rekapper/GenreGeneratorJava/blob/master/app/src/main/java/com/rekapper/genregenerator/MainActivity.java).  
This is where a majority of the code of the Genre Generator takes place as it starts by calling in the New Relic state to track crashing states.  Then follows with the AdMob requests as documented at https://developers.google.com/admob/android/quick-start#configure_gradle.  
Following is the triggers for the buttons and the vast arrays for the genres.  That could be further optimized by pulling down new elements from a secondary server to produce the contents genre string but this was simple enough to handle across an two arrays and a randomizing script.
Twitter handler and intent arrives after that tied with the functionality of Twitters Fabric tools so that both the native app is called for first and then if that doesn't work, it's passed off in a normal browser oriented intent following Twitter's API so that arrives as much of a convenience.  
YouTube's API is not really convenient to write for building an internal browser based on a search result to show a singular result of that search without having massively sudo-random database listings.  So that and the share button follow the normal intent calls for android with the YouTube one built around google apps YouTube which by default is installed on most devices. 
##Permissions##
For Fabric to operate properly, it requires:

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
This also follows the rules and requirements for both AdMob and New Relic
##Layout##
The base layout is located at GenreGeneratorJava/app/src/main/res/layout/activity_main.xml
Pretty simple following android standards minus the rounded buttons which follows along the lines of 

    <shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle" android:padding="10dp">
    <solid android:color="#3b5998"/>
    <corners
        android:bottomRightRadius="10dp"
        android:bottomLeftRadius="10dp"
        android:topLeftRadius="10dp"
        android:topRightRadius="10dp"/>
	</shape>
Located here for each button:  [GenreGeneratorJava/app/src/main/res/drawable/roundshapebtn.xml](https://github.com/Rekapper/GenreGeneratorJava/blob/master/app/src/main/res/drawable/roundshapebtn.xml)
