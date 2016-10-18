package com.example.kamelbenlakhal.atbmobilebanking;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class Localisation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localisation);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    public void onSearch(View view){
        EditText location_tf = (EditText)findViewById(R.id.TFaddress);
        String location = location_tf.getText().toString();
        List<Address> addressList = null;
        if (location !=null || !location.equals(""))
        {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

        }
    }
    public void onZoom(View view)
    {
        if (view.getId() == R.id.Bzoomin){
         mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if (view.getId() == R.id.Bzoomout){
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }

    public void changeType (View view){
        if (mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL)
        {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }
        else
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
    public void onExit (View view){
        finish();

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng place = new LatLng(36.787005,  10.175036);




        mMap.addMarker(new MarkerOptions().position(place).title("your location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(place));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7679563, 10.1116705)).title("ATB SIDI HASSINE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7907111, 10.1189876)).title("ATB CITÉ EZZOUHOUR").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8322334,10.0403023)).title("ATB OUED ELLIL").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8846838, 10.1839399)).title("ATB RAOUED").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.5996118,10.4984665)).title("ATB GROMBALIA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8024469,10.1118636)).title("ATB DEN DEN").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.766472,10.710535)).title("ATB SFAX EL AIN").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7275686,10.3053689)).title("ATB BOUMHEL").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7922920, 10.1770091)).title("ATB SIDI EL BECHIR, rue sidi el bechir").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7922920, 10.1770091)).title("tel:7545454,fax:84444").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8218249,10.3106046)).title("ATB LA GOULETTE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7763956,10.2283359)).title("ATB MEGRINE JAWHARA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8882364,10.3200245)).title("ATB MARSA 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7411883,10.3010559)).title("ATB EZZAHRA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7542554,10.1872873)).title("ATB IBN SINA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.6502072,10.5912495)).title("ATB BENI KHALLED").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7407412,10.2379704)).title("ATB YASMINET").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8273900,10.1334715)).title("ATB IBN KHALDOUN").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7799189,10.9856415)).title("ATB MENZEL TEMIME").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.4000591,10.1443291)).title("ATB ZAGHOUAN").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.1690958,8.7032962)).title("ATB KEF").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7674750,10.2720881)).title("ATB RADES").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.871094,10.535175)).title("ATB KALAA  EL KOBRA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.4701828,10.7817936)).title("ATB BENI KHIAR").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.0387285,9.4895482)).title("ATB SIDI BOUZID").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.7056164,8.9711094)).title("ATB KEBILI").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.3483471,10.4872012)).title("ATB MEDENINE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.5512069,9.4423842)).title("ATB TESTOUR").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7476190,10.2254820)).title("ATB BEN AOUS").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.7222675,10.7186222)).title("ATB SFAX SOUKRA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8180115,10.1668811)).title("ATB EL OMRANE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.1682480,8.8349605)).title("ATB KASSERINE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.6099299,8.9727402)).title("ATB BOUSSALEM").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.8372636,10.5958629)).title("ATB SOUSSE SAHLOUL").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.787805,10.779615)).title("ATB SFAX SAKKIET EDDAIER").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.6256982,10.7605720)).title("ATB JAMMEL").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.0854016,9.3705010)).title("ATB SILIANA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7954709,10.1694560)).title("ATB SAKKAJINE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(37.037227,9.662946)).title("ATB MATEUR").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8664032,10.2048182)).title("ATB BORJ LOUZIR").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8645492,10.2174354)).title("ATB SOUKRA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8335043,10.1178288)).title("ATB INTILAKA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.8623087,10.1039243)).title("ATB GABES 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.9608566,9.9965072)).title("ATB METOUIA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.6120103,10.2930951)).title("ATB MARETH").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8864172,10.2178645)).title("ATB CHOTRANA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.571804,10.857807)).title("ATB KORBA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7993026,10.1549292)).title("ATB ENNAJEH").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.7225014,10.7465601)).title("ATB JERBA AJIM").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8267717,10.1837039)).title("ATB ALAIN SAVARY").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8383817,10.3057981)).title("ATB KRAM OUEST").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.8043969,10.6022143)).title("ATB SOUSSE ERRIADH").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.8430734,10.6164193)).title("ATB HAMMAM SOUSSE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.8355588,10.6128144)).title("ATB SOUSSE JAWHARA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.2925352,10.7081079)).title("ATB EL JEM").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8299835,10.1925230)).title("ATB CITE EL KHADHRA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7149270,10.1701856)).title("ATB MGHIRA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.8019735,10.8846188)).title("ATB JERBA EL MAY").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.885726,9.795307)).title("ATB EL HAMMA GABES").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.8665137,10.0568461)).title("ATB GABES CHENINI").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8805989,10.2603292)).title("ATB SOUKA 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.682436,10.585943)).title("ATB MENZEL BOUZELFA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(37.2108663,10.1268411)).title("ATB RAS JEBEL").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.882412,10.332675)).title("ATB MARSA PLAGE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(37.266374,9.861755)).title("ATB BIZERTE ZONE FRANCHE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.801589,10.165658)).title("ATB BAB BNET").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.5036676,11.108830)).title("ATB ZARZIS").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.6989457,10.1685548)).title("ATB FOUCHANA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8054535,10.1685762)).title("ATB BAB SOUIKA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7762753,10.1782107)).title("ATB MONTFLEURY").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.4136544,8.7940192)).title("ATB GAFSA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8412495,11.1023068)).title("ATB KELIBIA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.7528612,10.7613230)).title("ATB SFAX ARIANA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8001617,10.1818585)).title("ATB HABIB BOURGUIBA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));

        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8013472,10.1851416)).title("ATB CENTRALE , 9 Rue H.Nouira - 1001 Tunis").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8013472,10.1851416)).title("Tél:71451562 , Fax:71459853").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));


        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7978937,10.1755071)).title("ATB JAZIRA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.7313851,10.7622671)).title("ATB SFAX").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.8208580,10.6417823)).title("ATB SOUSE ").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.4551172,10.7332349)).title("ATB NABEUL").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(37.2981587,9.8670745)).title("ATB BIZERTE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.8881944,10.0978518)).title("ATB GABES").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8135452,10.1736188)).title("ATB EL MECHTEL").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7619227,10.2459311)).title("ATB MEGRINE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.4043941,10.6121063)).title("ATB HAMMAMET").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.8770251,10.8604145)).title("ATB JERBA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.6713997,10.1025510)).title("ATB KAIROUAN").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8311514,10.1689196)).title("ATB MUTUINTERNATIONAL").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.7712033,10.8234429)).title("ATB MONASTIR").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8832078,10.3240156)).title("ATB LA MARSA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7274138,9.1847205)).title("ATB BEJA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.731056,10.752013)).title("ATB SFAX II").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8488394,10.1697993)).title("ATB EL MENZAH").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.500908,8.779856)).title("ATB JENDOUBA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.138397,11.220030)).title("ATB BEN GUERDANE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8383988,10.3180075)).title("ATB LE KRAM").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8623345,10.1958275)).title("ATB ARIANA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.2847061,10.3857708)).title("ATB CHORBENE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.8478914,10.6179857)).title("ATB KHEZAMA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.784894,10.721488)).title("ATB GREMDA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(37.2423893,10.0507307)).title("ATB METLINE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8182348,10.1834464)).title("ATB MONTPLAISIR").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8401333,10.2430773)).title("ATB LAC").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(32.9323173,10.4507446)).title("ATB TATAOUINE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8451820,10.1837039)).title("ATB SAADI").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.8088202,10.9935594)).title("ATB JERBA MIDOUN").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8378321,10.1558304)).title("ATB MANAR").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8100921,10.1796269)).title("ATB LIBERTE").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8423314,10.2011275)).title("ATB CHARGUIA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.7285692,10.8549428)).title("ATB JERBA GUELLALA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.5070595,11.0529971)).title("ATB MAHDIA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.6383773,10.9692693)).title("ATB TEBOULBA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(35.7175803,10.5795765)).title("ATB MSAKEN").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7386434,10.2059555)).title("ATB EL MOUROUJ").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7915875,10.1687479)).title("ATB EL MORKADH").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8561710,10.1572466)).title("ATB ENNASR").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7474986,10.2533770)).title("ATB EL MEDINA JADIDA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8538703,10.2576256)).title("ATB EL AOUINA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.683848,10.703534)).title("ATB SFAX TINA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.8355046,10.7644987)).title("ATB SFAX SAKIET EZZIT").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.7489473,10.7169271)).title("ATB SFAX MENZEL CHAKER").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7283769,10.3331566)).title("ATB HAMMAM LIF").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(34.7406780,10.7583833)).title("ATB SFAX JADIDA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8258614,10.0962853)).title("ATB DOUAR HICHER").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(37.1540403,9.7962427)).title("ATB MENZEL BOURGUIBA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.7980827,10.1045036)).title("ATB EL AGBA").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(33.9224055,8.1339598)).title("ATB TOZEUR").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8082024,10.1423550)).title("ATB BARDO 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(36.8385019,10.1127005)).title("ATB ETTADHAMEN").icon(BitmapDescriptorFactory.fromResource(R.drawable.loc)));



















    }
}
