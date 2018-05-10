# Birthday-App-Android-

This project is to send a gift to the birthday person an android app.

Just set the name, text you want to show, birth day, month, time generate an APK.

Send it to the user and tell him/her to wait until the surprise comes!

## Screenshots

After installing in android device

![Home](/Screenshots/layout-2018-05-10-195412.png = =100x200)

## Generating the gift


1. Open **app/src/main/java/com/example/shoukhin/bgift/CalculateTime.java** and edit the name, date etc that you want to edit.

2. To change previewed text, open **app/src/main/res/values/strings.xml** and replace the variable **letter_text**'s value with your desired text.

3. To change the video go to **app/src/main/res/raw** and replace the **video.mp4** with your desired video.
**Note : keep the video name 'video.mp4' otherwise u have to change the name of the video from app/src/main/java/com/example/shoukhin/bgift/Surprise.java**

4. Generate APK. (In android studio **Build->Generate Signed APK**)

5. Install to the birthday person's android device.

6. Wait until the time his/her birthday!