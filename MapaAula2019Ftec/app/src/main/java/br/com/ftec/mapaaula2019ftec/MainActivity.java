package br.com.ftec.mapaaula2019ftec;

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

public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (googleServicesAvailable()) {
            Toast.makeText(this,
                    "Google Services está disponível", Toast.LENGTH_LONG).show();
            initMap();
        }
    }

    private void initMap() {

        MapFragment mapFragment = (MapFragment)
                getFragmentManager()
                        .findFragmentById(R.id.mapFragment);

        mapFragment.getMapAsync(this);
    }

    private boolean googleServicesAvailable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvaiable = api.isGooglePlayServicesAvailable(this);
        if (isAvaiable == ConnectionResult.SUCCESS) {
            return true;
        } else if (api.isUserResolvableError(isAvaiable)) {
            //instalar o google service
            Dialog dialog = api.getErrorDialog(this, isAvaiable, 0);
            dialog.show();
        } else {
            Toast.makeText(this,
                    "Nâo foi possível a conexão ao Google Play Services",
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

    private void goToLocationZoom(double latitude, double longitude) {
        LatLng ll = new LatLng(latitude, longitude);
        CameraUpdate update = CameraUpdateFactory.newLatLng(ll);
        mGoogleMap.moveCamera(update);
    }
}
