package com.example.socialmediaintegration.pacakage_permission;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.socialmediaintegration.R;

public class Activity_MultiplePermissions extends AppCompatActivity {

    // Location Permission Request Code
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    // Camera Permission Request Code
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 2;

    // Multiple Permission Request Code
    private static final int MULTIPLE_PERMISSION_REQUEST_CODE = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__multiple_permissions);
        Button buttonRequestLocationPermission = findViewById(R.id.buttonRequestLocationPermission);
        buttonRequestLocationPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check Location Permission already granted or not
                if (ContextCompat.checkSelfPermission(Activity_MultiplePermissions.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(Activity_MultiplePermissions.this, "Location permission is already granted", Toast.LENGTH_SHORT).show();
                } else {
                    // Request Location Permission
                    ActivityCompat.requestPermissions(Activity_MultiplePermissions.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
                }
            }
        });
        Button buttonRequestCameraPermission = findViewById(R.id.buttonRequestCameraPermission);
        buttonRequestCameraPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Check Camera Permission already granted or not
                if (ContextCompat.checkSelfPermission(Activity_MultiplePermissions.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(Activity_MultiplePermissions.this, "Camera permission is already granted", Toast.LENGTH_SHORT).show();
                } else {
                    // Request Camera Permission
                    ActivityCompat.requestPermissions(Activity_MultiplePermissions.this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
                }
            }
        });
        Button buttonRequestMultiplePermission = findViewById(R.id.buttonRequestMultiplePermission);
        buttonRequestMultiplePermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Check Camera & Location Permission already granted or not
                if (ContextCompat.checkSelfPermission(Activity_MultiplePermissions.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                        && ContextCompat.checkSelfPermission(Activity_MultiplePermissions.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(Activity_MultiplePermissions.this, "Location and Camera permissions are already granted", Toast.LENGTH_SHORT).show();
                } else {
                    // Request Camera & Location Permission
                    ActivityCompat.requestPermissions(Activity_MultiplePermissions.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA}, MULTIPLE_PERMISSION_REQUEST_CODE);
                }
            }
        });
    }


    // When we request permission user will either allow or deny the permission which can be checked inside onRequestPermissionsResult method
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE:

                // Check Location permission is granted or not
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(Activity_MultiplePermissions.this, "Location  permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Activity_MultiplePermissions.this, "Location  permission denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case CAMERA_PERMISSION_REQUEST_CODE:

                // Check Camera permission is granted or not
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(Activity_MultiplePermissions.this, "Camera  permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Activity_MultiplePermissions.this, "Camera  permission denied", Toast.LENGTH_SHORT).show();
                }
                break;
            case MULTIPLE_PERMISSION_REQUEST_CODE:

                // Check Location permission is granted or not
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(Activity_MultiplePermissions.this, "Location  permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Activity_MultiplePermissions.this, "Location  permission denied", Toast.LENGTH_SHORT).show();
                }

                // Check Camera permission is granted or not
                if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(Activity_MultiplePermissions.this, "Camera  permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Activity_MultiplePermissions.this, "Camera  permission denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
