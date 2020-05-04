# Birthday-App-Android-

This project is to send a gift to the birthday person an android app.

Just set the name, text you want to show, birth day, month, time generate an APK.

Send it to the user and tell him/her to wait until the surprise comes!

## Screenshots

After installing in android device

![Home](/Screenshots/layout-2018-05-10-195412.png)

## Generating the gift


* Open [Constants.java](https://github.com/tanvir-ahmod/Birthday-App-Android-/blob/develop/app/src/main/java/com/example/shoukhin/bgift/Constants.java)  and edit the variables TARGET_MONTH or TARGET_DATE or other variables and set to the time you want to play.

* To change receiver name, open [String.xml](https://github.com/tanvir-ahmod/Birthday-App-Android-/blob/develop/app/src/main/java/com/example/shoukhin/bgift/Constants.java) and replace the variable receiver_name's value with your receiver name.

* To change preview text at home page, open [String.xml](https://github.com/tanvir-ahmod/Birthday-App-Android-/blob/develop/app/src/main/java/com/example/shoukhin/bgift/Constants.java) and replace the variable letter_text's value with your text.

* To change the video go to [Asset](https://github.com/tanvir-ahmod/Birthday-App-Android-/blob/develop/app/src/main/java/com/example/shoukhin/bgift/Constants.java) and replace the video.mp4 with your video.
Note : keep the video name 'video.mp4' otherwise you have to change the name of the video from [Surprise.java](https://github.com/tanvir-ahmod/Birthday-App-Android-/blob/develop/app/src/main/java/com/example/shoukhin/bgift/Constants.java)

* Generate APK. (In android studio **Build->Generate Signed APK**)

* Install to the person's android device that you want to play.

* Wait until the time his/her birthday!