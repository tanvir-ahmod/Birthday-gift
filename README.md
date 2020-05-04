# Birthday-App-Android-

This project is to send a gift to the birthday person an android app.

Just set the name, text you want to show, birth day, month, time generate an APK.

Send it to the user and tell him/her to wait until the surprise comes!

## Screenshots

After installing in android device

<img src="https://github.com/tanvir-ahmod/Birthday-App-Android-/blob/master/Screenshots/Screenshot_2020-05-04-18-22-03-771.jpg" alt="Screenshot" width="320" height ="693">


## Generating the gift


* Open [Constants.java](https://github.com/tanvir-ahmod/Birthday-App-Android-/blob/master/app/src/main/java/com/example/shoukhin/bgift/Constants.java) and edit the variables TARGET_MONTH or TARGET_DATE or other variables and set to the time you want to play.

* To change receiver name, open [String.xml](https://github.com/tanvir-ahmod/Birthday-App-Android-/blob/master/app/src/main/res/values/strings.xml) and replace the variable receiver_name's value with your receiver name.

* To change preview text at home page, open [String.xml](https://github.com/tanvir-ahmod/Birthday-App-Android-/blob/master/app/src/main/res/values/strings.xml) and replace the variable letter_text's value with your text.

* To change the video go to [raw](https://github.com/tanvir-ahmod/Birthday-App-Android-/tree/master/app/src/main/res/raw) and replace the video.mp4 with your video.
<br />Note : keep the video name 'video.mp4' otherwise you have to change the name of the video from [Surprise.java](https://github.com/tanvir-ahmod/Birthday-App-Android-/blob/master/app/src/main/java/com/example/shoukhin/bgift/Surprise.java)

* Generate APK. (In android studio **Build->Generate Signed APK**)

* Install to the person's android device that you want to play.

* Wait until the time his/her birthday!
