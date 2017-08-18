package kodluyoruz.bootcamp.kadir.com.havadurumuapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import kodluyoruz.bootcamp.kadir.com.havadurumuapp.models.WeatherStatusModel;
import kodluyoruz.bootcamp.kadir.com.havadurumuapp.networks.Contanst;
import kodluyoruz.bootcamp.kadir.com.havadurumuapp.networks.Factory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{
    private String[] iller = {"İl Seçiniz",       "ADANA"          , "ADIYAMAN"       , "AFYONKARAHİSAR" , "AĞRI"           , "AMASYA"         , "ANKARA"         , "ANTALYA"        , "ARTVİN"         , "AYDIN"          , "BALIKESİR"      , "BİLECİK"        , "BİNGÖL"         , "BİTLİS"         , "BOLU"           , "BURDUR"         , "BURSA"          , "ÇANAKKALE"      , "ÇANKIRI"        , "ÇORUM"          , "DENİZLİ"        , "DİYARBAKIR"     , "EDİRNE"         , "ELAZIĞ"         , "ERZİNCAN"       , "ERZURUM"        , "ESKİŞEHİR"      , "GAZİANTEP"      , "GİRESUN"        , "GÜMÜŞHANE"      , "HAKKARİ"        , "HATAY"          , "ISPARTA"        , "MERSİN"         , "İSTANBUL"       , "İZMİR"          , "KARS"           , "KASTAMONU"      , "KAYSERİ"        , "KIRKLARELİ"     , "KIRŞEHİR"       , "KOCAELİ"        , "KONYA"          , "KÜTAHYA"        , "MALATYA"        , "MANİSA"         , "KAHRAMANMARAŞ"  , "MARDİN"         , "MUĞLA"          , "MUŞ"            , "NEVŞEHİR"       , "NİĞDE"          , "ORDU"           , "RİZE"           , "SAKARYA"        , "SAMSUN"         , "SİİRT"          , "SİNOP"          , "SİVAS"          , "TEKİRDAĞ"       , "TOKAT"          , "TRABZON"        , "TUNCELİ"        , "ŞANLIURFA"      , "UŞAK"           , "VAN"            , "YOZGAT"         , "ZONGULDAK"      , "AKSARAY"        , "BAYBURT"        , "KARAMAN"        , "KIRIKKALE"      , "BATMAN"         , "ŞIRNAK"         , "BARTIN"         , "ARDAHAN"        , "IĞDIR"          , "YALOVA"         , "KARABÜK"        , "KİLİS"          , "OSMANİYE"       , "DÜZCE"          };
    private String[] ank				= {"İlçe Seçiniz", "Altındağ", "Ayaş", " Bala", "Beypazarı", "Çamlıdere", "Çankaya", "Çubuk", "Etimesgut", "Haymana", "Kalecik", "Keçiören", "Kızılcahamam", "Mamak", "Nallıhan", "Polatlı", "Şereflikoçhisar", "Sincan", "Yenimahalle"};
    private String[] ist	 			= {"İlçe Seçiniz", "Adalar", "Bağcılar", "Bahçelievler", "Bakırköy", "Beşiktaş", "Beykoz", "Beyoğlu", "Büyükçekmece", "Çatalca", "Eminönü", "Esenler", "Eyüp", "Fatih", "Gaziosmanpaşa", "Güngören", "Kadıköy", "Kağıthane", "Kartal", "Küçükçekmece", "Maltepe", "Pendik", "Sarıyer", "Silivri", "Şile", "Şişli", "Sultanbeyli", "Tuzla", "Ümraniye", "Üsküdar", "Zeytinburnu"};
    private String[] izmr 			    = {"İlçe Seçiniz", "Aliağa", "Balçova", "Bayındır", "Bergama", "Beydağ", "Bornova", "Buca", "Çeşme", "Dikili", "Foça", "Güzelbahçe", "Karaburun", "Karşıyaka", "Kemalpaşa", "Kınık", "Kiraz", "Konak", "Menderes","Menemen", "Narlıdere", "Ödemiş", "Seferihisar", "Selçuk", "Tire", "Torbalı", "Urla"};
    private String[] adna 			    = {"İlçe Seçiniz", "Aladağ", "Ceyhan", "Feke", "Karaisalı", "Kozan", "Pozantı", "Saimbeyli", "Seyhan", "Yumurtalı", "Yüreğir"};
    private String[] adymn 			    = {"İlçe Seçiniz", "Besni", "Gölbaşı", "Kahta", "Merkez"};
    private String[] afyn 			    = {"İlçe Seçiniz", "Başmakçı", "Bolvadin", "Çay", "Çobanlar", "Dinar", "Emirdağ", "İhsaniye", "Kızılören", "Merkez", "Sandıklı", "Sincanlı", "Suhut", "Sultandağı"};
    private String[] agri 			    = {"İlçe Seçiniz", "Diyadin", "Doğubeyazıt", "Merkez", "Patnos", "Tutak"};
    private String[] aksry 			    = {"İlçe Seçiniz", "Eskil", "Gülağaç", "Güzelyurt", "Merkez"};
    private String[] amsya 			    = {"İlçe Seçiniz", "Göynücek", "Gümüşhacıköy", "Merkez", "Merzifon", "Suluova", "Taşova"};
    private String[] ant 			    = {"İlçe Seçiniz", "Akseki", "Alanya", "Elmalı", "Finike", "Gazipaşa", "İbradi", "Kale", "Kaş", "Korkuteli", "Kumluca", "Manavgat", "Merkez", "Serik"};
    private String[] ardhn 			    = {"İlçe Seçiniz", "Çıldır", "Göle", "Merkez"};
    private String[] artvn 			    = {"İlçe Seçiniz", "Ardanuc", "Arhavi", "Hopa", "Merkez", "Murgül", "Savsat", "Yusufeli"};
    private String[] aydn 			    = {"İlçe Seçiniz", "Bozdoğan", "Buharkent", "Çine", "Germencik", "İncirliova", "Karacasu", "Karpuzlu", "Koçarlı", "Köşk", "Kuşadası", "Kuyucak", "Merkez", "Nazilli", "Söke", "Sultanhisar", "Yenihisar", "Yenipazar"};
    private String[] baliksr			= {"İlçe Seçiniz", "Ayvalık", "Balya", "Bandırma", "Bigadiç", "Burhaniye", "Dursunbey", "Edremit", "Erdek", "Gömeç", "Gönen", "Havran", "İvrindi", "Kepsut", "Manyas", "Merkez", "Savaştepe", "Sındırgı", "Susurluk"};
    private String[] brtn 			    = {"İlçe Seçiniz", "Amasra", "Merkez", "Ulus"};
    private String[] btmn 			    = {"İlçe Seçiniz", "Hasankeyf", "Merkez"};
    private String[] bybrt 			    = {"İlçe Seçiniz", "Aydıntepe", "Demirözü", "Merkez"};
    private String[] bilck 			    = {"İlçe Seçiniz", "Bozhüyük", "Gölpazarı", "Merkez", "Osmaneli", "Pazaryeri", "Söğüt"};
    private String[] bngl 			    = {"İlçe Seçiniz", "Adaklı", "Genç", "Karlıova", "Kiğı", "Merkez", "Solhan", "Yayladere", "Yedisu"};
    private String[] btls 			    = {"İlçe Seçiniz", "Adilcevaz", "Ahlat", "Güloymak", "Merkez", "Mutki", "Tatvan"};
    private String[] blu 			    = {"İlçe Seçiniz", "Dörtdivan", "Gerede", "Göynük", "Mengen", "Merkez", "Mudurnu", "Yeniçağa"};
    private String[] brdr 			    = {"İlçe Seçiniz", "Ağlasun", "Bucak", "Çavdır", "Gölhisar", "Karamanlı", "Merkez", "Tefenni", "Yeşilova"};
    private String[] brsa			    = {"İlçe Seçiniz", "Gemlik", "Gürsu", "İnegöl", "İznik", "Karacabey", "Keleş", "Kestel", "Mudanya", "Mustafa Kemal Paşa", "Nilüfer", "Orhaneli", "Orhangazi", "Osmangazi", "Yenişehir", "Yıldırım"};
    private String[] cnk 			    = {"İlçe Seçiniz", "Ayvacık", "Bayramiç", "Biga", "Bozcaada", "Çan", "Eceabat", "Ezine", "Gölbaşı", "Gökçeada", "Lapseki", "Merkez", "Yenice"};
    private String[] cnkri 			    = {"İlçe Seçiniz", "Atkaracalar", "Bayramören", "Çerkeş", "Eldivan", "Ilgaz", "Kurşunlu", "Merkez", "Orta", "Şabanözü", "Yapraklı"};
    private String[] crm 			    = {"İlçe Seçiniz", "Alaca", "Boğazkale", "Iskılıp", "Kargı", "Mecitözü", "Merkez", "Oğuzlar", "Osmancık", "Sungurlu", "Uğurludağ"};
    private String[] dnzli 			    = {"İlçe Seçiniz", "Acıpayam", "Babadağ", "Buldan", "Çal", "Çardak", "Çivril", "Güney", "Holaz", "Kale", "Merkez", "Sarayköy", "Tavaş"};
    private String[] dyrbkr 			= {"İlçe Seçiniz", "Çermik", "Eğil", "Ergani", "Hani", "Hazro", "Kocaköy", "Lice", "Merkez", "Silvan"};
    private String[] dzce 			    = {"İlçe Seçiniz", "Akçakoca", "Çilimli", "Merkez", "Yığılca"};
    private String[] edrne 			    = {"İlçe Seçiniz", "Enes", "Havsa", "İpsala", "Keşan", "Lalapaşa", "Meriç", "Merkez", "Uzunköprü"};
    private String[] elzg 			    = {"İlçe Seçiniz", "Ağin", "Arıcak", "Baskıl", "Karakoçan", "Keban", "Kovancılar", "Maden", "Merkez", "Palu", "Sivrice"};
    private String[] erzncn 			= {"İlçe Seçiniz", "Çayırlı", "Ilıç", "Kemah", "Kemaliye", "Merkez", "Refahiye", "Tercan", "Üzümlü"};
    private String[] erzrm 			    = {"İlçe Seçiniz", "Aşkale", "Hınıs", "Horasan", "Ilıca", "İspir", "Narman", "Oltu", "Olur", "Pasinler", "Tortum"};
    private String[] eskishr			= {"İlçe Seçiniz", "Alpu", "Beylikova", "Çifteler", "Günyüzü", "Han", "İnönü", "Mahmudiye", "Merkez", "Mihalıçcık", "Seyitgazi", "Sivrihisar"};
    private String[] gantep			    = {"İlçe Seçiniz", "Araban", "Islahiye", "Nizip", "Nurdağı", "Oğuzeli", "Şahinbey", "Şehitkamil", "Yavuzeli"};
    private String[] grsn			    = {"İlçe Seçiniz", "Alucra", "Bulancak", "Dereli", "Espiye", "Eynesil", "Görele", "Keşap", "Merkez", "Şebinkarahisar", "Tirebolu"};
    private String[] ghane			    = {"İlçe Seçiniz", "Kelkit", "Kurtun", "Merkez", "Şiran"};
    private String[] hkkri			    = {"İlçe Seçiniz", "Çukurca", "Merkez", "Şemdilli", "Yüksekova"};
    private String[] hty				= {"İlçe Seçiniz", "Altınözü", "Belen", "Dörtyol", "Yüksekova", "Erzin", "İskenderun", "Kırıkhan", "Kumlu", "Merkez", "Reyhanlı", "Samandağı", "Yayladağı"};
    private String[] igdr			    = {"İlçe Seçiniz", "Aralık", "Karakoyunlu", "Merkez", "Tuzluca"};
    private String[] isprta			    = {"İlçe Seçiniz", "Aksu", "Atabey", "Eğirdir", "Gelendost", "Gönen", "Keçiborlu", "Merkez", "Sarkıkaraağaç", "Senirkent", "Sütçüler", "Uluborlu", "Yalvaç"};
    private String[] kmaras			    = {"İlçe Seçiniz", "Afşın", "Andırın", "Çağlayancerit", "Elbistan", "Göksun", "Merkez", "Pazarcık"};
    private String[] krbk			    = {"İlçe Seçiniz", "Eskipazar", "Merkez", "Safranbolu"};
    private String[] krmn			    = {"İlçe Seçiniz", "Ayrancı", "Başyayla", "Ermenek", "Merkez"};
    private String[] krs				= {"İlçe Seçiniz", "Kağızman", "Merkez", "Sarıkamış"};
    private String[] kstmn			    = {"İlçe Seçiniz", "Abana", "Arac", "Bozkurt", "Çatalzeytin", "Cide", "Daday", "Devrenkanı", "Hanönü", "İhsangazi", "İnebolu", "Küre", "Merkez", "Taşköprü", "Tosya"};
    private String[] kysr			    = {"İlçe Seçiniz", "Akkışla", "Bünyan", "Develi", "Felahiye", "Hacılar", "İncesu", "Kocasinan", "Melekgazi", "Özvatan", "Pınarbaşı", "Talas", "Tomarza", "Yahyalı", "Yeşilhisar"};
    private String[] kls				= {"İlçe Seçiniz", "Elbeyli", "Merkez", "Musabeyli", "Polateli"};
    private String[] krkkale			= {"İlçe Seçiniz", "Karakeçili", "Keskin", "Merkez", "Sulakyurt"};
    private String[] krklreli		    = {"İlçe Seçiniz", "Babaski", "Lüleburgaz", "Merkez", "Pehlivanköy", "Pınarhisar", "Vize"};
    private String[] krshr			    = {"İlçe Seçiniz", "Akpınar", "Çiçekdağı", "Kaman", "Merkez", "Mucur"};
    private String[] kceli			    = {"İlçe Seçiniz", "Derince", "Gebze", "Gölcük", "Kandıra", "Karamürsel", "Merkez"};
    private String[] knya			    = {"İlçe Seçiniz", "Akören", "Akşehir", "Altınekin", "Beyşehir", "Bozkır", "Çeltik", "Cihanbeyli", "Çumra", "Derbent", "Doğanhisar", "Emirgazi", "Ereğli", "Hadım", "Hüyük", "Ilgın", "Kadınhanı", "Karapınar", "Karatay", "Meram", "Sarayönü", "Selçuklu", "Seydişehir", "Taşkent", "Yunak"};
    private String[] kthya			    = {"İlçe Seçiniz", "Altıntaş", "Domaniç", "Dumlupınar", "Emet", "Gediz", "Merkez", "Pazarlar", "Simav", "Tavşanlı"};
    private String[] mltya			    = {"İlçe Seçiniz", "Akçadağ", "Arapkır", "Arguvan", "Battalgazi", "Darende", "Doğanşehir", "Hekimhan", "Merkez", "Pötürge", "Yazıhan", "Yeşilhan"};
    private String[] mnsa			    = {"İlçe Seçiniz", "Ahmetli", "Akhisar", "Alaşehir", "Demirci", "Gölmarmara", "Gördes", "Kırkağaç", "Kula", "Merkez", "Salihli", "Sarıhanlı", "Soma", "Turgutlu"};
    private String[] mrdn			    = {"İlçe Seçiniz", "Derik", "Kızıltepe", "Mazıdağı", "Merkez", "Midyat", "Nusaybin", "Ömerli", "Savur"};
    private String[] mrsn			    = {"İlçe Seçiniz", "Anamur", "Bozyazı", "Çamlıyayla", "Erdemli", "Gülnar", "Merkez", "Mut", "Silifke", "Tarsus"};
    private String[] mgla			    = {"İlçe Seçiniz", "Bodrum", "Datça", "Fathiye", "Kavaklıdere", "Köyceğiz", "Marmaris", "Merkez", "Milas", "Ortaca", "Ula", "Yatağan"};
    private String[] ms				    = {"İlçe Seçiniz", "Bulanık", "Korkut", "Malazgirt", "Merkez"};
    private String[] nvshr			    = {"İlçe Seçiniz", "Avanos", "Derinkuyu", "Gülşehir", "Hacıbektaş", "Kozaklı", "Merkez", "Ürgüp"};
    private String[] ngde			    = {"İlçe Seçiniz", "Altunhisar", "Bor", "Çamardı", "Çiftlik", "Ulukışla"};
    private String[] ord				= {"İlçe Seçiniz", "Akkuş", "Fatsa", "Görköy", "Kabadüz", "Merkez", "Mesudiye", "Perşembe", "Ulubey", "Ünye"};
    private String[] osmnye			    = {"İlçe Seçiniz", "Bahçe", "Kadirli", "Merkez"};
    private String[] rze				= {"İlçe Seçiniz", "Ardeşen", "Çayeli", "Fındıklı", "Merkez", "Pazar", "Çamlıhemşin"};
    private String[] skrya			    = {"İlçe Seçiniz", "Akyazı", "Geyve", "Hendek", "Karasu", "Kaynarca", "Merkez", "Sapanca", "Taraklı"};
    private String[] smsn			    = {"İlçe Seçiniz", "Alaçam", "Bafra", "Çarşamba", "Havza", "Kavak", "Ladik", "Merkez", "Salıpazarı", "Tekkeköy", "Terme", "Vezirköprü"};
    private String[] snlrf			    = {"İlçe Seçiniz", "Akçakale", "Birecik", "Bozova", "Halfeti", "Harran", "Hilvan", "Merkez", "Siverek", "Suruç", "Viranşehir"};
    private String[] srt				= {"İlçe Seçiniz", "Aydınlar", "Baykan", "Eruh", "Kurtalan", "Merkez"};
    private String[] snp				= {"İlçe Seçiniz", "Ayancık", "Boyabat", "Durağan", "Elfelek", "Gerze", "Merkez"};
    private String[] srnk			    = {"İlçe Seçiniz", "Cizre", "İdil", "Merkez", "Silopi"};
    private String[] svs				= {"İlçe Seçiniz", "Altınyayla", "Divriği", "Doğansar", "Gemerek", "Hafik", "Kangal", "Merkez", "Şarkışla", "Suşehri", "Yılızeli", "Zara"};
    private String[] tkrdg			    = {"İlçe Seçiniz", "Çerkezköy", "Çorlu", "Hayrabolu", "Malkara", "Marmara Ereğlisi", "Merkez", "Muratlı", "Saray", "Şarköy"};
    private String[] tkt				= {"İlçe Seçiniz", "Almuz", "Erbaa", "Merkez", "Niksar", "Pazar", "Reşadiye", "Sulusaray", "Turhal", "Zile"};
    private String[] trbzn			    = {"İlçe Seçiniz", "Akçabat", "Araklı", "Arşin", "Beşikdüzü", "Çarşıbaşı", "Çaykara", "Dernekpazarı", "Maçka", "Merkez", "Of", "Sürmene", "Tonya", "Vakfıkebir", "Yomra"};
    private String[] tncli			    = {"İlçe Seçiniz", "Çemişgezek", "Hozat", "Mazgirt", "Merkez", "Nazimiye", "Pertek"};
    private String[] usk				= {"İlçe Seçiniz", "Banaz", "Eşme", "Merkez", "Sivaslı", "Ulubey"};
    private String[] vn				    = {"İlçe Seçiniz", "Başkale", "Çaldıran", "Çatak", "Erciş", "Gevaş", "Gürpınar", "Merkez", "Muradiye", "Özalp"};
    private String[] ylva			    = {"İlçe Seçiniz", "Altınova", "Armutlu", "Merkez"};
    private String[] yzgt			    = {"İlçe Seçiniz", "Boğazlıyan", "Çandır", "Çayıralan", "Merkez", "Sarıkaya", "Sefaatli", "Sorgun", "Yenifakili", "Yerköy"};
    private String[] zngldk			    = {"İlçe Seçiniz", "Araplı", "Çaycuma", "Devrek", "Ereğli", "Merkez"};
    private Spinner spinnerCountry,spinnerCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerCity = (Spinner) findViewById(R.id.spinnerCity);
        spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);
        ArrayAdapter<String> ilDataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, iller);
        ilDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(ilDataAdapter);
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (spinnerCity.getSelectedItem().equals("ANKARA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, ank);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("İSTANBUL")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, ist);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("İZMİR")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, izmr);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ADANA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, adna);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ADIYAMAN")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, adymn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("AFYON")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, afyn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("AĞRI")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, agri);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("AKSARAY")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, aksry);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("AMASYA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, amsya);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ANTALYA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, ant);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ARDAHAN")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, ardhn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ARTVİN")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, artvn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("AYDIN")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, aydn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("BALIKESİR")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, baliksr);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("BARTIN")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, brtn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("BATMAN")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, btmn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("BAYBURT")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, bybrt);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("BİLECİK")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, bilck);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("BİNGÖL")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, bngl);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("BİTLİS")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, btls);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("BOLU")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, blu);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("BURDUR")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, brdr);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("BURSA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, brsa);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ÇANAKKALE")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, cnk);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ÇANKIRI")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, cnkri);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ÇORUM")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, crm);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("DENİZLİ")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, dnzli);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("DİYARBAKIR")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, dyrbkr);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("DÜZCE")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, dzce);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("EDİRNE")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, edrne);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ELAZIĞ")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, elzg);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ERZİNCAN")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, erzncn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ERZURUM")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, erzrm);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ESKİŞEHİR")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, eskishr);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("GAZİANTEP")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, gantep);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("GİRESUN")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, grsn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("GÜMÜŞHANE")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, ghane);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("HAKKARİ")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, hkkri);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("HATAY")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, hty);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("IĞDIR")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, igdr);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ISPARTA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, isprta);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("KAHRAMANMARAŞ")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, kmaras);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("KARABÜK")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, krbk);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("KARAMAN")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, krmn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("KARS")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, krs);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("KASTAMONU")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, kstmn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("KAYSERİ")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, kysr);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("KİLİS")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, kls);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("KIRIKKALE")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, krkkale);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("KIRKLARELİ")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, krklreli);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("KIRŞEHİR")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, krshr);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("KOCAELİ")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, kceli);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("KONYA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, knya);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("KÜTAHYA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, kthya);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("MALATYA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, mltya);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("MANİSA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, mnsa);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("MARDİN")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, mrdn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("MERSİN")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, mrsn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("MUĞLA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, mgla);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("MUŞ")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, ms);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("NEVŞEHİR")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, nvshr);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("NİĞDE")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, ngde);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ORDU")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, ord);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("OSMANİYE")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, osmnye);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("RİZE")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, rze);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("SAKARYA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, skrya);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("SAMSUN")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, smsn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ŞANLIURFA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, snlrf);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("SİİRT")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, srt);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("SİNOP")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, snp);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ŞIRNAK")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, srnk);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("SİVAS")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, svs);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("TEKİRDAĞ")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, tkrdg);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("TOKAT")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, tkt);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("TRABZON")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, trbzn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("TUNCELİ")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, tncli);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("UŞAK")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, usk);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("VAN")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, vn);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("YALOVA")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, ylva);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("YOZGAT")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, yzgt);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                }
                if (spinnerCity.getSelectedItem().equals("ZONGULDAK")){
                    ArrayAdapter<String> ilceDataAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, zngldk);
                    ilceDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCountry.setAdapter(ilceDataAdapter);
                    spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String cCont = spinnerCity.getSelectedItem().toString()+","+spinnerCountry.getSelectedItem().toString();
                        getFactory(cCont,spinnerCity.getSelectedItem().toString(),spinnerCountry.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });


    }
    public void getFactory(String cCont, final String cityC, final String countryC){
        if(!spinnerCountry.getSelectedItem().equals("İlçe Seçiniz")) {
            final ImageView weatherStat = (ImageView) findViewById(R.id.imageStatus);
            final TextView desCrip = (TextView) findViewById(R.id.desCrip);
            final TextView citCountry = (TextView) findViewById(R.id.citCountry);
            final TextView tempEr = (TextView) findViewById(R.id.tempEr);
            final TextView windDet = (TextView) findViewById(R.id.windDeg);

            Factory.getInstance().getWeatherStatus(cCont, "metric", Contanst.APPID_KEY).enqueue(new Callback<WeatherStatusModel>() {
                @Override
                public void onResponse(Call<WeatherStatusModel> call, Response<WeatherStatusModel> response) {
                    citCountry.setText(countryC + " / " + cityC);
                    tempEr.setText("Sıcaklık: " + response.body().main.temp+"°C");
                    windDet.setText("Rüzgar: "+response.body().wind.speed+" m/s");
                    String ico = response.body().weather.get(0).icon;
                    if(ico.equals("01d")){
                        weatherStat.setImageResource(R.drawable.oid);
                        desCrip.setText("Açık Hava");
                    }
                    if(ico.equals("01n")){
                        weatherStat.setImageResource(R.drawable.oin);
                        desCrip.setText("Açık Hava");
                    }
                    if(ico.equals("02d")){
                        weatherStat.setImageResource(R.drawable.ozd);
                        desCrip.setText("Az Bulutlu");
                    }
                    if(ico.equals("02n")){
                        weatherStat.setImageResource(R.drawable.ozn);
                        desCrip.setText("Az Bulutlu");
                    }
                    if(ico.equals("03d")||ico.equals("03n")){
                        weatherStat.setImageResource(R.drawable.oed);
                        desCrip.setText("Çok Bulutlu");
                    }
                    if(ico.equals("04d")||ico.equals("04n")){
                        weatherStat.setImageResource(R.drawable.ofd);
                        desCrip.setText("Parçalı Bulutlu");
                    }
                    if(ico.equals("09d")||ico.equals("09n")){
                        weatherStat.setImageResource(R.drawable.ond);
                        desCrip.setText("Sağanak Yağmurlu");
                    }
                    if(ico.equals("10d")){
                        weatherStat.setImageResource(R.drawable.iod);
                        desCrip.setText("Yağmurlu");
                    }
                    if(ico.equals("10n")){
                        weatherStat.setImageResource(R.drawable.ion);
                        desCrip.setText("Yağmurlu");
                    }
                    if(ico.equals("11d")||ico.equals("11n")){
                        weatherStat.setImageResource(R.drawable.iid);
                        desCrip.setText("Gök Gürültülü");

                    }
                    if(ico.equals("13d")||ico.equals("13n")){
                        weatherStat.setImageResource(R.drawable.ied);
                        desCrip.setText("Karlı");
                    }
                    if(ico.equals("50d")||ico.equals("50n")){
                        weatherStat.setImageResource(R.drawable.sod);
                        desCrip.setText("Sisli");

                    }
                }

                @Override
                public void onFailure(Call<WeatherStatusModel> call, Throwable t) {

                }
            });
        }
    }

}
