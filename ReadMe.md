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

```bash
* b3528fa        (HEAD -> master, origin/master) readme yer degisikligi
| * 35e2787      (origin/MySoundPlot1, MySoundPlot1) service den datayi UI ye alamiyorum. onbinding kullanmaya calistim ama olmadi
| * e4c128e      grafik eklendi canli degil
| * 762fb1a      ses max degerini gafikte gormek
| | * d101570    (origin/MyPlot1, MyPlot1) build.gradle a buildscript eklendi deneme
| | * 236c018    MPChart la bir grakik cizldi. butona basinca
| | | * ae6e1b7  (origin/MyPlot3, origin/MyLayout4, MyPlot3, MyPlot2) yeni bir plot lib denemesi
| | | * b0b11d7  yeni bir plot lib denemesi
| | | * 5f8c8d6  yeni plot lib denemsi
| | | | * 1f854ab        (origin/MyLayout3, MyLayout3) libi silmis gradle da olmasina ragmen tekrar yukledim
| | | |/  
| | |/|   
| | * | 72a5812  MPChart la bir grakik cizldi. butona basinca
| | * | 20c2974  MPChart lib ini ekledim. bir grafik cizdi
| | * | 3096b30  bu plot pek kotlin destekli degil gibi o yuzden siliyorum yeni bir kutuphane deniyorum
| | * | d3feb0e  plot eklendi
| | * | 26d89ca  bottom nav daki item lere click listener eklendi
| | * | 4785e4e  dialoga buton eklendi
| | * | 5c43376  dialoga buton eklendi
| | * | 53f1687  dialog da sayi sayildi
| | * | 3c194da  butona alert dialog eklendi
| | * | 5711f97  (origin/MyLayout2, MyLayout2) sol ust 3 noktali option menu eklendi
| | |/  
| | * 770e92c    (origin/MyLayout1, MyLayout1) The 'kotlin-android-extensions' Gradle plugin is deprecated hatası çözümü eklendi
| | * ff13602    menu bar denemesi
| |/  
|/|   
| | * 313af96    (origin/Myintent1, Myintent1) intent result la ilgili yeni tarz
| | * 3668eef    intent ile resim dosyasi acma
| | * 5bab8b5    third acivity eklendi
| | * 5a5967f    activity sayfasi eklemek
| |/  
|/|   
| | * bd549a8    (origin/MyStorage_1, MyStorage_1) markdown na not
| | * bf7444b    en sonunda daha once kaydettigim dosya konumunu acabildim
| | * 291ec8e    istedigim dosya konumunu acmaya calisiyorum hala
| | * d614ccc    dosya konumu acma olmadi henuz
| | *   6f369f0  Merge remote-tracking branch 'origin/MyStorage_1' into MyStorage_1
| | |\  
| | | * 664b65a  duzenlemeherhangi bir dosyanin konumunu açma
| | |/  
| |/|   
| | * c3b08e7    bir ara kotlin extension hatasi verdi geri aldım programi
| |/  
| * cad8ae2      (origin/My_background_sound_record_and_phone_call_2, origin/My_background_sound_record_and_motion_1, My_background_sound_record_and_phone_call_2, My_background_sound_record_and_motion_1) duzenleme
| * 329a1bf      ses seviyesine gore arama oldu
| * fb01a8f      call u myservice tasidim
| * c06f251      stackoverflaww deki call ornegı eklendi
| * b464767      service den tetiklenen call icin calisma
| * 05ed1d3      (origin/My_background_sound_record_and_phone_call_1, My_background_sound_record_and_phone_call_1) sensor calisiyor
| * 1d1e100      sensor calisiyor, ses zaten vardı
| * 1573cf8      hareket sensoru verileri ekledim. oldu gibi
| * 71a8ee4      sese birde hareket sensoru verileri eklmemek icin calisma
| * 3cbad32      (origin/My_background_sound_record_1, My_background_sound_record_1) not baslik degisti
| * 938bc3d      (origin/My_interface_flow_permission_sound_2, My_interface_flow_permission_sound_2) tarih saat ekledim
| * cfbf0a8      text dosyasina kayıt ekledim calisiyor gibi
| * 1823df6      foregroun service kodunu ekledim ornekteki gibi
| * 7a96923      (origin/My_interface_flow_permission_sound_1, My_interface_flow_permission_sound_1) flow un icinde bir job tanimaldim
| * acaf3d5      flow bir döngüye sokma calisması
| * b7c2cb2      media recorder start ta hata
| * a898d29      Permission almayı başardım
| * 270185c      (origin/My_interface_flow_permission_1, My_interface_flow_permission_1) Permission almayı başardım
| * ba4b602      Permission almayı başardım
| * be341b0      Permission icin denemeler
| * 6734d70      (origin/My_interface_flow_3, My_interface_flow_3) notification kısmına degisen data gönderdim
| * 898d6b6      (origin/My_interface_flow_2, My_interface_flow_2) awaitClose kullanmak ise yaradı
| * 873a5a6      flow da onEach bazen data alıyor bazen almıyor
| * e201b89      ilk flow u sildim sadece ornekteki tarz kaldı
| * 5fd458d      interface e flow da ornege yaklastım
| * 1f6b0e5      (origin/My_interfaceand_flow, My_interfaceand_flow) interface e flow eklemek
| * f132d6d      (origin/Myinterface, origin/MyFlow1, Myinterface, MyFlow1) interface kavramini kurcalıyorum
| * bb90fa2      interface icin olusturulması gereken bir class var
|/  
* 8658ec5        (origin/MyServiceCalisti, origin/BroadcastReceiverCalisti, MyServiceCalisti, BroadcastReceiverCalisti) Foureground service için çalışmalar

```
