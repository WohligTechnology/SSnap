package com.example.wohlig.mycwac;

/**
 * Created by Wohlig on 01/10/15.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.commonsware.cwac.camera.CameraFragment;
import com.commonsware.cwac.camera.CameraView;

public class DemoCameraFragment extends CameraFragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View content=inflater.inflate(R.layout.camera, container, false);


        CameraView cameraView=(CameraView)content.findViewById(R.id.camera);

        setCameraView(cameraView);

        return(content);
    }
}