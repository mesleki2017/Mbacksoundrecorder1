1- Fouregroun service öğrenirken hep karşıma çıkan öyeler

- flow
- courutine
- intent
- service
- broadcast reciever
- notifications

# Broadcast in android
Broadcast in android is the system-wide events that can occur when the device starts, when a message is 
received on the device or when incoming calls are received, or when a device goes to airplane mode, etc.
Broadcast Receivers are used to respond to these system-wide events. Broadcast Receivers allow us to register 
for the system and application events, and when that event happens, then the register receivers get notified.
There are mainly two types of Broadcast Receivers:
- Static Broadcast Receivers
- Dynamic Broadcast Receivers

https://www.geeksforgeeks.org/broadcast-receiver-in-android-with-example/
buradki örnek çalıştı


## FLOW
- FLow mantığını öğrenmem gerekiyor bazı kodaları anlamak için
- https://blog.mindorks.com/what-is-flow-in-kotlin-and-how-to-use-it-in-android-project/
   In coroutines, a flow is a type that can emit multiple values sequentially,
as opposed to suspend functions that return only a single value.
For example, you can use a flow to receive live updates from a database.
  yukardaki linkte olan örneği uyguladım çalışıyor. ama nackground location tracking örneğindeki
stili uygulayamadım.

- https://stackoverflow.com/questions/54827455/how-to-implement-timer-with-kotlin-coroutines

##10 gün ugrastim daha önceki repolarda kaydettiğim txt dosyasinin yerini file explorer da acmak icin

``` kotlin
btn_call.setOnClickListener {
val dd: File? = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)

            val uri :Uri? = Uri.parse(dd?.toString())
            //https://stackoverflow.com/questions/21544331/trying-open-a-specific-folder-in-android-using-intent
            // bu koddan sonra mi acabildim tam eminde degilim
            // o kadar cok deneme yanilma yaptimki

            val intent = Intent()
                .setAction(Intent.ACTION_VIEW)//burasi gerekli
                .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)//bunlar gereklimi emin degilim
                .addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)//bunlar gereklimi emin degilim
                .addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)//bunlar gereklimi emin degilim
                .setDataAndType(uri, "resource/folder")//burasi gerekli
            startActivity(intent)

        }
```

