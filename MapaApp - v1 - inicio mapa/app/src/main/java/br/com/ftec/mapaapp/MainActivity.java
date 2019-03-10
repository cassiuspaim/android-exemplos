package br.com.ftec.mapaapp;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (googleServicesAvailable()) {
            Toast.makeText(this,
                    "Google Services disponível",
                    Toast.LENGTH_LONG).show();
            initMap();
        } else {
            // No Google Maps Layout
        }
    }

    private void initMap() {
        MapFragment mapFragment
                = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

    }

    public boolean googleServicesAvailable(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if (isAvailable == ConnectionResult.SUCCESS) {//usuário tem acesso
            return true;
        } else if (api.isUserResolvableError(isAvailable)) { //instalar google service
            Dialog dialog = api.getErrorDialog(this, isAvailable, 0);
            dialog.show();
        } else {//não foi possível instalar google services
            Toast.makeText(this,
                    "Não foi possível a conexão ao Google Play Services",
                    Toast.LENGTH_LONG).show();

        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        goToLocationZoom(-30.025537,
                        -51.219427,
                        15);
    }

    private void goToLocationZoom(double latitude, double longitude, float zoom) {
        LatLng ll = new LatLng(latitude, longitude);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mGoogleMap.moveCamera(update);
    }

    private void goToLocation(double latitude, double longitude) {
        LatLng ll = new LatLng(latitude, longitude);
        CameraUpdate update = CameraUpdateFactory.newLatLng(ll);
        mGoogleMap.moveCamera(update);
    }
}
