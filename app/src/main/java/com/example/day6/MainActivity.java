package com.example.day6;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterItem adapterItem;
    private ArrayList<ModelItem> modelItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getData();

        recyclerView = findViewById(R.id.item);
        adapterItem = new AdapterItem (modelItems);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterItem);

        adapterItem.setOnItemClickListener(new  AdapterItem.OnItemClickListener(){

            @Override
            public void onItemClick(ModelItem model) {

                Intent intent = new Intent(MainActivity.this, DetailItem.class);
                intent.putExtra("nama_barang", model.getNamaItem());
                intent.putExtra("deskripsi_barang", getDeskripsi(model.getNamaItem()));
                intent.putExtra("harga_barang", getHarga(model.getNamaItem()));
                intent.putExtra("gambar_Item", model.getGambarItem());
                startActivity(intent);
            }
        });
    }

    private void getData() {
        modelItems = new ArrayList<>();
        modelItems.add(new ModelItem(
                "Iphone 15 Pro Max", R.drawable.iphone15,
                "desain dan layar layar oled 6 7 inci dengan tingkat kecerahan mencapai 2000 nits dan dilindungi oleh ceramic shield bingkai terbuat dari titanium grade 5 memberikan ringan dan ketahanan ekstra tersedia dalam tiga pilihan warna putih biru dan hitam performa dan fotografi chip a17 pro bionic dengan arsitektur 3nm untuk peningkatan performa sebesar 10 kamera utama 48mp dengan sensor lebih besar kemampuan telefoto canggih dan kemampuan merekam video hingga 4k",
                33999000));
        modelItems.add(new ModelItem(
                "Black Shark", R.drawable.blackshark,
                "hp xiaomi black shark 3 pro memiliki ukuran layar sebesar 7 1 inci dengan resolusi 1440 x 3120pixels berteknologi amoled sehingga hp ini mempunyai berat sebesar 253g serta mempunyai material berupa aluminium dengan dimensi 177 8 x 83 3 x 10 1mm kinerja hp xiaomi black shark 3 pro didukung dengan prosesor qualcomm sm8250 snapdragon 865 7 nm octa core yang dapat mendukung pengguna dalam mengoprasikan hp ini kapasitas baterai yang dimiliki hp xiaomi black shark 3 pro ini adalah 4720mah yang telah mendukung fast charging kualitas kamera belakang xiaomi black shark 3 pro adalah 64 13 5mp serta memiliki kamera depan sebesar 20mp dengan type single kamera resolusi yang dihasilkan oleh kamera hp xiaomi black shark 3 pro adalah full hd.",
                16510500));
        modelItems.add(new ModelItem(
                "Samsung Z Flip", R.drawable.samsungzflip,
                "body dibuka 166 x 72 2 x 6 9 mm dilipat 86 4 x 72 2 x 15 9 17 1 mm berat 183 gr berlapis gorilla glass victus layar utama foldable dynamic amoled 2x 6 7 inci 1080 x 2640 pixel refresh rate 120hz layar cover super amoled 1 9 inci 1 9 inci chipset dan os qualcomm snapdragon 888 5g gpu adreno 660 android 11 one ui 3 5 memori 8gb ram 128gb rom 8gb ram 256gb rom kamera utama dual camera 12mp f 1 8 27mm wide 12mp f 2 2 123 ultrawide perekaman video 4k 30 60fps kamera depan single 10mp f 2 4 26mm wide perekaman 4k 30fps baterai 3 300 mah fast charging 25w fast wireless charging 11w fitur tahan air dan debu ipx8 internet 5g nfc usb type c sensor sidik jari tanpa audio jack",
                15999000));
        modelItems.add(new ModelItem(
                "Rog 7", R.drawable.rog7,
                "hp asus rog phone 7 ultimate memiliki ukuran layar standar dengan resolusi 2448 x 1080pixels berteknologi amoled sehingga hp ini mempunyai berat sebesar 239g serta mempunyai material berupa aluminium kaca dengan dimensi 173 x 77 x 10 3mm kinerja hp asus rog phone 7 ultimate didukung dengan prosesor qualcomm sm8550 ab snapdragon 8 gen 2 4 nm octa core yang dapat mendukung pengguna dalam mengoprasikan hp ini kapasitas baterai yang dimiliki hp asus rog phone 7 ultimate ini adalah 6000mah yang telah mendukung reverse charging kualitas kamera utama asus rog phone 7 ultimate adalah 50 13 5mp serta memiliki kamera selfie sebesar 32mp dengan type triple kamera resolusi yang dihasilkan oleh kamera hp asus rog phone 7 ultimate adalah full hd",
                17009500));
        modelItems.add(new ModelItem(
                "Realme 11", R.drawable.realme11,
                "hp realme 11 pro plus memiliki ukuran layar standar dengan resolusi 1080 x 2412pixels berteknologi amoled sehingga hp ini mempunyai berat sebesar 183g serta mempunyai material berupa kaca plastik dengan dimensi 73 9 x 161 6 x 8 2mm kinerja hp realme 11 pro plus didukung dengan prosesor mediatek dimensity 7050 6 nm octa core yang dapat mendukung pengguna dalam mengoprasikan hp ini kapasitas baterai yang dimiliki hp realme 11 pro plus ini adalah 5000mah yang telah mendukung fast charging kualitas kamera utama realme 11 pro plus adalah 200 8 2mp serta memiliki kamera selfie sebesar 32mp dengan type triple kamera resolusi yang dihasilkan oleh kamera hp realme 11 pro plus adalah full hd",
                7009500));
        modelItems.add(new ModelItem(
                "Asus Tuf Dash 15", R.drawable.asustufdash15,
                "processor onboard intel core i9 11900h processor 2 5 ghz 24m cache up to 4 9 ghz 8 cores memori standar 16 gb ddr4 3200mhz 8 2 tipe grafis nvidia geforce rtx 3060 laptop gpu 6gb gddr6 ukuran layar 15 6 inch fhd 1920 x 1080 16 9 anti glare srgb 62 5 adobe 45 refresh rate 144hz value ips level adaptive sync hard disk 512gb m 2 nvme pcie 3 0 ssd keyboard backlit chiclet keyboard rgb audio built in array microphone wireless network wi fi 6 802 11ax bluetooth 5 1 dual band 2 2 interfaces 1x 3 5mm combo audio jack 1x hdmi 2 0b 3x usb 3 2 gen 1 type a 1x rj45 lan port 1x type c usb 4 support displayport power delivery thunderbolt 4 sistem operasi windows 10 home microsoft office home dan student 2019 batteray 90whrs 4s1p 4 cell li ion dimension 36 0 x 25 2 x 1 99 1 99 cm berat 2 0kg colour grey free tuf gaming bagpack",
                20999000));
        modelItems.add(new ModelItem(
                "Macbook Pro", R.drawable.macbookpro,
                "display 13 3 led 2560 x 1600 retina display 500 nits processor 8 core cpu with 4 performance cores and 4 efficiency cores 10 core gpu 16 core neural engine 100gb s memory bandwidth memory 8gb unified memory hard disk 512gb ssd storage optical drive sistem operasi mac os camera 720p facetime hd camera networking 802 11ax wi fi 6 bluetooth 5 0 wireless technology secure authentication touch bar dan touch id audio stereo speakers dual microphones 3 5mm headphone jack slots interface 2x thunderbolt usb 4 ports battery integrated 58 2 watt hour lithium polymer battery adapter 67w usb c power adapter system dimensions 32 5 x 22 7 x 0 3 1 7 cm weight 1 4 kg",
                237990001));
        modelItems.add(new ModelItem(
                "Lenovo Legion", R.drawable.lenovolegion,
                "processor intel core i7 10875h processor 8 core 2 3 ghz up to 5 1ghz 16mb cache display 15 6 fhd ips 1920 x 1080 300 nits 144hz 100 adobe srgb dolby vision enabled memory 32 gb ddr4 2933mhz storage 1tb ssd m 2 2280 pcie 3 0 4 nvme graphics nvidia geforce rtx 2060 6 gb gddr6 audio 2 x 2w harman kardon speaker system keyboard 4 zone rgb backlit wireless network intel wifi 6 802 11ax 2 x 2 bluetooth 5 0 slots interface 1x power connector 1x card reader 2x usb c 3 2 gen 2 thunderbolt 3 support data transfer power delivery 100w and displayport 1 4 1x usb 3 2 gen 2 1x headphone microphone combo jack 3 5mm 1x usb 3 2 gen 2 always on operating system windows 10 home microsoft office home dan student 2019 battery integrated 71wh power adapter 230w ac adapter dimensions 356 x 250 x 15 9 17 9 weight 1 86 kg warranty garansi lenovo 2 tahun accidently damage protection bonus recon bagpack mouse headset",
                23799000));
        modelItems.add(new ModelItem(
                "Acer Nitro 5", R.drawable.acernitro5,
                "processor intel core i9 11900h processor 24mb cache up to 4 80ghz memory 16gb ddr4 3200mhz storage 512gb ssd nvme graphics nvidia geforce rtx 3060 with 6gb of gddr6 display 15 6 display with ips in plane switching technology qhd 165hz chipset intel hm570 mobile pch chipset keyboard rgb 4 zone keyboard audio optimized dolby audio premium sound enhancement camera webcam hd camera networking wireless wi fi 6 ax201 bluetooth slots interface 1x usb 3 2 gen 2 port featuring power off usb charging 2x usb 3 2 gen 1 ports 1x hdmi 2 0 port with hdcp support 1x ethernet rj 45 port 1x 3 5 mm headphone speaker jack supporting headsets with built in operating system windows 11 home microsoft office home dan student 2021 battery 57 wh lithium polymer battery battery weight 2 70 kg warranty 2 years acer indonesia bonus bag.",
                20199000));
        modelItems.add(new ModelItem(
                "Msi Katana", R.drawable.msikatana,
                "processor onboard intel core i7 12700h processor 24m cache up to 4 70 ghz memori standar 16 gb ddr4 tipe grafis nvidia geforce rtx3070 max q 8gb gddr6 ukuran layar 15 6 fhd 1920 1080 240hz close to 100 srgb hard disk 512gb nvme pcie ssd keyboard single red keyboard kamera hd type 30fps 720p wireless network intel wi fi 6 ax201 2 2 ax bt5 2 interfaces 1x type c usb3 2 gen1 2x type a usb3 2 gen1 1x type a usb2 0 1x rj45 1x 4k 60hz hdmi sistem operasi windows 11 home batteray 3 cell 53 5 whr li polymer dimension 359 x 259 x 24 9 mm berat 2 2kg colour black free bagpack msi",
                26999000));
        modelItems.add(new ModelItem(
                "Xbox", R.drawable.xbox,
                "nearly 60 percent smaller than xbox series x all digital 1440p resolution at up to 120 frames per second directx ray tracing variable rate shading variable refresh rate ultra low latency custom 512 gb nvme ssd powered by xbox velocity architecture 4k streaming media playback 4k upscaling for games the next generation of gaming brings our largest digital launch library yet to our smallest xbox ever with more dynamic worlds fast new xbox series x photos finally show what the console looks like in real life nearly 60 percent smaller than xbox series x all digital 1440p resolution at up to 120 frames per second directx ray tracing variable rate shading variable refresh rate ultra low latency custom 512 gb nvme ssd powered by xbox velocity architecture 4k streaming media playback 4k upscaling for games",
                3950000));
        modelItems.add(new ModelItem(
                "Playstation 2", R.drawable.ps2,
                "sony playstation 2 fat game console 40gb ref spch 10000 15000 free 60 games gaming pad silicon case adalah playstation 2 dengan kemampuan canggih yang dapat membaca harddisk eksternal sehingga anda tidak perlu beli atau pakai kaset lagi untuk bermain game favorit anda untuk kapasitas harddisk sony menyediakan berbagai kapasitas sehingga anda dapat memilih sesuai keinginan anda yaitu 40gb 60gb 80gb dan 160gb game atau permainan terisi langsung kedalam harddisk eksternal 1 unit playstation 2 fat series 10000 15000 1 hdd eksternal 40 gb full 60 games 2 gaming pad silicon case 2 stik getar 1 memory booting 1 kabel av 1 kabel power 1 panduan pemakaian",
                750000));
        modelItems.add(new ModelItem(
                "Playstation 3", R.drawable.ps3,
                "sony playstation 3 slim firmware cfw support dengan harddisk eksternal up to 2 terabite dan support all playstation 3 games dilengkapi kapasitas hard disk internal sebesar 500gb dan kabel hdmi set termasuk 1 ps3 slim 500gb 2 stik wireless controller original 1 kabel hdmi 1 usb charger 1 kabel power 0",
                1640000));
        modelItems.add(new ModelItem(
                "Playstation 4", R.drawable.ps4,
                "100 original 100 works 100 on time delivery bisa online offline bisa pakai kaset digital bukan hen refurbished bonus games bisa online fullset terdiri dari 1 x playstation 4 slim 500 gb cuh 20xx 21xx 22xx 1 2 x dualshock 4 wireless controller 1 x kabel micro usb 1 x kabel power 1 x kabel hdmi 1 x box fullset",
                2299000));
        modelItems.add(new ModelItem(
                "Playstation 5", R.drawable.ps5,
                "spesifikasi cpu 8x 8x zen 2 cores at 3 5 ghz gpu 10 28 tflops 36 cus at 2 23 ghz gpu architecture custom rdna 2 memory interface 16 gb gddr6 256 bit memory bandwidth 448 gbps internal storage custom 825 gb ssd io throughput 5 56 gbps raw typical 8 9 gbps expendable storage nvme ssd slot optical drive 4k uhd blu ray drive isi dalam dus 1x playstation 5 console disc version 1x dualsense wireless controller ps5 1x usb charging cable 1x hdmi cable 1x ac power cord",
                7199000));
    }

    private String getDeskripsi(String namaItem) {
        for (ModelItem item : modelItems) {
            if (item.getNamaItem().equals(namaItem)) {
                return item.getDeskripsiItem();
            }
        }
        return "";
    }

    private double getHarga(String namaItem) {
        for (ModelItem item : modelItems) {
            if (item.getNamaItem().equals(namaItem)) {
                return item.getHargaItem();
            }
        }
        return 0.0;
    }
}
