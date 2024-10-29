# **Understanding Broadcast Receivers in Android**
Thanks to Android's broadcast receiver components, applications can listen for system-wide broadcast notifications, such as low-power warnings or changes in network connectivity. By broadcasting bespoke events, they also allow apps to talk to each other.

## **What Are Broadcast Receivers?**
A Broadcast Receiver is a component that responds to broadcast messages (intents) from other applications or the system itself. These messages can be:

  1- System Broadcasts: Notifications like low battery, Wi-Fi state change, or screen turned off. 
  
  2- Custom Broadcasts: Messages that your app can send to notify other parts of the app or other apps.

## **Step 1: Creating a Simple Broadcast Receiver**
Create a class that inherits ***BroadcastReceiver()*** to specify what the broadcast do
```kotlin 
class MyBroadCast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

      val isTurnedOn = Settings.Global.getInt(
            context?.contentResolver,
            Settings.Global.AIRPLANE_MODE_ON
        ) != 0
        val x = if (isTurnedOn) "On" else "Off"
        Toast.makeText(context, "AirPlane mode is $x", Toast.LENGTH_LONG).show()

    }
}
```

## **Step 2:Register the Receiver in Your Activity
There are to ways There are two ways to register a Broadcast Receiver: dynamically in code or statically in the ***AndroidManifest.xml.***

1- Dynamically

```kotlin
class MainActivity : AppCompatActivity() {
  ......
private val myBroadCast = MyBroadCast()

 override fun onCreate(savedInstanceState: Bundle?) {
        .......
        registerReceiver(myBroadCast, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
       
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadCast)
    }
```

2- Staticlly 
``` XML
  <receiver
            android:name=".MyBroadCast"
            android:enabled="true"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.AIRPLANE_MODE" />
            </intent-filter>
        </receiver>
```
### **When should you use static or dynamic ?**
### Easiest way is:
If you want your App to listen to the broadcast even when closed, Go for a ***Static Broadcast receiver***.

If you want your App to listen only for certain instances (When the App is running) then go for ***Dynamic BroadCast Receiver***

but static needs **permission** don't forget that
